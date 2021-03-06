package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.exception.NameRepeatException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.vo.PageBean;
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
		req.getRequestDispatcher("/WEB-INF/jsp/student_list.jsp").forward(req, resp);
		
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
		//req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		byte[] buffer = name.getBytes("iso8859-1");
		String nameEncode = new String(buffer, "utf-8");
		System.out.println(nameEncode);
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		Student student = new Student(name, Integer.parseInt(age), gender, "青岛", new Date());
		System.out.println(student);
		
		/*//1.请求行(请求方式  URI  http版本)
		System.out.println("请求方式:" + req.getMethod());
		System.out.println("访问路径:" + req.getServletPath());
		System.out.println("http协议版本:" + req.getProtocol());
		
		//2.获得请求头(key-value)
		Enumeration<String> enumeration = req.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = req.getHeader(key);
			System.out.println(key + " : " + value);
		}*/
		
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
		resp.sendRedirect(req.getContextPath() + "/student?method=pageList");
	}
	
	private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String[] deleteIds = req.getParameterValues("selectIds");
		System.out.println(id);
	}
	
	private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] deleteIds = req.getParameterValues("selectIds");
		for (String id : deleteIds) {
			System.out.println(id);
		}
		IStudentService studentService = new StudentServiceImpl();
		studentService.deleteAll(deleteIds);
		
	}
	
	private void searchByCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//1.获得参数并封装
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		int pageIndex = 1;//默认取第一页的数据
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;//默认每一页数量
		if (pageSizeStr != null && !pageIndexStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		SearchCondition searchCondition = new SearchCondition(pageIndex, pageSize, name, age, gender);
		System.out.println(searchCondition);
		
		//2.调用service完成业务处理
		IStudentService service = new StudentServiceImpl();
		PageBean pageBean = service.searchByCondition(searchCondition);
		//3.将数据放到域对象中request,跳转到jsp页面展示数据
		req.setAttribute("pageBean", pageBean);
		req.setAttribute("searchCondition", searchCondition);
		req.getRequestDispatcher("/WEB-INF/jsp/student_list.jsp").forward(req, resp);
	}
	
	private void pageList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("StudentServlet.pageList()");
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		int pageIndex = 1;//默认取第一页的数据
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 3;//默认每一页数量
		if (pageSizeStr != null && !pageIndexStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		IStudentService studentService = new StudentServiceImpl();
		PageBean pageBean = studentService.getPageBean(pageIndex, pageSize);
		System.out.println(pageBean);
		//pageIndex totalPage  pageSize totalCount list
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/WEB-INF/jsp/student_list.jsp").forward(req, resp);
	}
	
	private void checkName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		System.out.println("name: " + name);
		IStudentService studentService = new StudentServiceImpl();
		boolean isExist = studentService.checkName(name);
		// {"isExist":isExist}
		String str = "{\"isExist\":"+isExist+"}";
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(str);
	}
	
	private void getSearchPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		list.add("Java1705");
		list.add("Java1707");
		list.add("Java1708");
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/jsp/student_search.jsp").forward(req, resp);
	}
	
}
