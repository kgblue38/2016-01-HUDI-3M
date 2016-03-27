var CARD = (function(){
	var cardTemplate = "<img src='image/card/{{random_card}}h.png'>";
	var cardTemplate_1 = "<img src='image/card/{{random_card}}s.png'>";
	var template_up = Handlebars.compile(cardTemplate);
	var template_up_1 = Handlebars.compile(cardTemplate_1);
	var resultTemplate = "<p>PlayerA got {{card_NumberA}} Space<br>"+
						"PlayerB got {{card_NumberB}} Heart</p>";
	var resultHeaderTemplate = "<h1>{{winner}}</h1>";
	var template_up_result = Handlebars.compile(resultTemplate);
	var template_up_resultHeader = Handlebars.compile(resultHeaderTemplate);

	function getCard(){

	}

	function revealCard(){
		var random_card = Math.floor((Math.random() * 10) + 1);
		var random_card_1 = Math.floor((Math.random() * 10) + 1);
		// $(".leftUser_card").append($(template_up({"random_card":random_card})));
		$(".leftUser_card").delay(1000).queue(function(){
			$(this).css('background-image', 'url("image/card/'+random_card+'s.png")');
		});
		// $(".rightUser_card").append($(template_up_1({"random_card":random_card_1})));
		$(".rightUser_card").delay(1000).queue(function(){
			$(this).css('background-image', 'url("image/card/'+random_card_1+'h.png")');
		});
		if(random_card>random_card_1){
				var result = "Player A wins.";
				$('#result').remove();
				$('.playerA').delay(1200).queue(function(){
					$(this).css('border', '5px solid red');
				});
				$(".remodal p").append($(template_up_result({"card_NumberA":random_card, 
					"card_NumberB":random_card_1})));
				$(".remodal h1").append($(template_up_resultHeader({"winner":result})));
		}else if (random_card == random_card_1){
				var result = "draw.";
				$('#result').remove();
				$(".remodal p").append($(template_up_result({"card_NumberA":random_card, 
					"card_NumberB":random_card_1})));
				$(".remodal h1").append($(template_up_resultHeader({"winner":result})));
		}else{
				var result = "Player B wins."
				$('#result').remove();
				$('.playerB').delay(1200).queue(function(){
					$(this).css('border', '5px solid red');
				});
				$(".remodal p").append($(template_up_result({"card_NumberA":random_card, 
					"card_NumberB":random_card_1})));
				$(".remodal h1").append($(template_up_resultHeader({"winner":result})));
		}
	}
	
	

	function init(){
		 $('#result').on('click', revealCard);
		// $('.gameArea').on('click', '.righttUser_card', getCardRight);
		
	}

	// var cardArray = [
	// 	{"type": "h", "number": "1"},
	// 	{"type": "h", "number": "2"},
	// 	{"type": "h", "number": "3"},
	// 	{"type": "h", "number": "4"},
	// 	{"type": "h", "number": "5"},
	// 	{"type": "h", "number": "6"},
	// 	{"type": "h", "number": "7"},
	// 	{"type": "h", "number": "8"},
	// 	{"type": "h", "number": "9"},
	// 	{"type": "h", "number": "10"},

	// 	{"type": "s", "number": "1"}, 
	// 	{"type": "s", "number": "2"},
	// 	{"type": "s", "number": "3"},
	// 	{"type": "s", "number": "4"},
	// 	{"type": "s", "number": "5"},
	// 	{"type": "s", "number": "6"},
	// 	{"type": "s", "number": "7"},
	// 	{"type": "s", "number": "8"},
	// 	{"type": "s", "number": "9"},
	// 	{"type": "s", "number": "10"},
 //        ];


    var context = {
        music: []
    };

    // var cardClone = $.extend(true, [], cardArray);

    function getRandom() {
        var random = Math.floor(Math.random() * cardClone.length);
        var data = cardClone[random];
        context.music.push(data);
        cardClone.splice(random, 1);
        console.log(data);
    }

	return{
		"init" : init
	}
})();

$(document).ready(function(){
	CARD.init();
});



