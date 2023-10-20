<?php 
  session_start();
  $_SESSION["option-3"] =  $_POST["option-3"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../global.css" />
    <link rel="stylesheet" href="quatro.css" />
    <title>Pergunta 4</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 4</h1>

      <p class="question">
        Qual o nome desses mobs?
      </p>

      <form action="cinco.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-4" id="a" value="1" />
          <label for="a">
            <p>Ravager - Elder Guardian</p>
          </label>
          <input type="radio" name="option-4" id="b" value="0" />
          <label for="b">
          <p>Guardian - Drowned</p>
          </label>
          <input type="radio" name="option-4" id="c" value="0"/>
          <label for="c">
          <p>Pillager - Strider</p>
          </label>
          <input type="radio" name="option-4" id="d" value="0" />
          <label for="d">
          <p>Vindicator - Stray</p>
          </label>
        </div>

        <div class="buttons">
          <button type="submit" class="disabled">Avançar</button>
        </div>
      </form>
    </main>
    <aside>
      <img src="../../images/ravager.png" alt="" />
      <img src="../../images/elder-guardian.png" alt="" />
    </aside>
    <script src="../../global.js"></script>
    <script
      src="https://kit.fontawesome.com/25fee3ea99.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>