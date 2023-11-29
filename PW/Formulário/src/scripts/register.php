<?php
    session_start();

    include 'connection.php';

    $email = $_POST["email"];
    $password = $_POST["password"];
    $username = $_POST["username"];
    $firstName = $_POST["first-name"];
    $lastName = $_POST["last-name"];
    $county = $_POST["county"];
    $course = $_POST["course"];
    $phone = $_POST["phone"];

    try {
        $command = "INSERT INTO tbUser(email, password, username, firstName, lastName, county, course, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        $s = $con->prepare($command);
        $s->bindParam(1, $email);
        $s->bindParam(2, $password);
        $s->bindParam(3, $username);
        $s->bindParam(4, $firstName);
        $s->bindParam(5, $lastName);
        $s->bindParam(6, $county);
        $s->bindParam(7, $course);
        $s->bindParam(8, $phone);
        
        $s->execute();

    } catch (PDOException $erro) {
        echo "Erro: " . $erro->getMessage();
    }

    header("Location: ../../index.php");
?>
