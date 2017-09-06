package com.situ.student.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.situ.student.pojo.Admin;
/**
 * 初始化在线列表集合监听器
 */
public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//创建在线Admin列表集合
		List<Admin> onLineAdminList = new ArrayList<Admin>();
		ServletContext servletContext = sce.getServletContext();
		//放到ServletContext域对象中
		servletContext.setAttribute("onLineAdminList", onLineAdminList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
