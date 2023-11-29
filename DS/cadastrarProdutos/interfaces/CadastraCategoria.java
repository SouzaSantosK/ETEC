package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class CadastraCategoria extends JDialog {
    
	JButton btInserir;
	JButton btAlterar;
	JButton btExcluir;
	JTextField txCategoria;

	public CadastraCategoria(Menu menu) {
		setResizable(false);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		setModal(true);
		
		Font interBold = null;
		Font interRegular = null;
		Font interSemiBold = null;
		
		try {
			interBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Bold.ttf"));
			interSemiBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-SemiBold.ttf"));
			interRegular = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Regular.ttf"));
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}

		interBold = interBold.deriveFont(Font.PLAIN, 20);
		interSemiBold = interSemiBold.deriveFont(Font.PLAIN, 16);
		interRegular = interRegular.deriveFont(Font.PLAIN, 16);
		
		JLabel lbTitulo = new JLabel("Cadastro de categorias");
		lbTitulo.setBounds(0, 0, getWidth(), 50);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setOpaque(true);
		lbTitulo.setBackground(Color.decode("#5B9BD5"));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(interBold);
		add(lbTitulo);
		
		JLabel lbCategoria = new JLabel("Inserir categoria:");
		lbCategoria.setBounds(60, 125, 160, 35);
		lbCategoria.setFont(interSemiBold);
		lbCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbCategoria);
		
		JTextField txCategoria = new JTextField();
		txCategoria.setBounds(230, 125, 200, 35);
		txCategoria.setFont(interRegular);
		add(txCategoria);
		
		JButton btInserir = new JButton();
		btInserir.setBounds(440, 125, 35, 35);
		btInserir.setBackground(Color.WHITE);
		btInserir.setBorderPainted(false);
		btInserir.setFont(interRegular.deriveFont(Font.PLAIN, 20));
		btInserir.setFocusPainted(false);
		add(btInserir);
		
		menu.setResizedImage("src/images/inserir.png", btInserir);

		btInserir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Statement state;
				
				Conexao conexao = new Conexao();
				
				String nomeCategoria = txCategoria.getText();
				
				if (nomeCategoria == null || nomeCategoria.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma categoria válida.");
					return;
				}
				
				String scriptCheck = "SELECT * FROM tbCategoria WHERE categoria = '" + nomeCategoria + "'";
				
				conexao.conectar();
				
				try {
					state = (Statement) Conexao.con.createStatement();
					ResultSet rs = state.executeQuery(scriptCheck);
					
					if (rs.next()) {
			            JOptionPane.showMessageDialog(null, "Essa categoria já existe.");
					} else {
						String script = "INSERT INTO tbCategoria VALUES(null, '" + nomeCategoria + "')";
						state.executeUpdate(script);
			            JOptionPane.showMessageDialog(null, "Categoria '" + nomeCategoria + "' inserida com sucesso.");
					}
				} catch(SQLException error) {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a inserção.");
				}
				
				conexao.desconectar();
			}
		});
		
		this.setVisible(true);
	}
}
