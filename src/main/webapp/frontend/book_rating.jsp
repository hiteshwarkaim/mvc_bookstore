
<div>
                    	<c:forTokens delims="," items="${book.ratingStars}">
                    		<c:if test="${star eq 'on'}">
								<img src="../static/images/star.png"/>
                    		</c:if>
                    		<c:if test="${star eq 'off'}">
								<img src="../static/images/star1.png"/>
                    		</c:if>	
                    		<c:if test="${star eq 'half'}">
								<img src="../static/images/star2.png"/>
                    		</c:if>
                    		
                    	</c:forTokens> 
                    </div>
                    