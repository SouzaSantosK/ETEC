package somatorio;

public class Contador {
	int atual = 0;
	int somatorio = 0;
	
	public void calcularSomatorio() {
		for (int i = 1; i <= 100; i++) {
			somatorio += i;
			System.out.println(atual + " + " + i + " = " + somatorio);
			atual = somatorio;
		}
	}
}
