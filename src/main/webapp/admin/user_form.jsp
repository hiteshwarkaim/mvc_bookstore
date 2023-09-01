
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h2>Create New Use </h2>
            </div>
             
              <div class="form">
                     <form action="create-user" method="POST" onsubmit="return validateForm()">
                     
						 <div class="mb-3">
						 	<label for="input-1">Name:</label>
						 	<input id="input-1" class="form-control" placeholder="Enter name" name="name" type="text"/>
						 </div>
						 
						<div class="mb-3">
							 <label for="input-2">Email:</label>
							 <input id="input-2" class="form-control" placeholder="Enter email id" name="email" type="email"/>
						</div>
						 
						 <div class="mb-3">
							 <label for="input-3">Password:</label>
							 <input id="input-3" class="form-control" placeholder="Enter password" name="password"  type="password"/>
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
				function validateForm(){
					var name=document.getElementById("input-1");
					var email=document.getElementById("input-2");
					var pwd=document.getElementById("input-3");
					
					if(name.value.length==0){
						alert("Name is required");
						name.focus();
						return false;
					}

					if(email.value.length==0){
						alert("Email is required");
						email.focus();
						return false;
					}

					if(pwd.value.length==0){
						alert("Password is required");
						pwd.focus();
						return false;
					}
				return true;
				}
            </script>
</html>


