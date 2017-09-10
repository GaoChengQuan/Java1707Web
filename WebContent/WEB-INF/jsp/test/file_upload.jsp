<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
		用户名：<input name="name" /><br/>
		年龄：<input name="age" /><br/>
		上传图片：<input type="file" name="fileUpload"><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>