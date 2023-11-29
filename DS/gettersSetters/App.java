package cadastroProduto;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int idProduto;
		String produto;
		String descricaoProduto;
		int valorProduto;
		String dataDoCadastro;
		
		System.out.print("Produto: ");
		produto = in.next();
		
		System.out.print("C�digo ID: ");
		idProduto = in.nextInt();

		System.out.print("Descri��o: ");
		descricaoProduto = in.next();
		
		System.out.print("Valor: ");
		valorProduto = in.nextInt();
		
		System.out.print("Data do cadastro: ");
		dataDoCadastro = in.next();
		
		Produto p = new Produto(idProduto, produto, descricaoProduto, valorProduto, dataDoCadastro);
		p.exibirProduto();
		
		in.close();	
	}
}
