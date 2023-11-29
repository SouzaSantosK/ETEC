package pessoas;

public class Pessoa {
	String nome;
	int idade;
	double peso;
	String vetor[] = new String [5];
	
	public String[] dadosPessoa() {
		
		vetor[0] = nome;
		
		if (idade < 18) {
			vetor[3] = "é menor de idade";
		} else {
			vetor[3] = "é maior de idade";
		}
		
		if (peso < 70) {
			vetor[4] = "e pesa menos que 70kg";
		} else {
			vetor[4] = "e pesa mais que 70kg";
		}
		
		vetor[1] = Integer.toString(idade);
		vetor[2] = peso + " kg";
		
		return vetor;
	}
}
