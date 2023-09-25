<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book World - Online Store</title>
</head>
<body align="center">
	<jsp:include page="/components/header_frontend.jsp"/>
	
	<c:if test="${message !=null }">
       	<div align="center">
       		<h4><i>${message}</i></h4>
       	</div>
     </c:if>
     
     <c:set var="cart" value="${sessionScope['cart']}"/>
     
     <c:if test="${cart.totalItems==0 }">
       	<h2>There is no item in your cart</h2>
     </c:if>
     
     <c:if test="${cart.totalItems>0 }">
       	<div>
       		<h2>Review your cart details <a href="view-cart">Edit</a></h2>
    			<table id="table-1">
					<thead>
						<tr>
							<th>No</th>
							<th>ID</th>
							<th>Book</th>
							<th>Author</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Subtotal</th>
						</tr>
					</thead>
					<tbody>
					 <c:forEach var="item" items="${cart.items}" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>
								${item.key.b_id}
								<input type="hidden" name="bookId" value="${item.key.b_id }"/>
							</td>
							<td>
								<img src="data:image/jpg;base64,${item.key.base64Image}" alt="image" style="width: 100px;"/>
								&nbsp;
								${item.key.b_title}
							</td>
							<td>${item.key.author}</td>
							<td><fmt:formatNumber value="${item.key.price}" type="currency"/></td>
							<td><input type="text" name="quantity${status.index+1}" value="${item.value}" size="4" readonly="readonly"></td>
							<td><fmt:formatNumber value="${item.value*item.key.price}" type="currency"/></td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td><strong>${cart.totalQuantity} book(s)</strong></td>
						<td>Total:</td>
						<td><strong><fmt:formatNumber value="${cart.totalAmount}" type="currency"/></strong></td>
					</tr>
				</tbody>
			</table>
			
			<h2>Your Shipping Information</h2>
			<form id="orderForm" action="place-order" method="post">
				<table id="">
					<tr>
						<td>Recipient Name:</td>
						<td><input type="text" name="recipientname" value="${loggedCustomer.fullName}"></td>
					</tr>
					<tr>
						<td>Recipient Phone:</td>
						<td><input type="text" name="recipientphone" value="${loggedCustomer.phone}"></td>
					</tr>
					<tr>
						<td>Recipient Address:</td>
						<td><input type="text" name="recipientaddress" value="${loggedCustomer.address}"></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><input type="text" name="city" value="${loggedCustomer.city}"></td>
					</tr>
					<tr>
						<td>Zipcode:</td>
						<td><input type="text" name="zipcode" value="${loggedCustomer.zipcode}"></td>
					</tr>
					<tr>
						<td>Country:</td>
						<td><input type="text" name="country" value="${loggedCustomer.country}"></td>
					</tr>
					
				</table>
				<div>
					<h2>Payment</h2>
					Choose your payment method: &nbsp;&nbsp;&nbsp;&nbsp;
					<select name="paymentmethod">
						<option value="Cash On delivery">Cash On Delivery</option>
					</select>
				</div>
				<div>
					<table>
		       			<tr><td>&nbsp;</td></tr>
		       			<tr>
		       				<td><button type="submit" style="width: 120px">Place Order</button></td>
			      			<td><a href="${pageContext.request.contextPath}">Continue Shopping</a> </td>
			      		</tr>
       				</table>
				</div>
			</form>
       	</div>
       	
     </c:if>
    <jsp:include page="/components/footer.jsp"/>
</body>

<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
		<script type="text/javascript">

			$(document).ready(function(){

				$("#orderForm").validate({
						rules:{
							recipientname:"required",
							recipientphone:"required",
							recipientaddress:"required",
							city:"required",
							zipcode:"required",
							country:"required"
						},
						messages:{
							recipientname:"Please enter Recipient name",
							recipientphone:"Please enter your phone number",
							recipientaddress:"Please enter address",
							city:"Please enter city",
							zipcode:"Please enter zipcode",
							country:"Please enter country"
						}
					});
			});
		</script>
</html>