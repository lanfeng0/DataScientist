<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("token", System.nanoTime() + "");
	%>
	<center>
		<form name="form1" action="LoginServlet" method="post">
			<%
				String msg = (String) request.getAttribute("msg");
				if (msg != null && !msg.equals("")) {
			%>
			<font color='red'>提示信息：<%=msg%></font><br>
			<%
				}
			%>
			<input type="hidden" name="token"
				value="<%=session.getAttribute("token")%>"> 用户名:<input
				type="text" name="username" /><br> 密码:<input type="password"
				name="pwd" /><br> <input type="submit" value="登录" /> <input
				type="reset" value="重置" />
		</form>
	</center>
</body>
</html>