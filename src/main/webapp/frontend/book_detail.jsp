<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/components/common_style.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
            <%@include file="/components/header_frontend.jsp" %>
       
            <div style="width: 80%;">
                <table>
                    <tr>
                        <td colspan="3" align="left">
                            <h2>${book.b_title}</h2>${book.author}
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="2">
                            <img src="data:image/jpg;base64,${book.base64Image}" alt="image" style="width: 400px;"/>
                        </td>
                        <td rowspan="2" valign="top" width="20%">
                            Rs. ${book.price}
                            <br>
                            <button id="buttonAddToCart">Add to Cart</button>
                        </td>
                        
                    </tr>
                    <tr>
                        <td valign="top">
                            ${book.desc}
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><h2>Customer Review</h2></td>
                        <td colspan="2" align="center">
                            <button id="writeReviewButton">Write a Customer Review</button>
                        </td>
                    </tr>
                   
                   <tr>
                   	<td colspan="3">
                   		<table>
                   			<c:forEach items="${findByBookId}" var="review">
                   				<tr>
                   					<td>
                   						<c:forTokens items="${review.stars}" delims="," var="star">
					                    	<c:if test="${star eq 'on'}">
												<img src="./static/images/star.png" height="18" width="18"/>
				                    		</c:if>
				                    		<c:if test="${star eq 'off'}">
												<img src="./static/images/star1.png" height="18" width="18"/>
				                    		</c:if>
					                    </c:forTokens>
                   					</td>
                   					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                   					<td>
                   						${review.headline }
                   					</td>
                   				</tr>
                   				
                   				<tr>
                   					<td></td>
                   					<td></td>
                   					<td>${review.comment }</td>
                   				</tr>
                   				<br>
                   			</c:forEach>
                   		</table>
                   	</td>
                   </tr>
                </table>
            </div>
            
            <%@include file="/components/footer.jsp" %>

        </div>
 <script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
        <script type="text/javascript">
			$(document).ready(function(){
				$('#writeReviewButton').click(function(){
					window.location='write-review?bookId='+${book.b_id};
				});

				$('#buttonAddToCart').click(function(){
					window.location='add-to-cart?bookId='+${book.b_id};
				});
				
			});
        </script>
</body>
</html>