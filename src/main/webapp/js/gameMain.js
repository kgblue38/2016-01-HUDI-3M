var GAME = (function() {
	// var cardTemplate = "<img src='image/card/{{random_card}}h.png'>";
	// var cardTemplate_1 = "<img src='image/card/{{random_card}}s.png'>";
	// var template_up = Handlebars.compile(cardTemplate);
	// var template_up_1 = Handlebars.compile(cardTemplate_1);

	var resultTemplate = "<p>PlayerA got {{card_NumberA}} Space<br>"
			+ "PlayerB got {{card_NumberB}} Heart</p>";
	var resultHeaderTemplate = "<h1>{{winner}}</h1>";
	var template_up_result = Handlebars.compile(resultTemplate);
	var template_up_resultHeader = Handlebars.compile(resultHeaderTemplate);

	var card = "<li class='left_user_card card{{cardNum}}'>" + "{{cardNum}}"
			+ "</li>";

	var user1 = {
			
			id : $('input[name="userId1"]').val(),
			cards: shuffle_random_card()
		};
	
	var user2 = {
			
			id : $('input[name="userId2"]').val(),
			cards: shuffle_random_card()
		};
	
	function revealedCard(e){
		
		e.preventDefault();
						
		var left_user_num = user1.cards[cliked_left_user_card_Idx];
		var right_user_num = user2.cards[cliked_left_user_card_Idx];

		var $matching_left_user = $(".match_left_User_card");
		var $matching_right_user = $(".match_right_User_card");
		
		$matching_left_user.css('background-color', 'white').text(left_user_num);
		$matching_right_user.css('background-color', 'white').text(right_user_num);
		
		if(left_user_num > right_user_num ){
			
			alert(user1.id + "님이 승리하셨습니다.");
			$(".match_left_User_card").css('display', 'none');
			$(".match_right_User_card").css('display', 'none')
			$(".match_left_User_card").removeClass('put_card');
			$(".match_right_User_card").removeClass('put_card');
			
		}else if(left_user_num < right_user_num){
			
			alert(user2.id + "님이 승리하셨습니다.");
			$(".match_left_User_card").css('display', 'none').removeClass('put_card');
			$(".match_right_User_card").css('display', 'none').removeClass('put_card');
			$(".match_left_User_card").removeClass('put_card');
			$(".match_right_User_card").removeClass('put_card');
			
		}else{
			alert("이번판은 무승부입니다.");
			$(".match_left_User_card").css('display', 'none').removeClass('put_card');
			$(".match_right_User_card").css('display', 'none').removeClass('put_card');
			$(".match_left_User_card").removeClass('put_card');
			$(".match_right_User_card").removeClass('put_card');
		}
						
	}
	

//	function revealCard() {
//		var random_card = Math.floor((Math.random() * 10) + 1);
//		var random_card_1 = Math.floor((Math.random() * 10) + 1);
//		// $(".leftUser_card").append($(template_up({"random_card":random_card})));
//		$(".leftUser_card").delay(1000).queue(
//				function() {
//					$(this).css('background-image',
//							'url("image/card/' + random_card + 's.png")');
//				});
//		// $(".rightUser_card").append($(template_up_1({"random_card":random_card_1})));
//		$(".rightUser_card").delay(1000).queue(
//				function() {
//					$(this).css('background-image',
//							'url("image/card/' + random_card_1 + 'h.png")');
//				});
//		if (random_card > random_card_1) {
//			var result = "Player A wins.";
//			$('#result').remove();
//			$('.playerA').delay(1200).queue(function() {
//				$(this).css('border', '5px solid red');
//			});
//			$(".remodal p").append($(template_up_result({
//				"card_NumberA" : random_card,
//				"card_NumberB" : random_card_1
//			})));
//			$(".remodal h1").append($(template_up_resultHeader({
//				"winner" : result
//			})));
//		} else if (random_card == random_card_1) {
//			var result = "draw.";
//			$('#result').remove();
//			$(".remodal p").append($(template_up_result({
//				"card_NumberA" : random_card,
//				"card_NumberB" : random_card_1
//			})));
//			$(".remodal h1").append($(template_up_resultHeader({
//				"winner" : result
//			})));
//		} else {
//			var result = "Player B wins."
//			$('#result').remove();
//			$('.playerB').delay(1200).queue(function() {
//				$(this).css('border', '5px solid red');
//			});
//			$(".remodal p").append($(template_up_result({
//				"card_NumberA" : random_card,
//				"card_NumberB" : random_card_1
//			})));
//			$(".remodal h1").append($(template_up_resultHeader({
//				"winner" : result
//			})));
//		}
//	}

	

	/* 배열에 랜덤값 얻기 1~10까지의 랜덤 값 넣기 */
	function shuffle_random_card() {

		// 결과 담을 배열
		var cardArray = [];
		var temp; // 난수 임시로 담을 변수
		var CheckFlag = 0; // 중복체크 Flag (0,1)

		for (var i = 0; i < 10; i++) {
			temp = Math.floor(Math.random() * 10) + 1; // 난수 생성 (+1 은 0 제외)
			for (var j = 0; j < i; j++) { // 기존 배열 값들 0 부터 i 번째(현재) 전까지
				if (cardArray[j] == temp) { // 중복체크 _ 같은것이 있다면,
					i = i - 1; // 현재 배열위치 i 에서 한칸 앞 위치를 가져간다. *( i++ 가 되니 미리
					// i-1해준다.) 결국은 i값이 증가되지 않는것.
					CheckFlag = 1; // 배열에 값을 넣지 않기 위해 중복체크 플래그 값 설정해주고
				}
			}

			if (CheckFlag == 0) { // 중복된 값이 아니면 난수를 배열 i 번째 넣어주고.
				cardArray[i] = temp;
			} else {
				CheckFlag = 0; // 중복된 값이면 i -1 번째 그대로 간다.
			}
		}

		return cardArray;
	}

	function get_card_fot_leftuser(cardArray) {

	}
	var cliked_left_user_card_Idx;
	var cliked_right_user_card_Idx;
	
	function remove_left(e) {

		cliked_left_user_card_Idx = $(e.target).val();
		var left_user_card= $(".match_left_User_card");
		
		if (!left_user_card.hasClass('put_card')) {
			$(e.target).remove();
			left_user_card.css('display', 'block');
			left_user_card.addClass('put_card');
		} else
			alert("낙장불입!");		
	}

	function remove_right(e) {

		var right_user_card = $(".match_right_User_card");
		cliked_right_user_card_Idx = $(e.target).val();	
		
		if (!right_user_card.hasClass('put_card')) {
			$(e.target).remove();
			right_user_card.css('display', 'block');
			right_user_card.addClass('put_card');
		} else
			alert("낙장불입!");
	}

	return {
		"init" : init
	}
	
	function match() {

		var right_user_card = $(".match_right_User_card");
		var left_user_card = $(".match_left_User_card");		
		var i;
		
		if (right_user_card.hasClass('put_card') && left_user_card('put_card'))
			$(".match_button").css("display", "block");
		
		
	}

	function init() {
		
//		get_card_fot_leftuser(shuffle_random_card());
//		match();
//		$('#result').on('click', revealCard);
		$(".right_user_card").on("dblclick", remove_right);
		$(".left_user_card").on("dblclick", remove_left);
		$(".matchi_button").on("click", revealedCard);
	
	}
	
})();

$(document).ready(function() {
	GAME.init();
});