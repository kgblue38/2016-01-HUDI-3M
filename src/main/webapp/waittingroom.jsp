<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="inpoker.controller.UserController"%>
<%@ page import="inpoker.users.model.Users"%>
<%@ page import="inpoker.users.model.User"%>
<%@ page import="inpoker.users.dao.UserDao"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="/css/waittingroom.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript"></script>

</head>
<body>

	<div class="header">
		<li>Logout</li>
		<li>about</li>
	</div>

	<div class="empty"></div>

	<%-- <%
		Users users = Users.getInstance();
		pageContext.setAttribute("userId1", uc);
		pageContext.setAttribute("userId2", uc);
		pageContext.setAttribute("ur", users);
	%> --%>

	<c:choose>
		<c:when test="${users.getUserCount() == 1}">
			<div class="user1_area">
				<div class="user1_avartar"></div>
				<div class="user1_ready_button">ready</div>
				<div class="user1_info">${userId}</div>
			</div>
		</c:when>

		<c:when test="${users.getUserCount() == 2}">
			<div class="user1_area">
				<div class="user1_avartar"></div>
				<div class="user1_ready_button">ready</div>
				<div class="user1_info">${ur}</div>
			</div>

			<div class="middle_area_box">
				<div class="chat_box"></div>
				<div class="start_button"><a href="/gameMain.jsp">START</a></div>
			</div>

			<div class="user2_area">
				<div class="user2_avartar"></div>
				<div class="user2_ready_button">ready</div>
				<div class="user2_info">${ur}</div>
			</div>
		</c:when>

		<c:otherwise>
			<h1>로그인된 유저가 없습니다.</h1>
		</c:otherwise>

	</c:choose>


	<script type="text/javascript" src="/js/waittingroom.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>