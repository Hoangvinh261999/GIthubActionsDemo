<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
		
			
           <c:forEach var="items" items="${listvd}" varStatus="loop">		
    			<c:if test="${loop.index < 4}">
        <div class="grid" style="    margin-top: 10px;">
            <div class="poster">
                <div class="im">
					      <img src="/asmGd1_java4/img/${items.img}" alt="Poster">
                </div>
					    <div class="video-title">
					      <h4 style="margin-left: 15px">${items.title}</h4>
					    </div>
					    <div class="like-share">
					      <button class="like">Thích</button>
					      <button class="share">Chia sẻ</button>
					    </div>
            </div>
        </div>
    </c:if>
		</c:forEach> --%>
<div class="grid-container">



  		<c:forEach var="items" items="${listvd}" varStatus="loop">		
  		<c:if test="${loop.index < 3}">
  						  <div class="grid">
					    <div class="poster">
					      <img src="/asmGd1_java4/img/${items.img}" alt="Poster">
					    </div>
					    <div class="video-title">
					      <h4 style="margin-left: 15px">${items.title}</h4>
					    </div>
					    <div class="like-share">
					      <button class="unlike">Thích</button>
					      <button class="share">Chia sẻ</button>
					    </div>
					  </div>
</c:if>
	
		</c:forEach>
</div>

</body>
</html>