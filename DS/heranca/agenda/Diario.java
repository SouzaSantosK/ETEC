/*
 * Menu de Opções: OK
 * JOptionPane para apresentação e leitura de valores: OK
 * Classes, objetos, atributos e métodos: OK
 * Construtores: OK
 * Encapsulamento: OK
 * Sobrecarga: OK
 * Herança: OK
 * Sobrescrita: OK
 * */

package agenda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Diario extends Rotina {
	private String senha;
	private String recuperacao;
	private static List<Diario> listaDiarios = new ArrayList<>();
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRecuperacao() {
		return recuperacao;
	}

	public void setRecuperacao(String recuperacao) {
		this.recuperacao = recuperacao;
	}

	public void menu() {
		Object[] funcoes = {"Criar", "Editar", "Excluir", "Mostrar"};
		
		while (true) {
			
			opcao = JOptionPane.showInputDialog(null,
					"Escolha uma opção:",
					"Diário", 
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
		preencherCadastro(new Diario());
	}
	
	public void cadastrar(Diario d) {
		preencherCadastro(d);
	}
	
	public void modificar() {
		if (listaDiarios.isEmpty()) {
			super.mensagemAviso("Nenhum diário para modificar :(", "Modificação");
			return;
		}
		
        String diarioSelecionado = selecionarDiario("Selecione um diário para modificá-lo", "Modificação");
        
        if (diarioSelecionado != null) {
        	Diario diario = buscarDiario(diarioSelecionado);
        	
        	if (diario != null) {
        		excluir(diario);
        		cadastrar(diario);
        	}
        }
	}
	
	public void mostrar() {
		if (listaDiarios.isEmpty()) {
			super.mensagemAviso("Nenhum diário para exibir :(", "Exibicao");
			return;
		}
		
        String diarioSelecionado = selecionarDiario("Selecione um diário para exibí-lo", "Exibição");

        if (diarioSelecionado != null) {
        	Diario diario = buscarDiario(diarioSelecionado);
        	
        	if (diario != null) {
        		PaginaDiario paginaDiario = new PaginaDiario(this);
        		paginaDiario.setDiario(diario);
        		paginaDiario.menu();
        	}
        }
	}
	
	public void excluir() {
		if (listaDiarios.isEmpty()) {
			super.mensagemAviso("Nenhum diário para excluir :(", "Exclusão");
			return;
		}
		
		String diarioSelecionado = selecionarDiario("Selecione um diario para excluí-lo", "Exclusão");
        
        Diario diario = buscarDiario(diarioSelecionado);
        
        if (diario != null) {
        	JOptionPane.showMessageDialog(null,
    				"Diário: " + diario.getNome() + " excluído com sucesso.",
    				"Excluindo...",
    				JOptionPane.INFORMATION_MESSAGE);
        	
            listaDiarios.remove(diario);
        }
	}
	
	public void excluir(Diario diario) {
		listaDiarios.remove(diario);
	}
	
	// ---------------------------------------------------------------------- Métodos Auxiliares -------------------------------------------------------
	
	private void preencherCadastro(Diario diario) {
		String nome;
		do {
			nome = super.receberInput("Nome do diário:");
			
			if (nome == null) {
				return;
			}
			
			if (super.isStringVazia(nome)) {
				super.mensagemAviso("Por favor insira um nome válido", "Aviso");
			}
		} while (super.isStringVazia(nome));
		diario.setNome(nome);
		
		String senha = super.receberInput("Senha do diário (vazio para não cadastrar uma senha):");
		
		if (senha == null || senha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Você optou por não criar uma senha para seu diário.", "Senha", JOptionPane.INFORMATION_MESSAGE);
			senha = null;
		}
		diario.setSenha(senha);
		
		if (senha != null) {
			
			do {
				 recuperacao = JOptionPane.showInputDialog(null, 
						 "Frase de recuperação do diário", "ATENCAO - RECUPERACAO",
						 JOptionPane.WARNING_MESSAGE);
			} while (recuperacao == null || recuperacao.isEmpty());
			
			diario.setRecuperacao(recuperacao);
		}
		
		listaDiarios.add(diario);
	}
		
	private Diario buscarDiario(String diarioSelecionado) {
		for (Diario diario : listaDiarios) {
			if (diario.getNome().equals(diarioSelecionado)) {
				return diario;
			}
		}
		return null;
	}
	
	
	public String[] nomeiaLista() {
    	String[] nomesDiarios = new String[listaDiarios.size()];
    	
        for (int i = 0; i < listaDiarios.size(); i++) {
        	nomesDiarios[i] = listaDiarios.get(i).getNome();
        }
        
		return nomesDiarios;
	}

	private String selecionarDiario(String mensagem, String titulo) {
		return (String) JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE, null,
				nomeiaLista(), nomeiaLista()[0]);
	}
}

	