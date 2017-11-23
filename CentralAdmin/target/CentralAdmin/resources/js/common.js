
var common = new function() {

  this.format = function(item) {
    return item.name;
  }
  
  this.escapeChars = function (str) {
    return str.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;') ;
  }
  
  //Handle session timeout (408) in ajax request
  this.checkForSessionTimeOut = function(data) {
	  
    if (data.status == 408) {
      $('.ajaxresult-danger').html("Session expired. Please Close popup and log back in").fadeIn();
      //window.location.reload();
      return true;
    }
    return false;
  }

}
