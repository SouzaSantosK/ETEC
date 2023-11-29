<?php
    include('conexao.php');

    session_start();
    $_SESSION["option-10"] =  $_POST["option-10"];
    $user = $_SESSION['name'];

    if(empty($user)){
        $user = "Guest".rand();
    }

    $stmt = $pdo->prepare("INSERT INTO tbUser VALUES(null, '$user', '0')");
    $stmt->execute();

    header('location:../Resultados/resultados.php');
?>