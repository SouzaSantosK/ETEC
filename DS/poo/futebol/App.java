package futebol;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Jogador j = new Jogador();
		
		System.out.print("Digite o nome do jogador: ");
		j.nome = in.next();
		
		System.out.println("O jogador em campo é: " + j.nome);
		
		j.chutar();
		j.golear();
		
		in.close();
	}
}
