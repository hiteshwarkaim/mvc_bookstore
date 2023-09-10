 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.entities.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <div class="user-list-div">
            
            <div>
                 <h1>User management</h1>    
                 <a href="user_form.jsp">Create new user</a>
            </div> 
            
            <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if>
           
                       
            <table class="table table-strips" border="1" width="800">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Country</th>
                        <th>Phone</th>
                        <th>Zipcode</th>
                        <th>Register</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="customer" items="${allCustomers}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${customer.cust_id}</td>
                            <td>${customer.fullName}</td>
                            <td>${customer.email}</td>
                            <td>${customer.address}</td>
                            <td>${customer.city}</td>
                            <td>${customer.country}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.zipcode}</td>
                            <td>${customer.register}</td>
                            
                            
                            <td> 
                                <a href="edit-user?id=${customer.cust_id}">Edit</a> &nbsp;&nbsp; &nbsp;&nbsp; 
                                <a href="javascript:confirmDelete(${customer.cust_id})"> Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%@include file="/components/footer.jsp" %>

        </div>
		<script>
                function confirmDelete(customerId) {
                    if(confirm("are sure to delete: "+customerId+"?"))
                    {
                        window.location='delete-customer?id=' + customerId;
                    }
                }
            </script>
    </body>
</html>
