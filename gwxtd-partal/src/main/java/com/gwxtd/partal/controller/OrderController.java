package com.gwxtd.partal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gwxtd.core.common.Constant;
import com.gwxtd.core.common.CookieUtils;
import com.gwxtd.core.common.JsonUtils;
import com.gwxtd.core.pojo.CartItem;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.pojo.User;
import com.gwxtd.core.service.GoodsService;
import com.gwxtd.core.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@RequestMapping("/receiverinfo.html")
	public String receiverInfo(){
		return "receiverinfo";
	}
	@RequestMapping("/orderconfirm.html")
	public String orderConfirm(String recname,String recadr,
			String rectel,HttpServletRequest request){
		addressToSession(recname, recadr, rectel, request);
		
		//获取详细的购物车集合及总价
		Map<String,Object> cartListAndTotalPrice = getCartListAndTotalPrice(request);
		@SuppressWarnings("unchecked")
		List<Goods> cartList = (List<Goods>)cartListAndTotalPrice.get("cartList");
		double totalPrice = (double)cartListAndTotalPrice.get("totalPrice");
		
		//对购物车商品进行排序
		Collections.sort(cartList,new Comparator<Goods>() {
			//进行倒序
			@Override
			public int compare(Goods arg0, Goods arg1) {
				return -1;
			}
		});
				
		request.setAttribute("cartList",cartList);
		request.setAttribute("totalPrice",totalPrice);
		return "order";
	}
	@RequestMapping("/commitorder.html")
	public String commitOrder(HttpServletRequest request,HttpServletResponse response){
		//设置提示信息页面是否显示返回按钮
		request.setAttribute("flag","isExist");
		
		//获取详细的购物车集合及总价
		Map<String,Object> cartListAndTotalPrice = getCartListAndTotalPrice(request);
		@SuppressWarnings("unchecked")
		List<Goods> cartList = (List<Goods>)cartListAndTotalPrice.get("cartList");
		double totalPrice = (double)cartListAndTotalPrice.get("totalPrice");
		
		//判断库存是否充足，当库存不够时停止提交订单
		String message = "";
		for(Goods goods:cartList){
			if(goods.getBuynum().intValue()>goods.getGamount()){
				message += "对不起，"+goods.getGname()+"的库存只有"+goods.getGamount()+"<br/>";
			}
		}
		if(!message.equals("")){
			request.setAttribute("msg",message);
			return "error";
		}
		
		//保存订单信息
		HttpSession session = request.getSession();
		Order order = new Order();
		order.setOdate(new Date());
		order.setOstate("未发货");
		@SuppressWarnings("unchecked")
		Map<String,String> info = (Map<String,String>)session.getAttribute("addressInfo");
		order.setOrecname(info.get("name"));
		order.setOrecadr(info.get("address"));
		order.setOrectel(info.get("phone"));
		User user = (User)session.getAttribute("ur");
		order.setUid(user.getUid());
		order.setOtotalprice(totalPrice);
		boolean success = orderService.saveOrder(order,cartList);
		
		//订单提交失败
		if(!success){
			request.setAttribute("msg","对不起，订单提交失败!");
			return "error";
		}
		
		//清空收货人信息
		session.setAttribute("addressInfo",null);
		//清空购物车
		Cookie cookie = new Cookie(Constant.USER_CART,null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		request.setAttribute("msg","恭喜你，订单提交成功!");
		return "error";
	}
	//将收货人信息放入session
	private void addressToSession(String recname, String recadr, String rectel,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String,String> addressInfo = new HashMap<>();
		addressInfo.put("name",recname.trim());
		addressInfo.put("address",recadr.trim());
		addressInfo.put("phone",rectel.trim());
		session.setAttribute("addressInfo",addressInfo);
	}
	
	//获取详细的购物车集合及总价
	public Map<String,Object> getCartListAndTotalPrice(HttpServletRequest request){
		String json = CookieUtils.getCookieValue(request,Constant.USER_CART,true);
		List<CartItem> list = new ArrayList<>();
		if(StringUtils.isNotBlank(json)){
			list = JsonUtils.jsonToList(json,CartItem.class);
		}
		//循环遍历加载祥细信息
		List<Goods> cartList = new ArrayList<>();
		double totalPrice = 0;
		for(CartItem cartItem:list){
			Goods goods = goodsService.selectGoods(cartItem.getCid());
			int buyNum = cartItem.getCnum().intValue();
			//设置购买数量
			goods.setBuynum(buyNum);
			cartList.add(goods);
			//计算总价
			totalPrice += goods.getGprice()*buyNum;
		}
		Map<String,Object> map = new HashMap<>();
		map.put("cartList",cartList);
		map.put("totalPrice",totalPrice);
		return map;
	}
	

}
