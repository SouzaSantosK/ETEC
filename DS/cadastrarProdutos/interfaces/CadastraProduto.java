package interfaces;

import javax.swing.*;

import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;

public class CadastraProduto extends JDialog {
    
	int idCategoria;
	JButton btInserir;
	JButton btAlterar;
	JButton btExcluir;
	
	public CadastraProduto(Menu menu) {
		setResizable(false);
		this.setSize(600, 500);
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
		interSemiBold = interSemiBold.deriveFont(Font.PLAIN, 18);
		interRegular = interRegular.deriveFont(Font.PLAIN, 16);
		
		JLabel lbTitulo = new JLabel("Cadastro de produtos");
		lbTitulo.setBounds(0, 0, getWidth(), 50);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setOpaque(true);
		lbTitulo.setBackground(Color.decode("#5B9BD5"));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(interBold);
		add(lbTitulo);
		
		JLabel lbProduto = new JLabel("Produto:");
		lbProduto.setBounds(60, 70, 230, 35);
		lbProduto.setFont(interSemiBold);
		lbProduto.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbProduto);
		
		JTextField txProduto = new JTextField();
		txProduto.setBounds(60, 115, 230, 35);
		txProduto.setFont(interRegular);
		add(txProduto);
		
		JLabel lbValor = new JLabel("Valor:");
		lbValor.setBounds(300, 70, 230, 35);
		lbValor.setFont(interSemiBold);
		lbValor.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbValor);
		
		JTextField txValor = new JTextField();
		txValor.setBounds(300, 115, 230, 35);
		txValor.setFont(interRegular);
		add(txValor);
		
		JLabel lbCategoria = new JLabel("Categoria:");
		lbCategoria.setBounds(60, 160, 230, 35);
		lbCategoria.setFont(interSemiBold);
		lbCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbCategoria);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(60, 195, 230, 35);
		cbCategoria.setFont(interRegular);
		cbCategoria.setOpaque(true);
		cbCategoria.setBackground(Color.WHITE);
		add(cbCategoria);
		
		cbCategoria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String selecionado = (String) cbCategoria.getSelectedItem();
				idCategoria = Integer.parseInt(selecionado.split(" - ")[0]);
			}
			
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				Conexao conexao = new Conexao();
				Statement state;
				
				String script = "SELECT idCategoria, categoria FROM tbCategoria";
				
				conexao.conectar();
				
				try {
					state = (Statement) Conexao.con.createStatement();
					ResultSet result = state.executeQuery(script);
					
					while (result.next()) {
						int idCategoria = result.getInt("idCategoria");
						String categoria = result.getString("categoria");
						cbCategoria.addItem(idCategoria + " - " + categoria);
					}
					
					result.close();
					state.close();

				} catch(SQLException error) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar a lista.");
				}
				
				conexao.desconectar();
			}
		});
		
		JLabel lbQuantidade = new JLabel("Quantidade:");
		lbQuantidade.setBounds(300, 160, 230, 35);
		lbQuantidade.setFont(interSemiBold);
		lbQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbQuantidade);
		
		JTextField txQuantidade = new JTextField();
		txQuantidade.setBounds(300, 195, 230, 35);
		txQuantidade.setFont(interRegular);
		add(txQuantidade);

		JLabel lbDescricao = new JLabel("Descrição:");
		lbDescricao.setBounds(60, 240, 470, 35);
		lbDescricao.setFont(interSemiBold);
		lbDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbDescricao);
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setFont(interRegular);
		taDescricao.setLineWrap(true);
		
		JScrollPane scrollpane = new JScrollPane(taDescricao);
		scrollpane.setBounds(60, 275, 470, 100);
		add(scrollpane);
		
		btInserir = new JButton("Inserir");
		btInserir.setUI(new CustomButtonUI());
		btInserir.setBounds(60, 385, 470, 35);
		btInserir.setForeground(Color.WHITE);
		btInserir.setBackground(Color.decode("#5B9BD5"));
		btInserir.setBorderPainted(false);
		btInserir.setFont(interRegular);
		btInserir.setFocusPainted(false);
		add(btInserir);
		
		btInserir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Statement state;
				
				Conexao conexao = new Conexao();
				
				String nomeProduto = txProduto.getText();
				String valorProduto =  txValor.getText();
				String qtdProduto = txQuantidade.getText();
				String descricaoProduto = taDescricao.getText();
				
				conexao.conectar();
				
				if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um nome de produto válido.");
					return;
				}
				
				if (valorProduto == null || valorProduto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um valor de produto válido.");
					return;
				}
				
				if (qtdProduto == null || qtdProduto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma quantidade de produto válida.");
					return;
				}
				
				if (descricaoProduto == null || descricaoProduto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma descrição do produto.");
					return;
				}
				
				String script = "INSERT INTO tbProduto VALUES(null, '" + nomeProduto + "', '" + valorProduto + "', '" + descricaoProduto + "', '" + qtdProduto + "', " + idCategoria + ")";
				
				try {
					state = (Statement) Conexao.con.createStatement();
					state.executeUpdate(script);
						
				} catch(SQLException error) {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a inserção.");
				}
				
	            JOptionPane.showMessageDialog(null, "Produto '" + nomeProduto + "' inserido com sucesso.");
				
				conexao.desconectar();
			}
		});
		
		this.setVisible(true);
	}
}
