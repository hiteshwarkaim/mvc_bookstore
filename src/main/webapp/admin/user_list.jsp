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
        <div class="user-list-div">
            
            <div>
                 <h1>User Management</h1>    
                 <a href="user_form.jsp">Create New User</a>
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
                        <th>Email</th>
                        <th>Name</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="user" items="${allUsers}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td> 
                                <a href="edit-user?id=${user.id}">Edit</a> &nbsp;&nbsp; &nbsp;&nbsp; 
                                <a href="javascript:confirmDelete(${user.id})"> Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%@include file="/components/footer.jsp" %>

        </div>
		<script>
                function confirmDelete(userId) {
                    if(confirm("are sure to delete: "+userId+"?"))
                    {
                        window.location='delete-user?id=' + userId;
                    }
                }
            </script>
    </body>
</html>
