<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="./static/css/style.css"/>
        <link rel="stylesheet" href="./static/css/jquery-ui.min.css"/>
        
           
	   <script type="text/javascript" src="./static/js/jquery-ui.min.js"></script> 
    </head>
    <body>
    	  <%@include file="/components/header_frontend.jsp" %>
          
        <div class="customer-form-div">
            
            <div>
                <h2>Register as a Customer</h2>
            </div>
            
            
             <div class="form-div" >
             
             		<form action="update-profile" method="POST" id="customerForm">
                   
						<div>
							<label for="input-2">Email:</label>+
							<input type="text" class="form-control error" name="email" readonly="true" value="${loggedCustomer.email}"/>
						</div>
						<div>
							<label for="input-3">Full Name:</label>
							<input type="text" class="form-control error" name="fullname" value="${loggedCustomer.fullName}"/>
						</div>
						
						
						<div>
							<label for="input-6">Phone No:</label>
							<input type="text" class="form-control error" name="phone" value="${loggedCustomer.phone}"/>
						</div>
						<div>
							<label for="input-7">Address:</label>
							<input type="text" class="form-control error" name="address" value="${loggedCustomer.address}"/>
						</div>
						<div>
							<label for="input-8">City:</label>
							<input type="text" class="form-control error" name="city" value="${loggedCustomer.city}"/>
						</div>
						<div>
							<label for="input-9">Zip Code:</label>
							<input type="text" class="form-control error" name="zipcode" value="${loggedCustomer.zipcode}"/>
						</div>
						<div>
							<label for="input-10">Country:</label>
							<input type="text" class="form-control error" name="country" value="${loggedCustomer.country}"/>
						</div>

						<div><i>(leave password field blank if you don't want to change password)</i></div>
						<div>
							<label for="input-4">Password:</label>
							<input type="password" class="form-control error" name="pwd1" id="password"/>
						</div>
						<div>
							<label for="input-5">Confirm Password:</label>
							<input type="password" class="form-control error" name="pwd2" />
						</div>
                      <input type="submit" class="btn btn-primary" value="Save"/> &nbsp;<input class="btn btn-dark" type="reset" value="Cancel"/>
				 </form>
    		 </div>

        </div>
        
        <%@include file="/components/footer.jsp" %>
    </body>
    <script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
    <script type="text/javascript">

			$(document).ready(function(){
				$("#customerForm").validate({
						rules:{
							email:{
								required: true,
								email:true
							},

							fullname:"required",
							
							pwd2:{
								equalTo:"#password"
							},
							phone:"required",
							address:"required",
							city:"required",
							zipcode:"required",
							country:"required"
						},
						messages:{
							email:{
								required: "Please enetr email",
								email:"Please enter valid email"
							},
							
							fullname:"Please enter name",
							pwd2:{
								equalTo: "Confirm password does not match"
							},
							phone:"Please enter phone",
							address:"Please enter address",
							city:"Please enter city",
							zipcode:"Please enter zipcode",
							country:"Please enter country",
							
							
						}
					});
				});
	
				
            </script>
</html>