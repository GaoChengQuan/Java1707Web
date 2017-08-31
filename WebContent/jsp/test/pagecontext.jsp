<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.getWriter().println("是不是同一个out:" + (out == pageContext.getOut()));
		response.getWriter().println("是不是同一个session:" + (session == pageContext.getSession()));
	%>
	
	<hr/>
	<%
		pageContext.setAttribute("name", "name pageContext zhangsan");
		pageContext.setAttribute("name", "name request zhangsan", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "name session zhangsan", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "name application zhangsan", PageContext.APPLICATION_SCOPE);
	%>
	
	<%=pageContext.getAttribute("name")%><br/>
	<%=pageContext.getAttribute("name", pageContext.REQUEST_SCOPE)%><br/>
	<%=pageContext.getAttribute("name", pageContext.SESSION_SCOPE)%><br/>
	<%=pageContext.getAttribute("name", pageContext.APPLICATION_SCOPE)%><br/>
	
	<%
		request.getRequestDispatcher("/jsp/test/pagecontext2.jsp").forward(request, response);
	%>
	
	

</body>
</html>