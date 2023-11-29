package menu;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


import menu.Menu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.beans.Customizer;
import java.io.IOException;
import java.io.File;

public class Sobre extends JDialog {
	
	JLabel bannerImg;
	JLabel profileImg;
	
	JLabel reactNativeImg;
	JLabel cssImg;
	JLabel htmlImg;
	JLabel javaImg;
	JLabel javaScriptImg;
	
	public Sobre(Menu menu) {
		super(menu, "Sobre", true);
		setResizable(false);

		this.setTitle("Sobre");
		this.setSize(800, 600);
		
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#1B1F23"));
		
		Font interBold = null;
		Font interRegular = null;
		try {
			interBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Bold.ttf"));
			interRegular = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Regular.ttf"));
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}

		interBold = interBold.deriveFont(Font.BOLD, 30);
		interRegular = interRegular.deriveFont(Font.PLAIN, 16);
		
		profileImg = new JLabel();
		profileImg.setBounds(30, 130, 150, 150);
		add(profileImg);
		
		menu.setResizedImage("src/menu/images/profile-icon1.png", profileImg);
		
		bannerImg = new JLabel();
		bannerImg.setBounds(0, 0, this.getWidth(), 250);
		bannerImg.setHorizontalAlignment(JLabel.CENTER);
		bannerImg.setVerticalAlignment(JLabel.CENTER);
		add(bannerImg);
        
		bannerImg.setIcon(new ImageIcon("src/menu/images/space-wallpaper3.png"));
		
		JLabel lbNome = new JLabel("Kauã de Souza, 17");
		lbNome.setFont(interBold);
		lbNome.setBounds(30, 290, this.getWidth(), 50);
		lbNome.setForeground(Color.WHITE);
		add(lbNome);
		
		JLabel lbEscola = new JLabel("<html>Cursando Desenvolvimento de Sistemas em <br>ETEC de Guaianazes</html>");
		lbEscola.setFont(interRegular);
		lbEscola.setBounds(30, 335, this.getWidth(), 50);
		lbEscola.setForeground(Color.WHITE);
		add(lbEscola);
		
		DateTimeFormatter brDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter brTimeFormat = DateTimeFormatter.ofPattern("HH:mm");
		
		JLabel lbCidade = new JLabel("<html>São Paulo, São Paulo, Brasil <br>" + LocalDate.now().format(brDateFormat) + " - " + LocalTime.now().format(brTimeFormat) + "</html>");
		lbCidade.setFont(interRegular);
		lbCidade.setBounds(30, 380, this.getWidth(), 65);
		lbCidade.setForeground(Color.decode("#BDBDBD"));
		add(lbCidade);
		
		JLabel lbLinguagens = new JLabel("Linguagens");
		lbLinguagens.setFont(interBold.deriveFont(Font.BOLD, 25));
		lbLinguagens.setBounds(30, 440, 200, 50);
		lbLinguagens.setForeground(Color.WHITE);
		add(lbLinguagens);
		
		javaImg = new JLabel();
		javaImg.setBounds(30, 490, 50, 50);
		add(javaImg);
		menu.setResizedImage("src/menu/images/java.png", javaImg);
		
		javaScriptImg = new JLabel();
		javaScriptImg.setBounds(90, 490, 50, 50);
		add(javaScriptImg);
		menu.setResizedImage("src/menu/images/javaScript.png", javaScriptImg);
		
		htmlImg = new JLabel();
		htmlImg.setBounds(150, 490, 50, 50);
		add(htmlImg);
		menu.setResizedImage("src/menu/images/html.png", htmlImg);
		
		cssImg = new JLabel();
		cssImg.setBounds(210, 490, 50, 50);
		add(cssImg);
		menu.setResizedImage("src/menu/images/css.png", cssImg);
		
		reactNativeImg = new JLabel();
		reactNativeImg.setBounds(270, 490, 50, 50);
		add(reactNativeImg);
		menu.setResizedImage("src/menu/images/reactNative.png", reactNativeImg);
		
		String[] bgImages = {"space-wallpaper3", "space-wallpaper4", "space-wallpaper5", "darkNebula"};
		int index = (int) (Math.random() * bgImages.length);
		bannerImg.setIcon(new ImageIcon("src/menu/images/" + bgImages[index] + ".png"));
		
		this.setVisible(true);
	}
	
	
}
