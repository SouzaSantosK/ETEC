
<?php
	$nome = $_POST["nome"];
	session_start();
	$_SESSION["nome"] = $nome;
?>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<form action="esporte.php" method="post">
			<p>Digite o seu sobrenome: <input type="text" name="sobrenome"></p>
			<p><input type="submit" value="Próximo"></p>
		</form>
	</body>
</html>