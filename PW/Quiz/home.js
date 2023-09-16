const aside = document.querySelector("aside");
const backgroundFade = document.querySelector(".background-fade");
const imagesUrl = ["minecraft1.jfif", "minecraft2.jpg", "minecraft3.jpg", "minecraft8.jpg"];
const computedStyle = window.getComputedStyle(aside);
const animationDuration = computedStyle.animationDuration;

let gradientColors = [
  { a: "rgba(43, 19, 41, 1)", b: "#040205" },
  { a: "#612210", b: "#380808" },
  { a: "rgba(69,82,21, 1)", b: "#242d0b" },
  { a: "#00bbfe", b: "#025188" },
  ,
];

let i = 0;

setInterval(() => {
  i = (i + 1) % imagesUrl.length;
  aside.style.backgroundImage = `url(./images/${imagesUrl[i]})`;

  backgroundFade.style.background = `linear-gradient(
    160deg,
    ${gradientColors[i].a} 0%,
    ${gradientColors[i].b} 50%,
    rgba(8, 8, 8, 1) 100%
  )`;
}, parseInt(animationDuration) * 1000);

const nameInput = document.getElementById("name");
const nameInputLabel = document.getElementById("name-label");

nameInput.addEventListener("input", () => {
  if (nameInput.value.length >= 4) {
    nameInput.classList.add("valid");
    nameInputLabel.classList.add("valid");
  } else {
    nameInput.classList.remove("valid");
    nameInputLabel.classList.remove("valid");
  }
});

const charactersSelection = document.querySelector(".character-selection");
const options = charactersSelection.querySelectorAll('input[type="radio"]');
const submitButton = document.querySelector("button");
let characterIndex;

nameInput.addEventListener("input", () => {
  if (nameInput.classList.contains("valid")) {
    charactersSelection.classList.remove("hidden");
    submitButton.classList.remove("hidden");
  } else {
    charactersSelection.classList.add("hidden");
    submitButton.classList.add("hidden");
  }
});

options.forEach((radio) => {
  radio.addEventListener("click", () => {
    characterIndex = Number(radio.value);
    radio.classList.add("valid");
    charactersSelection.querySelector("p").classList.add("valid");

    submitButton.classList.remove("disabled");
  });
});
