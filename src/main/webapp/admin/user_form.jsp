
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
    </head>
    <body>
    <%@include file="/components/header.jsp" %>
        <div class="user-form">
           <div>
                <h2>
                    <c:if test="${user!=null}">Edit User</c:if>
                    <c:if test="${user==null}">Create New User</c:if>
                        
                </h2>
            </div>
             
              <div class="form">
                      <c:if test="${user!=null}">
                            <form action="update-user" method="POST" id="userForm">
                             <input type="hidden" name="id" value="${user.id}">
                        </c:if>
                        <c:if test="${user==null}">
                            <form action="create-user" method="POST" id="userForm">
                        </c:if>
                     
						 <div class="mb-3">
						 	<label for="name">Name:</label>
						 	<input id="name" class="form-control error" placeholder="Enter name" name="name" type="text" value="${user.name}"/>
						 </div>
						 
						<div class="mb-3">
							 <label for="email">Email:</label>
							 <input id="email" class="form-control error" placeholder="Enter email id" name="email" type="email" value="${user.email}"/>
						</div>
						 
						 <div class="mb-3">
							 <label for="password">Password:</label>
							 <input id="password" class="form-control error" placeholder="Enter password" name="password"  type="password" value="${user.email}"/>
						 </div>
						
						 <div class="mb-3">
					   		<button type="submit" class="btn btn-primary" >Sign-Up</button> &nbsp;&nbsp;
		                   	 <button class="btn btn-dark" onclick="javascript:history.go(-1);">Cancel</button>
			                </div> 
                   </form>
      		</div>
            

        </div>
            <%@include file="/components/footer.jsp" %>
            
            
    </body>
    
    <script type="text/javascript">

			$(document).ready(function(){
				$("#userForm").validate({
						rules:{
							email:{
								required: true,
								email:true
							},

							name:"required",
							password:"required",
						},
						messages:{
							email:{
								required: "Please enetr email",
								email:"Please enter valid email"
							},
							
							name:"Please enter name",
							password:"Please enter password",
							
						}
					});
				});
	
				
            </script>
</html>


