<?php 
  session_start();
  $_SESSION["option-2"] =  $_POST["option-2"];
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../global.css" />
    <link rel="stylesheet" href="tres.css" />
    <title>Pergunta 3</title>
  </head>
  <body>
    <main>
      <form method="post" action="quatro.php">
        <div class="box">
          <h1>Pergunta 3</h1>
          <p>
            Selecione a imagem que corresponde a capa da mídia física do
            Minecraft que foi lançado para o console Xbox 360
          </p>
          <div class="buttons">
            <button type="submit" class="disabled">Avançar</button>
          </div>
        </div>
        <input type="radio" name="option-3" id="img-1" value="0" />
        <label for="img-1" class="lb lb-1"></label>

        <input type="radio" name="option-3" id="img-2" value="0" />
        <label for="img-2" class="lb lb-2"></label>

        <input type="radio" name="option-3" id="img-3" value="0" />
        <label for="img-3" class="lb lb-3"></label>

        <input type="radio" name="option-3" id="img-4" value="1" />
        <label for="img-4" class="lb lb-4"></label>

        <input type="radio" name="option-3" id="img-5" value="0" />
        <label for="img-5" class="lb lb-5"></label>

        <input type="radio" name="option-3" id="img-6" value="0" />
        <label for="img-6" class="lb lb-6"></label>

        <input type="radio" name="option-3" id="img-7" value="0" />
        <label for="img-7" class="lb lb-7"></label>

        <input type="radio" name="option-3" id="img-8" value="0" />
        <label for="img-8" class="lb lb-8"></label>

        <input type="radio" name="option-3" id="img-9" value="0" />
        <label for="img-9" class="lb lb-9"></label>
      </form>
    </main>
    <script src="../../global.js"></script>
  </body>
</html>