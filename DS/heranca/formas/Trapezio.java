package formas;

public class Trapezio {
	private double b;
	private double h;
	private double area;
	private double baseMaior;

	public double getB() {
		return b;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	public double getH() {
		return h;
	}
	
	public void setH(double h) {
		this.h = h;
	}
	
	public double getBaseMaior() {
		return baseMaior;
	}
	
	public void setBaseMaior(double baseMaior) {
		this.baseMaior = baseMaior;
	}
	
	public double calcular() {
		area = (baseMaior + b) / 2 * h;
		return area;
	}

	public double getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
}
