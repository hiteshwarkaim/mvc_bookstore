<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page not Found error</title>
</head>
<body align="center">
	<div>
		<img alt="logo" src="../static/images/logo.png"/>
		<!-- <img alt="logo" src="${pageContext.request.contextPath}/static/images/logo.png"/>   -->
	</div>
	
	<h2 >Sorry, Requested page not found</h2>
	<div>
		 <a href="javascript:history.go(-1);">Go back</a>
	</div>
</body>
</html>	