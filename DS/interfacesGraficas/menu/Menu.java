package menu;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {
	
	JLabel bgImage;
	
	public Menu() {
		this.setSize(1200, 800);
		this.setTitle("Menu de aplicativos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);
		
		Font interBold = null;
		
		try {
			interBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Bold.ttf"));
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}
		
		interBold = interBold.deriveFont(Font.BOLD, 30);
		
		JMenu aplicativos = new JMenu("Aplicativos");
		JMenu recursos = new JMenu("Recursos");
		JMenu ajuda = new JMenu("Ajuda");
		
		JMenuItem sair = new JMenuItem("Sair");
		JMenuItem orcamento = new JMenuItem("Loja de Carros");
		JMenuItem calculadora = new JMenuItem("Calculadora");
		JMenuItem jogoVelha = new JMenuItem("Jogo da Velha");
		JMenuItem sobre = new JMenuItem("Sobre");
		
		recursos.add(sair);
		aplicativos.add(orcamento);
		aplicativos.add(calculadora);
		aplicativos.add(jogoVelha);
		ajuda.add(sobre);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(aplicativos);
		bar.add(recursos);
		bar.add(ajuda);
		
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		orcamento.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        new Orcamento(Menu.this);
		    }
		});
		
		calculadora.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        new Calculadora(Menu.this);
		    }
		});
		
		sobre.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        new Sobre(Menu.this);
		    }
		});
		
		jogoVelha.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		    	new JogoVelha(Menu.this);
		    }
		});
		
		int index = (int) (Math.random() * 2);
		
		JLabel lbTexto = new JLabel("Menu de aplicativos");
		lbTexto.setBounds(15, getHeight() - 135, getWidth(), 60);
		lbTexto.setForeground(index == 0 ? Color.BLACK : Color.WHITE);
		lbTexto.setFont(interBold.deriveFont(Font.PLAIN, 60));
		add(lbTexto);
		
		JLabel lbBackground = new JLabel();
		lbBackground.setBounds(0, 0, getWidth(), getHeight());
		setResizedImage("src/menu/images/" + (index == 0 ? "darkNebula-white" : "darkNebula-dark") + ".png", lbBackground);
		add(lbBackground);
		
		this.setVisible(true);
	}
	
	public void setResizedImage(String imagePath, JLabel selectedLabel) {
		ImageIcon icon = new ImageIcon(imagePath);
	    Image image = icon.getImage();
	    Image resizedImage = image.getScaledInstance(selectedLabel.getWidth(), selectedLabel.getHeight(), Image.SCALE_SMOOTH);
	    selectedLabel.setIcon(new ImageIcon(resizedImage));
	}
}


