window.onload = function () {
  var app = new Vue({
    el: "#app",
    data: {
      istrue1: true,
      istrue2: false,
      istrue3: false,
      istrue4: false,
      istrue5: false,
      istrue6: false
    },
    methods: {
      GotIt: function () {
        setTimeout(function () {
          $("#idchoice").fadeOut(1000);
          $("#RegisterForm").fadeIn(1000);
        }, 0)
      },
      GotIt2: function () {
        setTimeout(function () {
          $("#idchoice").fadeOut(1000);
          $("#RegisterForm2").fadeIn(1000);
        }, 0)
      },
      ActiveNow1: function () {
        this.istrue1 = true;
        this.istrue2 = false;
      },
      ActiveNow2: function () {
        this.istrue1 = false;
        this.istrue2 = true;
      },
      lighting1: function () {
        this.istrue3 = true;
        this.istrue4 = false;
        this.istrue5 = false;
        this.istrue6 = false;
      },
      lighting2: function () {
        this.istrue4 = true;
        this.istrue3 = false;
        this.istrue5 = false;
        this.istrue6 = false;
      },
      lighting3: function () {
        this.istrue5 = true;
        this.istrue4 = false;
        this.istrue3 = false;
        this.istrue6 = false;
      },
      lighting4: function () {
        this.istrue6 = true;
        this.istrue4 = false;
        this.istrue5 = false;
        this.istrue3 = false;
      }
    }
  })
}