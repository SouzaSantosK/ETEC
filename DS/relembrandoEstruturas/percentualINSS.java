/*
	Criar um programa que calcule o sal�rio l�quido de um professor. Para fazer esse programa voc� dever� ler o
	valor da hora aula e o n�mero de aulas dadas no m�s. O sal�rio l�quido ser� obtido multiplicando-se o n�mero
	de aulas dadas pelo valor da hora aula e descontando o percentual do INSS conforme tabela abaixo:
*/

package relembrandoEstruturas;

import java.util.Scanner;

public class percentualINSS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double horaAula, salarioLiquido, aliquota;
		int aulas;
		
		System.out.print("Quanto voc� recebe por Hora/Aula? ");
		horaAula = in.nextDouble();
		
		System.out.print("Quantas aulas voc� leciona por m�s? ");
		aulas = in.nextInt();
		
		salarioLiquido = aulas * horaAula;
		
		if (salarioLiquido <= 1212) {
			aliquota = 7.5;
		} else if (salarioLiquido <= 2427.35) {
			aliquota = 9;
		} else if (salarioLiquido <= 3641.03) {
			aliquota = 12;
		} else if (salarioLiquido <= 7087.22) {
			aliquota = 14;
		} else if (salarioLiquido <= 12136.79) {
			aliquota = 14.5;
		} else if (salarioLiquido <= 24273.57) {
			aliquota = 16.5;
		} else if (salarioLiquido <= 47333.46) {
			aliquota = 19;
		} else {
			aliquota = 22;
		}
		
		System.out.println("Portanto, com desconto de " + aliquota + "% do INSS, seu sal�rio ser� de: R$ " + (salarioLiquido - (salarioLiquido * aliquota / 100)));
		in.close();
	}
}
