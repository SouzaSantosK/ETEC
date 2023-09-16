<?php 
  session_start();
  if (isset($_POST["alternative"])) {
    $_SESSION["alternative"] = $_POST["alternative"];
  }

  echo $_SESSION["alternative"];
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="questions.css" />
    <link rel="stylesheet" href="dois.css" />
    <title>Questão 1</title>
  </head>
  <body>
    <main>
      <div>
        <h1>Pergunta 1</h1>
        <p class="question">Em que ano o Minecraft foi oficialmente lançado?</p>
      </div>

      <form method="post" action="dois.php">
        <div class="alternatives">
          <input type="radio" name="alternative" id="a" />
          <label for="a">
            <span>A</span>
            <p>2010</p>
          </label>
          <input type="radio" name="alternative" id="b" />
          <label for="b">
            <span>B</span>
            <p>2010</p>
          </label>
          <input type="radio" name="alternative" id="c" />
          <label for="c">
            <span>C</span>
            <p>2010</p>
          </label>
          <input type="radio" name="alternative" id="d" />
          <label for="d">
            <span>D</span>
            <p>2010</p>
          </label>
          <input type="radio" name="alternative" id="e" />
          <label for="e">
            <span>E</span>
            <p>2010</p>
          </label>
          <input type="radio" name="alternative" id="f" />
          <label for="f">
            <span>F</span>
            <p>2010</p>
          </label>
          <input type="radio" name="alternative" id="g" />
          <label for="g">
            <span>G</span>
            <p>2010</p>
          </label>
          <input type="radio" name="alternative" id="h" />
          <label for="h">
            <span>H</span>
            <p>2010</p>
          </label>
        </div>
      </form>
    </main>
    <aside>
      <div class="player">
        <img src="images/steve-head.webp" alt="">  
        <p><?php echo $_SESSION["name"]; ?></p>
      </div>
    </aside>
  </body>
</html>