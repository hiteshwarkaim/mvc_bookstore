<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<%@include file="common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../static/css/style.css"></link>
       	<title>Header</title>
    </head>
    <body>
        <div class="adminheader">	
			
            <h4 class="welcome">Welcome, <c:out value="${sessionScope.userEmail}"></c:out> | <a href="logout">Logout</a> </h4>
            <div class="headermenu">
	                <div>
	                	<a href="${pageContext.request.contextPath}/admin">
	                		<img src="../static/images/logo.png" style="float: left;margin-left:-300px;margin-right:150px; height: 200px;width: 200px;"/>
	                	</a>
	                </div>
                    <div>
                        <a href="list-users">
                            <img src="../static/images/user.png" alt="alt" width="70" height="70"/><br>Users
                        </a> 
                    </div>
                    <div>
                        <a href="list-category">
                            <img src="../static/images/category.png" alt="alt" width="70" height="70"/> <br>Categories
                        </a> 
                     </div>
                    <div>
                        <a href="list-books">
                            <img src="../static/images/book.png" alt="alt" width="70" height="70"/> <br>Books
                        </a>
                    </div>
                    <div>
                        <a href="list-customers">
                            <img src="../static/images/customer.png" alt="alt" width="70" height="70"/><br> Customers
                        </a> 
                     </div>
                    <div>
                        <a href="list-order">
                            <img src="../static/images/order.png" alt="alt" width="70" height="70"/> <br>Orders
                        </a>  
                     </div>
                    <div>
                        <a href="list-reviews">
                            <img src="../static/images/review.png" alt="alt" width="70" height="70"/><br> Reviews
                        </a>
                     </div>
                
            </div>
            
            
        </div>
        
    </body>
</html>
