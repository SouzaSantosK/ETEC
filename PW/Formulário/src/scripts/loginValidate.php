<?php
    session_start();
    include 'connection.php';

    $email = $_POST['email'];
    $password = $_POST["password"];

    try {
        $command = "SELECT * FROM tbUser WHERE email = ? AND password = ?";
        $stmt = $con->prepare($command);

        $stmt->execute([$email, $password]);

        if ($stmt->rowCount() > 0) {
            $user = $stmt->fetch(PDO::FETCH_ASSOC);
           $_SESSION["email"] = $user["email"];
           $_SESSION["username"] = $user["username"];
           $_SESSION["first-name"] = $user["firstName"];
           $_SESSION["last-name"] = $user["lastName"];
           $_SESSION["county"] = $user["county"];
           $_SESSION["course"] = $user["course"];
           $_SESSION["phone"] = $user["phone"];
           
            header("Location: ../../menu.php");
        } else {
            $_SESSION["message"] = "Dados incorretos";
            header("Location: ../../login.php");
        }
    } catch (PDOException $erro) {
        echo "Erro: " . $erro->getMessage();
    }
?>
