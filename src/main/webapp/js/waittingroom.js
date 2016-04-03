var TODO = (function(window){
	// http://125.209.194.165 베포하면 요기로 접근해야함, 테스트 위해 로컬로 접근
	var baseURL = "http://localhost:8080";
	var $user1Button = $(".user1_ready_button");
	var $user2Button = $(".user2_ready_button");
	var user1Id = $user1Button.siblings('.user_info').text();
	var user2Id = $user2Button.siblings('.user_info').text();
	var myUserId = $('input[name="myUserId"]').val();
	var roomId = $('input[name="roomId"]').val();
	
	function init(){
		$user1Button.on("click", ajaxApi.clickReady);
		$user2Button.on("click", ajaxApi.clickReady);
		window.setInterval(function(){ajaxApi.checkStatus();}, 1000);
	}
	
	var ajaxApi = {
		clickReady: function(e) {
			console.debug("click event 동작");
			$eTarget = $(e.target);
			var data = {};
			var userId = $eTarget.siblings('.user_info').text();
			console.debug("myUserId : " + myUserId);
			console.debug("clickUserId : " + userId);
			if (userId != myUserId) {
				console.debug("not your button");
				return;
			}
			var userStatus = changeUserStatus($eTarget);
			data.roomId = roomId;
			data.userId = userId;
			data.userStatus = userStatus;
			console.debug(data);
			$.ajax({
				"url" : (baseURL + "/api/room/wait/ready"),
				"type" : "PUT",
				"data" : data
			}).done(function(room) {
				console.debug("click event done()");
				changeUserReady($eTarget, getUserStatus(room, userId));
			})
		},
		checkStatus: function() {
			console.debug("check event 동작");
			var data = {};
			data.roomId = roomId;
			$.ajax({
				"url" : (baseURL + "/api/room/wait/check"),
				"type" : "GET",
				"data" : data
			}).done(function(room) {
				console.debug("check event done()");
				changeUserReady($user1Button, getUserStatus(room, user1Id));
				changeUserReady($user2Button, getUserStatus(room, user2Id));
				updateStartButton(room);
			})
		}
		
	}
	
	function updateStartButton(room) {
		if (room.canStart === true) {
			$(".start_button").css('display','block');
		}
		if (room.canStart === false) {
			$(".start_button").css('display','none');
		}
	}
	
	function getUserStatus(room, userId) {
		if(room.roomUser1.user.userId === userId) {
			return room.roomUser1.userStatus;
		}
		if(room.roomUser2.user.userId === userId) {
			return room.roomUser2.userStatus;
		}
	}
	
	function changeUserReady($eTarget, userStatus) {
		if (userStatus == "ready") {
			$eTarget.addClass('clicked');
			return;
		}
		$eTarget.removeClass('clicked');
	}
	
	function changeUserStatus($eTarget) {
		if ($eTarget.hasClass('clicked')) {
			return "notReady";
		}
		return "ready";
	}

	function user1_click_ready_button(){
//		 $(this).toggleClass('clicked');
//		 if($(".user2_ready_button").hasClass("clicked")){
//		 		$(".start_button").css('display','block');
//		 	}
	}

		function user2_click_ready_button(){
//		 $(this).toggleClass('clicked');
//		 if($(".user2_ready_button").hasClass("clicked")){
//		 		$(".start_button").css('display','block');
//		 	}
	}

	return {
		"init" : init
	}
})(window)

$(function(){
	TODO.init();
})