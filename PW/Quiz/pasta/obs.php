
<?php
	$peso = $_POST["peso"];
	$altura = $_POST["altura"];
	$imc = $peso / ($altura*$altura);
	$imc = round($imc,3);
	session_start();
	$_SESSION["imc"] = $imc;
?>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<form action="relatorio.php" method="post">
			<p>Observações: <textarea name="obs"></textarea></p>
			<p><input type="submit" value="Próximo"></p>
		</form>
	</body>
</html>