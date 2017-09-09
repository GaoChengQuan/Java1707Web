package com.situ.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admin;
import com.situ.student.service.IAdminService;
import com.situ.student.service.impl.AdminServiceImpl;

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
		//验证验证码对不对
		String checkCode = req.getParameter("checkCode");
		if (checkCode == null || checkCode.equals("")) {
			resp.sendRedirect(req.getContextPath() + "/html/login.jsp");
			return;
		}
		//输入的和生成的是否一致
		String checkCodeSession = (String) req.getSession().getAttribute("checkCodeSession");
		if (!checkCode.equalsIgnoreCase(checkCodeSession)) {
			resp.sendRedirect(req.getContextPath() + "/html/login.jsp");
			return;
		}
		
		// 1.获取参数
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		
		IAdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.findByNameAndPassword(name, password);
		//2.业务处理
		if (admin != null) {
			//登陆成功
			//ServletContex   Request
			//1.构造session域对象
			HttpSession session = req.getSession(true);
			//把数据放在session对象做你该
			session.setAttribute("admin", admin);
			List<Admin> onLineAdminList = (List<Admin>) getServletContext().getAttribute("onLineAdminList");
			onLineAdminList.add(admin);
			//跳转到用户主页StudentServlet
			resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
		} else {
			//登陆失败
			resp.sendRedirect(req.getContextPath() + "/html/fail.html");
		}
	}
}
