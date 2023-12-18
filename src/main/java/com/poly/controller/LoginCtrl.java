package com.poly.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.poly.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/index/logout","/account/share"})
public class LoginCtrl extends HttpServlet{
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("PolyOE");
	EntityManager em= emf.createEntityManager();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User us= null;
		req.getSession().setAttribute("userlogin", us);
		req.getRequestDispatcher("/login").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String us = req.getParameter("username");
			String pw= req.getParameter("password");
			User entity= em.find(User.class, us);
			if(!entity.getPassword().equals(pw)) {
				System.out.println("sai pass");
			}else {
				req.getSession().setAttribute("userlogin", entity);
				req.getRequestDispatcher("/index").forward(req, resp);
			}
			

	}
	
	
	

}
