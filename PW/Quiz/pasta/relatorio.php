
<?php
	$observacao = $_POST["obs"];
	session_start();
	echo "Nome Completo: ".$_SESSION["nome"]." ".$_SESSION["sobrenome"]."<br/>";
	echo "Esporte: ".$_SESSION["esporte"]."<br/>";
	echo "Idade: ".$_SESSION["idade"]."<br/>";
	echo "Imc: ".$_SESSION["imc"]."<br/>";
	echo "Observações: ".$observacao."<br/>";
?>
