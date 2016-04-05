<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="inpoker.user.controller.UserController"%>
<%@ page import="inpoker.user.model.Users"%>
<%@ page import="inpoker.user.model.User"%>
<%@ page import="inpoker.user.dao.UserDao"%>


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
	<c:set value="${sessionScope.user.userId}" var="myUserId" />
	<c:set value="${room.roomUser1.user.userId}" var="userId1" />
	<c:set value="${room.roomUser2.user.userId}" var="userId2" />
	<c:set value="${room.roomId}" var="roomId" />

	<div class="header">
		<li class="exit"><a href="/room/wait/exit?roomId=${roomId}">방에서 나가기</a></li>
		<li>about</li>
	</div>

	<div class="empty"></div>
	
	<input type="hidden" name="roomId" value="${roomId}" />
	<input type="hidden" name="myUserId" value="${myUserId}" />
	<c:choose>
		<c:when test="${not empty room}">
			<div class="user1_area">
				<c:if test="${not empty userId1}">
				<div class="user1_avartar"></div>
				<div class="user1_ready_button">ready</div>
				<c:choose>
					<c:when test= "${myUserId eq userId1}">
						<div>내 아이디</div>
					</c:when>
					<c:otherwise>
						<div>상대방 아이디</div>
					</c:otherwise>
				</c:choose>
				<div class="user_info">${userId1}</div>
				</c:if>
			</div>

			<div class="middle_area_box">
				<div class="chat_box"></div>
				<div class="start_button"><a href="/room/game?roomId=${roomId}">START</a></div>
			</div>

			<div class="user2_area">
				<c:if test="${not empty userId2}">
				<div class="user2_avartar"></div>
				<div class="user2_ready_button">ready</div>
				<c:choose>
					<c:when test= "${myUserId eq userId2}">
						<div>내 아이디</div>
					</c:when>
					<c:otherwise>
						<div>상대방 아이디</div>
					</c:otherwise>
				</c:choose>
				<div class="user_info">${userId2}</div>
				</c:if>
			</div>
		</c:when>

		<c:otherwise>
			<h1>잘못된 경로로 접속하셨습니다.</h1>
		</c:otherwise>

	</c:choose>


	<script type="text/javascript" src="/js/waittingroom.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>