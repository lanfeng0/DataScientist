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
		<form name="form1" action="UploadServlet" method="post"
			enctype="multipart/form-data">
			姓名：<input type="text" name="userName"><br> 文件上传：<input
				type="file" name="file"><br> <input type="submit"
				value="上传" />
		</form>
	</center>
</body>
</html>
