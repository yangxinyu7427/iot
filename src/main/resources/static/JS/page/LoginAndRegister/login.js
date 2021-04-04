window.onload = function () {
  var tag = document.getElementsByClassName('tag');
  var active = document.getElementsByClassName('inactive');
  for (var i = 0; i < tag.length; i++) {
      tag[i].index = i;
      tag[i].onclick = function () {
          for (var n = 0; n < tag.length; n++) {
              tag[n].className = 'tag';
              active[n].className = 'inactive';
          }
          this.className = 'tag_act';
          oPs[this.index].className= 'active'
      }
  }
}
