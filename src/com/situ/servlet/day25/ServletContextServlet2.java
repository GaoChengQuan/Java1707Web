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

public class ServletContextServlet2 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String name = (String) context.getAttribute("name");
		System.out.println(name);
		
		List<Student> list = (List<Student>) context.getAttribute("list");
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
