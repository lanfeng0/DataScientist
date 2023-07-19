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
	<form name = "form" action = "GetCookieServlet" method = "post">
		<table>
			<tr>
				<td>Cookie属性名为：</td>
				<td><input type = "text" name = "name"/></td>
			</tr>
			<tr>
				<td>Cookie属性值为：</td>
				<td><input type = "text" name = "value"/></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "提交"/></td>
				<td><input type = "reset" name = "重置"/></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>