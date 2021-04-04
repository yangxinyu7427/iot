(function ($) {
  // A global object used by the functions of the plug-in:
  var gVars = {};

  // Extending the jQuery core:

  $.fn.tzineClock = function (opts) {

    // "this" contains the elements that were selected when calling the plugin:         $('elements').tzineClock();
    // If the selector returned more than one element, we use the first one:
    var container = this.eq(0);
    if (!container) {
      try {
        console.log("Invalid selector!");
      } catch (e) { }

      return false;
    }

    if (!opts) opts = {};

    var defaults = {
      /* Additional options will be added in future versions of the plugin. */
    };

    /* Merging the provided options with the default ones (will be used in future versions of the plugin): */

    $.each(defaults, function (k, v) {
      opts[k] = opts[k] || defaults[k];
    });

    // Calling the setUp function and passing the container,
    // will be available to the setUp function as "this":

    setUp.call(container);

    return this;
  }

  function setUp() {
    // The colors of the dials:
    var colors = ['orange', 'blue', 'green'];

    var tmp;
    for (var i = 0; i < 3; i++) {
      // Creating a new element and setting the color as a class name:

      tmp = $('<div>').attr('class', colors[i] + ' clock').html(
        '<div class="display"></div>' +
        '<div class="front left"></div>' +
        '<div class="rotate left">' +
        '<div class="bg left"></div>' +
        '</div>' +
        '<div class="rotate right">' +
        '<div class="bg right"></div>' +
        '</div>'
      );

      // Appending to the fancyClock container:
      $(this).append(tmp);

      // Assigning some of the elements as variables for speed:
      tmp.rotateLeft = tmp.find('.rotate.left');
      tmp.rotateRight = tmp.find('.rotate.right');
      tmp.display = tmp.find('.display');

      // Adding the dial as a global variable. Will be available as gVars.colorName
      gVars[colors[i]] = tmp;
    }

    // Setting up a interval, executed every 1000 milliseconds:
    setInterval(function () {

      var currentTime = new Date();
      var h = currentTime.getHours();
      var m = currentTime.getMinutes();
      var s = currentTime.getSeconds();

      animation(gVars.green, s, 60);
      animation(gVars.blue, m, 60);
      animation(gVars.orange, h, 24);
    }, 1000);
  }
})