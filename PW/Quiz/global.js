window.addEventListener("load", () => {
  const options = document.querySelectorAll('input[type="radio"]');
  const submitButton = document.querySelector('button[type="submit"]');

  options.forEach((option) => {
    option.addEventListener("click", () => {
      submitButton.classList.remove("disabled");
    });
  });
});
