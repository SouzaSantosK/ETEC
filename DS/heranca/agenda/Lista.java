package agenda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Lista extends Rotina {
	private List<String> itens;
	private static List<Lista> vetorLista = new ArrayList<>();

	
	public List<String> getItens() {
		return itens;
	}
	public void setItens(List<String> itens) {
		this.itens = itens;
	}
	
	public void menu() {
		Object[] funcoes = {"Criar", "Editar", "Excluir", "Mostrar"};
		
		while (true) {
			opcao = JOptionPane.showInputDialog(null,
					"Escolha uma opcao:",
					"Agenda", 
					JOptionPane.QUESTION_MESSAGE,
					null,
					funcoes,
					funcoes[0]);
			
			if (opcao == null) {
				super.mensagemSaida();
				
				this.menu();
			}
			
			switch(opcao.toString()) {
			case "Criar":
				this.cadastrar();
				break;
			case "Editar":
				this.modificar();
				break;
			case "Excluir":
				this.excluir();
				break;
			case "Mostrar":
				this.mostrar();
				break;
			}
		}	
	}
	
	public void cadastrar() {
		preencherCadastro(new Lista());
	}
	
	public void cadastrar(Lista l) {
		preencherCadastro(l);
	}
	
	public void modificar() {
		if (vetorLista.isEmpty()) {
			super.mensagemAviso("Nenhuma lista para modificar :(", "Modificacao");
			return;
		}
		
        String listaSelecionada = selecionarEvento("Selecione uma lista para modifica-la", "Modificacao");
        
        if (listaSelecionada != null) {
        	Lista lista = buscarEvento(listaSelecionada);
        	
        	if (lista != null) {
        		excluir(lista);
        		cadastrar(lista);
        	}
        }
	}
	
	public void excluir() {
		if (vetorLista.isEmpty()) {
			super.mensagemAviso("Nenhuma lista para excluir :(", "Exclusao");
			return;
		}
		
        String listaSelecionada = selecionarEvento("Seleciona uma lista para exclui-la", "Exclusao");
        
        Lista lista = buscarEvento(listaSelecionada);
        
        JOptionPane.showMessageDialog(null,
				"Lista: " + lista.getNome() + " excluida com sucesso",
				"Excluindo...",
				JOptionPane.INFORMATION_MESSAGE);
        
        vetorLista.remove(lista);
	}
	
	public void excluir(Lista l) {
		vetorLista.remove(l);
	}
	
	public void mostrar() {
		if (vetorLista.isEmpty()) {
			super.mensagemAviso("Nenhuma lista para mostrar :(", "Visualizacao");
			return;
		}
		
        String listaSelecionada = selecionarEvento("Seleciona uma lista para visualiza-la", "Visualizacao");

        Lista lista = buscarEvento(listaSelecionada);

    	StringBuilder textoItens = new StringBuilder();
    	textoItens.append("Itens da lista ").append(lista.getNome()).append(":\n");
    	
    	List<String> itens = lista.getItens();
    	
    	if (itens.isEmpty()) {
    		textoItens.append("Nenhum item na lista.");
    		return;
    	}
    	
		for (String item : itens) {
			textoItens.append("- ").append(item).append("\n");
		}
    	
		JOptionPane.showMessageDialog(null,
				textoItens.toString(),
				"Itens da Lista",
				JOptionPane.INFORMATION_MESSAGE);

	}
	
	
	// ----------------------------------------------------------- Métodos auxiliares -----------------------------
	
	private void preencherCadastro(Lista lista) {
		String nome;
		do {
			nome = super.receberInput("Nome da lista:");
			
			if (nome == null) {
				return;
			}
			
			if (super.isStringVazia(nome)) {
				super.mensagemAviso("Por favor insira um nome válido", "Aviso");
			}
		} while (super.isStringVazia(nome));
		lista.setNome(nome);
		
		List<String> itens = new ArrayList<>();
		
		while (true) {
			String item;
			do {
				item = super.receberInput("Digite o item que deseja inserir na lista '" + nome + "'");
				
				if (item == null) {
					return;
				}
				
				if (super.isStringVazia(item)) {
					super.mensagemAviso("Por favor insira um nome de item válido", "Aviso");
				}
			} while (super.isStringVazia(item));
			
			itens.add(item);
			int opcao = JOptionPane.showConfirmDialog(null, "Deseja inserir mais itens na lista '" + nome + "'?", "Continuar", JOptionPane.YES_NO_OPTION);
			if (opcao == JOptionPane.NO_OPTION) {
				break;
			}
		}
		
		lista.setItens(itens);
		vetorLista.add(lista);
	}
	
	private Lista buscarEvento(String listaSelecionada) {
		for (Lista lista : vetorLista) {
			if (lista.getNome().equals(listaSelecionada)) {
				return lista;
			}
		}
		return null;
	}
	
	// JOptionPane que muda de acordo com a função escolhida
	private String selecionarEvento(String mensagem, String titulo) {
		return (String) JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE, null,
				nomeiaLista(), nomeiaLista()[0]);
	}
	
	// Coloca nome pra cada evento da lista
	public String[] nomeiaLista() {
    	String[] nomesListas = new String[vetorLista.size()];
    	
        for (int i = 0; i < vetorLista.size(); i++) {
        	nomesListas[i] = vetorLista.get(i).getNome();
        }
        
		return nomesListas;
	}
}