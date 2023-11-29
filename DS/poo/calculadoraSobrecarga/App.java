package calculadoraSobrecarga;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int opcao;
		double n1, n2;
		boolean resposta = true;
		
		do {
			System.out.println("Informe qual opera��o deseja realizar: "
					+ "\n [ 1 ] - Somar \n [ 2 ] - Subtrair "
					+ "\n [ 3 ] - Multiplicar \n [ 4 ] - Dividir");
			System.out.print("Sua op��o: ");
			opcao = in.nextInt();
			
			System.out.print("Informe o 1� n�mero: ");
			n1 = in.nextDouble();
			
			System.out.print("Informe o 2� n�mero: ");
			n2 = in.nextDouble();
			
			Calculadora calc = new Calculadora(n1, n2);

			switch(opcao) {
			case 1:
				System.out.print("Com retorno e com par�metro: " + calc.somar(n1, n2));
				calc.somar();
				System.out.println("\nSem retorno e sem par�metro: " + calc.resultado);
				break;
			case 2:
				System.out.print("Com retorno e com par�metro: " + calc.subtrair(n1, n2));
				calc.subtrair();
				System.out.println("\nSem retorno e sem par�metro: " + calc.resultado);
				break;
			case 3:
				System.out.print("Com retorno e com par�metro: " + calc.multiplicar(n1, n2));
				calc.multiplicar();
				System.out.println("\nSem retorno e sem par�metro: " + calc.resultado);
				break;
			case 4:
				System.out.println("Com retorno e com par�metro: " + calc.dividir(n1, n2));
				calc.dividir();
				System.out.println("Sem retorno e sem par�metro: " + calc.resultado);
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