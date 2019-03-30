package com.gwxtd.partal.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.service.GoodsService;
import com.qingniao.common.page.PageInfo;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/splist.html")
	public String splist(Integer pageNumber,String gclass,String tsearch,Model model){
		GoodsCriteria goodsCriteria = new GoodsCriteria();
		StringBuilder condition = new StringBuilder();
		if(pageNumber == null){
			goodsCriteria.setPageNo(1);
		}else{
			goodsCriteria.setPageNo(pageNumber);
		}
		goodsCriteria.setPageSize(2);
		if(gclass != null && gclass != ""){
			try {
				String category = new String(gclass.getBytes("iso8859-1"),"utf-8");
				goodsCriteria.setGclass(category);
				condition.append("gclass="+category);
				model.addAttribute("gclass",category);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if(tsearch != null && tsearch.trim() != ""){
			try {
				String gname = new String(tsearch.trim().getBytes("iso8859-1"),"utf-8");
				goodsCriteria.setGname(gname);
				condition.append("&gname="+gname);
				model.addAttribute("gname",gname);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String url = "/goods/splist.html";
		PageInfo pageInfo = goodsService.goodsShow(goodsCriteria);
		pageInfo.pageView(url,condition.toString());
		model.addAttribute("pageInfo",pageInfo);
		return "splist";
	}
	@RequestMapping("/goodsdetail.html")
	public String goodsDetail(Integer gid,Model model){
		Goods goods = goodsService.selectGoods(gid);
		goodsService.updateLook(gid,goods);
		model.addAttribute("goods",goods);
		return "goodsdetail";
	}
}
