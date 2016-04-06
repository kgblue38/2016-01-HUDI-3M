var CHANNEL = (function() {
	var $button = $('button[type="button"]');
	var sock = SockJS("http://127.0.0.1:8080/channelChat");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	
	function sendMessage() {
		console.debug("in sendMessage()");
		sock.send($button.text());
	}
	
	function onMessage(e) {
		var data = e.data;
		$('.media-list').append("<li>" + data + "</li>");
	}
	
	function onClose(e) {
		$('.media-list').append("<li>유저한명퇴장</li>");
	}
	
	
	
	function init() {
		$button.on('click', sendMessage);
	}

	return {
		init : init
	};
	
})();