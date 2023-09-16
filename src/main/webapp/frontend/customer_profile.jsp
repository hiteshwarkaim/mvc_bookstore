<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book World - Online Store</title>

</head>
<body>
	<jsp:include page="/components/header_frontend.jsp"/>
	
	<div align="center">
		 <h2>Customer Profile</h2>
		 
		 <table>
		 	<tr>
		 		<td>Email ID:	</td>
		 		<td>${loggedCustomer.email}</td>
		 	</tr>
		 	<tr>
		 		<td>Name:	</td>
		 		<td>${loggedCustomer.fullName}</td>
		 	</tr>
		 	<tr>
		 		<td>Phone:	</td>
		 		<td>${loggedCustomer.phone}</td>
		 	</tr>
		 	<tr>
		 		<td>Address:	</td>
		 		<td>${loggedCustomer.address}</td>
		 	</tr>
		 	<tr>
		 		<td>City:	</td>
		 		<td>${loggedCustomer.city}</td>
		 	</tr>
		 	<tr>
		 		<td>Zipcode:	</td>
		 		<td>${loggedCustomer.zipcode}</td>
		 	</tr>
		 	
		 	<tr>
		 		<td>Country:	</td>
		 		<td>${loggedCustomer.country}</td>
		 	</tr>
		 	<tr>
		 		<td colspan="2" align="center"><a href="edit-profile">Edit My Profile</a></td>
		 	</tr>
		 	
		 	
		 </table>
	</div>
	
	<jsp:include page="/components/footer.jsp"/>
</body>
</html>