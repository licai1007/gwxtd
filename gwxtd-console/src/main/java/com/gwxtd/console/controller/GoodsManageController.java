package com.gwxtd.console.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.pojo.GoodsWithBLOBs;
import com.gwxtd.core.service.GoodsService;
import com.qingniao.common.page.PageInfo;

@Controller
@RequestMapping("/manage/goods")
public class GoodsManageController {
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/index.do")
	public String index(Model model){
		List<String> classs = goodsService.selectClass();
		model.addAttribute("classs",classs);
		return "adminindex";
	}
	@RequestMapping("/list.do")
	public String goodslist(Integer pageNumber,String gclass,String tsearch,Model model){
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
		String url = "/manage/goods/list.do";
		PageInfo pageInfo = goodsService.goodsShow(goodsCriteria);
		pageInfo.pageView(url,condition.toString());
		model.addAttribute("pageInfo",pageInfo);
		return "goodsmanage";
	}
	@RequestMapping(value="/add.do",method=RequestMethod.GET)
	public String addGoods(){
		return "addgoods";
	}
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public String addGoods(GoodsWithBLOBs goods,Model model){
		//补全
		goods.setGdate(new Date());
		goods.setGlook(0);
		boolean isSuccess = goodsService.addGoods(goods);
		if(isSuccess){
			model.addAttribute("msg","恭喜您，商品添加成功!!!");
		}else{
			model.addAttribute("msg","对不起，商品添加失败!!!");
		}
		return "hint";
	}
	@RequestMapping("/edit.do")
	public String editGoods(Integer gid,String url,Model model){
		Goods goods = goodsService.selectGoods(gid);
		model.addAttribute("goods",goods);
		model.addAttribute("url",url);
		return "modifygoods";
	}
	@RequestMapping("/modify.do")
	public String modifyGoods(GoodsWithBLOBs goods,String url,Model model){
		boolean isSuccess = goodsService.updateGoods(goods);
		if(isSuccess){
			model.addAttribute("msg","恭喜您，商品修改成功!!!");
		}else{
			model.addAttribute("msg","对不起，商品修改失败!!!");
		}
		model.addAttribute("url",url);
		return "hint";
	}
	@RequestMapping("/delete.do")
	public String deleteGoods(Integer gid,String url,Model model){
		boolean isSuccess = goodsService.deleteGoodsById(gid);
		if(isSuccess){
			model.addAttribute("msg","恭喜您，删除成功!!!");
		}else{
			model.addAttribute("msg","对不起，删除失败!!!");
		}
		model.addAttribute("url",url);
		return "hint";
	}
	
	
	
	
	
	
	
	
	
	
	
}
