<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%--  Jsp的脚本
	  语法：<%java代码 %> --%>
	<%
		for(int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
	%>
	
	<%-- Jsp表达式
  	语法：<%=变量或表达式%> --%>
	<%=Math.random() %><br/>
	<%=4 %><br/>
	<%=Math.random()*100 %><br/>
	
	
	<%
		for(int i = 1; i <= 100; i++) {
	%>
			<%=i%>
	<%
		}
	%>
	<hr/>
	<%
		for(int i = 1; i <= 6; i++ ) {
			
	%>
			<h<%=i%>>标题<%=i%></h<%=i %>>
	<%
		}
	%>
	
	
	
	
</body>
</html>