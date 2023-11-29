package calculadora;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Calculadora calc = new Calculadora();
		
		int opcao;
		boolean resposta = true;
		
		do {
			System.out.println("Informe qual opera��o deseja realizar: "
					+ "\n [ 1 ] - Somar \n [ 2 ] - Subtrair "
					+ "\n [ 3 ] - Multiplicar \n [ 4 ] - Dividir");
			System.out.println("Sua op��o: ");
			opcao = in.nextInt();
			
			System.out.println("Informe o 1� n�mero: ");
			calc.numero1 = in.nextInt();
			
			System.out.println("Informe o 2� n�mero: ");
			calc.numero2 = in.nextInt();
			
			switch(opcao) {
			case 1:
				calc.somar();
				System.out.println(calc.resultado);
				break;
			case 2: 
				calc.subtrair();
				System.out.println(calc.resultado);
				break;
			case 3:
				calc.multiplicar();
				System.out.println(calc.resultado);
				break;
			case 4:
				calc.dividir();
				break;
			default: 
				break;
			}
			
			System.out.println("Deseja calcular novamente? S / N");
			
			if (!in.next().equalsIgnoreCase("S")) {
				System.out.println("Encerrando o programa...");
				resposta = false;
			}
			
		} while(resposta);
		
		in.close();
	}
}