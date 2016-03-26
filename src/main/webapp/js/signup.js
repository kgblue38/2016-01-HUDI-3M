var SIGNUP = (function() {
	var TypeCheckRegex = {
		userId : /^[a-z]+[a-z0-9]{5,19}$/,
		userEmail : /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/,
		userPassword : /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/,
		passwordConfirm : null
	};
	var validationMsg = {
		userId : {
			successMsg : "아이디를 올바르게 입력하셨습니다.",
			errorMsg : "알파벳으로 시작하는 6~20 글자를 입력하시오.",
			valid : false
		},
		userEmail : {
			successMsg : "이메일 형식이 맞습니다.",
			errorMsg : "이메일 형식이 틀립니다.",
			valid : false
		},
		userPassword : {
			successMsg : "패스워드를 올바르게 입력하셨습니다.",
			errorMsg : "6~20 영문, 숫자조합으로 입력하세요.",
			valid : false
		},
		passwordConfirm : {
			successMsg : "비밀번호와 일치합니다.",
			errorMsg : "비밀번호와 일치하지 않습니다.",
			valid : false
		}
	};
	var userExist = "true";

	function getValidationMsg(eTarget, validationRegex) {
		if (validationRegex.test(eTarget.value)) {
			validationMsg[eTarget.id].valid = true;
			return validationMsg[eTarget.id].successMsg;
		}
		validationMsg[eTarget.id].valid = false;
		return validationMsg[eTarget.id].errorMsg;
	}
	function showValidationMsg(eTarget, validationMsg) {
		var $eTarget = $(eTarget);
		var validationContainer = $eTarget.siblings(".validationMsg");
		if (!validationContainer.length) {
			validationContainer = $('</br><span class="validationMsg"></span>')
					.insertAfter($eTarget);
		}
		validationContainer.text(validationMsg);
	}

	function isPasswordConfirm(eTarget) {
		return eTarget.id === "passwordConfirm";
	}

	function changePasswordConfirmRegex() {
		TypeCheckRegex.passwordConfirm = new RegExp($("#userPassword").val());
	}

	function validateSignUp(e) {
		var eTarget = e.target;
		if (isPasswordConfirm(eTarget)) {
			changePasswordConfirmRegex();
		}
		var validationRegex = TypeCheckRegex[eTarget.id];
		var validationMsg = getValidationMsg(eTarget, validationRegex);
		showValidationMsg(eTarget, validationMsg);
	}

	function regexpSubmitCheck() {
		var valid = validationMsg.userId.valid && validationMsg.userEmail.valid
				&& validationMsg.userPassword.valid
				&& validationMsg.passwordConfirm.valid;
		return valid;
	}

	function userExistSubmitCheck() {
		if (userExist === "true") {
			return false;
		}
		return true;
	}

	function submitCheck(event) {
		try {
			if (!regexpSubmitCheck()) {
				throw new Error('입력 형식이 올바르지 않습니다.');
			}
			if (!userExistSubmitCheck()) {
				// TODO 나중에 시간 있으면 분리
				throw new Error('이미 존재하는 아이디거나 아이디 확인을 하지 않으셨습니다.');
			}
		} catch (e) {
			event.preventDefault();
			alert(e.message);
		}
	}
	// SELECTOR 따로 빼고, id, class 정리좀 하기
	// TODO ajax 통신 따로 분리하기
	function init() {
		$("#signup-container").on('input', validateSignUp);
		$('.signUpForm #userId').on('input', function(e) {
			userExist = "true"; // id 변경되면 아이디 확인할 수 있도록 userExist를 true로 설정해줌.  
		});
		$(".idConfirm").on('click', function(e) {
			var data = {};
			data["userId"] = $(e.target).siblings('input').val();
			
			$.ajax({
				"url" : '/api/user',
				"type" : 'POST',
				"data" : data
			}).done(function(data) {
				console.log(userExist);
				if (data["userId"] === "exist") {
					alert("이미 존재하는 아이디입니다.");
					userExist = "true";
					return;
				}
				userExist = "false";
				alert("이 아이디로 회원가입하실 수 있습니다.");
			}).fail(function() {
				alert("idConfirm ajax 실패!");
			});
		});
		
		$('.signUpForm').on('submit', submitCheck);
	//	$("#signup-container button[type=submit]").on('click', submitCheck);
	}

	return {
		init : init
	};
})();