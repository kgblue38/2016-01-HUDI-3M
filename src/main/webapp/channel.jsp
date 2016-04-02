<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>IndianPoker</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="css/channel.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="lib/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

</head>
<body>
	<div class="col-md-6 col-md-offset-6">
		<table class="table" id="info">
			<tr>
				<th id="avatarTable" rowspan="4">{{avatar]]</th>
				<td>ID</td>
				<td></td>
			</tr>
			<tr>
				<td>Level</td>
				<td></td>
			</tr>
			<tr>
				<td>승 / 패</td>
				<td></td>
			</tr>
			<tr>
				<td>승률</td>
				<td></td>
			</tr>
		</table>
	</div>
	</div>


	<div class="col-md-6">
		<table class="table">
			<tr>
				<th>Room#</th>
				<th>Player</th>
				<th>status</th>
			</tr>
			<tr>
				<td>001</td>
				<td>포커의제왕재성</td>
				<td>1/2</td>
			</tr>
		</table>

	</div>

	<div class="col-md-3">
		<div class="panel panel-primary">
			<div class="panel-heading">User List</div>
			<div class="panel-body" style="overflow: auto; height: 400px">
				<ul class="media-list">
					<li class="media">
						<div class="media-body">
							<div class="media">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle" style="max-height: 40px;"
									src="assets/img/user.png" />
								</a>
								<div class="media-body">
									<h5>임동준 | 사파이어</h5>

									<small class="text-muted"> 3시간째 게임중 </small>
								</div>
							</div>

						</div>
					</li>
					<li class="media">

						<div class="media-body">

							<div class="media">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle" style="max-height: 40px;"
									src="assets/img/user.gif" />
								</a>
								<div class="media-body">
									<h5>이도형 | 루비</h5>
									<small class="text-muted">3시간째 게임중</small>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>

	</div>

	<div class="col-md-3">
		<div class="panel panel-info">
			<div class="panel-heading">CHATTING</div>
			<div class="panel-body" style="overflow: auto; height: 400px">
				<ul class="media-list">
					<li class="media">
						<div class="media-body">
							<div class="media">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle " src="assets/img/user.png" />
								</a>
								<div class="media-body">
									nNnaa <br /> <small class="text-muted">chiho | 23rd
										June at 5:00pm</small>
									<hr />
								</div>
							</div>

						</div>
					</li>
					<li class="media">
						<div class="media-body">

							<div class="media">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle " src="assets/img/user.png" />
								</a>
								<div class="media-body">
									Hello from the other side, I must have told that thousands
									times, to tell <br /> <small class="text-muted">Dohyung
										| 23rd June at 5:00pm</small>
									<hr />
								</div>
							</div>

						</div>
					</li>
					<li class="media">
						<div class="media-body">

							<div class="media">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle " src="assets/img/user.png" />
								</a>
								<div class="media-body">
									넘나 귀찮은것. <br /> <small class="text-muted">javajigi |
										23rd June at 5:00pm</small>
									<hr />
								</div>
							</div>

						</div>
					</li>
					<li class="media">

						<div class="media-body">

							<div class="media">
								<a class="pull-left" href="#"> <img
									class="media-object img-circle " src="assets/img/user.gif" />
								</a>
								<div class="media-body">
									인디언 포커 재미있는둡, 생각보다. <br /> <small class="text-muted">adele
										| 23rd June at 5:00pm</small>
									<hr />
								</div>
							</div>

						</div>
					</li>
				</ul>

				<div>
					<a href="/room/wait">게임시작</a>
				</div>
			</div>
			<div class="panel-footer">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Enter Message" />
					<span class="input-group-btn">
						<button class="btn btn-info" type="button">SEND</button>
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/js/waittingroom.js"></script>
<script src="/js/remodal.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<script type="text/javascript">
	
</script>
</html>