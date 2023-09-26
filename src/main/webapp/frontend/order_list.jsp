 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
    <%@include file="/components/header_frontend.jsp" %>
        <div class="">
            
            <div>
                 <h1>Your Order History</h1>    
            </div> 
            
            
            <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if>
            
            
            <c:if test="${fn:length(listOrders) ==0 }">
            	<h3>You have not placed any order yet</h3>
            </c:if>
            <c:if test="${fn:length(listOrders) >0 }">
				<table border="1" width="1000">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>Order ID</th>
                        <th>Amount</th>
                        <th>Order Date</th>
                        <th>Status</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="order" items="${listOrders}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${order.order_id}</td>
                            <td>${order.total}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.status}</td>
                            <td>
                            	<a href="show-order-detail?id=${order.order_id}">View Detail</a> &nbsp;&nbsp; &nbsp;&nbsp; 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
				
            </c:if>
                        
            
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
