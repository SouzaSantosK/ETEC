package tabuada;

public class Tabuador {
	int fator;
	int produto;
	
	public void fazerTabuada() {
		for (int i = 1; i <= 10; i++) {
			produto = fator * i;
			System.out.println(fator + " X " + i + " = "+ produto);
		}
	}
}
