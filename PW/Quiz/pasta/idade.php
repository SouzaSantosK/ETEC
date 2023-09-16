<?php
	$esporte = $_POST["esporte"];
	session_start();
	$_SESSION["esporte"] = $esporte;
?>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<form action="imc.php" method="post">
			<p>Digite a sua idade: <input type="text" name="idade"> anos</p>
			<p><input type="submit" value="Próximo"></p>
		</form>
	</body>
</html>