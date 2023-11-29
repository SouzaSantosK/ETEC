package areaPerimetro;

public class Retangulo {
	int base;
	int altura;
	int perimetro;
	int area;
	
	public void calculaPerimetro() {
		perimetro = 2 * (base + altura);
		System.out.println("O perimetro desse ret�ngulo �: " + perimetro);
	}
	
	public void calculaArea() {
		area = base * altura;
		System.out.println("A �rea desse ret�ngulo �: " + area);
	}
	
}

// perimetro = 2 * (base + altura)
// area = base * altura