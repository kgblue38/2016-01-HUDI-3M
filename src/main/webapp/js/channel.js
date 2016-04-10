var CHANNEL = (function() {
	console.log("dd");
	var $gameStart = $('.matchTest');
	console.log($gameStart);
	var baseURL = "http://localhost:8080";
	var timerId;
	var api = {
		clickReady : function(e){
			console.log("chih");
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
				
			}, 1000);
		}
	}

	function gameStart(e){
		window.setInterval(function(){api.clickReady(e)}, 1000);
	}

	function init() {
		$gameStart.on('click', gameStart);
	
	}

	return {
		init : init
	};
	
	 
})();

$(function(){
	CHANNEL.init();
})