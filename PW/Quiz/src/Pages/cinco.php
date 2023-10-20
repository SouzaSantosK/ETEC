<?php 
  session_start();
  $_SESSION["option-4"] =  $_POST["option-4"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../global.css" />
    <link rel="stylesheet" href="cinco.css" />
    <title>Pergunta 5</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 5</h1>

      <p>Analise a seguinte frase:</p>

      <p class="phrase">
        <span>"</span>
        Quando um raio cai em um villager, ele se torna uma bruxa
        <span>"</span>
      </p>

      <form action="seis.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-5" id="false" value="0" />
          <button type="submit">
            <label for="false">Falso</label>
          </button>
          <input type="radio" name="option-5" id="true" value="1" />
          <button type="submit">
            <label for="true">Verdadeiro</label>
          </button>
        </div>
      </form>
    </main>
    <script
      src="https://kit.fontawesome.com/25fee3ea99.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
