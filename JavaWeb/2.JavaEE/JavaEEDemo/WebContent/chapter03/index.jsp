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
	我的第一个jsp页面！！！<br>
	System.out.println("在JSP中可以编写Java代码");<br>
	<% System.out.println("在JSP中可以编写Java代码"); %><br>
	您的ip地址是：<%= request.getRemoteAddr()%>
</center>
</body>
</html>