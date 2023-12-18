<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cssAdmin.css">
</head>
<body style="width: 1240px;margin: 0 auto;">
    <div>
        <div>
            <%@ include file="menuAd.jsp" %>
        </div>																	
        <div style="margin-top: 10px">
            <jsp:include page="${viewad}"></jsp:include>
        </div>
    </div>
</body>
</html>