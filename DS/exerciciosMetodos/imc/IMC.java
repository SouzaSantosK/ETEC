// Um programa que calcule o imc de uma pessoa e seja retornado a situação (peso ideal, obeso, etc), de uma pessoa.

package imc;

public class IMC {
	double peso;
	double altura;
	double imc;
	String status, vetor[] = new String [2];
	
	public String[] calculaIMC() {
		imc = peso / (altura * altura);
		if (imc < 18.5) {
			status = "Abaixo do peso";
		} else if (imc < 24.9) {
			status = "Peso normal";
		} else if (imc < 29.9) {
			status = "Sobrepeso";
		} else if (imc < 34.9) {
			status = "Obesidade I";
		} else if (imc < 39.9) {
			status = "Obesidade II";
		} else {
			status = "Obesidade Mórbida";
		}
		
		vetor[0] = Double.toString(imc);
		vetor[1] = status;
		
		return vetor;
	}
}
