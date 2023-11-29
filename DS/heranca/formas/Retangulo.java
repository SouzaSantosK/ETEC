package formas;

public class Retangulo {
	private double b;
	private double h;
	private double area;

	public double getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public double getH() {
		return h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public double calcular() {
		area = b * h;
		return area;
	}
	
}
