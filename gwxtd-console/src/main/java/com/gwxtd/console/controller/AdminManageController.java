package com.gwxtd.console.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gwxtd.core.common.Constant;
import com.gwxtd.core.common.MD5Utils;
import com.gwxtd.core.pojo.Admin;
import com.gwxtd.core.service.AdminService;

@Controller
@RequestMapping("/manage/admin")
public class AdminManageController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		if(admin.getAlevel()==null||(!admin.getAlevel().equals("超级"))){
			request.setAttribute("msg","对不起，您没有权限来进行管理!!!");
			return "hint";
		}
		return "adminmanage";
	}
	@RequestMapping("/top.do")
	public String top(){
		return "admintop";
	}
	@RequestMapping("/main.do")
	public String main(){
		return "adminmain";
	}
	@RequestMapping("/left.do")
	public String left(){
		return "adminleft";
	}
	@RequestMapping("/list.do")
	public String adminlist(Model model){
		List<Admin> admins = adminService.selectAll();
		model.addAttribute("admins",admins);
		return "adminlist";
	}
	@RequestMapping("/delete.do")
	public String deleteAdmin(Integer aid,Model model){
		model.addAttribute("url",Constant.ADMIN_MANAGE_URL);
		Admin adm = adminService.selectById(aid);
		if(adm.getAlevel().equals("超级")){
			model.addAttribute("msg","对不起，超级管理员不可以删除!!!");
			return "hint";
		}
		boolean isSuccess = adminService.deleteById(aid);
		if(isSuccess){
			model.addAttribute("msg","恭喜您，管理员删除成功!!!");
		}else{
			model.addAttribute("msg","对不起，管理员删除失败!!!");
		}
		return "hint";
	}
	@RequestMapping(value="/add.do",method=RequestMethod.GET)
	public String addAdmin(){
		return "adminadd";
	}
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public String addAdmin(Admin admin,Model model){
		model.addAttribute("url",Constant.ADMIN_MANAGE_URL);
		Admin ad = adminService.selectByName(admin.getAname().trim());
		if(ad!=null){
			model.addAttribute("msg","对不起，用户名已存在!!!");
			return "hint";
		}
		admin.setAname(admin.getAname().trim());
		admin.setApwd(MD5Utils.md5(admin.getApwd()));
		admin.setAlevel("普通");
		boolean isSuccess = adminService.addAdmin(admin);
		if(isSuccess){
			model.addAttribute("msg","恭喜您，管理员添加成功!!!");
		}else{
			model.addAttribute("msg","对不起，管理员添加失败!!!");
		}
		return "hint";
	}
	@RequestMapping(value="/pwdreset.do",method=RequestMethod.GET)
	public String resetPwd(){
		return "resetpwd";
	}
	@RequestMapping(value="/pwdreset.do",method=RequestMethod.POST)
	public String resetPwd(Admin admin,Model model){
		model.addAttribute("url",Constant.ADMIN_MANAGE_URL);
		Admin ad = adminService.selectByName(admin.getAname().trim());
		if(ad==null){
			model.addAttribute("msg","对不起，用户名输入错误!!!");
			return "hint";
		}
		admin.setAid(ad.getAid());
		admin.setApwd(MD5Utils.md5(admin.getApwd()));
		boolean isSuccess = adminService.updateAdmin(admin);
		if(isSuccess){
			model.addAttribute("msg","恭喜您，密码重置成功!!!");
		}else{
			model.addAttribute("msg","对不起，密码重置失败!!!");
		}
		return "hint";
	}
	@RequestMapping(value="/changepwd.do",method=RequestMethod.GET)
	public String changepwd(HttpSession session,Model model){
		Admin admin = (Admin)session.getAttribute("admin");
		model.addAttribute("name",admin.getAname());
		return "changepwd";
	}
	@RequestMapping(value="/changepwd.do",method=RequestMethod.POST)
	public String changepwd(String oldpwd,String newpwd,HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		String secret = MD5Utils.md5(oldpwd.trim());
		if(!admin.getApwd().equals(secret)){
			request.setAttribute("msg","对不起，旧密码输入有误!!!");
			return "hint";
		}
		Admin adn = new Admin();
		adn.setAid(admin.getAid());
		adn.setApwd(MD5Utils.md5(newpwd.trim()));
		boolean isSuccess = adminService.updateAdmin(adn);
		if(isSuccess){
			request.setAttribute("message","恭喜您，密码修改成功!请重新登录");
			return "adlogin";
		}else{
			request.setAttribute("msg","对不起，密码修改失败!!!");
			return "hint";
		}
	}
	
}
