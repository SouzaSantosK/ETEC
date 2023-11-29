package imc;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		IMC calculador = new IMC();
		
		System.out.print("Informe o peso em Kg: ");
		calculador.peso = in.nextDouble();
		
		System.out.print("Informe a altura: ");
		calculador.altura = in.nextDouble();
		
		String[] resultado = calculador.calculaIMC();
		
		if (calculador.peso > 0 && calculador.altura > 0) {
			System.out.println("Com base no seu IMC de: " + resultado[0] + " você é classificado como: " + resultado[1]);
		} else {
			System.out.println("Valores inválidos");
		}
		in.close();
	}
}
