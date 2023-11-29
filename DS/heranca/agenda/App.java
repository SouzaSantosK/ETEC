package agenda;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		Object[] rotinas = {"Eventos", "Listas", "Diário", "Anotações"};
		Object opcao;
		
		do {
			opcao = JOptionPane.showInputDialog(null,
					"Escolha uma rotina para ver suas opções",
					"Agenda", 
					JOptionPane.QUESTION_MESSAGE,
					null,
					rotinas,
					rotinas[0]);
			
			if (opcao == null) {
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
			
		} while (opcao == null);
		
		switch(opcao.toString()) {
			case "Eventos":
				Evento evento = new Evento();
				evento.menu();
				break;
			case "Listas":
				Lista lista = new Lista();
				lista.menu();
				break;
			case "Diário":
				Diario diario = new Diario();
				diario.menu();
				break;
			case "Anotações":
				Anotacao anotacao = new Anotacao();
				anotacao.menu();
				break;
		}
	}
}
