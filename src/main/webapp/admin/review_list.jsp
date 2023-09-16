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
        <div class="category-list-div">
            
            <div>
                 <h1 class="pageheading">Review Management</h1>    
                 <a href="category_form.jsp">Create New Review</a>
            </div> 
            <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if>

            <table class="table table-strips" border="1" width="500">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>ID</th>
                        <th>Book</th>
                        <th>Rating</th>
                        <th>Headline</th>
                        <th>Customer</th>
                        <th>Review On</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="review" items="${allReview}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${review.review_id}</td>
                            <td>${review.book.b_title}</td>
                            <td>${review.rating}</td>
                            <td>${review.headline}</td>
                            <td>${review.customer.fullName}</td>
                            <td>${review.reviewDate}</td>
                            <td> 
                                <a href="">Edit</a> &nbsp;&nbsp; 
                                <a href="">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            

        </div>
	<%@include file="/components/footer.jsp" %>
            
    </body>
</html>
