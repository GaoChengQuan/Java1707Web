package com.situ.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admin;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取HttpSession
		HttpSession session = req.getSession(false);
		if (session != null) {
			/*Admin admin = (Admin) session.getAttribute("admin");
			session.removeAttribute("admin");
			List<Admin> onLineAdminList = (List<Admin>) getServletContext().getAttribute("onLineAdminList");
			onLineAdminList.remove(admin);*/
			session.invalidate();
		}
		//2.回到登陆界面
		resp.sendRedirect(req.getContextPath() + "/html/login.html");
	}
}
