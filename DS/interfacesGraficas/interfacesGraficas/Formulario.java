package interfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	JLabel lbNumero1;
	JLabel lbNumero2;
	JTextField txNumero1;
	JTextField txNumero2;
	JButton btSoma;
	JButton btSubtracao;
	JButton btMultiplicacao;
	JButton btDivisao;
	
	private JPanel contentPane;
	
	public Formulario() {
	    try {
	        final Image backgroundImage = javax.imageio.ImageIO.read(new File("F:\\ETEC\\2° Ano - DS\\DS\\concessionaria\\images\\class-s.png"));
	        setContentPane(new JPanel(new BorderLayout()) {
	            @Override public void paintComponent(Graphics g) {
	                g.drawImage(backgroundImage, 250, -300, null);
	            }
	        });
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
		
		
		this.setTitle("Calculadora Básica");
		this.setSize(800, 600);
		this.setLocation(100, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		
		lbNumero1 = new JLabel();
						// x, y, width, height
		lbNumero1.setBounds(20, 30, 100, 25);
		lbNumero1.setText("Número 1");
		add(lbNumero1);
		
		lbNumero2 = new JLabel();
		lbNumero2.setBounds(20, 60, 100, 25);
		lbNumero2.setText("Número 2");
		add(lbNumero2);
		
		txNumero1 = new JTextField();
		txNumero1.setBounds(80, 30, 100, 25);
		add(txNumero1);
		
		txNumero2 = new JTextField();
		txNumero2.setBounds(80, 60, 100, 25);
		add(txNumero2);
		
		btSoma = new JButton();
		btSoma.setBounds(20, 100, 100, 25);
		btSoma.setText("Soma");
		btSoma.setBackground(Color.BLACK);
		btSoma.setForeground(Color.WHITE);
		add(btSoma);

		btSoma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double numero1 = Double.parseDouble(txNumero1.getText());
				double numero2 = Double.parseDouble(txNumero2.getText());
				double resultado = numero1 + numero2;
				JOptionPane.showMessageDialog(null, "O resultado de "+ numero1 + " + " + numero2 + " é " + resultado);
			}
		});

		btSubtracao = new JButton();
		btSubtracao.setBounds(130, 100, 100, 25);
		btSubtracao.setText("Subtração");
		btSubtracao.setBackground(Color.BLACK);
		btSubtracao.setForeground(Color.WHITE);
		add(btSubtracao);
		
		btSubtracao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double numero1 = Double.parseDouble(txNumero1.getText());
				double numero2 = Double.parseDouble(txNumero2.getText());
				double resultado = numero1 - numero2;
				JOptionPane.showMessageDialog(null, "O resultado de "+ numero1 + " - " + numero2 + " é " + resultado);
			}
		});

		btMultiplicacao = new JButton();
		btMultiplicacao.setBounds(20, 135, 100, 25);
		btMultiplicacao.setText("Multiplicação");
		btMultiplicacao.setBackground(Color.BLACK);
		btMultiplicacao.setForeground(Color.WHITE);
		add(btMultiplicacao);
		
		btMultiplicacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double numero1 = Double.parseDouble(txNumero1.getText());
				double numero2 = Double.parseDouble(txNumero2.getText());
				double resultado = numero1 * numero2;
				JOptionPane.showMessageDialog(null, "O resultado de "+ numero1 + " x " + numero2 + " é " + resultado);
			}
		});

		btDivisao = new JButton();
		btDivisao.setBounds(130, 135, 100, 25);
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
					JOptionPane.showMessageDialog(null, "Não dividirás por 0!");
				} else {
					double resultado = numero1 / numero2;
					JOptionPane.showMessageDialog(null, "O resultado de "+ numero1 + " / " + numero2 + " é " + resultado);
				}
			}
		});
		
		// sempre por último
		this.setLayout(null);
		this.setVisible(true);
	}
}
