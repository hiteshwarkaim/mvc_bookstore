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
                  <form action="create-book" method="POST" enctype="multipart/form-data">
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
                           
					   Title:<input type="text" name="title" value="${book.b_title}"/><br>
                       Author:<input type="text" name="author" value="${book.author}"/><br>
                       ISBN:<input type="text" name="isbn" value="${book.isbn}"/><br>
                       Publish Date:<input type="text" id="publishDate" name="publishdate" value="<fmt:formatDate pattern="MM/dd/yyyy" value='${book.publishDate}'/>" ><br> <!--taki hume bar -bar date select na krni pade-->
                       Price:<input type="text" name="price" value="${book.price}"/><br>
                       Description:<textarea name="desc">
                                       ${book.desc}
                                   </textarea><br>
                       Book Image:<input type="file" id="bookImage" name="bookimage" />
                       <img src="data:image/jpg;base64,${book.base64Image}" alt="alt" id="thumbnail" style="width: 10%;"/> <br>
                       
                  	  <input type="submit" value="Add Book"/>
                    </form>
            </div>
            <%@include file="/components/footer.jsp" %>

        </div>
               <script type="text/javascript">
                $(document).ready(function(){
                    $('#publishDate').datepicker();
                    $('#bookImage').change(function(){
                        showImageThumbnail(this);
                    });
                    
                    function showImageThumbnail(fileInput){
                        var file=fileInput.files[0];
                        
                        var reader=new FileReader();
                        
                        reader.onload=function(e){
                            $('#thumbnail').attr('src', e.target.result);
                        };
                        
                        reader.readAsDataURL(file);
                    }
                });
               </script>
    </body>
    
    
</html>


