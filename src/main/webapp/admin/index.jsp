<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../static/css/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center" class="admin-index">
            <%@include file="/components/header.jsp" %>
            
            
            <h1>Admin Dashboard</h1>
            
            <div class="quick-action-links">
            <hr>
            	<h2>Quicks Actions:</h2>
            	<ul>
            		<li><a href="user_form.jsp">New User</a></li>
            		<li><a href="category_form.jsp">New Category</a></li>
            		<li><a href="create-book">New Book</a></li>
            		<li><a href="create-customer">New Customer</a></li>
            	</ul>
            </div>
            <hr>
            <h2>Recent Sales:</h2>
            <hr>
            <h2>Recent Reviews:</h2>
            <hr>
            <h2>Statistics:</h2>
            
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
</html>
