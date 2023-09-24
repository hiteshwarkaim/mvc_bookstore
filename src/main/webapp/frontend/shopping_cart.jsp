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
	
	<div>
		<h2>Shopping Cart</h2>
	</div>
	
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
       		<form action="update-cart" method="post" id="cartForm">
				<table id="table-1">
					<thead>
						<tr>
							<th>No</th>
							<th>Book</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Subtotal</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					 <c:forEach var="item" items="${cart.items}" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>
								<img src="data:image/jpg;base64,${item.key.base64Image}" alt="image" style="width: 100px;"/>
								&nbsp;
								${item.key.b_title}
							</td>
							<td>
								<input type="hidden" name="bookId" value="${item.key.b_id }"/>
								<input type="text" name="quantity${status.index+1}" value="${item.value}" size="4">
							</td>
							<td><fmt:formatNumber value="${item.key.price}" type="currency"/></td>
							<td><fmt:formatNumber value="${item.value*item.key.price}" type="currency"/></td>
							<td>
								<a href="remove-from-cart?bookId=${item.key.b_id}">Remove</a>
							</td>
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
       		
       	</div>
       	
       	<div>
       		<table>
       			<tr><td>&nbsp;</td></tr>
       			<tr>
	      			<td></td>
	      			<td><button type="submit">Update</button></td>
	      			<td><input type="button" id="clearCart" value="Clear Cart"/></td>
	      			<td><a href="${pageContext.request.contextPath}">Continue Shopping</a> </td>
	      			<td><a href="">Checkout</a></td>
       		</tr>
       		</table>
       	</div>
     </c:if>
     </form>
	<jsp:include page="/components/footer.jsp"/>
</body>

<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
		<script type="text/javascript">

			$(document).ready(function(){

				$("#clearCart").click(function(){
					window.location='clear-cart';
				});
				
				$("#cartForm").validate({
						rules:{
							<c:forEach items="${cart.items}" var="item" varStatus="status">
								quantity${status.index+1}: {
									required: true,
									number:true,
									min:1
								},
							</c:forEach>
						},
						messages:{
							<c:forEach items="${cart.items}" var="item" varStatus="status">
								quantity${status.index+1}: {
									required:"Please enter quantity",
									number:"Quantity must be a number",
									min:"Quantity must be minimum one"
								},
							</c:forEach>
						}
					});
			});
		</script>
</html>