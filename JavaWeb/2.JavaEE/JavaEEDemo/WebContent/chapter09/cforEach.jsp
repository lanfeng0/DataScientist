<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import = "java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<font size = "4">
		<%
			ArrayList listt = new ArrayList();
			for(int i = 0 ; i < 5; i++){
				listt.add(i, (i+1)*15);
			}
			request.setAttribute("list1", listt);
		%>
		<c:out value = "c:forEach示例："/><br>
		<c:forEach items = "${list1 }" var = "current1" varStatus = "status1">
			<c:out value = "序号："/>
			<c:out value = "${status1.count }"/>
			<c:out value = "值"/>
			<c:out value = "${current1 }"/><br>
		</c:forEach>
		
	</font>
</center>
</body>
</html>