<?php 
  session_start();
  $_SESSION["option-10"] =  $_POST["option-10"];
  $vetor = [$_SESSION["option-1"], $_SESSION["option-2"], $_SESSION["option-3"], $_SESSION["option-4"], $_SESSION["option-5"], $_SESSION["option-6"], $_SESSION["option-7"], $_SESSION["option-8"], $_SESSION["option-9"], $_SESSION["option-10"]];

  $acertos = 0;
  $erros = 0;

  for ($i = 0; $i < 10; $i++) {
    if ($vetor[$i] == "1") {
      $acertos++;
    } else {
      $erros++;
    }
  }

  $mensagens = [$_SESSION["name"] . " é uma máquina!", "Bom trabalho " . $_SESSION["name"], "Passou perto " . $_SESSION["name"], "Putz, errou feio " . $_SESSION["name"] . "..."];

  if ($acertos < 4) {
    $mensagensIndex = 3;  
  } else if ($acertos < 6) {
    $mensagensIndex = 2;  
  } else if ($acertos < 10) {
    $mensagensIndex = 1;  
  } else {
    $mensagensIndex = 0;  
  }
?>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Resultados</title>
    <link rel="stylesheet" href="resultado.css" />
  </head>
  <body>
    <main>
      <img class="character-icon" src="images/<?php echo $_SESSION["character"][$_SESSION["character-index"]] . '.png'; ?>" alt="">
      <h1><span class="user-name"><?php echo $mensagens[$mensagensIndex] ?></span></h1>
      <div class="percentuais">
        <h2>
          Acertos: <span class="percentual"><?php echo $acertos ?></span> / 10 ou
          <span class="percentual"><?php echo ($acertos * (100 / ($acertos + $erros))) ?></span>%
        </h2>
        <h2>
          Erros: <span class="percentual"><?php echo $erros ?></span> / 10 ou
          <span class="percentual"><?php echo ($erros * (100 / ($acertos + $erros))) ?></span>%
        </h2>
      </div>
      <a href="home.php">Tentar novamente</a>
    </main>
  </body>
</html>
