package extras;

public class Tabuada {
	
	int produto = 0;

	public void fazerTabuadas(int inicio, int fim) {
			if (inicio < fim) {
				for (; inicio <= fim; inicio++) {
					for (int j = 1; j <= 10; j++) {
						produto = inicio * j;
						System.out.println(j + " X " + inicio + " = " + produto);
					}
					System.out.println();
				}
			} else {
				System.out.println("Entrou no invertido");
				
				for (; inicio >= fim; inicio--) {
					for (int j = 1; j <= 10; j++) {
						produto = inicio * j;
						System.out.println(j + " X " + inicio + " = " + produto);
					}
					System.out.println();
				}
				
			}
	}
}
