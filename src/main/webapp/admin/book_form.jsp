<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../static/css/jquery-ui.min.css"/>
        
    </head>
    <body>
        <div align="center">
            <%@include file="/components/header.jsp" %>
          
            
            <div>
                <h2>
                    <c:if test="${book!=null}">Edit Book</c:if>
                    <c:if test="${book==null}">Create new Book</c:if>
                        
                </h2>
            </div>
             
                    <div>
                    
                 
                        <form>
                               
                             Category:<select name="category">
                                         <c:forEach items="${listCategory}" var="category">
                                             <c:if test="${category.cat_id eq book.category.cat_id}">
                                                 <option value="${category.cat_id}" selected>
                                             </c:if>
                                             <c:if test="${category.cat_id ne book.category.cat_id}">
                                                 <option value="${category.cat_id}">
                                             </c:if>
                                                 ${category.name}    
                                                 </option>
                                         </c:forEach>
                             </select><br>
                             

                    </form>
            </div>
            <%@include file="/components/footer.jsp" %>

        </div>
           
    </body>
    
    
</html>


