<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="login-form">
          
            <h1>BookStore Admin</h1>
            <h2>Admin Login</h2>
           
            
             <div>
                 <form action="login" method="POST" id="loginForm">
					<div>
						<label for="input-1">Email:</label>
						<input id="input-1" class="form-control error" placeholder="Enter email id" type="email" name="email"/>
					</div>
			
					<div>
						<label for="input-2">Password:</label>
						<input id="input-2" class="form-control error" placeholder="Enter password" type="password" name="password"/>
					</div>
			
                     <div>
                     	<button type="submit" class="btn btn-dark" >Login</button> &nbsp;&nbsp;
                     </div>
                     
                 </form>
             </div>
            
        </div>
            
    </body>
    
    <script type="text/javascript">

			$(document).ready(function(){
				$("#loginForm").validate({
						rules:{
							email:{
								required: true,
								email:true
							},

							password:"required",
						},
						messages:{
							email:{
								required: "Please enter email",
								email:"Please enter valid email"
							},
							
							password:"Please enter password",
							
						}
					});
				});
	
				
            </script>
</html>


