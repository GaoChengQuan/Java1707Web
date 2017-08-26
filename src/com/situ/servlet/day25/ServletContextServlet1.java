package com.situ.servlet.day25;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class ServletContextServlet1 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		context.setAttribute("name", "张三");
		
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
		context.setAttribute("list", list);
		
	}
}
