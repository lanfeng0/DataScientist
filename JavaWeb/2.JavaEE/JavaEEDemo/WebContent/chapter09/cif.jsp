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
	<c:set var = "name" value = "Brain"/>
	<c:if test = "${not empty name }">
		<c:out value = "${name }"/>
	</c:if>
</center>
</body>
</html>