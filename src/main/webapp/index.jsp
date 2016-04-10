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
	<link rel="stylesheet" type="text/css" href="/css/remodal.css">
<link rel="stylesheet" type="text/css" href="/css/remodal-default-theme.css">
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
			<!-- <div id="signUp">Sign Up</div> -->
 			<div id="signUp"><a href="#modal_signup">Sign Up</a></div>
 			<a href="#modal"><div id="login">로그인</div></a>
		</c:otherwise>
	</c:choose>

	<!-- <div class="SignUp-box animated fadeInUp">
		<div class="box-header">
			<h2>Sign Up</h2>
		</div>
		<form class="signUpForm" action="/user" method="post">
			<div id="signup-container">
				<div class="userId">
					<label for="userId" class="required">UserId</label> </br> <input
						type="text" placeholder="Input Id" name="userId" id="userId"></input>
					</br>
					<button class="idConfirm">아이디 확인</button>
				</div>
				<div class="userPassword">
					<label for="userPassword" class="required">Password</label></br> <input
						type="password" placeholder="Input Password" name="userPassword"
						id="userPassword"></input>
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
	</div> -->

	<div class="remodal" data-remodal-id="modal_signup" role="dialog"
		aria-labelledby="modal1Title" aria-describedby="modal1Desc">
		<button data-remodal-action="close" class="remodal-close"
			aria-label="Close"></button>
		<form class="loginForm" action="/user/login" method="post">
			<div id="signup-container">
				<h2 id="modal1Title" style="color:black">Signup HERE.</h2>
				<p id="modal1Desc">즐겁디 즐거운 게임 인디언포커에 오셨군요. 많이 하세요.</p>
				<div class="userId">
					<label for="userId" class="required">UserId</label> </br> <input
						type="text" placeholder="Input Id" name="userId" id="userId"></input>
					</br>
					<button class="idConfirm">아이디 확인</button>
				</div>
				<div class="userPassword">
					<label for="userPassword" class="required">Password</label></br> <input
						type="password" placeholder="Input Password" name="userPassword"
						id="userPassword"></input><br><br>
				</div>
				<div class="passwordConfirm">
					<label for="passwordConfirm" class="required">Confirm</label> </br> <input
						type="password" placeholder="Confirm Password"
						name="passwordConfirm" id="passwordConfirm"></input><br><br>
				</div>
				<div class="userEmail">
					<label for="userEmail" class="required">email</label> </br> <input
						type="email" placeholder="Input Email" name="userEmail"
						id="userEmail"><br>
				</div>
			</div>
			<br>
			<button data-remodal-action="cancel" class="remodal-cancel">Cancel</button>
			<input type="submit" value="OK" />
		</form>
	</div>

	<div class="remodal" data-remodal-id="modal" role="dialog"
		aria-labelledby="modal1Title" aria-describedby="modal1Desc">
		<button data-remodal-action="close" class="remodal-close"
			aria-label="Close"></button>
		<form class="loginForm" action="/user/login" method="post">
			<div>
				<h2 id="modal1Title" style="color:black">Login HERE.</h2>
				<p id="modal1Desc">즐겁디 즐거운 게임 인디언포커에 오셨군요. 많이 하세요.</p>
				<label>Id :</label> <input type="text" placeholder="Input Id" name="userId" id="loginUserId"> <br><br> <label>Password	: </label><input type="password" placeholder="Input Password" name="userPassword" id="loginUserPassword">
			</div>
			<br>
			<button data-remodal-action="cancel" class="remodal-cancel">Cancel</button>
			<input type="submit" value="OK" />
		</form>
	</div>

	<!-- <script type="text/javascript" src="/js/index.js"></script>  -->
	<script>
		$(document).ready(function() {
			$("#signUp").on("click", function() {
				$('.SignUp-box').fadeIn(1000).css('display', 'block');
			});
			
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
	<script src="/js/remodal.js"></script>
</body>
</html>