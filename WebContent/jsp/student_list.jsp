<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.situ.student.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
<style>
	.align-center {
		margin: 10px auto;
	}
</style>
</head>
<body>
	<%
		List<Student> list = (List<Student>)request.getAttribute("list");
	%>
	<table style="width: 800px;" class="align-center table table-striped table-bordered table-hover table-condensed">
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>地址</td>
			<td>出生日期</td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		<%
			for(Student stu : list) {
		%>
				<tr>
					<td><%=stu.getId()%></td>
					<td><%=stu.getName()%></td>
					<td><%=stu.getAge()%></td>
					<td><%=stu.getGender()%></td>
					<td><%=stu.getAddress()%></td>
					<td><%=stu.getBirthday()%></td>
					<td><a href="<%=request.getContextPath()%>/deleteStudent.do?id=<%=stu.getId()%>">删除</a></td>
					<td><a href="<%=request.getContextPath()%>/toUpdateStudent.do?id=<%=stu.getId()%>">修改</a></td>
				</tr>
		<%
			}
		%>
		
		
	</table>
</body>
</html>