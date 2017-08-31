package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.internal.runners.model.EachTestNotifier;

import com.situ.student.exception.NameRepeatException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.vo.SearchCondition;

public class StudentServlet extends BaseServlet{
	

	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentServlet.service()");
		
		//.获得HttpSession
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("userName");
		if (userName == null) {
			resp.sendRedirect(req.getContextPath() + "/html/login.html");
			return;
		}
		
		ServletContext context = getServletContext();
		int count = (int) context.getAttribute("count");
		count++;
		context.setAttribute("count", count);
		System.out.println("当前访问次数：" + count);
		
		//System.out.println(req.getContextPath());
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		if ("/addStudent.do".equals(servletPath)) {
			addStudent(req, resp);
		} else if ("/findAllStudents.do".equals(servletPath)) {
			findAllStudents(req, resp);
		} else if ("/seachByName.do".equals(servletPath)) {
			searchByName(req, resp);
		} else if ("/toUpdateStudent.do".equals(servletPath)) {
			toUpdateStudent(req, resp);
		}
	}*/

	private void toUpdateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		IStudentService service = new StudentServiceImpl();
		Student student = service.findById(Integer.parseInt(id));
		req.setAttribute("student", student);
		req.getRequestDispatcher("/jsp/student_update.jsp").forward(req, resp);
	}

	private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchName = req.getParameter("searchName");
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.searchByName(searchName);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/display").forward(req, resp);
	}

	private void findAllStudents(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//1.接收请求参数，封装成对象
		//2.业务处理
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findAll();
		//3.控制界面跳转
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/student_list.jsp").forward(req, resp);
		
		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<a href='/Java1707Web/html/add_student.html'>添加<a/>");
		printWriter.println("<h1>欢迎您回来" + userName + "</h1>");
		printWriter.println("<a href='/Java1707Web/logout'>退出</a>");
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
			
		printWriter.close();*/
	}
	
	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("StudentServlet.addStudent()");
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		byte[] buffer = name.getBytes("iso8859-1");
		String nameEncode = new String(buffer, "utf-8");
		System.out.println(nameEncode);
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		Student student = new Student(name, Integer.parseInt(age), gender, "青岛", new Date());
		System.out.println(student);
		
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
		
		//resp.setContentType("text/html;charset=utf-8");
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
	
	private void deletById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		System.out.println(id);
	}
	
	private void searchByCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//1.获得参数并封装
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		SearchCondition searchCondition = new SearchCondition(name, age, gender);
		System.out.println(searchCondition);
		//2.调用service完成业务处理
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.searchByCondition(searchCondition);
		//3.将数据放到域对象中request,跳转到jsp页面展示数据
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/student_list.jsp").forward(req, resp);
	}
	
	
	private void findAllStudents() {
		
	}
}
