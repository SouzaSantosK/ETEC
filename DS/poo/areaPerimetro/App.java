package areaPerimetro;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Retangulo engenheiro = new Retangulo();
		
		System.out.println("Informe o valor da base do ret�ngulo: ");
		engenheiro.base = in.nextInt();
		
		System.out.println("Informe o valor da altura do ret�ngulo: ");
		engenheiro.altura = in.nextInt();
		
		engenheiro.calculaPerimetro();
		engenheiro.calculaArea();
		in.close();
		}
}
