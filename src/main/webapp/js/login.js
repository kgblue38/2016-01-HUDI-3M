var LOGIN = (function() {
	function isEmpty(el) {
		return $(el).val() === "";
	}

	function printWarnMsgWhenInputIsEmpty(e) {
		var $eTarget = $(e.target);
		if (isEmpty(e.target)) {
			$eTarget.siblings('.warn').show();
			return;
		}
		$eTarget.siblings('.warn').hide();
	}
	
	function canSubmit() {
		return $('#loginUserId').val() && $('#loginUserPassword').val();
	}
	function checkSubmit(e) {
		if (!canSubmit()) {
			e.preventDefault();
		}
	}

	function init() {
		$('.warn').hide();
		$('#login-container').on('input', printWarnMsgWhenInputIsEmpty);
		$('.loginForm').on('submit', checkSubmit);
	}
	return {
		init : init
	};
})();
