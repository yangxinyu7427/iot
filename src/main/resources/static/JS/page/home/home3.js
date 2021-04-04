$('#anchor').click(function () {
  var t = document.body.clientHeight;
  window.scroll({ top: t, left: 0, behavior: 'smooth' });
});