package agenda;

import javax.swing.JOptionPane;

public abstract class Rotina {
	
	private String nome;
	private String descricao;
	private String data;
	Object opcao;


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public abstract void cadastrar();
	public abstract void modificar();
	public abstract void excluir();
	public abstract void mostrar();
	public abstract void menu();
	
	// -------------------------------------------- Métodos auxiliares -------------------------------------------------------
	
	// JOptionPane ativado quando o usuário clica em cancelar ou sair (no menu)
	public void mensagemSaida() {
		int sair = JOptionPane.showConfirmDialog(null,
                "Deseja realmente encerrar?",
                "Encerrando",
                JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "Encerrando o programa",
                    "Encerrando...",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
	}
	
	// JOptionPane ativado para mostrar algum aviso (quando não há registro de evento por exemplo)
	public void mensagemAviso(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
		return;
    }
	
	// JOptionPane para receber entradas de dados do usuário
	public String receberInput(String mensagem) {
		return JOptionPane.showInputDialog(null, mensagem);
	}
	
	// Verificador de string vazia
	public boolean isStringVazia(String texto) {
	    return texto == null || texto.isEmpty();
	}
	
	
}
