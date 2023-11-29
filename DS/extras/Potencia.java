package extras;

public class Potencia {
	
	int multiplicador;
	
	public int fazerPotencia(int base, int expoente) {
		if (expoente == 0) { 
			base = 1;
		}
		
		multiplicador = base;
		for (int i = 1; i < expoente; i++) {
			base *= multiplicador;
		}
		return base;
	}
}
