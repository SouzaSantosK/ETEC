package formasHeranca;

public class Quadrado extends Forma {
	
	public double calcularArea() {
		return super.getBase() * super.getBase();
	}
}
