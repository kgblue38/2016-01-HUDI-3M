<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Indian Game</title>
<link rel="stylesheet" type="text/css" href="./css/index.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
</head>
<body>
	<script src="lib/jquery-1.12.0.js"></script>
	<script src="lib/handlebars-v4.0.5.js"></script>
	<div class="header">
		<img src="/image/indianpoker_logo.png">
	</div>

	<%
		Object errorMessage = request.getAttribute("errorMessage");
	%>

	<c:if test="${not empty errorMessage}">
		<div class="control-group">
			<label class="error"> <%
 	out.println(errorMessage);
 %></label>
		</div>
	</c:if>


	<%
		Object userId = session.getAttribute("userId");
	%>
	<c:choose>
		<c:when test="${not empty userId}">
			<div id="logout">
				<a href="/user/logout">logout</a>
			</div>
			<div id="make">
				<a href="/play.jsp">play 
			</div>
		</c:when>
		<c:otherwise>
			<div id="signUp">Sign Up</div>
			<div id="login">Login</div>
		</c:otherwise>
	</c:choose>

	<div class="SignUp-box animated fadeInUp">
		<div class="box-header">
			<h2>Sign Up</h2>
		</div>
		<!-- <form class="form" action="/form_action.jsp" method="post"> -->
		<form class="signUpForm" action="/user" method="post">
			<div id="signup-container">
			<!-- 	<div class="pid">
					<label for="pid" class="required"></label> </br> 
					<input type="hidden" name="pid" id="pid" value=0></input>
					</br>
				</div> -->
				<div class="userId">
					<label for="userId" class="required">UserId</label> </br> 
					<input type="text" placeholder="Input Id" name="userId" id="userId"></input>
					</br>
					<button class="idConfirm">아이디 확인</button>
				</div>
				<div class="userPassword">
					<label for="userPassword" class="required">Password</label></br> <input
						type="password" placeholder="Input Password"
						name="userPassword" id="userPassword"></input>
				</div>
				<div class="passwordConfirm">
					<label for="passwordConfirm" class="required">Confirm</label> </br> <input
						type="password" placeholder="Confirm Password"
						name="passwordConfirm" id="passwordConfirm"></input>
				</div>
				<div class="userEmail">
					<label for="userEmail" class="required">email</label> </br> <input
						type="email" placeholder="Input Email" name="userEmail"
						id="userEmail">
				</div>
				<div id="signUpSubmit">
					<button type="submit">Sign up</button>
				</div>
				<br />
			</div>
		</form>
	</div>

	<div class="login-box animated fadeInUp">
		<div class="box-header">
			<h2>LogIn</h2>
		</div>
		<form class="loginForm" action="/user/login" method="post">
			<div id="login-container">
				<div id="id-container">
					<label for="userId">UserId</label> <br /> <input type="text"
						placeholder="Input Id" name="userId" id="loginUserId"> <br />
					<span class="warn">Please input id</span>
				</div>

				<div id="userPassword-container">
					<label for="userPassword">Password</label> <br /> <input
						type="password" placeholder="Input Password" name="userPassword"
						id="loginUserPassword"> <br /> <span class="warn">Please
						input password</span>
				</div>
				<div id="loginSubmit">
					<button type="submit">Login</button>
				</div>
				<br />
		</form>
	</div>

	<!-- <script type="text/javascript" src="/js/index.js"></script>  -->
	<script>
		$(document).ready(function() {
			$("#signUp").on("click", function() {
				$('.SignUp-box').fadeIn(1000).css('display', 'block');
			});
			$("#login").on("click", function() {
				$('.login-box').fadeIn(1000).css('display', 'block');
			});
			/* $("#logout").on("click", function() {
				$('.login-box').fadeIn(1000).css('display', 'block');
			}); */
			$('#logo').addClass('animated fadeInDown');
			$("input:text:visible:first").focus();
		});
		$('#username').focus(function() {
			$('label[for="username"]').addClass('selected');
		});
		$('#username').blur(function() {
			$('label[for="username"]').removeClass('selected');
		});
		$('#password').focus(function() {
			$('label[for="password"]').addClass('selected');
		});
		$('#password').blur(function() {
			$('label[for="password"]').removeClass('selected');
		});
	</script>
	<script src="/js/signup.js"></script>
	<script src="/js/login.js"></script>
	<script src="/js/init.js"></script>
</body>
</html>