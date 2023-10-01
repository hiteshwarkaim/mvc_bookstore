<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          
	   <script type="text/javascript" src="./static/js/jquery-ui.min.js"></script> 
    </head>
    <body>
    	  <%@include file="/components/header_frontend.jsp" %>
          
        <div class="customer-form-div">
            
                   
			<table id="table-1" align="center">
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
						
					</tr>
					<tr>
						<td>${loggedcustomer.fullName}</td>
						<td colspan="2">
							<h2>Your review has been posted. Thank You!</h2>
						</td>
					</tr>
			</table>

        </div>
        
        <%@include file="/components/footer.jsp" %>
    </body>
</html>