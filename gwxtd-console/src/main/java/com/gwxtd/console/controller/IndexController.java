package com.gwxtd.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 初始化页面
 * @author licai
 *
 */
@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public void index(){
		System.out.println("welcome");
	}
}
