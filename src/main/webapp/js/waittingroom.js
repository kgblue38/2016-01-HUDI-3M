var TODO = (function(window){


	function init(){
		$(".user1_ready_button").on("click", user1_click_ready_button);
		$(".user2_ready_button").on("click", user2_click_ready_button);
	}

	

	function user1_click_ready_button(){
		$(".user1_ready_button").css({

			'background-color':'rgba(82,167,178,0.7)',
			'width':'80%',
			'height':'50px',
			'color': 'white',
			'line-height':'45px',
			'text-align': 'center',
			'font-size': '25px',
			'border':'none',
			'padding-top': '3px'

			});
		 $(this).addClass('clicked');

		 if($(".user2_ready_button").hasClass("clicked")){
		 		$(".start_button").css('display','block');
		 	}
	}

		function user2_click_ready_button(){
		$(".user2_ready_button").css({

			'background-color':'rgba(82,167,178,0.7)',
			'width':'80%',
			'height':'50px',
			'color': 'white',
			'line-height':'45px',
			'text-align': 'center',
			'font-size': '25px',
			'border':'none',
			'padding-top': '3px'

			});

		 $(this).addClass('clicked');

		 if($(".user2_ready_button").hasClass("clicked")){
		 		$(".start_button").css('display','block');
		 	}
	}


	return {
		"init" : init
	}


})(window)


$(function(){

	TODO.init();
})