<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <style type="text/css">
        	
        	.header{
        		display: flex;
        	}
        	.header img{
        		width: 10rem;
				height: 10rem;
				margin-left: 10rem;
				margin-top: -1%;
        	}
        	.header-links{
        		margin-top:4rem;
				margin-left: 150px;
        	}
        	.header-links ul li{
        		display: inline-block;
        		list-style: none;
        	}
        	
        	.header-links ul li a{
        		margin-left: 14px;
				font-size: 17px;
				color: darkblue;
				font-weight: 600;
				padding: 8px 10px;
				text-decoration: none;
        	}
        	form{
        		margin-top:4rem;
				margin-left: 150px;
        	}
        	
        	form input{
				height: 35px;
				border-style:none;
				border-radius: 5%;
				background-color: lightgray;
			}
		
			form button{
				height: 35px;
				width: 80px;
				border-style:none;
				border-radius: 5%;
				background-color:darkblue;
				color: white;
			}
		    
        	
        	.category{
        		margin-top: 10px;
				text-align: center;
				background-color: #E4F1FF;	
				width: 50%;
				height:32px;
				margin: auto;
				border-radius: 30px;	
        	}
        	.category a{
        		margin-left: 20px;
        		text-decoration: none;
        		font-size: 20px;	
        		padding: 6px 16px;
        		font-weight: bold;
        		color: #900C3F;
        	}
        	.category a:hover{
        		color: darkblue;
        		text-decoration: none;
        	}
        	
        	
        	.register-links{
        		margin-top:4rem;
				margin-left: 150px;
        	}
        	.register-links ul li{
        		display: inline-block;
        		list-style: none;
        	}
        	
        	.register-links ul li a{
        		margin-left: 14px;
				font-size: 17px;
				color: darkblue;
				font-weight: 600;
				padding: 8px 10px;
				text-decoration: none;
        	}
        	.register-links ul li a:hover, .header-links ul li a:hover{
        		background-color: darkblue;
				color:white;
				padding: 8px 10px;
        	}
        	
        	a:link { text-decoration: none; }

			a:visited { text-decoration: none; }
			
			a:hover { 
				text-decoration: underline; 
				color: darkblue;
			}
			
			a:active { 
				color: red;	
			}
			        	
        	
        </style>
    </head>
    <body>

    	<div class="header">
    		<div class="logo-img">
				<img alt="logo" src="./static/images/logo.png" height="100" width="150"/>
				
    		</div>
    		<div class="header-links">
    			<ul>
					<li><a href="register-customer">Home</a></li>
                    <li><a href="login-customer">Contact-Us</a></li>
                    <li><a href="#">Order</a></li>
                    <li><a href="view-cart">Cart</a></li>
                </ul>
    		</div>
    		<div class="form-div1">
				<form id="form-1" action="search">
					<input placeholder="Search here" name="search" type="text" size="35"/>
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
    	
    	<div class="category">
    		
    			<c:forEach var="category" items="${allCategory}" varStatus="status">
    				  <a href="view-category?id=${category.cat_id}">
                        <c:out value="${category.name}"/>
                    </a>
    			</c:forEach>
    		</div>
    		
    		<hr>
      
      		<div style="margin-bottom: 30px;">
    		</div>
    		
    </body>
</html>
 