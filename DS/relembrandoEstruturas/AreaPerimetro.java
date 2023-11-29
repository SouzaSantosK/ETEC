/*
 * Dado o tamanho da base e da altura de um ret�ngulo, calcular a sua �rea e o seu per�metro.
 */

package relembrandoEstruturas;

import java.util.Scanner;

public class AreaPerimetro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double base, altura, area;
		
		System.out.println("Informe a base do ret�ngulo:");
		base = in.nextDouble();
		
		System.out.println("Informe a altura do ret�ngulo:");
		altura = in.nextDouble();
		
		area = base * altura;
		
		System.out.println("A �rea desse ret�ngulo é de: " + area + "m²");
		System.out.println("E o perímetro desse retângulo é de: " + (2 * base +  2 * altura) + "m²");
		in.close();
	}

}
