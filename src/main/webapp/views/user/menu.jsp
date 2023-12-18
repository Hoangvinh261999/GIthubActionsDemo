<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.lang}" scope="request" />
	<fmt:setBundle basename="global" scope="request"/>
	<c:url var="home" value="${pageContext.request.contextPath}" />
	<ul class="menu">
		<li><a href="/asmGd1_java4/index"
			style="font-size:large; color: red; font-weight: bolder;"><fmt:message
					key="menu.name" /></a></li>
		<li><a href="favorite"><fmt:message key="menu.favorite" /></a></li>
		<li class="has-submenu"><a href="#"><fmt:message
					key="menu.account" /></a>
			<ul class="submenu">
				<li><a href="/asmGd1_java4/login"><fmt:message
							key="submenu.login" /></a></li>
				<li><a href="/asmGd1_java4/forgotpass"><fmt:message
							key="submenu.fogotpass" /></a></li>
				<li><a href="/register"><fmt:message
							key="submenu.registration" /></a></li>
				<li><a href="logout"><fmt:message key="submenu.logout" /></a></li>
				<li><a href="/asmGd1_java4/changepass"><fmt:message
							key="submenu.changepass" /></a></li>
				<li><a href="/asmGd1_java4/editprofile"><fmt:message key="submenu.edit" /></a></li>
			</ul></li>

		<div
			style="display: flex; margin-left: 250px; justify-content: center; align-items: center; gap: 15px">
			<a href="?lang=en"><img src="/asmGd1_java4/img/uk.png"
				alt="Poster"></a> <a href="?lang=vi"><img
				src="/asmGd1_java4/img/vn.png" alt="Poster"></a> <a href="#v ">
				<img alt="" src="/asmGd1_java4/img/account.png"
				style="width: 40px; height: 40px">
			</a>
			<p>${userlogin.id}</p>
		</div>
	</ul>


</body>
</html>