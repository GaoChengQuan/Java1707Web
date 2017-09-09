<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	function refreshCode() {
		$("#codeImg").attr("src", "${pageContext.request.contextPath}/checkImg?"+Math.random());
	}
</script>

</head>
<body>
	<form action="/Java1707Web/login" method="post">
		用户名<input type="text" name="name"/><br/>
		密码<input type="text" name="password"/></br>
		验证码:<input type="text" name="checkCode"/>
		<img id="codeImg" src="${pageContext.request.contextPath}/checkImg" onclick="refreshCode();"/>
		<input type="submit" value="登陆"/>
	</form>
</body>
</html>