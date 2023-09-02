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
                 <h1 class="pageheading">Category management</h1>    
                 <a href="category_form.jsp">Create New Category</a>
            </div> 
            <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if>
            <table class="table table-strips" border="1" width="800">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="cat" items="${allCategory}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${cat.cat_id}</td>
                            <td>${cat.name}</td>
                            <td> 
                                <a href="edit-category?id=${cat.cat_id}">Edit</a> &nbsp;&nbsp; 
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
