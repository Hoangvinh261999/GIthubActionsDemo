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
			<div class="container">
			    <div class="vid">
            <div class="boder">
                <iframe width="100%" height="315" src="https://www.youtube.com/embed/${idlist}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
            </div>
            <div>
                <strong> <h1 style="background-color:green">${videodetail.title}</h1> </strong>
            </div>
            <div>
                <strong> <h2>${videodetail.description}</h2> </strong>
            </div>
            <div class="like-share">
            <a href="<%= request.getContextPath() %>/like" style="color: red; margin-right: 20px;font-size: large;">Like</a>
            <a href="<%= request.getContextPath() %>/share" style="color: red;font-size: large;">Chia Sẻ</a>
            

            </div>
        </div>
			    <div class="favorite">
            			<div class="vit" style="display: flex; flex-direction: column;">
           <c:forEach var="items" items="${listvd}" varStatus="loop">		
    <c:if test="${loop.index < 4}">
        <div class="grid" style="    margin-top: 10px;">
            <div class="poster">
                <div class="img1">
            <a href="${pageContext.request.contextPath}/detail?idlist=${items.id}">
                 <img src="/asmGd1_java4/img/${empty items.poster ? 'default.JPG' : items.poster}" name="Poster" style="width: 150px;height: 100px">
                </a>
                </div>
                <div class="title">
                    <p>${items.title}</p>
                </div>
            </div>
        </div>
    </c:if>
		</c:forEach>
            			</div>
			    </div>
			</div>

</body>
</html>