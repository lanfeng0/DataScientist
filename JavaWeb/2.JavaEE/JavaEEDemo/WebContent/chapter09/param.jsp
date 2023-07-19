<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form name = "form1" action =  "param1.jsp" method = "post">
		用户名:<input type = "text" name = "username"><br>
		密码:<input type = "password" name = "password"><br>
		姓名:<input type = "text" name = "name"><br>
		性别:<input type = "radio" name = "sex" value = "男" checked>男
		   <input type = "radio" name = "sex" value = "女">女 <br>
		爱好:<input type = "checkbox" name = "interst" value = "看书">看书
		<input type = "checkbox" name = "interst" value = "打篮球">打篮球
		<input type = "checkbox" name = "interst" value = "旅行">旅行
		<input type = "checkbox" name = "interst" value = "编程">编程<br>
		<input type = "submit" value = "提交"/>
		<input type = "reset" value = "重置"/>
	</form>
</center>
</body>
</html>