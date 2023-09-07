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
    	<%@include file="/components/header.jsp" %>
        
        <div align="center">
             
            <div>
                <h2>Create new Book</h2>
            </div>
             
            <div>
                        
                <form action="create-book" method="POST" enctype="multipart/form-data">
                    
       
                    Category:<select name="category">
                                <c:forEach items="${listCategory}" var="category">
                                      <option value="${category.cat_id}"> ${category.name}</option>
                                </c:forEach>
                    </select><br>
                    Title:<input type="text" name="title" value="${book.b_title}"/><br>
                    Author:<input type="text" name="author" value="${book.author}"/><br>
                    ISBN:<input type="text" name="isbn" value="${book.isbn}"/><br>
                    Publish Date:<input type="text" id="publishDate" name="publishdate" value="${book.publishDate}" ><br> <!--taki hume bar -bar date select na krni pade-->
                    Price:<input type="text" name="price" value="${book.price}"/><br>
                    Description:<textarea name="desc">
                                    ${book.desc}
                                </textarea><br>
                    Book Image:<input type="file" id="bookImage" name="bookimage" />
                     
                    
                	<input type="submit" value="Add Book"/>

       			 </form>
            </div>

        </div>
        
        <%@include file="/components/footer.jsp" %>
			
    </body>
    
    
</html>


