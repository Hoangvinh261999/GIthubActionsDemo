<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
</head>
<body>
  <div class="grid-container">
<c:forEach var="items" items="${subListPage}" varStatus="loop">
        <div class="grid">
            <div class="poster">
                <a href="${pageContext.request.contextPath}/detail?idlist=${items.id}">
                    <img src="/asmGd1_java4/img/${empty items.poster ? 'default.JPG' : items.poster}" name="Poster" style="width: 270px;height: 240px">
                </a>
            </div>
            <div class="video-title">
                <h4 style="margin-left: 15px">${items.title}</h4>
            </div>
        </div>
</c:forEach>


</div>
	    <div style="display:flex;justify-content: center; margin-top: 20px; gap:30px" >
  			<div class="last-page"><a href="/asmGd1_java4/index/page?idp=first"> Page 1 </a></div>
  			<div class="last-page"><a href="/asmGd1_java4/index/page?idp=Previous"> Previous </a></div>
  			<div class="last-page"><a href="/asmGd1_java4/index/page?idp=next"> Next </a></div>
  			<div class="Lastpage"><a href="/asmGd1_java4/index/page?idp=last"> Page end </a></div>
  </div>

	
</body>
</html>

