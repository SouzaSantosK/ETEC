<?php 
  session_start();
  $_SESSION["option-7"] =  $_POST["option-7"];
?>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="global.css" />
    <link rel="stylesheet" href="oito.css" />
    <title>Pergunta 8</title>
  </head>
  <body>
    <main>
      <h1>Pergunta 8</h1>

      <p>Analise a seguinte frase:</p>

      <p class="phrase">
        <span>"</span>
        A entidade misteriosa conhecida como Herobrine é irmão de Notch (criador do Minecraft)? 
        <span>"</span>
      </p>

      <form action="nove.php" method="post">
        <div class="alternatives">
          <input type="radio" name="option-8" id="false" value="1" />
          <button type="submit">
            <label for="false">Falso</label>
          </button>
          <input type="radio" name="option-8" id="true" value="0" />
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
