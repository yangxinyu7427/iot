var text1 = document.getElementById("text");
var text2 = document.getElementById("text2");
var text3 = document.getElementById("text3");
var str1 = 'Welcome!';
var str2 = 'ToJoin';
var str3 = 'Us';
TypingWordNew(text1, str1, 0);
TypingWordNew(text2, str2, 1800);
TypingWordNew(text3, str3, 3000);
$(document).ready(function () {
  setTimeout(function () {
    $("#inner").fadeOut(1000, function () {
      $("#LoadingAnimation").remove();
    });
  }, 3600)
})

$(document).ready(function () {
  var inner = document.getElementById('inner');
  inner.onclick = function(){
    $("#inner").fadeOut(1000, function () {
      $("#LoadingAnimation").remove();
    });
  }
  setTimeout(function () {
    $("#inner").fadeOut(1000, function () {
      $("#LoadingAnimation").remove();
    });
  }, 3600)
})