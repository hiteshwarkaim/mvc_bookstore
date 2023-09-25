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
        <div class="">
            
            <div>
                 <h1>Order Management</h1>    
                 <a href="user_form.jsp">Create New User</a>
            </div> 
            
            <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if>
           
                       
            <table class="table table-strips" border="1" width="1000">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>Order ID</th>
                        <th>Order by</th>
                        <th>Book Copies</th>
                        <th>Order Date</th>
                        <th>Payment method</th>
                        <th>Total</th>
                        <th>Status</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="order" items="${allOrders}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${order.order_id}</td>
                            <td>${order.customer.fullName}</td>
                            <td>${order.bookCopies}</td>
                            <td>${order.orderDate}</td>
                             <td>${order.paymentMethod}</td>
                            <td>${order.total}</td>
                            <td>${order.status}</td>
                            <td>
                            	<a href="view-order?id=${order.order_id}">Detail</a> &nbsp;&nbsp; &nbsp;&nbsp; 
                                <a href="edit-order?id=${order.order_id}">Edit</a> &nbsp;&nbsp; &nbsp;&nbsp; 
                                <a href="javascript:confirmDelete(${order.order_id})"> Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%@include file="/components/footer.jsp" %>

        </div>
		<script>
                function confirmDelete(userId) {
                    if(confirm("are sure to delete: "+orderId+"?"))
                    {
                        window.location='delete-order?id=' + orderId;
                    }
                }
            </script>
    </body>
</html>
