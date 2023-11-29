package matrizes;
import java.util.Scanner;

public class tabuleiro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char tabuleiro[][] = new char[3][3], jogador = 'X';
		boolean vitoria = false, linhaValida = false, colunaValida = false;
		int jogadas = 1, linha = 0, coluna = 0;
		
		while(!vitoria) {
			if (jogadas % 2 == 0) {
				System.out.println("Vez do jogador O. Escolha uma linha e coluna (1 - 3)");
				jogador = 'O';
			} else {
				System.out.println("Vez do jogador X. Escolha uma linha e coluna (1 - 3)");
				jogador = 'X';
			}
			
			linhaValida = false;
			while(!linhaValida) {
				System.out.print("Entre com a linha: ");
				linha = in.nextInt() - 1;
				
				if (linha >= 0 && linha <= 2) {
					linhaValida = true;
				} else {
					System.out.println("Entrada de linha inválida, tente novamente...");
				}
			}
			
			colunaValida = false;
			
			while(!colunaValida) {
				System.out.print("Entre com a coluna: ");
				coluna = in.nextInt() - 1;
				
				if (coluna >= 0 && coluna <= 2) {
					colunaValida = true;
				} else {
					System.out.println("Entrada de coluna inválida, tente novamente...");
				}
			}
			
			if (tabuleiro[linha][coluna] == 'X' || tabuleiro[linha][coluna] == 'O') {
				System.out.println("Posição já preenchida, tente novamente...");
			} else {
				tabuleiro[linha][coluna] = jogador;
				jogadas++;
			}
			
			for (int i = 0; i < tabuleiro.length; i++) {
				for (int j = 0; j < tabuleiro[i].length; j++) {
					System.out.print(tabuleiro[i][j] + " | ");
				}
				System.out.println();
			}
			
			if (jogadas > 9) {
                System.out.println("Ninguém ganhou essa partida.");
                break;
            } else if ((tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X') ||
                    (tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X') ||
                    (tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X') ||
                    (tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X') ||
                    (tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X') ||
                    (tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X') ||
                    (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') ||
                    (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X') ||
                    (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') || 
                    (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X')) {
                vitoria = true;
                System.out.println("Parabéns, jogador X ganhou!");
			} else if ((tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O') ||
					(tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O') ||
					(tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O') ||
					(tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O') ||
					(tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O') ||
					(tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O') ||
					(tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') ||
					(tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O') ||
					(tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') || 
                    (tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O')) {
				vitoria = true;
				System.out.println("Parabéns, jogador O ganhou!");
			}
		}
		in.close();
	}
}