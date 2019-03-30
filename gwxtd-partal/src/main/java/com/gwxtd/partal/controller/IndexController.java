package com.gwxtd.partal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gwxtd.core.service.GoodsService;
/**
 * 前台页面跳转
 * @author licai
 *
 */
@Controller
public class IndexController {
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/index.html")
	public String index(){
		return "index";
	}
	@RequestMapping("/spclass.html")
	public String spclass(Model model){
		List<String> classs = goodsService.selectClass();
		model.addAttribute("classs",classs);
		return "spclass";
	}
	@RequestMapping("/register.html")
	public String register(){
		return "register";
	}
	@RequestMapping("/userinfo.html")
	public String userinfo(){
		return "userinfo";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
