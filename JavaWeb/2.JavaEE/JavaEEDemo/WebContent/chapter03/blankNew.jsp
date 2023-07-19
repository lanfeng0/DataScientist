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
	我是blankNew.jsp文件<br>
	<%
		for(int i = 0 ; i < 10 ; i ++){
			System.out.println("在控制台打印："+i);
		}
	%>
	您的IP地址：<%= request.getRemoteAddr() %>
</center>
</body>
</html>