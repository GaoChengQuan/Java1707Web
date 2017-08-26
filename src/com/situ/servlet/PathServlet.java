package com.situ.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Context 上下文
		System.out.println(req.getContextPath());// /Java1707Web
		System.out.println(req.getServletPath());// /path
		System.out.println(req.getRequestURI());//  /Java1707Web/path
		System.out.println(req.getRequestURL());//  http://localhost:8080/Java1707Web/path
		
		ServletContext servletContext = getServletContext();
		String contextSize = servletContext.getInitParameter("size");
		System.out.println("service:" + contextSize);
	}
}
