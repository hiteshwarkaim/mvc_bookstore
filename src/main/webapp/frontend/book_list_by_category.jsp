<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books in ${category.name}</title>
    </head>
    <body>
    	<jsp:directive.include file="/components/header_frontend.jsp"/>
	    
        <div align="center">
            
            <div>
            	<h2 style="color: darkblue;margin-bottom: 30px;">${category.name}</h2>
        	</div> 
			
			<div>
				<c:forEach items="${listBookByCategory}" var="book">
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
	                    <div>Ratting *****</div>
	                    <div>by ${book.author}</div>
	                    <div>Rs. ${book.price}</div>
	                </div>
           		 </c:forEach>
			</div>
			            
         </div>
            
         <%@include file="/components/footer.jsp" %>
    </body>
</html>