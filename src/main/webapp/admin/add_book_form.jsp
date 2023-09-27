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
    	
        <div align="center">
				<h3>Add book to Order ID: ${order.order_id }</h3>
        </div>
        
		<form action="add-book-to-order">
			<table>
				<tr>
					<td>Select a book:</td>
					<td>
						<select name="bookId">
							<c:forEach items="${listAll}" var="book" varStatus="status">
								<option value="${book.b_id}">${book.b_title}-${book.author}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr><td>&nbsp;&nbsp;</td></tr>
				<tr>
					<td>Quantity:</td>
					<td>
						<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Save"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="Cancel" onclick="javascript:self.close();"/>
					</td>
				</tr>
			</table>
		</form>
        
        </body>
</html>


