<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listspcss.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/detail.css">
</head>
<body>
    <div style="margin: 0 auto; width: 1040px; display: flex; flex-direction: column;">
        <div>Asm-GD1</div>
        <div>
         <%@ include file="menu.jsp" %>
        </div>																		
        <div style="margin-top: 10px">
            <jsp:include page="${view}"></jsp:include>
        </div>
    </div>
</body>
</html>
