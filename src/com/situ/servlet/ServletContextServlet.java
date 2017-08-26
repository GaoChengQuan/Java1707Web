package com.situ.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// "/WEB-INF/classes/db.properties"
		ServletContext servletContext = getServletContext();
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String url = properties.getProperty("url");
		System.out.println(url);
		
		
		String aPath = servletContext.getRealPath("/a.txt");
		System.out.println(aPath);
		String bPath = servletContext.getRealPath("/WEB-INF/b.txt");
		System.out.println(bPath);
	}
}
