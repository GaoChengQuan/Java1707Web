<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#name").blur(function(){
			var name = $("#name").val();
			$.post(
				"${pageContext.request.contextPath}/student?method=checkName", //url
				{"name":name}, //data
				function(data) {
					// {"isExist":isExist}
					if(data.isExist) {
						$("#nameInfo").html("è¯¥ç¨æ·å·²å­å¨");
						$("#nameInfo").css("color", "red");
					}
				},//callback
				"json" //type
			);
		});
		
	});
</script>
</head>
<body>
	<!--
   	å½åï¼/Java1707Web/html/add_student.html
   	ç®æ ï¼/Java1707Web/addStudent
   	ç¸å¯¹è·¯å¾
   	<form action="../addStudent">
    -->
	<form action="/Java1707Web/student?method=addStudent" method="post">
		å§åï¼<input type="text" name="name" id="name"/><br/>
		<span id="nameInfo"></span>
		å¹´é¾ï¼<input type="text" name="age"/><br/>
		æ§å«ï¼<input type="text" name="gender"/><br/>
		<input type="submit" value="æ·»å "/>
	</form>
</body>
</html>