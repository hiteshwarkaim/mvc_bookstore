<%@page import="com.bookstore.entities.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.entities.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            
        </script>
    </head>
    <body>
   		 <%@include file="/components/header.jsp" %>
        <div class="book-list-div" align="center">
            <div>
                 <h1 class="pageheading">Book management</h1>    
                 <a href="new-book">Create new book</a>
            </div> 
            <c:if test="${message!=null}">
                <h4 class="message">${message}</h4>
            </c:if>
            
            <table border="1" width="1000" class="table table-striped">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>ID</th>
                        <th>Image</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Last updated</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="book" items="${allBooks}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${book.b_id}</td>
                            <td style="height: 150px;width: 50px">
                                <img src="data:image/jpg;base64,${book.base64Image}" alt="image" style="width: 140px;"/>
                            </td>
                            <td>${book.b_title}</td>
                            <td>${book.author}</td>
                            <td>${book.category.name}</td>
                            <td>Rs. ${book.price}</td>
                            <td> <fmt:formatDate pattern="MM/dd/yyyy" value='${book.lastUpdateTime}'/></td>
                            <td> 
                                <a href="edit-book?id=${book.b_id}">Edit</a> &nbsp;&nbsp; 
                                <a href="javascript:confirmDelete(${book.b_id})">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>
            <%@include file="/components/footer.jsp" %>

			<script>
                function confirmDelete(bookId) {
                    if(confirm("Are sure to delete: "+bookId+"?"))
                    {
                        window.location='delete-book?id=' + bookId;
                    }
                }
            </script>
    </body>
</html>
