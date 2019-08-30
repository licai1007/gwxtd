package com.gwxtd.console.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.gwxtd.core.pojo.Admin;
import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.pojo.OrderCriteria;
import com.gwxtd.core.pojo.OrderCriteria.Criteria;
import com.gwxtd.core.pojo.OrderGoods;
import com.gwxtd.core.service.OrderGoodsService;
import com.gwxtd.core.service.OrderService;
import com.qingniao.common.page.PageInfo;

@Controller
@RequestMapping("/manage/order")
public class OrderManageController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderGoodsService orderGoodsService;
	@RequestMapping("/index.do")
	public String index(Integer pageNumber,String ostate,Integer oid,Model model){
		OrderCriteria orderCriteria = new OrderCriteria();
		StringBuilder condition = new StringBuilder();
		if(pageNumber == null){
			orderCriteria.setPageNo(1);
		}else{
			orderCriteria.setPageNo(pageNumber);
		}
		orderCriteria.setPageSize(10);
		orderCriteria.setOrderByClause("oDate DESC");
		Criteria criteria = orderCriteria.createCriteria();
		if(ostate != null && ostate != ""){
			try {
				String state = new String(ostate.getBytes("iso8859-1"),"utf-8");
				criteria.andOstateEqualTo(state);
				condition.append("ostate="+state);
				model.addAttribute("ostate",state);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if(oid != null){
			criteria.andOidEqualTo(oid);
			condition.append("&oid="+oid);
			model.addAttribute("oid",oid);
		}
		String url = "/manage/order/index.do";
		PageInfo pageInfo = orderService.orderShow(orderCriteria);
		pageInfo.pageView(url,condition.toString());
		model.addAttribute("pageInfo",pageInfo);
		return "ordermanage";
	}
	@RequestMapping("/handle.do")
	public String handleOrder(Integer oid,String url,Model model){
		List<OrderGoods> orderDetails = orderGoodsService.selectByOid(oid);
		Order order = orderService.selectOrderById(oid);
		model.addAttribute("orderDetails",orderDetails);
		model.addAttribute("order",order);
		model.addAttribute("url",url);
		return "ordermodify";
	}
	@RequestMapping("/delete.do")
	public String deleteOrder(Integer oid,String url,Model model){
		boolean isSuccess = orderService.deleteById(oid);
		if(isSuccess){
			model.addAttribute("msg","恭喜您，订单删除成功!!!");
		}else{
			model.addAttribute("msg","对不起，订单删除失败!!!");
		}
		model.addAttribute("url",url);
		return "hint";
	}
	@RequestMapping("/update.do")
	public String update(Integer oid,String url,HttpServletRequest request){
		Order order = new Order();
		order.setOid(oid);
		order.setOstate("已发货");
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		order.setAid(admin.getAid());
		boolean isSuccess = orderService.delivery(order);
		if(isSuccess){
			request.setAttribute("msg","恭喜您，订单确定成功!!!");
		}else{
			request.setAttribute("msg","对不起，订单确定失败!!!");
		}
		request.setAttribute("url",url);
		return "hint";
	}
	
}
