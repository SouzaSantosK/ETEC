<?php 
  session_start();
  $_SESSION["option-8"] =  $_POST["option-8"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../global.css" />
    <link rel="stylesheet" href="nove.css" />
    <title>Pergunta 9</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 9</h1>

      <p class="question">
        Analise as imagens ao lado e responda, quantas dessas dimensões NÃO fazem parte do Minecraft Vanilla
      </p>

      <form action="dez.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-9" id="a" value="0" />
          <label for="a">
            <p>1</p>
          </label>
          <input type="radio" name="option-9" id="b" value="0" />
          <label for="b">
            <p>2</p>
          </label>
          <input type="radio" name="option-9" id="c" value="0" />
          <label for="c">
            <p>3</p>
          </label>
          <input type="radio" name="option-9" id="d" value="1" />
          <label for="d">
            <p>4</p>
          </label>
        </div>

        <div class="buttons">
          <button type="submit" class="disabled">Avançar</button>
        </div>
      </form>
    </main>
    <aside>
      <img src="../../images/aether.jpg" alt="" />
      <img src="../../images/twilight-forest.jpg" alt="" />
      <img src="../../images/atum.png" alt="" />
      <img src="../../images/crystal.png" alt="" />
    </aside>
    <script src="../../global.js"></script>
    <script
      src="https://kit.fontawesome.com/25fee3ea99.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
