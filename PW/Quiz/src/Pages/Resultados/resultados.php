<?php 
  session_start();
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

  $mensagens = [$_SESSION["name"] . " é uma máquina!", "Bom trabalho " . $_SESSION["name"], "Passou perto " . $_SESSION["name"], "Errou feio " . $_SESSION["name"] . "..."];

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
    <link rel="stylesheet" href="resultados.css" />
    <title>Resultados</title>
  </head>
  <body>
    <main>
      <h1>Vejamos como você se saiu...</h1>
      <div class="status">
        <h2>Seu resultado foi:</h2>
        <p class="message">"<?php echo $mensagens[$mensagensIndex] ?>"</p>

        <p class="acertos-erros">
          Acertando <?php echo $acertos ?> e errando <?php echo $erros > 1 ? $erros . " questões" : $erros . " questão";?>  de um total de 10
        </p>

        <h4>Deseja tentar novamente?</h4>

        <a href="../Home/home.php">
          <span>Aperte aqui! </span>
        </a>
      </div>
      <!-- <img class="character-icon" src="../../../images/<?php echo $_SESSION["character"]
      [$_SESSION["character-index"]] . '.png'; ?>" alt=""> -->
    </main>
    <aside>
      <header>
        <h3>Ranking</h3>
        <p>
          Opa FULANO! Atualmente você está em n-êsemico colocado no ranking.
        </p>
      </header>
      <div class="table">
        <?php 
          include('../../config/conexao.php');

          $stmt = $pdo->prepare("SELECT * FROM tbUser ORDER BY points DESC");
          $stmt->execute();

          $resultados = $stmt->fetchAll(PDO::FETCH_ASSOC);
          
          $character_image = "../../../images/" . $_SESSION["character"][$_SESSION["character-index"]] . ".png";
          foreach ($resultados as $row) {
            echo '<div class="celula"> <img src="' . $character_image . '" alt="" /> <p>' . $row["nameUser"] . '</p>';
          }
        ?>
      </div>
    </aside>
  </body>
</html>
