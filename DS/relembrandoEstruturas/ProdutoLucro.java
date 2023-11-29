/*
	Criar um programa que leia o pre�o de um produto e a margem de lucro (em porcentagem). Calcule e
	apresente o pre�o de venda. Executar esse programa at� que o usu�rio responda �N� para a pergunta (�Deseja
	continuar a execu��o? (S/N) �)
 */

package relembrandoEstruturas;

import java.util.Scanner;

public class ProdutoLucro {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String resposta;
		double preco, lucro;

		
		do {
			System.out.print("Informe o pre�o do produto: ");
			preco = in.nextDouble();
			
			System.out.print("Informe a margem de lucro desejada: ");
			lucro = in.nextDouble();
			
			System.out.println("Para o produto atingir a margem de lucro desejada, ele dever� ser vendido por: R$ " + (preco + (lucro / 100 * preco)));
			
			System.out.print("Deseja continuar? (S/N): ");
			resposta = in.next();
		} while (resposta.equalsIgnoreCase("S"));
		
		System.out.println("Encerrando o programa...");
		in.close();
	}
}
