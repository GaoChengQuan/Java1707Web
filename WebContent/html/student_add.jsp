<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
						$("#nameInfo").html("该用户已存在");
						$("#nameInfo").css("color", "red");
					} else {
						$("#nameInfo").html("该用户可以使用");
						$("#nameInfo").css("color", "green");
					}
				},//callback
				"json" //type
			);
			/* $.get(
					"${pageContext.request.contextPath}/student?method=checkName", //url
					{"name":name}, //data
					function(data) {
						// {"isExist":isExist}
						if(data.isExist) {
							$("#nameInfo").html("该用户已存在");
							$("#nameInfo").css("color", "red");
						} else {
							$("#nameInfo").html("该用户可以使用");
							$("#nameInfo").css("color", "green");
						}
					},//callback
					"json" //type
				); */
		});
		
	});
</script>
</head>
<body>
	<form action="/Java1707Web/student?method=addStudent" method="post">
		用户名<input type="text" name="name" id="name"/><br/>
		<span id="nameInfo"></span><br/>
		年龄<input type="text" name="age"/><br/>
		性别<input type="text" name="gender"/><br/>
		<input type="submit" value="添加"/>
	</form>
</body>
</html>