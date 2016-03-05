$(function() {
  $("#signup-container").on('input', function(e) {
  	validateSignUp(e);
  });	 

  $(".idConfirm").on('click', function(e) {
    $.ajax({
      type: "GET",
      url: '#',
      timeout: 2000,
      sucess: function(isExistId) {
        if (isExistId) {
          alert("이미 존재하는 아이디입니다.");
          return;
        } 
        alert("이 아이디로 회원가입하실 수 있습니다.");
      }
    });
  });

  function validateSignUp(e) {
  	var eTarget = e.target;
  	var validationRegex = getValidationRegex(eTarget);
  	var validationMsg = getValidationMsg(eTarget, validationRegex);
  	showValidationMsg(eTarget, validationMsg);
  	
  	function getValidationRegex(eTarget) {
	  var TypeCheckRegex = {
	    userId: /^[a-z]+[a-z0-9]{5,19}$/,
	    userEmail: /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/,
	    userPassword: /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/,
	    passwordConfirm: /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/
	  };
	  return TypeCheckRegex[eTarget.id];
  	}
 
  	function getValidationMsg(eTarget, validationRegex) {
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
  	  		successMsg: "올바른 형식의 패스워드를 입력하셨습니다.",
  	  		errorMsg: "6 ~ 20자 영문과 최소 1개의 숫자 혹은 특수문자를 포함해야합니다."
  	  	}
  	  };
  	  var valid = validationRegex.test(eTarget.value);
  	  if (valid) {
  	  	return validationMsg[eTarget.id].successMsg;
  	  	}
  	  return validationMsg[eTarget.id].errorMsg; 
  	}

  	function showValidationMsg(eTarget, validationMsg) {
  	  var $eTarget = $(eTarget);
  	  console.log(eTarget);
  	  var validationContainer = $eTarget.siblings(".validationMsg");
  	  if (!validationContainer.length) {
  	  	validationContainer = $('<span class="validationMsg"></span>').insertAfter($eTarget);
  	  }

  	  validationContainer.text(validationMsg);
  	}
  }
});