<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="./static/css/style.css"/>
        <link rel="stylesheet" href="./static/css/jquery-ui.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
          
          
    </head>
    <body>
    	  <%@include file="/components/header_frontend.jsp" %>
          
        <div class="customer-form-div">
            
            <div>
                <h2>Write Review</h2>
            </div>
            
            
             <div class="form-div" >
             
             		<form action="submit-review" method="POST" id="reviewForm">
                   
						<table id="table-1">
								<tr>
									<td>Your Review:</td>
									<td>&nbsp;</td>
									<td><strong>${loggedCustomer.fullName}</strong></td>
								</tr>
								<tr>
									<td colspan="3"><hr></td>
								</tr>
								<tr>
									<td>
										${book.b_title} <br>
										<img src="data:image/jpg;base64,${book.base64Image}" alt="image" style="width: 200px;"/>
									</td>
									<td>
									<td>
										<div id="rateYo"></div>
										<input type="hidden" id="rating" name="rating"/>
										<input type="hidden" id="bookId"  name="bookId" value="${book.b_id}"/>
										<br>
										<input type="text" size="68" name="headline" placeholder="write headline" style="background-color: white;border:1px solid black;"/><br>
										<textarea rows="10" cols="70" placeholder="comment" name="comment"></textarea>
									</td>
									<td>${loggedcustomer.fullName}</td>
								</tr>
								<tr>
									<td colspan="3">
										<input type="submit"  value="Submit"/>
									</td>
								</tr>
						</table>
					</form>
    		 </div>

        </div>
        
        <%@include file="/components/footer.jsp" %>
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
    <script type="text/javascript" src="../static/js/jquery.validate.min.js"></script>
    <script type="text/javascript">
    		$(document).ready(function(){
        		
    			
    				 
    			$("#rateYo").rateYo({
					  starWidth: "40px",
				        fullStar:true,
				        onSet:function(rating, rateYoInstance){
							$('#rating').val(rating);
					    }
				  });
  			});
            </script>
</html>