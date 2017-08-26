package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.exception.NameRepeatException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
/**
 * controller层作用: 控制层, 获取界面上的数据,为界面设置数据; 将要实现的功能交给业务层处理
 * 后期这一块是SpringMVC帮助我们管理
 * @author GaoMatrix
 *
 */
public class FindAllStudentServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		int count = (int) context.getAttribute("count");
		count++;
		context.setAttribute("count", count);
		System.out.println("当前访问次数：" + count);
		
		//1.接收请求参数，封装成对象
	    //2.业务处理
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findAll();
		//3.控制界面跳转
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<a href='/Java1707Web/html/add_student.html'>添加<a/>");
		printWriter.println("<table border='1' cellspacing='0'>");
		printWriter.println("<tr>");
		printWriter.println("	<td>id</td>");
		printWriter.println("	<td>姓名</td>");
		printWriter.println("	<td>年龄</td>");
		printWriter.println("	<td>性别</td>");
		printWriter.println("	<td>地址</td>");
		printWriter.println("	<td>出生日期</td>");
		printWriter.println("</tr>");
		for (Student student : list) {
			printWriter.println("<tr>");
			printWriter.println("	<td>" + student.getId() + "</td>");
			printWriter.println("	<td>" + student.getName() + "</td>");
			printWriter.println("	<td>" + student.getAge() + "</td>");
			printWriter.println("	<td>" + student.getGender() + "</td>");
			printWriter.println("	<td>" + student.getAddress() + "</td>");
			printWriter.println("	<td>" + student.getBirthday() + "</td>");
			printWriter.println("</tr>");
		}
		printWriter.println("</table>");
			
		printWriter.close();
	}
	
}
