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
          
        <div class="customer-form-div">
            
            <div>
                <h2>Edit Review </h2>
            </div>
            
             <c:if test="${message !=null }">
            	<div align="center">
            		<h4><i>${message}</i></h4>
            	</div>
            </c:if> 
                    <div class="form-div">
                    		
                    		<form action="update-review" method="POST" id="reviewForm">
                    	 	<input type="hidden" name="id" value="${review.review_id}">
	                        
							<div>
								<label for="input-1">Book: </label>
								<b>${review.book.b_title}</b>
							</div>
							<div>
								<label for="input-2">Rating: </label>
								<b>${review.rating}</b>
							</div>
							<div>
								<label for="input-3">Customer: </label>
								<b>${review.customer.fullName}</b>
							</div>
							
							<div>
								Headline:<input type="text" class="form-control error" name="headline" value="${review.headline}"/>
							</div>
							<div>
								Comment:<textarea rows="5" cols="62" name="comment">
									${review.comment}
								</textarea>
							</div>
							
                            <input type="submit" class="btn btn-primary" value="Save"/> &nbsp;<input class="btn btn-dark" type="reset" value="Cancel"/>

                    </form>
            </div>
            

        </div>
        
        <%@include file="/components/footer.jsp" %>
    </body>
    
    <script type="text/javascript">

			$(document).ready(function(){
				$("#reviewForm").validate({
						rules:{
							comment:"required",
							headline:"required",
						},
						messages:{
							
							comment:"Please enter comment",
							headline:"Please enter headline",
							
						}
					});
				});
	
				
            </script>
</html>