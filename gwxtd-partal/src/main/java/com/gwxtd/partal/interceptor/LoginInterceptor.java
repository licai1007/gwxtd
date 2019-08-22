package com.gwxtd.partal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gwxtd.core.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("ur");
		if(user==null){
			String msg = "<h1>请你先登陆!!!</h1><a href='/gwxtd-partal/index.html'>[登录]</a>";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("/WEB-INF/partal/error.jsp").forward(request,response);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
