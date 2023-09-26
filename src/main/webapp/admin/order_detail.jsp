 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body align="center">
    <%@include file="/components/header.jsp" %>
        <div class="">
            
            <div>
                 <h2>Details of Order ID: ${order.order_id}</h2>    
            </div> 
            <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if>
           	
           	<div>
           		<h2>Order Review:</h2>
           		<table>
           			<tr>
           				<td><strong>Ordered By:</strong></td>
           				<td>${order.customer.fullName}</td>
           			</tr>
           			<tr>
           				<td><strong>Quantity:</strong></td>
           				<td>${qty}</td>
           			</tr>
           			<tr>
           				<td><strong>Total Amount:</strong></td>
           				<td><fmt:formatNumber value="${order.total}" type="currency"/></td>
           			</tr>
           			<tr>
           				<td><strong>Recipient Name:</strong></td>
           				<td>${order.recipientName}</td>
           			</tr>
           			<tr>
           				<td><strong>Recipient Phone:</strong></td>
           				<td>${order.recipientPhone}</td>
           			</tr>
           			<tr>
           				<td><strong>Shipping Address:</strong></td>
           				<td>${order.shippingAddress}</td>
           			</tr>
           			<tr>
           				<td><strong>Payment method:</strong></td>
           				<td>${order.paymentMethod}</td>
           			</tr>
           			
           			<tr>
           				<td><strong>Ordered Status:</strong></td>
           				<td>${order.status}</td>
           			</tr>
           			<tr>
           				<td><strong>Ordered Date:</strong></td>
           				<td>${order.orderDate}</td>
           			</tr>
           			
           		</table>
           	</div>
           	
           	<div>
           		<h2>Ordered Books</h2>
				<table id="table-1">
						<tr>
							<th>Index</th>
							<th>Book Title</th>
							<th>Author</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Subtotal</th>
						</tr>
						<c:forEach items="${orderDetailById}" var="orderDetail" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>${orderDetail.book.b_title}</td>
							<td>${orderDetail.book.author}</td>
							<td>${orderDetail.book.price}</td>
							<td>${orderDetail.quantity}</td>
							<td>${orderDetail.subtotal}</td>
						</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>Total</td>
							<td><strong>${qty}</strong></td>
							<td><strong>${order.total}</strong></td>
						</tr>
				</table>
           	</div>

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
