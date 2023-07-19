<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr size="3" color="red" width="80%">
	<%
		Cookie[] c = request.getCookies();
		if (c == null) {
			String i = "2";
			Cookie ck = new Cookie("count", i);
			ck.setMaxAge(60 * 60 * 24);
			response.addCookie(ck);
		} else {
			for (int i = 0; i < c.length; i++) {
				String s = c[i].getName();
				if (s.equals("count")) {
					out.println("欢迎您访问我们的网站，这是您第" + c[i].getValue() + "次访问，欢迎以后常来！！！");
					int j = Integer.parseInt(c[i].getValue()) + 1;
					Cookie ck = new Cookie("count", new Integer(j).toString());
					//ck.setMaxAge(0);
					ck.setMaxAge(60 * 60 * 24);
					response.addCookie(ck);
				}
			}
		}
	%>
	<hr size="3" color="red" width="80%">
</body>
</html>