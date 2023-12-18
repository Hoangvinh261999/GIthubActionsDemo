package com.poly.controller;

import java.io.IOException;

import com.poly.entity.User;
import com.poly.ultils.HttpFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(filterName = "auth",urlPatterns = {"/logout","/like","/menu","/forgotpass","/share","/update","/register","/changepass","/editprofile","/favorite"})
public class AuthFilter implements HttpFilter{
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String uri=req.getRequestURI();
		User user= (User) req.getSession().getAttribute("userlogin");
		String error="";
		if(user==null) {
			error=resp.encodeURL("vui long dang nhap!");
			resp.sendRedirect("/asmGd1_java4/login?"+resp.encodeURL(error));
			return;
		}
//		else if(!user.getAdmin() && uri.contains("/like")) {
//			error=resp.encodeURL("vui long dang nhap tk ad!");
//			resp.sendRedirect("/asmGd1/user/login.jsp?error="+resp.encodeURL(error));
//			System.out.println(user+"trong checkad"); 
//			return;
//
//		}
		
		if(user!=null &&uri.contains("/logout")) {
			System.out.println("lo");
			req.getSession().setAttribute("securi", error);
			resp.sendRedirect("/asmGd1_java4/login");
			System.out.println("đã điều hướng đeén đây");
			
			return;
		}else {
			chain.doFilter(req, resp);
			System.out.println("do filter");
		}
		
	}
}
