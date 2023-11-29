package agenda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Evento extends Rotina {
	private String localizacao;
	private String pessoas;
	
	private static List<Evento> listaEventos = new ArrayList<>();
	
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public String getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(String pessoas) {
		this.pessoas = pessoas;
	}
	
	public void menu() {
		Object[] funcoes = {"Criar", "Editar", "Excluir", "Mostrar"};
		
		while (true) {
			opcao = JOptionPane.showInputDialog(null,
					"Escolha uma opcao:",
					"Evento", 
					JOptionPane.QUESTION_MESSAGE,
					null,
					funcoes,
					funcoes[0]);
			
			if (opcao == null) {
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
		preencherCadastro(new Evento());
	}
	
	public void cadastrar(Evento e) {
		preencherCadastro(e);
	}
	
	@Override
	public void modificar() {
		if (listaEventos.isEmpty()) {
			super.mensagemAviso("Nenhum evento para modificar :(", "Modificacao");
			return;
		}
		
        String eventoSelecionado = selecionarEvento("Selecione um evento para modifica-lo", "Modificacao");
        
        if (eventoSelecionado != null) {
        	Evento evento = buscarEvento(eventoSelecionado);
        	
        	if (evento != null) {
        		excluir(evento);
        		cadastrar(evento);
        	}
        }
    }
	
	@Override
	public void mostrar() {
		if (listaEventos.isEmpty()) {
			super.mensagemAviso("Nenhum evento para exibir :(", "Exibicao");
			return;
		}
		
        String eventoSelecionado = selecionarEvento("Selecione um evento para exibi-lo", "Exibicao");

        if (eventoSelecionado != null) {
            Evento evento = buscarEvento(eventoSelecionado);

            if (evento != null) {
                JOptionPane.showMessageDialog(null,
                        "===== Detalhes do Evento ====="
                        		+ "\nNome: " + evento.getNome() 
                        		+ "\nDescrição: " + evento.getDescricao()
                        		+ "\nData: " + evento.getData()
                        		+ "\nLocalização: " + evento.getLocalizacao()
                        		+ "\nPessoas: " + evento.getPessoas(),
                        "Detalhes do Evento",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
	}
	
	@Override
	public void excluir() {
		if (listaEventos.isEmpty()) {
			super.mensagemAviso("Nenhum evento para excluir :(", "Exclusão");
			return;
		}
		
		String eventoSelecionado = selecionarEvento("Selecione um evento para exclui-lo", "Exclusão");
        
        Evento evento = buscarEvento(eventoSelecionado);
        
        if (evento != null) {
        	JOptionPane.showMessageDialog(null,
    				"Evento: " + evento.getNome() + " excluído com sucesso.",
    				"Excluindo...",
    				JOptionPane.INFORMATION_MESSAGE);
        	
            listaEventos.remove(evento);
        }
	}
	
	public void excluir(Evento evento) {
		listaEventos.remove(evento);
	}
	
// ============================================== Métodos auxiliares ==============================================
	
	// Cadastra as propriedades do objeto e atribui na lista de objetos
	private void preencherCadastro(Evento evento) {
		String nome;
		do {
			nome = super.receberInput("Nome do evento:");
			
			if (nome == null) {
				return;
			}
			
			if (super.isStringVazia(nome)) {
				super.mensagemAviso("Por favor insira um nome válido", "Aviso");
			}
		} while (super.isStringVazia(nome));
		evento.setNome(nome);
		
		String descricao;
		do {
			descricao = super.receberInput("Descrição do evento:");
			
			if (descricao == null) {
				return;
			}
			
			if (super.isStringVazia(descricao)) {
				super.mensagemAviso("Por favor insira uma descrição válida", "Aviso");
			}
		} while (super.isStringVazia(descricao));
		evento.setDescricao(descricao);
		
		String data;
		do {
			data = super.receberInput("Data do evento:");
			
			if (data == null) {
				return;
			}
			
			if (super.isStringVazia(data)) {
				super.mensagemAviso("Por favor insira uma data válida", "Aviso");
			}
		} while (super.isStringVazia(data));
		evento.setData(data);
		
		String localizacao;
		do {
			localizacao = super.receberInput("Localização do evento:");
			
			if (localizacao == null) {
				return;
			}
			
			if (super.isStringVazia(localizacao)) {
				super.mensagemAviso("Por favor insira uma localização válida", "Aviso");
			}
		} while (super.isStringVazia(localizacao));
		evento.setLocalizacao(localizacao);
		
		String pessoas;
		do {
			pessoas = super.receberInput("Pessoas no evento:");
			
			if (pessoas == null) {
				return;
			}
			
			if (super.isStringVazia(pessoas)) {
				super.mensagemAviso("Por favor insira uma quantidade válida", "Aviso");
			}
		} while (super.isStringVazia(pessoas));
		evento.setPessoas(pessoas);
		
		listaEventos.add(evento);
	}
	
	// Procurar na lista o nome do eventoSelecionado (string) pelo usuário e retornar o objeto correspondente a esse nome
	private Evento buscarEvento(String eventoSelecionado) {
		for (Evento evento : listaEventos) {
			if (evento.getNome().equals(eventoSelecionado)) {
				return evento;
			}
		}
		return null;
	}
	
	// Renomeia todos os objetos da lista, pelos seus nomes do setNome();
	public String[] nomeiaLista() {
    	String[] nomesEventos = new String[listaEventos.size()];
    	
        for (int i = 0; i < listaEventos.size(); i++) {
            nomesEventos[i] = listaEventos.get(i).getNome();
        }
        
		return nomesEventos;
	}
	
	// Pega o nome do evento selecionado (em string) na lista e o atribui na variavel eventoSelecionado;
	private String selecionarEvento(String mensagem, String titulo) {
		return (String) JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE, null,
				nomeiaLista(), nomeiaLista()[0]);
	}
}
