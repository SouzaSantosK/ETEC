<?php
	$sobrenome = $_POST["sobrenome"];
	session_start();
	$_SESSION["sobrenome"] = $sobrenome;
?>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<form action="idade.php" method="post">
			<p>Escolha o seu Esporte: 
				<input type="radio" name="esporte" value="futebol"> Futebol
				<input type="radio" name="esporte" value="basquete"> Basquete
				<input type="radio" name="esporte" value="corrida"> Corrida
			</p>
			<p><input type="submit" value="Próximo"></p>
		</form>
	</body>
</html>