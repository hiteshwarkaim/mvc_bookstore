
<%@include file="common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Header</title>
    </head>
    <body>
    	<div class="header">
    		<div class="logo-img">
				<img alt="logo" src="../static/images/logo.png"/>
    		</div>
    		<div class="header-links">
    			<ul>
					<li><a href="register-customer">Home</a></li>
                    <li><a href="login-customer">Contact-Us</a></li>
                    <li><a href="#">Order</a></li>
                    <li><a href="view-cart">Cart</a></li>
                </ul>
    		</div>
    		<div>
				<form id="form-1">
					<input placeholder="Search here" type="text" size="35"/>
					<button>Search</button>
				</form>
    		</div>
    		<div class="register-links">
    			<ul>
					<li><a href="register-customer">Register</a></li>
                    <li><a href="login-customer">Signin</a></li>
                </ul>
    		</div>
    	</div>
       
        
    </body>
</html>
