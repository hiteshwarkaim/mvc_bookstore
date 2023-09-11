<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book World - Online Store</title>
	<style type="text/css">
		/*customer login*/
		.login-div {
			width: 30%;
			margin-left:540px;
		}
		
		.login-div h2{
			margin-left: 330px;
			margin-bottom: -90px;
		}
		
		.login-div form{
			padding: 18px 30px;
			border-radius: 10px;
			width: 500px;
			height: 320px;
		}
		.login-div form div{
			margin: 28px;
		}
		.login-div form input[type="submit"]{
			width: 24rem;
		}
		.login-div .error{
			color: red;
		}
		
		
		
	</style>
</head>
<body>
	<jsp:include page="/components/header_frontend.jsp"/>
	
	<div class="login-div">
		<h2>Login</h2>
		<form action="login" method="post" id="loginForm">
			<div>
				<label for="input-1">Email:</label>
				<input id="input-1" class="form-control error" placeholder="Enter email id" type="text" name="email"/>
			</div>
			<div>
				<label for="input-2">Password:</label>
				<input id="input-2" class="form-control error" placeholder="Enter password" type="password" name="password"/>
			</div>
			<div>
				<input class="btn btn-primary" type="submit" value="Sign-Up">
			</div>
		</form>
	</div>
	
	<jsp:include page="/components/footer.jsp"/>
</body>

<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
    <script type="text/javascript">

			$(document).ready(function(){
				$("#loginForm").validate({
						rules:{
							email:{
								required: true,
								email:true
							},
							password:"required"
						},
						messages:{
							email:{
								required: "Please enter email",
								email:"Please enter valid email"
							},
							password:"Please enter password"
						}
					});
				});
	
				
            </script>
</html>