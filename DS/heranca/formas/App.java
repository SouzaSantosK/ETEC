package formas;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Escolha uma opção: \n[ 1 ] - Quadrado \n[ 2 ] - Triangulo \n[ 3 ] - Retangulo \n[ 4 ] - Trapezio");
		switch(in.nextInt()) {
		case 1:
			Quadrado quadrado = new Quadrado();			
			
			System.out.println("Informe a base do quadrado: ");
			quadrado.setB(in.nextInt());

			System.out.println("Informe a altura do quadrado: ");
			quadrado.setH(in.nextInt());
			System.out.println(quadrado.calcular());
			break;
		case 2:
			Triangulo triangulo = new Triangulo();

			System.out.println("Informe a base do triangulo: ");
			triangulo.setB(in.nextInt());

			System.out.println("Informe a altura do triangulo: ");
			triangulo.setH(in.nextInt());
			System.out.println(triangulo.calcular());
			break;
		case 3:
			Retangulo retangulo = new Retangulo();
			
			System.out.println("Informe a base do retangulo: ");
			retangulo.setB(in.nextInt());
			
			System.out.println("Informe a altura do retangulo: ");
			retangulo.setH(in.nextInt());
			System.out.println(retangulo.calcular());
			break;
		case 4:
			Trapezio trapezio = new Trapezio();
			
			System.out.println("Informe a base menor do trapezio: ");
			trapezio.setB(in.nextInt());
			
			System.out.println("Informe a base maior do trapezio:");
			trapezio.setBaseMaior(in.nextInt());
			
			System.out.println("Informe a altura do trapezio: ");
			trapezio.setH(in.nextInt());
			
			System.out.println(trapezio.calcular());
			break;
		}
	
		in.close();
	}

}
