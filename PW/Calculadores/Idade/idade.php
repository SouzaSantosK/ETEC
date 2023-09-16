

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../main.css">
    <link rel="stylesheet" href="./style.css">
    <title>Calculador Salário</title>
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
        $idade = $_POST['idade'];

        echo "<h1><span>".$nome."</span></h1>";

        if ($idade < 18) {
            echo "<h3>Você é <span>menor de idade</span></h3>";
        } else {
            echo "<h3>Você é <span>maior de idade</span></h3>";
        }
        ?>
    </div>

</body>

</html>
