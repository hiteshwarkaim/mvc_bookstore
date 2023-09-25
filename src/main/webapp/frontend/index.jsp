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
<body align="center">
	<jsp:include page="/components/header_frontend.jsp"/>
	
	<div>
		 <h2>New arrival</h2>
            <c:forEach items="${listNewBook}" var="book">
                <div style="display: inline-block">
                    <div>
                        <a href="view-book?id=${book.b_id}">
                            <img src="data:image/jpg;base64,${book.base64Image}" alt="image" style="width: 200px;margin: 15px;"/>
                        </a>
                    </div>
                    <div>
                        <strong>
                            <a href="view-book?id=${book.b_id}">${book.b_title}</a>
                        </strong>
                    </div>
                    <div>by ${book.author}</div>
                    <div>Rs. ${book.price}</div>
                </div>
            </c:forEach>
		<h2>Best Selling books </h2>
		<h2>Top books</h2>
	</div>
	
	<jsp:include page="/components/footer.jsp"/>
</body>
</html>