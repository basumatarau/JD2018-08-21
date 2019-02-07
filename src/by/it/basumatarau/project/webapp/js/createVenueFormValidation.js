function validateFormCreateVenue() {
  var name = document.forms["createVenueForm"]["nameinput"].value;

  var validationResult = true;
  if (name == "1") {
    document.getElementById("nameinputWarning").style.display = "";
    validationResult = false;
  }

  return validationResult;
}
