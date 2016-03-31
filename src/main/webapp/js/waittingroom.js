var TODO = (function(window){
	var baseURL = "http://125.209.194.165";
	var $user1Button = $(".user1_ready_button");
	var $user2Button = $(".user2_ready_button");
	var user1Id = $user1Button.siblings('.user_info').val();
	var user2Id = $user2Button.siblings('.user_info').val();
	function init(){
		$user1Button.on("click", user1_click_ready_button);
		$user2Button.on("click", user2_click_ready_button);
	}
	var ajaxApi = {
		clickReady: function(e) {
			$eTarget = $(e.target);
			var data = {};
			var userId = $eTarget.siblings('.user_info').val();
			var userStatus = changeUserStatus($eTarget);
			data.roomId = roomId;
			data.userId = userId;
			data.userStatus = userStatus;
			$.ajax({
				"url" : (baseURL + "/api/room/wait/ready"),
				"type" : "PUT",
				"data" : data
			}).done(function(room) {
				changeUserReady($eTarget, getUserStatus(room, userId));
			})
		},
		checkStatus: function() {
			var data = {};
			data.roomId = roomId;
			$.ajax({
				"url" : (baseURL + "/api/room/wait/check"),
				"type" : "GET",
				"data" : data
			}).done(function(room) {
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
		if(room.RoomUser1.user.userId === userId) {
			return room.RoomUser1.userStatus;
		}
		if(room.RoomUser2.user.userId === userId) {
			return room.RoomUser2.userStatus;
		}
	}
	
	function changeUserReady($eTarget, userState) {
		if (userStatus == "ready") {
			$eTarget.addClass('clicked');
			return;
		}
		$eTarget.removeClass('clicked');
	}
	
	function changeUserStatus($eTarget) {
		if (eTarget.hasClass('clicked')) {
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