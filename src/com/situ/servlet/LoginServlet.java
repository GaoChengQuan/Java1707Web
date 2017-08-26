package com.situ.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String maxOnLine = config.getInitParameter("maxOnLine");
		System.out.println(maxOnLine);
		String size = config.getInitParameter("size");
		System.out.println(size);
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String maxOnLine = config.getInitParameter("maxOnLine");
		System.out.println("service:" + maxOnLine);
		String size = config.getInitParameter("size");
		System.out.println("service:" + size);
		
		//ServletContext servletContext = config.getServletContext();
		ServletContext servletContext = getServletContext();
		String contextSize = servletContext.getInitParameter("size");
		System.out.println("service:" + contextSize);
	}
}
