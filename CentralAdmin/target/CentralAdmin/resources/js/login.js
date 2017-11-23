$(function() {
  $('#email').blur(validateF1x2Email);
  
  $('#email').focus(function() {
    $('#emailError').fadeOut();
  });
});

var validateF1x2Email = function(e) {
  var sEmail = $('#email').val();
  if ($.trim(sEmail).length == 0) {
    emailError('Please enter an email address');
    e.preventDefault();
  } else if (!validateEmail(sEmail)) {
    emailError('Please enter a valid email address');
    e.preventDefault();
  } else if (!endsWith(sEmail, '1x2gaming.com')) {
    emailError('Please enter an 1x2gaming email address');
    e.preventDefault();
  }
}

function endsWith(str, suffix) {
  return str.slice(-suffix.length) == suffix;
}
function emailError(message) {
  $('#emailError').text(message).fadeIn();
}

function validateEmail(sEmail) {
  var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
  if (filter.test(sEmail)) {
    return true;
  } else {
    return false;
  }
}
