package com.gwxtd.partal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gwxtd.core.pojo.User;
import com.gwxtd.core.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login.html")
	public String login(User user,HttpServletRequest request){
		User ur = userService.selectUser(user);
		String link = null;
		if(ur == null){
			request.setAttribute("msg","对不起,登录失败,请重新登录!!!");
			link = "error";
		}else{
			user.setUid(ur.getUid());
			user.setUemail(ur.getUemail());
			request.getSession().setAttribute("ur",user);
			link = "index";
		}
		return link;
	}
	
	@RequestMapping("/register.html")
	public String register(User user,Model model,HttpSession session){
		User user1 = new User(user.getUname(),user.getUpwd(),user.getUemail());
		User ur = userService.selectUserByUname(user.getUname());
		String url = null;
		if(ur == null){
			boolean flag = userService.userRegister(user);
			if(flag){
				session.setAttribute("ur",user1);
				url = "index";
			}else{
				model.addAttribute("msg","对不起,注册失败,请重新注册!!!");
				url = "error";
			}
		}else{
			model.addAttribute("msg","对不起,该用户名已经存在,请重新注册!!!");
			url = "error";
		}
		
		return url;
	}
	
	@RequestMapping("/logout.html")
	public String logout(HttpSession session){
		session.removeAttribute("ur");
		return "index";
	}
	@RequestMapping("/modify.html")
	public String modify(User user,HttpSession session,Model model){
		User ur = (User)session.getAttribute("ur");
		User user1 = new User(ur.getUname(),user.getUpwd(),user.getUemail());
		boolean flag = userService.modifyUserByUname(user,ur.getUname());
		if(flag){
			//设置提示信息页面是否显示返回按钮
			model.addAttribute("flag","isExist");
			
			model.addAttribute("msg","恭喜您,信息修改成功!!!");
			session.setAttribute("ur",user1);
		}else{
			model.addAttribute("msg","对不起,信息修改失败!!!");
		}
		return "error";
	}
		
}
