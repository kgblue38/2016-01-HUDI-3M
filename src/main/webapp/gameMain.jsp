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
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
      <style type="text/css">      
        </style>
        <link rel="stylesheet" type="text/css" href="/css/gameMain.css">
        <script type="text/javascript"
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script type="text/javascript"
			src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
		<script type="text/javascript"></script>
        <script src="lib/jquery-1.12.0.js"></script>
        <script src="lib/handlebars-v4.0.5.js"></script>
        <link rel="stylesheet" href="css/remodal.css">
        <link rel="stylesheet" href="css/remodal-default-theme.css">
        
    </head>
    <body>
<%--     <%
		UserRepository ur = UserRepository.getInstance();
		UserController uc = new UserController();
		pageContext.setAttribute("userId1", uc);
		pageContext.setAttribute("userId2", uc);
<<<<<<< HEAD
		
/* 		User user1 = userDao.findUserById(dj0999);
		req.getSession().setAttribute("user1", dj0999);
		
		User user2 = userDao.findUserById("asd123");
		req.getSession().setAttribute("user", asd123); */
		

	%>
=======
		pageContext.setAttribute("ur", ur);
	%> --%>
>>>>>>> e43d9ff35b4e963231c9b5b6416a615cf32dd7c5
	
<%-- 	<c:choose>
		<c:when test="${ur.getUserCount() == 1}"> --%>
			<%-- <div class="header">
            <div class="playerA">
                 <div class="playerAAvatar"><img src="image/avartar_in_circle.png"></div>
                 <div class="playerAInformation">Id: ${userId1.getUserId1()} </br> 계급: 루비</div>
                 <div class="PlayerArubyChips">
                 	<div class="ruby"></div>
                 	<div class="ruby"></div>
                 	<div class="ruby"></div>
                 	<div class="ruby"></div>
                 	<div class="ruby"></div>
                 </div>
                 <div class="playerAScore">53(점)</div>
            </div> --%>
	<%-- 	</c:when> --%>

		<%-- <c:when test="${ur.getUserCount() == 2}"> --%>
			<div class="header">
            <div class="playerA">
                 <div class="playerAAvatar"><img src="image/avartar_in_circle.png"></div>
                 <div class="playerAInformation">Id: ${userId1.getUserId1()} </br> 계급: 루비</div>
                 	 <div class="PlayerArubyChips">
	                 	<div class="ruby"></div>
	                 	<div class="ruby"></div>
	                 	<div class="ruby"></div>
	                 	<div class="ruby"></div>
	                 	<div class="ruby"></div>
               	  </div>
                 <div class="playerAScore">53(점)</div>
            </div>

			<div class="playerB">
                <div class="playerBAvatar"><img src="image/avartar2_in_circle.png"></div>
                <div class="playerBInformation">Id: ${userId1.getUserId2()} </br> 계급: 사파이어</div>
                   <div class="PlayerBrubyChips">
                    <div class="ruby"></div>
                    <div class="ruby"></div>
                    <div class="ruby"></div>
                    <div class="ruby"></div>
                    <div class="ruby"></div>
                  </div>
                <div class="playerBScore"> 점수
                </div>
            </div>
<%-- 		</c:when> --%>

<%-- 		<c:otherwise>
			<h1>로그인된 유저가 없습니다.</h1>
		</c:otherwise>

	</c:choose> --%>
         
       </div>

       <div class="header_line"></div>
       <div class="middleArea">
        <div class="gameArea">
            <div class="leftUserArea">
                <ul class="leftUser"> 
                  <li class="left_user_card card1"></li>
                  <li class="left_user_card card2"></li>
                  <li class="left_user_card card3"></li>
                  <li class="left_user_card card4"></li>
                  <li class="left_user_card card5"></li>
                  <li class="left_user_card card6"></li>
                  <li class="left_user_card card7"></li>
                  <li class="left_user_card card8"></li>
                  <li class="left_user_card card9"></li>
                  <li class="left_user_card card10"></li>
                </ul>
            </div>
             <div class="matchArea">
                    <div class="match">
                    	 <div class="match_left_User_card">
                         <!-- <img src="image/card/back.png"> -->
                        </div>
                          <input type="button" value="match" class="match_button"></input>
                    	<div class="match_right_User_card">
                        <!-- <img src="image/card/back.png"> -->
                    	</div>
                    </div>
            </div> 
            <div class="rightUserArea">
                <ul class="rightUser">
                	<li class="right_user_card card1"></li>
                  <li class="right_user_card card2"></li>
                  <li class="right_user_card card3"></li>
                  <li class="right_user_card card4"></li>
                  <li class="right_user_card card5"></li>
                  <li class="right_user_card card6"></li>
                  <li class="right_user_card card7"></li>
                  <li class="right_user_card card8"></li>
                  <li class="right_user_card card9"></li>
                  <li class="right_user_card card10"></li>                 
                </ul>
            </div>
            <div class="resultEvent">

            </div>
          </div>
       </div>
       <div class="clear"></div>
       <div class="botton_container">
         
        <a id="result" href="#modal">See the Result.</a>
                 
        <div class="remodal" data-remodal-id="modal">
          <button data-remodal-action="close" class="remodal-close"></button>
          <h1></h1>
          <p>
            
          </p>
          <br>
          <button data-remodal-action="confirm" class="remodal-confirm">OK</button>
          <button data-remodal-action="cancel" class="remodal-cancel">Get Back to Waiting Room</button>
        </div>
                
       </div>
       <div class="footer">
           <!--  <div class="footerCard">
            </div> -->
       </div>
       <script src="/js/gameMain.js"></script>
        <script src="/js/remodal.js"></script>

    </body>
</html>