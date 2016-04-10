var CHANNEL = (function() {
	var $gameStart = $('.matchTest');
	var baseURL = "http://localhost:8080";
	var timerId;
	Handlebars.registerPartial('userPartial', template.userSource);
    var userlistTemplate = Handlebars.compile(template.userlistSource);
    
	var api = {
		clickReady : function(e){
			$eTarget = $(e.target);
			var data = {};
			var userId = $('.sessionUserId').text();
			data.userId = userId;
			$.ajax({
				url : (baseURL + "/api/room/channel/match"),
				type : "PUT",
				data : data
			}).done(function(matchJsonData) {
					console.log(matchJsonData);
					if (matchJsonData == -1) {
						console.log("fail");
						return;
					}
					if (matchJsonData != -1) {
						console.log("success");
						window.location.href = ('/room/wait?roomId=' + matchJsonData);
						
					}
				
			});
		},
		updateUserList : function() {
			$.ajax({
				url : (baseURL + "/api/room/channel/users"),
				type : "PUT"
			}).done(function(loginUsers) {
				var userlist = {};
				userlist["loginUsers"] = loginUsers;
				var userlistHTML = userlistTemplate(userlist);
				$(".user-list").html(userlistHTML);
			});
		}
	}

	function gameStart(e){
		window.setInterval(function(){api.clickReady(e)}, 1000);
	}

	function init() {
		$gameStart.on('click', gameStart);
		window.setInterval(function(){api.updateUserList();}, 1000);
	}

	return {
		init : init
	};
	
	 
})();

$(function(){
	CHANNEL.init();
})