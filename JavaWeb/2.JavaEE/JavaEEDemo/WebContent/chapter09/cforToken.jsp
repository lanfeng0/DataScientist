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
<hr size = "5" color = "red" width = "50%">
	<font size = "4">
		<%
			String question = "What*is*your*name*?";
			request.setAttribute("question1", question);
		%>
		<c:out value = "c:forTokens标签示例"/><br>
		<c:forTokens items="${question1}" delims="*" var = "current1" varStatus="statusss">
			第<c:out value = "${statusss.count }"/> 次取出的单词为:<c:out value = "${current1 }"/><br>
		</c:forTokens>
	</font>
<hr size = "5" color = "red" width = "50%">
</center>
</body>
</html>