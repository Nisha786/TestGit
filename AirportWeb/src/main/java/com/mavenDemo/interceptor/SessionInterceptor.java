package com.mavenDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mavenDemo.Model.UserDTO;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		 System.out.println("Inside session interceptor Pre handler");
		UserDTO usrDto = (UserDTO) request.getSession().getAttribute("usrDto");
		if (usrDto == null || usrDto.equals("")) {
			response.sendRedirect("login.do");
			return false;
		}  
		System.out.println("Session preHandle !");
		System.out.println(System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Session interceptor Post handler");
		System.out.println(System.currentTimeMillis());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Inside session interceptor after completion ");
	}

}
