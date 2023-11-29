package extras;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inicio, fim;
		
		Tabuada tabuada = new Tabuada();
		
		System.out.print("Informe o inicio do intervalo ao qual deseja fazer as tabuadas: ");
		inicio = in.nextInt();
		
		System.out.print("Informe o fim do intervalo ao qual deseja fazer as tabuadas: ");
		fim = in.nextInt();
		
		tabuada.fazerTabuadas(inicio, fim);
		in.close();
	}

}
