function TypingWordNew(txt, str, timewait) {
  var i = 0;
  setTimeout(function () {
    // alert("hello")
    var TimerIn = setInterval(function () {
      if (i < str.length) {
        txt.innerHTML = str.slice(0, ++i) + '|';
      } else {
        txt.innerHTML = str;
        clearInterval(TimerIn);
      }
    }, 200)
  }, timewait);
}