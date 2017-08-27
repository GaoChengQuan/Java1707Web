package com.situ.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 1.获取参数
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		//2.业务处理
		if ("zhangsan".equals(name) && "123".equals(password)) {
			//登陆成功
			//ServletContex   Request
			//1.构造session域对象
			HttpSession session = req.getSession(true);
			//把数据放在session对象做你该
			session.setAttribute("userName", name);
			//跳转到用户主页StudentServlet
			resp.sendRedirect(req.getContextPath() + "/findAllStudents.do");
		} else {
			//登陆失败
			resp.sendRedirect(req.getContextPath() + "/html/fail.html");
		}
	}
}
