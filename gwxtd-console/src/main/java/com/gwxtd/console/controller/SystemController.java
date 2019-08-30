package com.gwxtd.console.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gwxtd.core.pojo.Admin;
import com.gwxtd.core.service.AdminService;

/**
 * 初始化页面
 * @author licai
 *
 */
@Controller
public class SystemController {
	@Autowired
	private AdminService adminService;
	@RequestMapping(value="/login.do",method = RequestMethod.GET)
	public String login(){
		return "adlogin";
	}
	@RequestMapping(value="/login.do",method = RequestMethod.POST)
	public String login(Admin admin,Model model,HttpSession session){
		Admin ad = adminService.selectAdmin(admin);
		if(ad==null){
			model.addAttribute("message","用户名或密码错误!");
			return "adlogin";
		}
		session.setAttribute("admin",ad);
		return "redirect:/manage/goods/index.do";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		//将Session失效
		request.getSession(true).invalidate();
		return "adlogin";
	}
}
