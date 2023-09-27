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
				<h3>Add book ${book.b_title} to Order ID: ${order.order_id }</h3>
				<input type="button" value="Close" onclick="javascript:self.close();"/>
        </div>
        
        <script type="text/javascript">
			window.onunload=function(){
				window.opener.location.reload();
			}
        </script>
    </body>
</html>


