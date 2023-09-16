<?php 
  session_start();
  $_SESSION["option-6"] =  $_POST["option-6"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="global.css" />
    <link rel="stylesheet" href="sete.css" />
    <title>Pergunta 7</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 7</h1>
      <p class="question">Qual dos "Minecrafts" é o da imagem?</p>

      <form action="oito.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-7" id="vanilla" value="0" />
          <label for="vanilla">
            <p>Vanilla</p>
          </label>
          <input type="radio" name="option-7" id="story-mode" value="1" />
          <label for="story-mode">
            <p>Story Mode</p>
          </label>
          <input type="radio" name="option-7" id="legends" value="0" />
          <label for="legends">
            <p>Legends</p>
          </label>
          <input type="radio" name="option-7" id="dungeons" value="0" />
          <label for="dungeons">
            <p>Dungeons</p>
          </label>
        </div>

        <div class="buttons">
          <button type="submit" class="disabled">Avançar</button>
        </div>
      </form>
    </main>
    <aside></aside>
    <script src="global.js"></script>
    <script
      src="https://kit.fontawesome.com/25fee3ea99.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
