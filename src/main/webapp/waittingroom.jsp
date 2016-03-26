<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
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
    	
    <%
		Object errorMessage = request.getAttribute("errorMessage");
	%>

		<c:if test="${not empty errorMessage}">
			<div class="control-group">
				<label class="error"> <% out.println(errorMessage); %></label>
			</div>
		</c:if>

	<%
		Object userId = session.getAttribute("userId");
	%>
		
		<c:choose>
			<c:when test="${not empty userId}">
				<div class="user1_area">
	    		<div class="user1_avartar"></div>
	    		<div class="user1_ready_button">ready</div>
	    		<div class="user1_info">user1</div>
	    			
	    	</div>
    		
	    	<div class="middle_area_box">
	    		<div class="chat_box"></div>
	    		<div class="start_button">START</div>
	    	</div>

	    	<div class="user2_area">
	    		<div class="user2_avartar"></div>
	    		<div class="user2_ready_button">ready</div> 
	    		<div class="user2_info">user2</div>
	    	</div>
			</c:when>
			<c:otherwise>
				<h1>로그인을 해야 게임진행이 가능합니다.</h1>
			</c:otherwise>
		</c:choose>

	    	


	<script type="text/javascript" src="/js/waittingroom.js"></script>
    </body>
</html>