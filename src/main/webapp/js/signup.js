var SIGNUP = (function() {
    var TypeCheckRegex = {
        userId: /^[a-z]+[a-z0-9]{5,19}$/,
        userEmail: /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/,
        userPassword: /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/,
        passwordConfirm: null
    };
    var validationMsg = {
        userId: {
            successMsg: "Id Success!",
            errorMsg: "6~20 letters starting alphabet",
            valid: false
        },
        userEmail: {
            successMsg: "Email Success!",
            errorMsg: "Wrong email format",
            valid: false
        },
        userPassword: {
            successMsg: "Password Success!",
            errorMsg: "6~20 alphbets with number",
            valid: false
        },
        passwordConfirm: {
            successMsg: "Matched Password!",
            errorMsg: "Unmatched Password",
            valid: false
        }
    };

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
            validationContainer = $('</br><span class="validationMsg"></span>').insertAfter($eTarget);
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
    
    function canSubmit() {
		var valid = validationMsg.userId.valid && validationMsg.userEmail.valid && validationMsg.userPassword.valid && validationMsg.passwordConfirm.valid;
		console.log(valid);
		return valid;
	}
	function checkSubmit(e) {
		if (!canSubmit()) {
			e.preventDefault();
		}
	}

    // TODO ajax 통신 따로 분리하기
    function init() {
        $("#signup-container").on('input', validateSignUp);
        $('.signUpForm').on('submit', checkSubmit);
        $(".idConfirm").on('click', function(e) {
            var testUserId = "hello";
            var testPassword = "world";
            $.ajax({
                "type": "GET",
                "url": '#',
                "timeout": 2000,
                "data": {
                    userId: testUserId,
                    userPassword: testPassword
                }
            }).done(function(isExistId) {
                if (isExistId) {
                    alert("이미 존재하는 아이디입니다.");
                    return;
                }
                alert("이 아이디로 회원가입하실 수 있습니다.");
            }).always(function() {
                alert("validation userId");
            });
        });
    }

    return {
        init: init
    };
})();