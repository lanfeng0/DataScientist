<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
successs!!!!

<%
	String [] city = (String []) request.getAttribute("city");
	for(String c:city){
		
%>
<%= c %>
<%} %>
</body>
</html>