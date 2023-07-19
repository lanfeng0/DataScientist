<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var = "IDE" value = "Eclipse"/>
	<c:choose>
		<c:when test="${IDE=='IDEA' }">
			<c:out value = "你使用的工具是IDEA"/>
		</c:when>
		<c:when test = "${IDE=='Eclipse' }">
			<c:out value = "你使用的工具是Eclipse"/>
		</c:when>
		<c:when test = "${IDE=='MyEclipse' }">
			<c:out value = "你使用的工具是MyEclipse"/>
		</c:when>
		<c:otherwise>
			<c:out value = "我是高手我用记事本写代码！"/>
		</c:otherwise>
	</c:choose>
</body>
</html>