package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.exception.NameRepeatException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("AddStudentServlet.init()");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		Student student = new Student(name, Integer.parseInt(age), gender, "青岛", new Date());
		
		//1.请求行(请求方式  URI  http版本)
		System.out.println("请求方式:" + req.getMethod());
		System.out.println("访问路径:" + req.getServletPath());
		System.out.println("http协议版本:" + req.getProtocol());
		
		//2.获得请求头(key-value)
		Enumeration<String> enumeration = req.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = req.getHeader(key);
			System.out.println(key + " : " + value);
		}
		
		IStudentService service = new StudentServiceImpl();
		boolean result = false;
		try {
			result = service.add(student);
		} catch (NameRepeatException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		/*if (result) {
			printWriter.println("<h1>添加学生成功</h1>");
		} else {
			printWriter.println("<h1>添加学生失败</h1>");
		}*/
		
		//重定向到FindAllStudentServlet
		//resp.sendRedirect("/Java1707Web/findAllStudent");
		resp.sendRedirect(req.getContextPath() + "/findAllStudent");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("AddStudentServlet.destroy()");
	}
	
}
