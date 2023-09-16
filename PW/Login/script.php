<?php
    $login = $_POST['login'];
    $password = $_POST['senha'];

    if ($login == "1234" && $password == "1234") {
        header('Location: galeria.html');
    } else {
        header('Location: index.html');
    }
?>