<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <%@include file="/components/header.jsp" %>
        <div align="center">
           
          
            <div>
                <h2>Create New Category</h2>
            </div>
             
              <div>
                      <form action="create-category" method="POST">
             
                       Name:<input type="text" name="name"/><br>
                       <input type="submit" value="Add category"/>

              		</form>
      		 </div>
        </div>
       <%@include file="/components/footer.jsp" %>
    </body>
</html>


