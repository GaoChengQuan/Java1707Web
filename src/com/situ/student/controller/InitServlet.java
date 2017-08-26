package com.situ.student.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.situ.student.util.JdbcUtil;
/*
 * load-on-startup=1 是用来初始化的，不是用来调用的。
 */
public class InitServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("InitServlet.init()");
		ServletContext context = getServletContext();
		JdbcUtil.init(context);
		
		int count = 0;
		context.setAttribute("count", count);
	}
	
}
