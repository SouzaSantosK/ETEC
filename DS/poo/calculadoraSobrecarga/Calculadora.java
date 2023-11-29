package calculadoraSobrecarga;

public class Calculadora {
	double resultado;
	double numero1;
	double numero2;
	String operacao = "";
	
	public Calculadora(double n1, double n2) {
		this.numero1 = n1;
		this.numero2 = n2;
	}

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
			operacao = " ÷ ";
		} else {
			System.out.println("Impossível dividir por 0");
		}
	}
	
	public double somar(double numeroUm, double numeroDois) {
		resultado = numeroUm + numeroDois;
		return resultado;
	}
	
	public double subtrair(double n1, double n2) {
		resultado = n1 - n2;
		return resultado;
	}
	
	public double multiplicar(double n1, double n2) {
		resultado = n1 * n2;
		return resultado;
	}
	
	public double dividir(double n1, double n2) {
		if (n2 != 0) {
			resultado = n1 / n2;
		} else {
			System.out.println("Impossível dividir por 0");
		}
		return resultado;
	}
}
