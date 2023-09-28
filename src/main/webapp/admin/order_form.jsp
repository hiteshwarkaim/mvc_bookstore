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
                 <h2>Edit Order ID: ${order.order_id}</h2>   
                 
            </div> 
            <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if>
           	
           	<div>
           		<h2>Order Review:</h2>
				<form id="form-1" action="update-order" method="post">
				<input type="hidden" name="orderId" value="${order.order_id}"/>
					<table>
           			<tr>
           				<td><strong>Ordered By:</strong></td>
           				<td>${order.customer.fullName}</td>
           			</tr>
           			<tr>
           				<td><strong>Recipient Name:</strong></td>
           				<td><input type="text" name="recipientName" value="${order.recipientName}"> </td>
           			</tr>
           			<tr>
           				<td><strong>Recipient Phone:</strong></td>
           				<td><input type="text" name="recipientPhone" value="${order.recipientPhone}"> </td>
           			</tr>
           			<tr>
           				<td><strong>Shipping Address:</strong></td>
           				<td><input type="text" name="shippingAddress" value="${order.shippingAddress}"> </td>
           			</tr>
           			<tr>
           				<td><strong>Payment method:</strong></td>
           				<td>
           					<select name="paymentMethod">
           						<option value="Cash On Delivery">Cash On Delivery</option>
           					</select>
           				</td>
           			</tr>
           			
           			<tr>
           				<td><strong>Ordered Status:</strong></td>
           				<td>
           					<select name="status">
           						<option value="Processing">Processing</option>
           						<option value="Shipping">Shipping</option>
           						<option value="Delivered">Delivered</option>
           						<option value="Completed">Completed</option>
           						<option value="Cancelled">Cancelled</option>
           					</select>
           				</td>
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
							<td>
								<a href="remove-book-from-order?id=${orderDetail.book.b_id }">Remove</a>
							</td>
						</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>Total</td>
							<td><strong>${qty}</strong></td>
							<td><strong>${total}</strong></td>
						</tr>
				</table>
           	</div>
           	<div>
           		<a href="javascript:showAddBookPopup()">Add Book</a> &nbsp;&nbsp;&nbsp;&nbsp;
           		<input type="submit" value="Update"/>&nbsp;&nbsp;&nbsp;&nbsp;
           		<input type="reset" value="Cancel"/>
           	</div>
		</form>
            <%@include file="/components/footer.jsp" %>

        </div>
		<script>
                function showAddBookPopup() {
                        window.open('add-book-form','_blank','width=300','height="300','top=100','left=100');
                }
            </script>
    </body>
</html>
