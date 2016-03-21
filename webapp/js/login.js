var LOGIN = (function() {
    function isEmpty(el) {
        return $(el).val() === "";
    }

    function printWarnMsgWhenInputIsEmpty(e) {
        var eTarget = e.target;
        console.debug("hi i`m login callback");
        if (isEmpty(eTarget)) {
            console.debug("input box is empty");
            $(e.target).siblings('.warn').show();
            return;
        }
        $(e.target).siblings('.warn').hide();
    }

    function init() {
    	$('.warn').hide();
        $('#login-container').on('input', printWarnMsgWhenInputIsEmpty);
    }
    
    return {
        init: init
    };
})();



