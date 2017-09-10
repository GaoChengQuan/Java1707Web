<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.situ.student.pojo.*" %>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* 1.获得基本数据类型  */
		pageContext.setAttribute("name", "张三");
	
		/* 2.Student对象 */
		Student student = new Student();
		student.setName("lisi");
		student.setAge(20);
		session.setAttribute("student", student);
		
		/* 3.获得List<Student>中的值 */
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("lisi", 20, "男", "青岛", new Date()));
		list.add(new Student("wangwu", 23, "男", "青岛", new Date()));
		application.setAttribute("list", list);
	%>
	<%=pageContext.getAttribute("name") %><br>
	${pageScope.name}
	<hr>
	<%
		Student studentSession = (Student)session.getAttribute("student");
	%>
	<%=studentSession.getName() %> : <%=studentSession.getAge() %><br/>
	${sessionScope.student.name} : ${sessionScope.student.age}
	<hr/>
	<%
		List<Student> listApplication = (List<Student>)pageContext.findAttribute("list");
	%>
	<%=listApplication.get(0).getName() %> <%=listApplication.get(1).getName() %> <br/>
	${applicationScope.list[0].name} ${applicationScope.list[1].name}
	<hr/>
	${name}<br/>
	${student.name} - ${student.age}<br/>
	${list[0].name} - ${list[1].name}
	<hr/>
	 <!-- 比较运算
       >  <  >=  <=  !=
    -->
	${5>2}<br/>
	${!false}<br/>
	
	<%
		String address = "aa";
		pageContext.setAttribute("address", address);
	%>
	${address == null || address == "" }<br/>
	${empty address}
	
	
	
</body>
</html>