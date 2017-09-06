<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.situ.student.pojo.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<table style="width: 700px;" class="align-center table table-striped table-bordered table-hover table-condensed">
			<tr>  
				<td>id</td>
				<td>姓名</td>
				<td>密码</td>
			</tr>
			<c:forEach items="${onLineAdminList}" var="admin">
				<tr>
					<td>${admin.id}</td>
					<td>${admin.name}</td>
					<td>${admin.password}</td>
				</tr>
			</c:forEach>
			
		</table>
</body>
</html>