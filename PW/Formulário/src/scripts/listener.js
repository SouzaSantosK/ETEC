const inputGroups = document.querySelectorAll(".input-group input, #county");

inputGroups.forEach((input) => {
  input.addEventListener("focus", function () {
    this.parentElement.classList.add("focused");
  });

  input.addEventListener("blur", function () {
    this.parentElement.classList.remove("focused");
  });

  input.addEventListener("input", function () {
    if (input.validity.valid) {
      this.parentElement.classList.add("valid");
    } else {
      this.parentElement.classList.remove("valid");
    }
  });
});
