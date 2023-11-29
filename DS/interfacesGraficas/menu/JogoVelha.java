package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class JogoVelha extends JDialog {
	
	private JTextField txJogador1;
	private String idosoSelecionado1;
	private JComboBox<String> cbIdosos;
	private JLabel lbPlayer1;
	private String playerName1;
	private JLabel playerIcon1;
	
	private JTextField txJogador2;
	private String idosoSelecionado2;
	private JComboBox<String> cbIdosos2;
	private JLabel lbPlayer2;
	private String playerName2;
	private JLabel playerIcon2;
	
	private boolean isPlayer1Turn = true;
	private JLabel lbJogada;
	
	private JButton[] buttons;
	private String[] board;
	
	public JogoVelha(Menu menu) {
		super(menu, "Jogo da Velha", true);
		
		this.setSize(900, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		
		Font interBold = null;
		Font interRegular = null;
		
		try {
			interBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Bold.ttf"));
			interRegular = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Regular.ttf"));
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}
		
		interBold = interBold.deriveFont(Font.BOLD, 30);
		interRegular = interRegular.deriveFont(Font.PLAIN, 18);
		
		Container janela = this.getContentPane();
		setLocationRelativeTo(janela);
		janela.setLayout(null);
		
		JTabbedPane tabbedpane = new JTabbedPane();
		tabbedpane.setBounds(0, 0, getWidth(), getHeight());
		
		JPanel tabPlayer1 = new JPanel();
		tabPlayer1.setLayout(null);
		
		JPanel tabPlayer2 = new JPanel();
		tabPlayer2.setLayout(null);
		
		JPanel boardTab = new JPanel();
		boardTab.setLayout(null);
		
		JLabel lbNome = new JLabel();
		createLabel(lbNome, "Nome:", 0, 150, getWidth() / 2, 30, JLabel.CENTER, interBold.deriveFont(Font.PLAIN, 28));
		tabPlayer1.add(lbNome);
		
		txJogador1 = new JTextField();
		txJogador1.setBounds(getWidth() / 4 - 100, 200, getWidth() / 4, 40);
		txJogador1.setFont(interRegular.deriveFont(Font.PLAIN, 24));
		tabPlayer1.add(txJogador1);
		
		JLabel lbIdoso = new JLabel();
		createLabel(lbIdoso, "Escolha seu idoso:", getWidth() - getWidth() / 2, 150, getWidth() / 2, 30, JLabel.CENTER, interBold.deriveFont(Font.PLAIN, 28));
		tabPlayer1.add(lbIdoso);
		
		String[] idosos = {"Jurema", "Juvenal", "Manoel", "Marcelia", "Marcio", "Maristela", "Maurilio", "Sueli"};
		cbIdosos = new JComboBox<String>(idosos);
		cbIdosos.setBounds(getWidth() - getWidth() / 4 - 100, 200, getWidth() / 4, 40);
		cbIdosos.setFont(interRegular);
		cbIdosos.setBackground(Color.WHITE);
        tabPlayer1.add(cbIdosos);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(getWidth() / 2 - 100, 300, 200, 35);
		tabPlayer1.add(btCadastrar);
		
		btCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        idosoSelecionado1 = (String) cbIdosos.getSelectedItem();
		        playerName1 = txJogador1.getText();

		        if (txJogador1.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Digite um nome válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        
		        if (idosoSelecionado1 == idosoSelecionado2) {
		        	JOptionPane.showMessageDialog(null, "O idoso(a) '" + idosoSelecionado1 + "' já foi selecionado pelo jogador 2. Que pena...", "Aviso", JOptionPane.WARNING_MESSAGE);
		        	return;
		        }
		        
		        lbPlayer1.setText(playerName1);
		        lbJogada.setText("Vez de " + playerName1);
		        
		        setResizedImage("src/menu/images/idosos/" + idosoSelecionado1 + ".png", playerIcon1);
		        JOptionPane.showMessageDialog(null, "Nome " + playerName1 + " cadastrado e idoso(a) ' " + idosoSelecionado1 + "' selecionado com sucesso!");
		        
		        tabbedpane.addTab("Jogador 2", null, tabPlayer2, "Painel do Jogador 1");
			}
		});
		
		JLabel lbNome2 = new JLabel("Nome:");
		createLabel(lbNome2, "Nome:", 0, 150, getWidth() / 2, 30, JLabel.CENTER, interBold.deriveFont(Font.PLAIN, 28));
		tabPlayer2.add(lbNome2);
		
		txJogador2 = new JTextField();
		txJogador2.setBounds(getWidth() / 4 - 100, 200, getWidth() / 4, 40);
		txJogador2.setFont(interRegular.deriveFont(Font.PLAIN, 24));
		tabPlayer2.add(txJogador2);
		
		JLabel lbIdoso2 = new JLabel("Escolha seu idoso:");
		createLabel(lbIdoso2, "Escolha seu idoso:", getWidth() - getWidth() / 2, 150, getWidth() / 2, 30, JLabel.CENTER, interBold.deriveFont(Font.PLAIN, 28));
		tabPlayer2.add(lbIdoso2);
		
		cbIdosos2 = new JComboBox<String>(idosos);
		cbIdosos2.setBounds(getWidth() - getWidth() / 4 - 100, 200, getWidth() / 4, 40);
		cbIdosos2.setFont(interRegular);
		cbIdosos2.setBackground(Color.WHITE);
		tabPlayer2.add(cbIdosos2);
		
		JButton btCadastrar2 = new JButton("Cadastrar");
		btCadastrar2.setBounds(getWidth() / 2 - 100, 300, 200, 35);
		tabPlayer2.add(btCadastrar2);
		
		btCadastrar2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        idosoSelecionado2 = (String) cbIdosos2.getSelectedItem();
		        playerName2 = txJogador2.getText();

		        if (txJogador2.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Digite um nome válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        
		        if (idosoSelecionado2 == idosoSelecionado1) {
		        	JOptionPane.showMessageDialog(null, "O idoso(a) '" + idosoSelecionado2 + "' já foi selecionado pelo jogador 1. Que pena...", "Aviso", JOptionPane.WARNING_MESSAGE);
		        	return;
		        }
		        
		        lbPlayer2.setText(playerName2);
		        setResizedImage("src/menu/images/idosos/" + idosoSelecionado2 + ".png", playerIcon2);
		        JOptionPane.showMessageDialog(null, "Nome " + playerName2 + " cadastrado e idoso(a) ' " + idosoSelecionado2 + "' selecionado com sucesso!");
		        
				tabbedpane.addTab("Tabuleiro", null, boardTab, "Jogo da Velha");
			}
		});
		
		/* board tab */

		lbPlayer1 = new JLabel();
		createLabel(lbPlayer1, playerName1, 120, 15, 200, 50, JLabel.LEFT, interBold);
		boardTab.add(lbPlayer1);

		
		JLabel lbForma1 = new JLabel();
		createLabel(lbForma1, "Ícone: X", 120, 45, 100, 50, JLabel.LEFT, interRegular.deriveFont(Font.PLAIN, 22));
		boardTab.add(lbForma1);
		
		playerIcon1 = new JLabel();
		playerIcon1.setBounds(0, 0, 100, 100);
		boardTab.add(playerIcon1);
		
		lbPlayer2 = new JLabel();
		createLabel(lbPlayer2, playerName2, getWidth() - 340, 15, 200, 50, JLabel.RIGHT, interBold);
		boardTab.add(lbPlayer2);
	
		JLabel lbForma2 = new JLabel();
		createLabel(lbForma2, "Ícone: O", getWidth() - 240, 45, 100, 50, JLabel.RIGHT, interRegular.deriveFont(Font.PLAIN, 22));
		boardTab.add(lbForma2);
		
		playerIcon2 = new JLabel();
		playerIcon2.setBounds(getWidth() - 120, 0, 100, 100);
		boardTab.add(playerIcon2);
		
		lbJogada = new JLabel();
		createLabel(lbJogada, "Vez de \n" + playerName1, 0, 100, getWidth(), 50, JLabel.CENTER, interRegular.deriveFont(Font.PLAIN, 30));
		boardTab.add(lbJogada);
		
		buttons = new JButton[9];
		board = new String[9];
		
		JPanel grid = new JPanel();
		GridLayout layout = new GridLayout(3, 3);
		layout.setHgap(10);
		layout.setVgap(10);
		grid.setLayout(layout);
		grid.setBounds(getWidth() / 2 - 175, getHeight() - 420, 350, 350);
		
        for (int i = 0; i < 9; i++) {
        	final int index = i;
            JButton button = new JButton();
            button.setFont(interBold);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (button.getText().isEmpty()) {
                    	if (isPlayer1Turn) {
                            button.setText("X");
                            board[index] = "X";
                        } else {
                            button.setText("O");
                            board[index] = "O";
                        }
                    	isPlayer1Turn = !isPlayer1Turn;
                    	atualizaJogada();
                        verificaVitoria();
                    }
                }
            });
            buttons[i] = button;
            grid.add(button);
        }

		boardTab.add(grid);
		
		JButton resetar = new JButton("Resetar");
		resetar.setBounds(25, 400, 200, 50);
		
		resetar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciaTabuleiro();
			}
		});
		
		boardTab.add(resetar);
		
		tabbedpane.addTab("Jogador 1", null, tabPlayer1, "Painel do Jogador 1");
		
		janela.add(tabbedpane);
		this.setVisible(true);
	}
	
	private void atualizaJogada() {
		if (isPlayer1Turn) {
			lbJogada.setText("Vez de \n" + playerName1);
		} else {
			lbJogada.setText("Vez de \n" + playerName2);
		}
	}
	
	private void verificaVitoria() {
		String ganhador = null;
		
		// Horizontais
		if (board[0] != null && board[0].equals(board[1]) &&  board[0].equals(board[2])) {
			ganhador = board[0];
		} else if (board[3] != null && board[3].equals(board[4]) && board[3].equals(board[5])) {
			ganhador = board[3];
		} else if (board[6] != null && board[6].equals(board[7]) && board[6].equals(board[8])) {
			ganhador = board[6];
        }
		
		// Verticais
		else if (board[0] != null && board[0].equals(board[3]) && board[0].equals(board[6])) {
			ganhador = board[0];
        } else if (board[1] != null && board[1].equals(board[4]) && board[1].equals(board[7])) {
        	ganhador = board[1];
        } else if (board[2] != null && board[2].equals(board[5]) && board[2].equals(board[8])) {
        	ganhador = board[2];
        }
		
		// Diagonais
        else if (board[0] != null && board[0].equals(board[4]) && board[0].equals(board[8])) {
        	ganhador = board[0];
        } else if (board[2] != null && board[2].equals(board[4]) && board[2].equals(board[6])) {
        	ganhador = board[2];
        }
		
		if (ganhador != null) {
			if (ganhador == "X") {
				lbJogada.setText("O jogador " + playerName1 + " venceu!");
			} else {
				lbJogada.setText("O jogador " + playerName2 + " venceu!");
			}
            for (JButton button : buttons) {
            	button.setEnabled(false);
            }
        } else if (tabuleiroPreenchido()) {
            JOptionPane.showMessageDialog(null, "Não houveram ganhadores, empate!");
            for (JButton button : buttons) {
            	button.setEnabled(false);
            }
        }
	}
	
	private boolean tabuleiroPreenchido() {
		for (String button : board) {
			if (button == null) {
				return false;
			}
		}
		return true;
	}
	
	private void reiniciaTabuleiro() {
		for (int i = 0; i < 9; i++) {
			buttons[i].setText("");
			buttons[i].setEnabled(true);
			board[i] = null;
		}
		isPlayer1Turn = true;
		lbJogada.setText("Vez de \n" + playerName1);
	}
	
	private void setResizedImage(String imagePath, JLabel selectedLabel) {
		ImageIcon icon = new ImageIcon(imagePath);
	    Image image = icon.getImage();
	    Image resizedImage = image.getScaledInstance(selectedLabel.getWidth(), selectedLabel.getHeight(), Image.SCALE_SMOOTH);
	    selectedLabel.setIcon(new ImageIcon(resizedImage));
	}
	
	private void createLabel(JLabel label, String text, int x, int y, int width, int height, int horizontalAlignment, Font font) {
		label.setText(text);
		label.setBounds(x, y, width, height);
		label.setFont(font);
		label.setHorizontalAlignment(horizontalAlignment);
	}
}
