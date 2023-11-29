package formularioBasico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {
	
	JLabel lbNome;
	JTextField txNome;
	JButton btExibir;
	JComboBox cbCurso;
	JRadioButton rdTurma1;
	JRadioButton rdTurma2;
	JRadioButton rdTurma3;
	ButtonGroup bgTurma;
	JCheckBox ckCoresPreferida1;
	JCheckBox ckCoresPreferida2;
	JCheckBox ckCoresPreferida3;
	
	public Janela() {
		this.setTitle("Janela");
		this.setSize(800, 600);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		lbNome = new JLabel();
		lbNome.setBounds(20, 20, 100, 20);
		lbNome.setText("Digite seu nome:");
		add(lbNome);
		
		txNome = new JTextField();
		txNome.setBounds(20, 40, 100, 20);
		
		btExibir = new JButton();
		btExibir.setBounds(20, 180, 100, 40);
		btExibir.setText("Exibir");
		btExibir.setBackground(Color.BLACK);
		btExibir.setForeground(Color.YELLOW);
		add(btExibir);
		
		btExibir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome, curso, turma="", cor="";
				nome = txNome.getText();
				curso = cbCurso.getSelectedItem().toString();
				
				if (rdTurma1.isSelected()) {
					turma = rdTurma1.getText();
				} else if (rdTurma2.isSelected()) {
					turma = rdTurma2.getText();
				} else {
					turma = rdTurma3.getText();
				}
				
				if (ckCoresPreferida1.isSelected()) {
					cor = cor + " " + ckCoresPreferida1.getText();
				}
				
				if (ckCoresPreferida2.isSelected()) {
					cor = cor + " " + ckCoresPreferida2.getText();
				}
				
				if (ckCoresPreferida3.isSelected()) {
					cor = cor + " " + ckCoresPreferida3.getText();
				}
				
				JOptionPane.showMessageDialog(null, "Nome do aluno: " + nome + 
						"\nCurso: " + curso + "\nTurma: " + turma + "\nCor Preferida: " + cor);
			}
		});
		
		cbCurso = new JComboBox();
		cbCurso.setBounds(20, 70, 150, 20);
		cbCurso.addItem("MTEC DS");
		cbCurso.addItem("MTEC Nutrição");
		add(cbCurso);
		
		rdTurma1 = new JRadioButton();
		rdTurma1.setBounds(20, 100, 100, 20);
		rdTurma1.setText("1° série");
		add(rdTurma1);
		
		rdTurma2 = new JRadioButton();
		rdTurma2.setBounds(125, 100, 100, 20);
		rdTurma2.setText("2° série");
		add(rdTurma2);
		
		rdTurma3 = new JRadioButton();
		rdTurma3.setBounds(225, 100, 100, 20);
		rdTurma3.setText("3° série");
		add(rdTurma3);
		
		bgTurma = new ButtonGroup();
		bgTurma.add(rdTurma1);
		bgTurma.add(rdTurma2);
		bgTurma.add(rdTurma3);
		
		ckCoresPreferida1 = new JCheckBox();
		ckCoresPreferida1.setBounds(20, 130, 100, 20);
		ckCoresPreferida1.setText("Azul");
		add(ckCoresPreferida1);
		
		ckCoresPreferida2 = new JCheckBox();
		ckCoresPreferida2.setBounds(125, 130, 100, 20);
		ckCoresPreferida2.setText("Amarelo");
		add(ckCoresPreferida2);
		
		ckCoresPreferida3 = new JCheckBox();
		ckCoresPreferida3.setBounds(125, 130, 100, 20);
		ckCoresPreferida3.setText("Verde");
		add(ckCoresPreferida3);
		
		this.setVisible(true);
	}
	
	public void limpar() {
		txNome.setText("");
	}
}
