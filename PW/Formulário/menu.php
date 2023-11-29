<?php session_start() ?>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./src/styles/menu.css" />
    <title>Menu</title>
  </head>
  <body>
    <nav>
      <div class="info">
        <p>
          <?php echo $_SESSION["email"] ?>
        </p>
        <p>
          <?php echo $_SESSION["phone"] ?>
        </p>
      </div>
      <h3 class="hello-message">
        Olá, bem vindo <?php echo $_SESSION["username"] ?>!
      </h3>
      <div class="user">
        <div class="name">
          <h4>
            <?php echo $_SESSION["username"]; ?>
          </h4>
          <p>
            <?php echo $_SESSION["first-name"] . " " . $_SESSION["last-name"] . " - " . $_SESSION["county"]; ?> 
          </p>
        </div>
        <img src="src/images/user-icon.png" />
      </div>
    </nav>

    <main>
      <h1>Cursos para</h1>
      <h3><?php echo $_SESSION["course"] ?></h3>
      <div class="container">
        <div class="card">
          <div class="content">
            <h2>PHP</h2>
            <p>Primeiros passos com programação em php</p>
          </div>
        </div>
        <div class="card">
          <div class="content">
            <h2>Java</h2>
            <p>Primeiros passos com programação em java</p>
          </div>
        </div>
        <div class="card">
          <div class="content">
            <h2>JavaScript</h2>
            <p>Primeiros passos com programação em JS</p>
          </div>
        </div>
        <div class="card">
          <div class="content">
            <h2>HTML e CSS</h2>
            <p>Primeiros passos com programação em HTML e CSS</p>
          </div>
        </div>
        <div class="card">
          <div class="content">
            <h2>SQL</h2>
            <p>Primeiros passos com programação em SQL</p>
          </div>
        </div>
        <div class="card">
          <div class="content">
            <h2>Python</h2>
            <p>Primeiros passos com programação em Python</p>
          </div>
        </div>
      </div>
    </main>

    <footer>
      <p>
        @All rights reserved,
        <a target="_blank" href="https://github.com/souzasantosk"
          >SouzaSantosK</a
        >
        - 2023
      </p>
      <a class="back" href="./index.php">Voltar</a>
    </footer>
  </body>
</html>
