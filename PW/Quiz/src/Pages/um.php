<?php 
  session_start();
  $_SESSION["name"] =  $_POST["name"];
  $_SESSION["character-index"] = $_POST["character-index"];
  $_SESSION["character"] = ["steve-head", "whiter-skeleton-head", "skeleton-head", "dragon-head", "creeper-head", "zombie-head", "piglin-head", "lich"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../global.css" />
    <link rel="stylesheet" href="um.css" />
    <title>Pergunta 1</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 1</h1>

      <p class="question">Qual dos "Minecrafts" é o da imagem?</p>

      <form action="dois.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-1" id="vanilla" value="0" />
          <label for="vanilla">
            <p>Vanilla</p>
          </label>
          <input type="radio" name="option-1" id="story-mode" value="0" />
          <label for="story-mode">
            <p>Story Mode</p>
          </label>
          <input type="radio" name="option-1" id="legends" value="1" />
          <label for="legends">
            <p>Legends</p>
          </label>
          <input type="radio" name="option-1" id="dungeons" value="0" />
          <label for="dungeons">
            <p>Dungeons</p>
          </label>
        </div>

        <div class="buttons">
        <button type="submit" class="disabled">Avançar</button>
        </div>
      </form>
    </main>
    <aside>
      <img src="../../images/minecraft3.jpg" alt="">
    </aside>
    <script src="../../global.js"></script>
    <script
      src="https://kit.fontawesome.com/25fee3ea99.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>

