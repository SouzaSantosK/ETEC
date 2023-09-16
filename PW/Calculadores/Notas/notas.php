<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../main.css">
    <link rel="stylesheet" href="./style.css">
    <title>Gerador de Notas</title>
</head>

<body>
    <nav>
        <a href="../index.html">Home 🏡</a>
        <a href="../Idade/idade.html">Verifica Idade 🧒</a>
        <a href="../Notas/notas.html">Gerador de Notas 👩‍🎓</a>
        <a href="../Salário/salario.html">Calculador Salário 💸</a>
    </nav>
    
    <div class="container">
        <?php
            $nome = $_POST['nome'];
            $nota1 = $_POST['nota1'];
            $nota2 = $_POST['nota2'];
            $media = $nota1 + $nota2 / 2;

            echo "<h1> <span>".$nome."</span></h1>";

            if ($media < 5) {
                echo "<h3>Você está <span>REPROVADO</span>😨</h3>";
            } else if ($media >= 7){
                echo "<h3>Você está <span>APROVADO</span>😎</h3>";
            } else {
                echo "<h3>Você está de <span>RECUPERAÇÃO</span>😭</h3>";
            }
        ?>
    </div>

</body>

</html>
