package com.gwxtd.partal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwxtd.core.common.Constant;
import com.gwxtd.core.common.CookieUtils;
import com.gwxtd.core.common.JsonUtils;
import com.gwxtd.core.pojo.CartItem;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.service.GoodsService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private GoodsService goodsService;
	//显示购物车
	@RequestMapping("/shopping.html")
	public String showCart(Model model,HttpServletRequest request){
		List<CartItem> list = getCartList(request);
		if(list.size()!=0){
			//对购物车商品进行排序
			Collections.sort(list,new Comparator<CartItem>() {
				//进行倒序
				@Override
				public int compare(CartItem arg0, CartItem arg1) {
					return -1;
				}
			});
		}
		//循环遍历加载祥细信息
		List<Goods> cartList = new ArrayList<>();
		for(CartItem cartItem:list){
			Goods goods = goodsService.selectGoods(cartItem.getCid());
			goods.setBuynum(cartItem.getCnum());
			cartList.add(goods);
		}
		model.addAttribute("cartList",cartList);
		return "cart";
	}
	//添加商品到购物车中
	@RequestMapping(value="/addToCart.html",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addToCart(int gid,HttpServletRequest request,HttpServletResponse response){
		List<CartItem> list = getCartList(request);
		boolean isExist = false;
		for(CartItem cartItem:list){
			if(cartItem.getCid()==gid){
				//如果库存不足返回"库存不足"
				Goods goods = goodsService.selectGoods(gid);
				if(goods.getGamount()<cartItem.getCnum()+1){
					return "{\"stocknum\":\"库存不足\"}";
				}
				//如果存在相同的商品就直接增加商品数量
				cartItem.setCnum(cartItem.getCnum()+1);
				isExist = true;
				break;
			}
		}
		//如果不存在相同的商品，就将此商品添加到购物车中
		if(!isExist){
			CartItem item = new CartItem(gid,1);
			list.add(item);
		}
		//将购物车重新写入cookie
		CookieUtils.setCookie(request,response,Constant.USER_CART,
				JsonUtils.objectToJson(list),Constant.CART_TIME,true);
		
		//库存充足添加商品后返回空字符串
		return "{\"stocknum\":\"\"}";
	}
	//通过id删除购物项
	@RequestMapping("/delete.html")
	public String delete(int gid,HttpServletRequest request,HttpServletResponse response){
		//取出购物车
		List<CartItem> cartList = getCartList(request);
		//遍历
		for(CartItem cartItem:cartList){
			if(cartItem.getCid()==gid){
				//删除购物项
				cartList.remove(cartItem);
				break;
			}
		}
		//更新到cookie中
		CookieUtils.setCookie(request,response,Constant.USER_CART,
				JsonUtils.objectToJson(cartList),Constant.CART_TIME,true);
		return "redirect:/cart/shopping.html";
	}
	//修改购物车中购物项数量
	@RequestMapping("/updateNum.html")
	@ResponseBody
	public String updateNum(int gid,int num,HttpServletRequest request,HttpServletResponse response){
		//如果库存不足返回库存量
		Goods goods = goodsService.selectGoods(gid);
		if(goods.getGamount()<num){
			return "{\"stocknum\":\""+goods.getGamount()+"\"}";
		}
		
		//取出购物车
		List<CartItem> cartList = getCartList(request);
		//遍历
		for(CartItem cartItem:cartList){
			if(cartItem.getCid()==gid){
				//修改指定商品数量
				cartItem.setCnum(num);
				break;
			}
		}
		//更新cookie
		CookieUtils.setCookie(request,response,Constant.USER_CART,
				JsonUtils.objectToJson(cartList),Constant.CART_TIME,true);
		//库存充足修改库存后返回空字符串
		return "{\"stocknum\":\"\"}";
	}
	//清空购物车
	@RequestMapping("/clearCart.html")
	public String clearCart(HttpServletResponse response){
		//清空cookie
		Cookie cookie = new Cookie(Constant.USER_CART,null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/cart/shopping.html";
	}
	//从cookie中获取购物车
	private List<CartItem> getCartList(HttpServletRequest request){
		String json = CookieUtils.getCookieValue(request,Constant.USER_CART,true);
		List<CartItem> list = new ArrayList<>();
		if(StringUtils.isNotBlank(json)){
			list = JsonUtils.jsonToList(json,CartItem.class);
		}
		return list;
	}
}
