package calculadora;

public class Calculadora {
	double numero1;
	double numero2;
	double resultado;
	String operacao = "";
	
	public void somar() {
		resultado = numero1 + numero2;
		operacao = " + ";
	}
	
	public void subtrair() {
		resultado = numero1 - numero2;
		operacao = " - ";
	}
	
	public void multiplicar() {
		resultado = numero1 * numero2;
		operacao = " x ";
	}
	
	public void dividir() {
		if (numero2 != 0) {
			resultado = numero1 / numero2;
			System.out.println(resultado);
		} else {
			System.out.println("Impossível dividir por 2");
		}
		operacao = " ÷ ";
	}
}
