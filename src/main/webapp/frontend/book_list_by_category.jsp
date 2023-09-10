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
	            	<h2>${category.name}</h2>
	        	</div> 
	            
	            </div>
	            
            <%@include file="/components/footer.jsp" %>

        
    </body>
</html>