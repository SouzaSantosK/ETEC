<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="login.css" />
    <title>Home</title>
  </head>
  <body>
    <main>


    <div class="left">
      <h3>Configurações do PC:💻</h3>
      <ul>
        <li>
          <?php
            if (isset($_POST["sistema"])) {
              echo "<b>Sistema Operacional:</b> " . $_POST["sistema"];
            } else {
              echo "<b>Sistema Operacional:</b> <i>não definido...</i>";
            }
          ?>
        </li>
        <li>
          <?php
            if (isset($_POST["monitor"])) {
              echo "<b>Monitor:</b> " . $_POST["monitor"];
            } else {
              echo "<b>Monitor:</b> <i>não definido...</i>";
            }
          ?>  
        </li>
        <li>
          <?php
            if(isset($_POST["processador"])) {
              echo "<b>Processador: </b>";
              foreach($_POST["processador"] as $processador) {
                if ($processador != "") {
                  echo "<i>" . $processador . "</i>";
                } else {
                  echo "<i>não definido...</i>";
                }
              }
            }
          ?>
        </li>
        <li>
          <?php
            if (isset($_POST["placa"])) {
              echo "<b>Placa de Vídeo: </b>";
              foreach($_POST["placa"] as $placa) {
                if ($placa != "") {
                  echo "<i>" . $placa . "</i>";
                } else {
                  echo "<i>não definido...</i>";
                }
              }
            }
          ?>
        </li>
        <li>
            <?php
              echo "<b>Armazenamento interno:</b> ";
              if (isset($_POST["interno"])) {
                foreach ($_POST["interno"] as $armazenamento) {
                  echo $armazenamento . "; ";
                }
              }
              else {
                echo "<i>não definido...</i>";
              }
            ?>
        </li>
        <li class="news-letter">
          <?php
            echo "<b>Status da News Letter: </b>";
            if (isset($_POST["news"])) {
              echo "<i>Aprovado!!! você optou por assinar a nossa Newsletter, muito Obrigado! Em breve você começará a receber notificações diárias sobre as novidades da tecnologia direto no seu email, aguarde!! 😎</i>";
              }
              else {
                echo "<i>Negado... você não deseja receber nossas notícias diárias? Que pena...</i>";
            }
          ?>
        </li>
      </ul>

 
    </div>

    <div class="right">
      <h1>      
        <?php
          echo "Olá " . $_POST["nome"] . ", seja muito bem vindo!";
        ?>
      </h1>

      <h2>
        <?php
          echo $_POST["email"];
        ?>
      </h2>

    </div>

    

    </main>
  </body>
</html>
