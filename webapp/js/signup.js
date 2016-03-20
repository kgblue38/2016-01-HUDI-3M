var SIGNUP = (function() {
    var TypeCheckRegex = {
        userId: /^[a-z]+[a-z0-9]{5,19}$/,
        userEmail: /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/,
        userPassword: /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/,
        passwordConfirm: /^$/
    };
    var validationMsg = {
        userId: {
            successMsg: "올바른 형식의 아이디를 입력하셨습니다.",
            errorMsg: "아이디는 영문으로 시작하는 6 ~ 20자 영문과 숫자로만 가능합니다."
        },
        userEmail: {
            successMsg: "올바른 형식의 이메일을 입력하셨습니다.",
            errorMsg: "이메일 형식이 올바르지 않습니다."
        },
        userPassword: {
            successMsg: "올바른 형식의 패스워드를 입력하셨습니다.",
            errorMsg: "6 ~ 20자 영문과 최소 1개의 숫자 혹은 특수문자를 포함해야합니다."
        },
        passwordConfirm: {
            successMsg: "패스워드와 일치합니다.",
            errorMsg: "패스워드와 일치하지 않습니다."
        }
    };

    function getValidationMsg(eTarget, validationRegex) {
        if (validationRegex.test(eTarget.value)) {
            return validationMsg[eTarget.id].successMsg;
        }
        return validationMsg[eTarget.id].errorMsg;
    }
    function showValidationMsg(eTarget, validationMsg) {
        var $eTarget = $(eTarget);
        var validationContainer = $eTarget.siblings(".validationMsg");
        if (!validationContainer.length) {
            validationContainer = $('<span class="validationMsg"></span>').insertAfter($eTarget);
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

    //TODO ajax 통신 따로 분리하기
    function init() {
        $("#signup-container").on('input', validateSignUp);
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