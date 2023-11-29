package menu;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.File;

public class Calculadora extends JDialog {
	
	Font interBold = null;
	Font interRegular = null;
	
	public Calculadora(Menu menu) {

		super(menu, "Calculadora", true);
		setResizable(false);
		this.setSize(800, 300);
		
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		

		
		try {
			interBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Bold.ttf"));
			interRegular = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Regular.ttf"));
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}

		interBold = interBold.deriveFont(Font.BOLD, 18);
		interRegular = interRegular.deriveFont(Font.PLAIN, 16);
		
		JLabel lbNumero1 = new JLabel("Número 1");
		lbNumero1.setBounds(0, 20, 165, 30);
		lbNumero1.setFont(interBold);
		lbNumero1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbNumero1);
		
		JLabel lbNumero2 = new JLabel("Número 2");
		lbNumero2.setBounds(170, 20, 165, 30);
		lbNumero2.setFont(interBold);
		lbNumero2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbNumero2);
		
		JTextField txNumero1 = new JTextField();
		txNumero1.setBounds(0, 50, 165, 40);
		txNumero1.setFont(interRegular);
		add(txNumero1);
		
		JTextField txNumero2 = new JTextField();
		txNumero2.setBounds(170, 50, 165, 40);
		txNumero2.setFont(interRegular);
		add(txNumero2);
		
		JLabel lbResultado = new JLabel("Aguardando...");
		lbResultado.setBounds(500, 83, 150, 50);
		lbResultado.setFont(interRegular);
		lbResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbResultado);
		
		JButton btSoma = new JButton();
		btSoma.setBounds(0, 155, 165, 50);
		btSoma.setText("Soma");
		btSoma.setBackground(Color.BLACK);
		btSoma.setForeground(Color.WHITE);
		add(btSoma);
		
		btSoma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetLabel(lbResultado);
				double numero1 = Double.parseDouble(txNumero1.getText());
				double numero2 = Double.parseDouble(txNumero2.getText());
				double resultado = numero1 + numero2;
				lbResultado.setText(numero1 + " + " + numero2 + " = " + resultado);
			}
		});
		
		JButton btSubtracao = new JButton();
		btSubtracao.setBounds(170, 155, 165, 50);
		btSubtracao.setText("Subtração");
		btSubtracao.setBackground(Color.BLACK);
		btSubtracao.setForeground(Color.WHITE);
		add(btSubtracao);
		
		btSubtracao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetLabel(lbResultado);
				double numero1 = Double.parseDouble(txNumero1.getText());
				double numero2 = Double.parseDouble(txNumero2.getText());
				double resultado = numero1 - numero2;
				lbResultado.setText(numero1 + " - " + numero2 + " = " + resultado);
			}
		});
		
		JButton btMultiplicacao = new JButton();
		btMultiplicacao.setBounds(0, 210, 165, 50);
		btMultiplicacao.setText("Multiplicação");
		btMultiplicacao.setBackground(Color.BLACK);
		btMultiplicacao.setForeground(Color.WHITE);
		add(btMultiplicacao);
		
		btMultiplicacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetLabel(lbResultado);
				double numero1 = Double.parseDouble(txNumero1.getText());
				double numero2 = Double.parseDouble(txNumero2.getText());
				double resultado = numero1 * numero2;
				lbResultado.setText(numero1 + " x " + numero2 + " = " + resultado);
			}
		});
		
		JButton btDivisao = new JButton();
		btDivisao.setBounds(170, 210, 165, 50);
		btDivisao.setText("Divisão");
		btDivisao.setBackground(Color.BLACK);
		btDivisao.setForeground(Color.WHITE);
		add(btDivisao);
		
		btDivisao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double numero1 = Double.parseDouble(txNumero1.getText());
				double numero2 = Double.parseDouble(txNumero2.getText());
				if (numero2 == 0) {
					lbResultado.setText("Impossível por 0");
					lbResultado.setForeground(Color.RED);
				} else {
					resetLabel(lbResultado);
					double resultado = numero1 / numero2;
					lbResultado.setText(numero1 + " / " + numero2 + " = " + resultado);
				}
			}
		});
		
		JLabel calcImg = new JLabel();
		calcImg.setBounds(350, 0, 450, 450);
		add(calcImg);
		menu.setResizedImage("src/menu/images/calculator.png", calcImg);
		
		this.setVisible(true);
	}
	
	private void resetLabel(JLabel label) {
		label.setFont(interRegular);
		label.setForeground(Color.BLACK);
	}
	
}
