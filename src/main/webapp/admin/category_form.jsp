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
                <h2>
                    <c:if test="${category!=null}">Edit Category</c:if>
                    <c:if test="${category==null}">Create new Category</c:if>
                        
                </h2>
            </div>
          
             
              <div>
                      <c:if test="${category!=null}">
                            <form action="update-category" method="POST" onsubmit="return validateForm()">
                             <input type="hidden" name="id" value="${category.cat_id}">
                        </c:if>
                        <c:if test="${category==null}">
                            <form action="create-category" method="POST" onsubmit="return validateForm()">
                        </c:if>
             
                       Name:<input type="text" id="cat" name="name" value="${category.name}"/><br>
                       <input type="submit" value="Add category" "/>

              		</form>
      		 </div>
        </div>
       <%@include file="/components/footer.jsp" %>
       
       
    </body>
    
    <script type="text/javascript">
       function validateForm(){
    	   var catName=document.getElementById("cat");
    	   
			if(catName.value.length==0)
			{
				alert("Name is required");
				catName.focus();
				return false;
			}
			return true;
       }
       </script>
</html>


