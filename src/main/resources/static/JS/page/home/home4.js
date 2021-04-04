var getUserPhoto = document.getElementById("user-photo");
getUserPhoto.onchange = function () {
  var file = this.files;
  console.log(file);
  var reader = new FileReader();
  reader.readAsDataURL(file[0]);
  reader.onload = function () {
    var imaIn = document.getElementById("imgIn");
    imaIn.src = reader.result;
    var showPicture = document.getElementById("show-picture");
    showPicture.append(image);
  };
};