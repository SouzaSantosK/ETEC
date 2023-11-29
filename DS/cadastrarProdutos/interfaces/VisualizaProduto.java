package interfaces;

import javax.swing.*;

import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;

public class VisualizaProduto extends JDialog {
    
	int idCategoria;
	JButton btInserir;
	JButton btAlterar;
	JButton btExcluir;
	JTextField txProduto;
	JTextField txValor;
	JComboBox cbCategoria;
	JTextField txQuantidade;
	JTextArea taDescricao;
	int idProduto;
	
	public VisualizaProduto(Menu menu) {
		setResizable(false);
		this.setSize(900, 550);
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
		
		JLabel lbTitulo = new JLabel("Gerenciamento de produtos");
		lbTitulo.setBounds(0, 0, getWidth(), 50);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setOpaque(true);
		lbTitulo.setBackground(Color.decode("#5B9BD5"));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(interBold);
		add(lbTitulo);
		
		JLabel lbPesquisar = new JLabel("Pesquisar categoria:");
		lbPesquisar.setBounds(60, 70, 200, 35);
		lbPesquisar.setFont(interSemiBold);
		lbPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbPesquisar);
		
		JTextField txPesquisar = new JTextField();
		txPesquisar.setBounds(270, 70, 200, 35);
		txPesquisar.setFont(interRegular);
		add(txPesquisar);
		
		JButton btPesquisar = new JButton();
		btPesquisar.setBounds(480, 70, 35, 35);
		btPesquisar.setBackground(Color.WHITE);
		btPesquisar.setBorderPainted(false);
		btPesquisar.setFont(interRegular.deriveFont(Font.PLAIN, 20));
		btPesquisar.setFocusPainted(false);
		add(btPesquisar);
		
		menu.setResizedImage("src/images/pesquisar.png", btPesquisar);
		
		JLabel nProduto = new JLabel();
		nProduto.setBounds(600, 115, 230, 35);
		nProduto.setFont(interSemiBold);
		
		JLabel vProduto = new JLabel();
		vProduto.setBounds(600, 160, 230, 35);
		vProduto.setFont(interSemiBold);
		
		JLabel dProduto = new JLabel();
		dProduto.setBounds(600, 205, 230, 35);
		dProduto.setFont(interSemiBold);
		
		JLabel qProduto = new JLabel();
		qProduto.setBounds(600, 250, 230, 35);
		qProduto.setFont(interSemiBold);
		
		JLabel iProduto = new JLabel();
		iProduto.setBounds(600, 295, 230, 35);
		iProduto.setFont(interSemiBold);
		
		add(nProduto);
		add(vProduto);
		add(dProduto);
		add(qProduto);
		add(iProduto);

		btPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Statement state;
				
				Conexao conexao = new Conexao();
				
				String nomeProduto = txPesquisar.getText();

				if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um produto válido.");
					return;
				}

				String script = "SELECT idProduto, produto, valor, descricao, quantidade, idCategoria FROM tbProduto WHERE produto = '" + nomeProduto + "'";
			
				conexao.conectar();
			
				try {
					state = (Statement) Conexao.con.createStatement();
					ResultSet rs = state.executeQuery(script);

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Produto encontrado.");
						
						nProduto.setText("Produto: " + rs.getString("produto"));
						vProduto.setText("Valor: " + rs.getString("valor"));
						dProduto.setText("Descricao: " + rs.getString("descricao"));
						qProduto.setText("Quantidade:" + rs.getString("quantidade"));
						iProduto.setText("idCategoria: " + rs.getString("idCategoria"));
						
						idProduto = rs.getInt("idProduto");
						
						btAlterar.setEnabled(true);
						btExcluir.setEnabled(true);
						txProduto.setEnabled(true);
						txValor.setEnabled(true);
						txQuantidade.setEnabled(true);
						cbCategoria.setEnabled(true);
						taDescricao.setEnabled(true);
					} else {
						btAlterar.setEnabled(false);
						btExcluir.setEnabled(false);
						txProduto.setEnabled(false);
						txValor.setEnabled(false);
						txQuantidade.setEnabled(false);
						cbCategoria.setEnabled(false);
						taDescricao.setEnabled(false);
						
						nProduto.setText("");
						vProduto.setText("");
						dProduto.setText("");
						qProduto.setText("");
						iProduto.setText("");
						
						JOptionPane.showMessageDialog(null, "Nenhum produto '" + nomeProduto + "' encontrado.");
						int option = JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo produto?", "Cadastrar?", JOptionPane.YES_NO_OPTION);
						
						if (option == JOptionPane.YES_OPTION) {
							new CadastraProduto(menu);
						}
						
					}
				} catch(SQLException error) {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa.");
				}
				
				conexao.desconectar();
			}
		});
		
		JLabel lbProduto = new JLabel("Produto:");
		lbProduto.setBounds(60, 115, 230, 35);
		lbProduto.setFont(interSemiBold);
		lbProduto.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbProduto);
		
		txProduto = new JTextField();
		txProduto.setBounds(60, 150, 230, 35);
		txProduto.setFont(interRegular);
		txProduto.setEnabled(false);
		add(txProduto);		
		
		JLabel lbValor = new JLabel("Valor:");
		lbValor.setBounds(300, 115, 230, 35);
		lbValor.setFont(interSemiBold);
		lbValor.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbValor);
		
		txValor = new JTextField();
		txValor.setBounds(300, 150, 230, 35);
		txValor.setFont(interRegular);
		txValor.setEnabled(false);
		add(txValor);
		
		JLabel lbCategoria = new JLabel("Categoria:");
		lbCategoria.setBounds(60, 195, 230, 35);
		lbCategoria.setFont(interSemiBold);
		lbCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbCategoria);
		
		cbCategoria = new JComboBox();
		cbCategoria.setBounds(60, 240, 230, 35);
		cbCategoria.setFont(interRegular);
		cbCategoria.setOpaque(true);
		cbCategoria.setBackground(Color.WHITE);
		cbCategoria.setEnabled(false);
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
		lbQuantidade.setBounds(300, 195, 230, 35);
		lbQuantidade.setFont(interSemiBold);
		lbQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbQuantidade);
		
		txQuantidade = new JTextField();
		txQuantidade.setBounds(300, 240, 230, 35);
		txQuantidade.setFont(interRegular);
		txQuantidade.setEnabled(false);
		add(txQuantidade);

		JLabel lbDescricao = new JLabel("Descrição:");
		lbDescricao.setBounds(60, 285, 470, 35);
		lbDescricao.setFont(interSemiBold);
		lbDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbDescricao);
		
		taDescricao = new JTextArea();
		taDescricao.setFont(interRegular);
		taDescricao.setLineWrap(true);
		taDescricao.setEnabled(false);
		
		JScrollPane scrollpane = new JScrollPane(taDescricao);
		scrollpane.setBounds(60, 330, 470, 100);
		add(scrollpane);
		
		btAlterar = new JButton("Alterar");
		btAlterar.setBounds(60, 440, 230, 35);
		btAlterar.setUI(new CustomButtonUI());
		btAlterar.setForeground(Color.WHITE);
		btAlterar.setBackground(Color.decode("#5B9BD5"));
		btAlterar.setBorderPainted(false);
		btAlterar.setFont(interRegular);
		btAlterar.setFocusPainted(false);
		btAlterar.setEnabled(false);
		add(btAlterar);
		menu.setResizedImage("src/images/alterar.png", btAlterar);
		
		btAlterar.addActionListener(new ActionListener() {
			
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
					
					String script = "UPDATE tbProduto SET produto = '" + nomeProduto + "', valor = '" + valorProduto + "', descricao = '" + descricaoProduto + "', quantidade = '" + qtdProduto + "', idCategoria = " + idCategoria + " WHERE idProduto = '" + idProduto + "'";
					
					try {
						state = (Statement) Conexao.con.createStatement();
						state.executeUpdate(script);
							
					} catch(SQLException error) {
						JOptionPane.showMessageDialog(null, "Não foi possível realizar a alteração.");
					}
					
		            JOptionPane.showMessageDialog(null, "Produto '" + nomeProduto + "' alterado com sucesso.");
					
					conexao.desconectar();
				}
			});
		
		btExcluir = new JButton("Excluir");
		btExcluir.setBounds(300, 440, 230, 35);
		btExcluir.setUI(new CustomButtonUI());
		btExcluir.setForeground(Color.WHITE);
		btExcluir.setBackground(Color.decode("#5B9BD5"));
		btExcluir.setBorderPainted(false);
		btExcluir.setFont(interRegular);
		btExcluir.setFocusPainted(false);
		btExcluir.setEnabled(false);
		menu.setResizedImage("src/images/excluir.png", btExcluir);
		add(btExcluir);
		
		btExcluir.addActionListener(new ActionListener() {
			
			  @Override
			  public void actionPerformed(ActionEvent e) {
			      String nomeProduto = txPesquisar.getText();

			      if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
			          JOptionPane.showMessageDialog(null, "Informe um produto válido.");
			          return;
			      }

			      Conexao conexao = new Conexao();
			      
			      String script = "DELETE FROM tbProduto WHERE idProduto = '" + idProduto + "'";

			      conexao.conectar();

			      try {
			          Statement state = (Statement) Conexao.con.createStatement();
			          if (state.executeUpdate(script) > 0) {
			        	  JOptionPane.showMessageDialog(null, "Produto '" + nomeProduto + "' excluída com sucesso.");
			          } else {
			        	  JOptionPane.showMessageDialog(null, "O produto '" + nomeProduto + "' não existe.");
			          }
			          
			      } catch (SQLException error) {
			          JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto.");
			      }

			      conexao.desconectar();
			  }
			});
		
		this.setVisible(true);
	}
}
