<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
                    	<c:forTokens delims="," items="${book.stars}" var="star">
                    		<c:if test="${star eq 'on'}">
								<img src="./static/images/star.png"/>
                    		</c:if>
                    		<c:if test="${star eq 'off'}">
								<img src="./static/images/star1.png" height="18" width="18"/>
                    		</c:if>	
                    		<c:if test="${star eq 'half'}">
								<img src="./static/images/star2.png" />
                    		</c:if>
                    		
                    	</c:forTokens> 
                    </div>
                    