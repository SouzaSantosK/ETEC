/*
	Escreva um programa que apresente um n�mero inteiro de tr�s algarismos, dado pelo usu�rio, com seus
	algarismos invertidos, por exemplo: para o n�mero 894 lido, o n�mero invertido a ser apresentado � 498.
 */

package relembrandoEstruturas;

import java.util.Scanner;

public class NumeroInvertido {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		/*
			int numero,  numeroInvertido = 0;

			System.out.print("Digite um n�mero de 3 algarismos: ");
			numero = in.nextInt();
			
			while(numero > 0) {
			    int ultimoDigito = numero % 10;
			    numeroInvertido = (numeroInvertido * 10) + ultimoDigito;
			    numero = numero / 10;
			}
			System.out.println("O n�mero invertido �: " + numeroInvertido);
		 */
		
		int numero, inverso, centena, dezena, unidade;
		
		System.out.print("Digite um n�mero de 3 algarismos: ");
		numero = in.nextInt();
		
		unidade = numero % 10 * 100;
		dezena = (numero % 100) / 10 * 10;
		centena = numero / 100;
		
		inverso = unidade + dezena + centena;
		
		System.out.println("O n�mero invertido �: " + inverso);
		in.close();
	}
}
