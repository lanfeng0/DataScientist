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
	<hr size = "5" color = "red" width = "50%">
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	用户名：${param.username }<br>
	密码：${param.password }<br>
	姓名：${param.name }<br>
	性别:${param.sex }<br>
	爱好：${paramValues.interst[0] }${paramValues.interst[1] }${paramValues.interst[2] }<br>
	<hr size = "5" color = "red" width = "50%">
</center>
</body>
</html>