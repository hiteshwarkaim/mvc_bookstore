<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../static/css/jquery-ui.min.css"/>
        
    </head>
    <body>
    	  <%@include file="/components/header.jsp" %>
          
        <div class="customer-form-div">
            
            
            <div>
                <h2>Customer Registration </h2>
            </div>
             <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if> 
                    <div class="form-div">
                            <form action="create-customer" method="POST" id="customerForm">
                               
                             
							<div>
								<label for="input-2">Email:</label>
								<input type="text" class="form-control error" name="email"/>
							</div>
							<div>
								<label for="input-3">Full Name:</label>
								<input type="text" class="form-control error" name="fullname"/>
							</div>
							<div>
								<label for="input-4">Password:</label>
								<input type="password" class="form-control error" name="pwd1" id="password"/>
							</div>
							<div>
								<label for="input-5">Confirm Password:</label>
								<input type="password" class="form-control error" name="pwd2"/>
							</div>
							
							<div>
								<label for="input-6">Phone No:</label>
								<input type="text" class="form-control error" name="phone"/>
							</div>
							<div>
								<label for="input-7">Address:</label>
								<input type="text" class="form-control error" name="address"/>
							</div>
							<div>
								<label for="input-8">City:</label>
								<input type="text" class="form-control error" name="city"/>
							</div>
							<div>
								<label for="input-9">Zip Code:</label>
								<input type="text" class="form-control error" name="zipcode"/>
							</div>
							<div>
								<label for="input-10">Country:</label>
								<input type="text" class="form-control error" name="country"/>
							</div>
							
                            <input type="submit" class="btn btn-primary" value="Save"/> &nbsp;<input class="btn btn-dark" type="reset" value="Cancel"/>

                    </form>
            </div>
            

        </div>
        
        <%@include file="/components/footer.jsp" %>
    </body>
    
    <script type="text/javascript">

			$(document).ready(function(){
				$("#customerForm").validate({
						rules:{
							email:{
								required: true,
								email:true
							},

							fullname:"required",
							pwd1:"required",
							
							pwd2:{
								required: true,
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
							pwd1:"Please enter password",
							pwd2:{
								required:"Please enter confirm password",
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