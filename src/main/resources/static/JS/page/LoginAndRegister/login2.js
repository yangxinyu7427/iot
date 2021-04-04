window.onload = function () {
  var app = new Vue({
    el: "#app",
    data: {
      istrue1: true,
      istrue2: false
    },
    methods: {
      ActiveNow1: function () {
        this.istrue1 = true;
        this.istrue2 = false;
      },
      ActiveNow2: function () {
        this.istrue1 = false;
        this.istrue2 = true;
      }
    }
  });
  
}