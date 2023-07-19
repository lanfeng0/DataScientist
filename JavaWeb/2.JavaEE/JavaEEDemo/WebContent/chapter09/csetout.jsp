<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<font size = "3">
		<c:out value = "c:set标签示例" ></c:out><br>
		第一种语法示例：<br>
		<c:set var = "number" value = "2" scope = "session"></c:set>
		<c:out value = "number的值为:${number }"/><br>
		第二种语法示例：<br>
		<c:set var = "number">2</c:set>
		<c:out value = "number的值为：${number }"/>
	</font>
</center>
</body>
</html>