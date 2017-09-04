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
			var student = {
				"id" : 12,
				"name" : "lisi",
				"gender" : "男"
			};
			alert(student.name);
			
			var list = [
		            {
		                "id" : 12,
		                "name" : "gao",
		                "age" : 30,
		                "gender" : "男"
		            },
		            {
		                "id" : 13,
		                "name" : "li",
		                "age" : 30,
		                "gender" : "男"
		            },
		            {
		                "id" : 14,
		                "name" : "wang",
		                "age" : 20,
		                "gender" : "男"
		            },
	        ];
			alert(list[2].name);
			
			var student2 = {
			        "id" : 12,
			        "name" : "gao",
			        "age"  :   30,
			        "gender" : "男",
			        "interest" : ["篮球", "爬山", "旅游"]
			    };
			alert(student2.interest[2]);
			
			var student3 = {
				 "id" : 12,
			     "name" : "gao",
			     "age"  :   30,
			     "gender" : "男",
			     "interest" : [
			           {"name":"篮球", "time":5},
			           {"name":"爬山", "time":3},
			           {"name":"旅游", "time":6}
			      ]
					
			};
			
			alert(student3.interest[2].time);

		});
	</script>
</head>
<body>

</body>
</html>