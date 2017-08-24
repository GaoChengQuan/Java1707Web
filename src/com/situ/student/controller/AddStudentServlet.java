package com.situ.student.controller;

import java.io.IOException;
import java.util.Date;

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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		Student student = new Student(name, Integer.parseInt(age), gender, "青岛", new Date());
		
		IStudentService service = new StudentServiceImpl();
		try {
			service.add(student);
		} catch (NameRepeatException e) {
			e.printStackTrace();
		}
		
		//重定向到FindAllStudentServlet
		resp.sendRedirect("/Java1707Web/findAllStudent");
	}
}
