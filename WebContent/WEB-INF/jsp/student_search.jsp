<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
	</head>
	<body>
		
		<%@include file="common/header.jsp"%>		
		<!--中间内容部分 begin-->
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<div class="list-group">
					 <a href="${pageContext.request.contextPath}/student?method=pageList" class="list-group-item">学生管理</a>
		             <a href="${pageContext.request.contextPath}/student?method=getSearchPage" class="list-group-item  active">学生搜索</a>
		             <a href="${pageContext.request.contextPath}/student?method=getAddPage" class="list-group-item">添加学生</a>
					</div>
				</div>
				
				<div class="col-md-10">
					<ul class="nav nav-tabs">
					  <li role="presentation"><a href="#">学生管理</a></li>
					  <li role="presentation"  class="active"><a href="#">学生搜索</a></li>
					  <li role="presentation"><a href="#">学生添加</a></li>
					</ul>
					
					<form class="form_border">
						<div class="alert alert-info" role="alert">
		                    <strong>技巧提示：</strong>
		                    	支持模糊搜索和匹配搜索，匹配搜索使用*代替！
		                </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email address</label>
					    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputFile">File input</label>
					    <input type="file" id="exampleInputFile">
					    <p class="help-block">Example block-level help text here.</p>
					  </div>
					  <div class="checkbox">
					    <label>
					      <input type="checkbox"> Check me out
					    </label>
					  </div>
					  <button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
		</div>
		<!--中间内容部分 end-->
		
	</body>
</html>
