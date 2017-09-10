<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.situ.student.pojo.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	  <!-- 1、单条件判断 -->
	  <!-- if(){} -->
	  <c:set value="17" var="age"></c:set>
	  <c:if test="${age==18}">
	  	今年18岁
	  </c:if>
	  <hr/>
	  <c:set value="70" var="score"></c:set>
	  <c:choose>
	      <c:when test="${score>=90 && score<=100}">
	          	优秀
	      </c:when>
	      <c:when test="${score>=80 && score<90}">
	          	良好
	      </c:when>
	      <c:when test="${score>=70 && score<80}">
	          	一般
	      </c:when>
	      <c:when test="${score>=60 && score<70}">
	          	及格
	      </c:when>
	      <c:otherwise>
	      	不及格
	      </c:otherwise>
	  </c:choose>
	 <hr/>
	 
	 <!-- 循环
	 for (int i = 0; i <= 6; i++) {
	 	syso
	 } 
	 -->
	 <c:forEach begin="0" end="6" var="i">
	 	${i}<br/>
	 </c:forEach>
	 
	 <%
	 	/* 3.获得List<Student>中的值 */
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("lisi", 20, "男", "青岛", new Date()));
		list.add(new Student("wangwu", 23, "男", "青岛", new Date()));
		application.setAttribute("list", list);
	 %>
	 <hr/>
	 <c:forEach items="${list}" var="student">
	 	${student.name} - ${student.age}<br/>
	 </c:forEach>
	 <hr/>
	 
	 <%
	 	/* 3.获得List<Student>中的值 */
	 	Map<String, Student> map = new HashMap<String, Student>();
		Student stu1 = new Student("lisi", 20, "男", "青岛", new Date());
		Student stu2 = new Student("wangwu", 23, "男", "青岛", new Date());
		map.put("stu1", stu1);
		map.put("stu2", stu2);
		application.setAttribute("map", map);
	 %>
	 <c:forEach items="${map}" var="entry">
	 	${entry.key} - ${entry.value.name}<br/>
	 </c:forEach>
	 
	 
	 
	 
	 
</body>
</html>