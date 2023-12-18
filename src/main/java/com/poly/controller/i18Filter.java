package com.poly.controller;

import java.io.IOException;

import com.poly.ultils.HttpFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class i18Filter implements HttpFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
			String lang=req.getParameter("lang");
			if(lang!=null) {
				req.getSession().setAttribute("lang", lang);
			}
			chain.doFilter(req, resp);
		
	}
}
