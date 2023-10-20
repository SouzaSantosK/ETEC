<?php 
  session_start();
  $_SESSION["option-9"] =  $_POST["option-9"];
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../../global.css" />
    <link rel="stylesheet" href="dez.css" />
    <title>Pergunta 10</title>
  </head>
  <body>
    <main>
      <form method="post" action="Resultados/resultados.php">
        <div class="box">
          <h1>Pergunta 10</h1>
          <p>
            Cada uma das imagens mostra uma dimensão que não existe no minecraft padrão. Qual dessas dimensões é a mais recente?
          </p>
          <div class="buttons">
            <button type="submit" class="disabled">Avançar</button>
          </div>
        </div>
        <input type="radio" name="option-10" id="a" value="0" />
        <label for="a" class="lb lb-1"></label>

        <input type="radio" name="option-10" id="b" value="0" />
        <label for="b" class="lb lb-2"></label>

        <input type="radio" name="option-10" id="c" value="0" />
        <label for="c" class="lb lb-3"></label>

        <input type="radio" name="option-10" id="d" value="0" />
        <label for="d" class="lb lb-4"></label>

        <input type="radio" name="option-10" id="e" value="0" />
        <label for="e" class="lb lb-5"></label>

        <input type="radio" name="option-10" id="f" value="0" />
        <label for="f" class="lb lb-6"></label>

        <input type="radio" name="option-10" id="i" value="0" />
        <label for="i" class="lb lb-7"></label>

        <input type="radio" name="option-10" id="j" value="1" />
        <label for="j" class="lb lb-8"></label>

      </form>
    </main>
    <script src="../../global.js"></script>
  </body>
</html>
