<?php 
  session_start();
  $_SESSION["option-1"] =  $_POST["option-1"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../global.css" />
    <link rel="stylesheet" href="dois.css" />
    <title>Pergunta 2</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 2</h1>

      <p class="question">
        Selecione a opção que contém todos os mundos. Baseado nas imagens ao lado.
      </p>

      <form action="tres.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-2" id="a" value="1" />
          <label for="a">
            <p>Overworld - Nether - Aether - The End</p>
          </label>
          <input type="radio" name="option-2" id="b" value="0" />
          <label for="b">
            <p>Twilight Forest - Nether - Aether - The End</p>
          </label>
          <input type="radio" name="option-2" id="c" value="0"/>
          <label for="c">
            <p>Céu - Nether - The End - Aether</p>
          </label>
          <input type="radio" name="option-2" id="d" value="0" />
          <label for="d">
            <p>Overworld - Underworld - Skyworld - Farlands</p>
          </label>
        </div>

        <div class="buttons">
          <button type="submit" class="disabled">Avançar</button>
        </div>
      </form>
    </main>
    <aside>
      <img src="../../images/overworld.png" alt="" />
      <img src="../../images/nether.png" alt="" />
      <img src="../../images/aether.jpg" alt="" />
      <img src="../../images/the_end.png" alt="" />
    </aside>
    <script src="../../global.js"></script>
    <script
      src="https://kit.fontawesome.com/25fee3ea99.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>