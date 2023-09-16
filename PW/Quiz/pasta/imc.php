
<?php
	$idade = $_POST["idade"];
	session_start();
	$_SESSION["idade"] = $idade;
?>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<form action="obs.php" method="post">
			<p>Digite o seu peso: <input type="text" name="peso"></p>
			<p>Digite a sua altura: <input type="text" name="altura"></p>
			<p><input type="submit" value="Próximo"></p>
		</form>
	</body>
</html>