$(function() {
  $('#login-container').on('input', function(e) {
    printWarnMsgWhenInputIsEmpty(e);
  });

  function printWarnMsgWhenInputIsEmpty(e) {
    var eTarget = e.target;
    if (isEmpty(eTarget)) {
      $(e.target).siblings('.warn').show();
      return;
    }
    $(e.target).siblings('.warn').hide();

    function isEmpty(el) {
    return $(el).val() === "";
    }
  }
});