// TODO QUESTION) 로딩된 페이지의 init만 호출하게 하는 방법이 없을까 
// TODO MY SOLUTION) map을 활용하는 refactoring 
$(document).ready(function() {
    if ($('.init').data('value') === "SIGNUP") {
        SIGNUP.init();
    }
    if ($('.init').data('value') === "LOGIN") {
        LOGIN.init();
    }
});