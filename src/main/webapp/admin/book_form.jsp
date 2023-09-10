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
        <link rel="stylesheet" href="/path/to/font-awesome.min.css" />
        <link rel="stylesheet" href="../static/css/richtext.min.css">
        
        <script type="text/javascript" src="../static/js/jquery.richtext.min.js"></script>
        <script src="/path/to/cdn/jquery.min.js"></script>
        
    </head>
    <body>
    	<%@include file="/components/header.jsp" %>
        
        <div align="center" class="book-form-div">
             
            <div>
                <h2>
                	<c:if test="${book!=null}">Edit Book</c:if>
                    <c:if test="${book==null}">Create new Book</c:if>
                </h2>
            </div>
             
            <div class="form-div">
                 		<c:if test="${book!=null}">
                            <form action="update-book" method="post" enctype="multipart/form-data" id="bookForm">
                             <input type="hidden" name="id" value="${book.b_id}">
                        </c:if>
                        <c:if test="${book==null}">
                            <form action="create-book" method="POST" enctype="multipart/form-data" id="bookForm">
                        </c:if>
                    
							<div>
								<label for="input-1">Category:</label>
								
									<select name="category" class="form-select" aria-label="Default select example">
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
                    				</select>
							</div>
							<div>
								<label for="input-2">Title:</label>
								<input type="text" class="form-control error" name="title" value="${book.b_title}"/>
							</div>
							<div>
								<label for="input-3">Author:</label>
								<input type="text" class="form-control error" name="author" value="${book.author}"/>
							</div>
							<div>
								<label for="input-4">ISBN:</label>
								<input type="text" class="form-control error" name="isbn" value="${book.isbn}"/>
							</div>
							<div>
								<label for="input-5">Publish Date:</label>
								<input type="text" class="form-control error" id="publishDate" name="publishdate" value="<fmt:formatDate pattern="MM/dd/yyyy" value='${book.publishDate}'/>" >
							</div>
							<div>
								<label for="input-6">Price:</label>
								<input type="text" class="form-control error" name="price" value="${book.price}"/>
							</div>
							<div>
								<label for="input-7">Description:</label>
								
									<textarea name="desc" id="description" class="form-control error" rows="6" cols="50"> ${book.desc} </textarea>
								
							</div>
							<div>
								<label for="input-8" class="form-label">Book Image:</label>
								
									<input type="file"  class="form-control error" id="bookImage" name="bookimage" />
									<img src="data:image/jpg;base64,${book.base64Image}" alt="alt" id="thumbnail" style="width: 10%;"/>
                     		</div>
							<div>
								
								<input class="btn btn-primary" type="submit" value="Add Book"/>
								
							</div>
					
       			 </form>
       			 
            </div>

        </div>
        
        <%@include file="/components/footer.jsp" %>
			
			<script type="text/javascript">
                $(document).ready(function(){
                    $('#publishDate').datepicker();
                    $('#description').richText();
					
                    $('#bookImage').change(function(){
                        showImageThumbnail(this);
                    });

                    $("#bookForm").validate({
						rules:{
							category:"required",
							title:"required",
							author:"required",
							isbn:"required",
							publishdate:"required",
							price:"required",
							desc:"required",

							<c:if test="${book==null}">
								bookimage:"required"
							</c:if>
						},
						messages:{
							
							category:"Please select category",
							title:"Please enter title",
							author:"Please enter author",
							isbn:"Please enter isbn",
							publishdate:"Please enter publish date",
							price:"Please enter price",
							desc:"Please enter description",
							bookimage:"Please select image"
							
						}
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


