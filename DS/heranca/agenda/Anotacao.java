package agenda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Anotacao extends Rotina {
	
	private static List<Anotacao> listaAnotacoes = new ArrayList<>();
	
	public void menu() {
		Object[] funcoes = {"Criar", "Modificar", "Excluir", "Mostrar"};
		
		while (true) {
			opcao = JOptionPane.showInputDialog(null,
					"Escolha uma opção:",
					"Anotacoes", 
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
			case "Modificar":
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
		preencherCadastro(new Anotacao());
	}
	
	public void cadastrar(Anotacao a) {
		preencherCadastro(a);
	}
	
	@Override
	public void modificar() {
		if (listaAnotacoes.isEmpty()) {
			super.mensagemAviso("Nenhuma anotação para modificar :(", "Modificacao");
			return;
		}
		
        String anotacaoSelecionada = selecionarAnotacao("Selecione uma anotação para modifica-la", "Modificacao");
        
        if (anotacaoSelecionada != null) {
        	Anotacao anotacao = buscarAnotacao(anotacaoSelecionada);
        	
        	if (anotacao != null) {
        		excluir(anotacao);
        		cadastrar(anotacao);
        	}
        }
    }
	
	@Override
	public void mostrar() {
		if (listaAnotacoes.isEmpty()) {
			super.mensagemAviso("Nenhuma anotação para exibir :(", "Exibicao");
			return;
		}
		
        String anotacaoSelecionada = selecionarAnotacao("Selecione uma anotação para exibi-la", "Exibicao");

        if (anotacaoSelecionada != null) {
            Anotacao anotacao = buscarAnotacao(anotacaoSelecionada);

            if (anotacao != null) {
                JOptionPane.showMessageDialog(null,
                        "===== Anotação: " + anotacao.getNome() +  " =====\n\n"
                		+ anotacao.getDescricao(),
                        "Detalhes da anotacao",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
	}
	
	@Override
	public void excluir() {
		if (listaAnotacoes.isEmpty()) {
			super.mensagemAviso("Nenhuma anotação para excluir :(", "Exclusão");
			return;
		}
		
		String anotacaoSelecionada = selecionarAnotacao("Selecione uma anotação para excluí-la", "Exclusão");
        
        Anotacao anotacao = buscarAnotacao(anotacaoSelecionada);
        
        if (anotacao != null) {
        	JOptionPane.showMessageDialog(null,
    				"Anotação " + anotacao.getNome() + " excluída com sucesso...",
    				"Excluindo...",
    				JOptionPane.INFORMATION_MESSAGE);
        	
        	listaAnotacoes.remove(anotacao);
        }
	}
	
	public void excluir(Anotacao anotacao) {
		listaAnotacoes.remove(anotacao);
	}
	
// ============================================== Métodos auxiliares ==============================================
	
	private void preencherCadastro(Anotacao anotacao) {
		String nome;
		do {
			nome = super.receberInput("Titulo da anotacao:");
			
			if (nome == null) {
				return;
			}
			
			if (super.isStringVazia(nome)) {
				super.mensagemAviso("Por favor insira um titulo valido", "Aviso");
			}
		} while (super.isStringVazia(nome));
		anotacao.setNome(nome);
		
		String descricao;
		do {
			descricao = super.receberInput("Descrição da anotacao:");
			
			if (descricao == null) {
				return;
			}
			
			if (super.isStringVazia(descricao)) {
				super.mensagemAviso("Por favor insira uma descricao valida", "Aviso");
			}
		} while (super.isStringVazia(descricao));
		anotacao.setDescricao(descricao);
		
		listaAnotacoes.add(anotacao);
	}
	
	private Anotacao buscarAnotacao(String anotacaoSelecionada) {
		for (Anotacao anotacao : listaAnotacoes) {
			if (anotacao.getNome().equals(anotacaoSelecionada)) {
				return anotacao;
			}
		}
		return null;
	}
	
	public String[] nomeiaLista() {
    	String[] nomesAnotacoes = new String[listaAnotacoes.size()];
    	
        for (int i = 0; i < listaAnotacoes.size(); i++) {
        	nomesAnotacoes[i] = listaAnotacoes.get(i).getNome();
        }
        
		return nomesAnotacoes;
	}
	
	private String selecionarAnotacao(String mensagem, String titulo) {
		return (String) JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE, null,
				nomeiaLista(), nomeiaLista()[0]);
	}
}
