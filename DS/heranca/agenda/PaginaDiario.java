package agenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PaginaDiario extends Diario {
	private Diario diario;
	private static List<PaginaDiario> listaPaginasDiario = new ArrayList<>();
	private boolean login = false;
	private int numeroPaginaAtual = 1;
	
	public PaginaDiario(Diario diario) {
		this.diario = diario;
	}
	
	public Diario getDiario() {
		return diario;
	}
	
	public void setDiario(Diario diario) {
		this.diario = diario;
	}
	
	public void menu() {
		
		validaSenha();
		
		 Object[] funcoes = {"Escrever uma página", "Modificar uma página", "Excluir uma página", "Mostrar uma página"};
		 
		 while (true) {
			opcao = JOptionPane.showInputDialog(null,
					"Agora sim... Seja bem-vindo ao " + diario.getNome(),
					"Agenda", 
					JOptionPane.QUESTION_MESSAGE,
					null,
					funcoes,
					funcoes[0]);
				
			if (opcao == null) {
				// OBS: Fazer ele voltar ao menu de diarios sem dar erro em vez de finalizar o programa
				super.mensagemSaida();
            } else {
            	switch(opcao.toString()) {
    			case "Escrever uma página":
    				this.cadastrar();
    				break;
    			case "Modificar uma página":
    				this.modificar();
    				break;
    			case "Excluir uma página":
    				this.excluir();
    				break;
    			case "Mostrar uma página":
    				this.mostrar();
    				break;
    			}
            }
		}
	}
	
	public void cadastrar() {
		preencherCadastro(new PaginaDiario(diario));
	}
	
	public void cadastrar(PaginaDiario p) {
		preencherCadastro(p);
	}
	
	public void mostrar() {
		if (listaPaginasDiario.isEmpty()) {
			super.mensagemAviso("Nenhuma página para exibir :(", "Exibição");
			return;
		}
		
		String paginaSelecionada = selecionarPagina("Selecione uma página para exibí-la:", "Exibição");
		
		if (paginaSelecionada != null) {
			PaginaDiario pagina = buscarPagina(paginaSelecionada);
			
			if (pagina != null) {
				JOptionPane.showMessageDialog(null,
                        "===== " + pagina.getNome().substring(pagina.getNome().indexOf(" - ") + 3) + " ("+ pagina.getData() +  ") ====="
                        + "\n\n" + pagina.getDescricao(),
                        pagina.getNome() + " - " +  pagina.getData(),
                        JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void excluir() {
		if (listaPaginasDiario.isEmpty()) {
			super.mensagemAviso("Nenhuma página para excluir :(", "Exclusão");
			return;
		}
		
		String paginaSelecionada = selecionarPagina("Selecione uma página para excluí-la:", "Exclusão");
		
		if (paginaSelecionada != null) {
			PaginaDiario pagina = buscarPagina(paginaSelecionada);
			
			if (pagina != null) {
				JOptionPane.showMessageDialog(null,
	    				"Página: " + pagina.getNome() + " excluída com sucesso.",
	    				"Excluindo...",
	    				JOptionPane.WARNING_MESSAGE);
				
				listaPaginasDiario.remove(pagina);
				atualizarNumerosPaginas();
			}
		}
	}
	
	public void excluir(PaginaDiario pagina) {
		listaPaginasDiario.remove(pagina);
		atualizarNumerosPaginas();
	}
	
	public void modificar() {
		if (listaPaginasDiario.isEmpty()) {
			super.mensagemAviso("Nenhuma página para modificar :(", "Modificação");
			return;
		}
		
        String paginaSelecionada = selecionarPagina("Selecione uma página para modificá-la", "Modificação");
        
        if (paginaSelecionada != null) {
        	PaginaDiario pagina = buscarPagina(paginaSelecionada);
        	
        	if (pagina != null) {
        		excluir(pagina);
        		cadastrar(pagina);
        		atualizarNumerosPaginas();
        	}
        }
    }
	
// ============================================== Métodos auxiliares ==============================================
	
	private void preencherCadastro(PaginaDiario pagina) {
		String nome = super.receberInput("Título dessa página (vazio para título padrão):");
		if (nome == null || nome.isEmpty()) {
			nome = "Sem Titulo";
		}
		pagina.setNome(numeroPaginaAtual + " - " + nome);
		numeroPaginaAtual++;
		

		String data = super.receberInput("Data dessa página (vazio para data atual):");
		if (data.toString() == null || data.isEmpty()) {
			data = LocalDate.now().toString();
		}
		pagina.setData(data);
		
		
		String descricao = super.receberInput("Escreva o quanto quiser:");
		if (descricao == null | descricao.isEmpty()) {
			descricao = "Nada por aqui... :|";
		}
		pagina.setDescricao(descricao);
		
		listaPaginasDiario.add(pagina);
	}
	
	private PaginaDiario buscarPagina(String paginaSelecionada) {
		for (PaginaDiario pagina: listaPaginasDiario) {
			if (pagina.getNome().equals(paginaSelecionada)) {
				return pagina;
			}
		}
		return null;
	}
	
	public String[] nomeiaLista() {
    	String[] nomesPaginas = new String[listaPaginasDiario.size()];
    	
        for (int i = 0; i < listaPaginasDiario.size(); i++) {
        	nomesPaginas[i] = listaPaginasDiario.get(i).getNome();
        }
        
		return nomesPaginas;
	}

	private String selecionarPagina(String mensagem, String nome) {
		return (String) JOptionPane.showInputDialog(null, mensagem, nome, JOptionPane.QUESTION_MESSAGE, null,
				nomeiaLista(), nomeiaLista()[0]);
	}
	
	private void atualizarNumerosPaginas() {
		for (int i = 0; i < listaPaginasDiario.size(); i++) {
			PaginaDiario pagina = listaPaginasDiario.get(i);
			if (!pagina.getNome().equals(numeroPaginaAtual + " - Sem título")) {
				pagina.setNome((i + 1) + " - " + pagina.getNome().substring(pagina.getNome().indexOf(" - ") + 3));
			} else {
				pagina.setNome((i + 1) + " - Sem título");
			}
		}
	}
	
	private void validaSenha() {
		
		// Se o diário conter senha
		if (diario.getSenha() != null) {
			
			// Enquanto o usuário não estiver logado (inserido a senha correta)
			while(!login) {
				
	            String inputSenha = JOptionPane.showInputDialog(null, "Digite a senha do diário:", "Login", JOptionPane.INFORMATION_MESSAGE);
	            
	            // Se a senha for null, então clicou em cancelar ou no X
				if (inputSenha == null) {
					super.mensagemSaida();
					
				// Se a senha for a mesma cadastrada, então permite o acesso
				} else if (inputSenha.equals(diario.getSenha())) {
					login = true;
					break;
				}
				
				// Se a senha estiver incorreta
				 Object[] funcoes = {"Tentar novamente", "Recuperar senha"};

				 opcao = JOptionPane.showInputDialog(null,
						"Senha incorreta. Escolha uma opção",
						"Login", 
						JOptionPane.ERROR_MESSAGE,
						null,
						funcoes,
						funcoes[0]);
				 
				 switch(opcao.toString()) {
				 case "Recuperar senha":
					 String fraseRecuperacao = super.receberInput("Informe a frase de recuperação de senha:");
					 
					 // Se a frase de recuperação estiver correta
					 if (fraseRecuperacao.equals(diario.getRecuperacao())) {
						 
						 String senha = JOptionPane.showInputDialog(null, "Senha do diário (vazio para não cadastrar uma senha):");
						
						 if (isStringVazia(senha)) {
							JOptionPane.showMessageDialog(null, "Você optou por não criar uma senha para seu diário.", "Senha", JOptionPane.INFORMATION_MESSAGE);
							login = true;
							break;
						}
						diario.setSenha(senha);
						
						if (senha != null) {
							
							do {
								 fraseRecuperacao = receberInput("Nova frase de recuperação do diário");
							} while (isStringVazia(fraseRecuperacao));
							
							diario.setRecuperacao(fraseRecuperacao);
						}
					 }
					 break;
				 }
			}
		}
	}
}
