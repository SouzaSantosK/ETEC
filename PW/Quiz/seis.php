<?php 
  session_start();
  $_SESSION["option-5"] =  $_POST["option-5"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="global.css" />
    <link rel="stylesheet" href="seis.css" />
    <title>Pergunta 6</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 6</h1>

      <p class="question">
        Qual o nome desses mobs?
      </p>

      <form action="sete.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-6" id="a" value="1"/>
          <label for="a">
            <p>Endermite e Allay</p>
          </label>
          <input type="radio" name="option-6" id="b" value="0"/>
          <label for="b">
            <p>Endermite e Ravager</p>
          </label>
          <input type="radio" name="option-6" id="c" value="0"/>
          <label for="c">
            <p>Ravager e Evoker</p>
          </label>
          <input type="radio" name="option-6" id="d" value="0"/>
          <label for="d">
            <p>Illusioner e Ghast</p>
          </label>
        </div>

        <div class="buttons">
          <button type="submit" class="disabled">Avançar</button>
        </div>
      </form>
    </main>
    <aside>
      <img src="./images/endermite.png" alt="" />
      <img src="./images/allay.png" alt="" />
    </aside>
    <script src="global.js"></script>
    <script
      src="https://kit.fontawesome.com/25fee3ea99.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
