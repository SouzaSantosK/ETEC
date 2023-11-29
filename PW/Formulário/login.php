<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./src/styles/login.css" />
    <title>Login</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"
    />
  </head>
  <body>
    <section>
      <button class="close">
        <a href="./index.php">
          <span class="material-symbols-outlined"> close </span>
        </a>
      </button>
      <h2>Faça Login</h2>

      <form action="./src/scripts/loginValidate.php" method="post">
        <?php 
        session_start();
        if (isset($_SESSION["message"])): ?>
          <div class="alert alert-danger">
            <?php echo $_SESSION["message"]; unset($_SESSION["message"]); ?>
          </div>
        <?php endif; ?>
        <div class="input-group filled">
          <input required type="email" id="email" name="email" />
          <label for="email">Email</label>
        </div>
        <div class="input-group">
          <input required type="password" id="password" name="password" />
          <label for="password">Senha</label>
        </div>
        <div class="buttons">
          <button type="submit" class="submit">Entrar</button>
          <a href="./register.php">Ainda não possui uma conta? Crie uma!</a>
        </div>
      </form>
    </section>
    <script src="./src/scripts/listener.js"></script>
  </body>
</html>
