package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class VisualizaCategoria extends JDialog {
    
	JButton btInserir;
	JButton btAlterar;
	JButton btExcluir;
	JTextField txCategoria;

	public VisualizaCategoria(Menu menu) {
		setResizable(false);
		this.setSize(800, 350);
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
		
		JLabel lbTitulo = new JLabel("Gerenciamento de categorias");
		lbTitulo.setBounds(0, 0, getWidth(), 50);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setOpaque(true);
		lbTitulo.setBackground(Color.decode("#5B9BD5"));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(interBold);
		add(lbTitulo);
		
		JLabel lbPesquisar = new JLabel("Pesquisar categoria:");
		lbPesquisar.setBounds(60, 100, 160, 35);
		lbPesquisar.setFont(interSemiBold);
		lbPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbPesquisar);
		
		JTextField txPesquisar = new JTextField();
		txPesquisar.setBounds(230, 100, 200, 35);
		txPesquisar.setFont(interRegular);
		add(txPesquisar);
		
		JButton btPesquisar = new JButton();
		btPesquisar.setBounds(440, 100, 35, 35);
		btPesquisar.setBackground(Color.WHITE);
		btPesquisar.setBorderPainted(false);
		btPesquisar.setFont(interRegular.deriveFont(Font.PLAIN, 20));
		btPesquisar.setFocusPainted(false);
		add(btPesquisar);
		
		menu.setResizedImage("src/images/pesquisar.png", btPesquisar);
		
		JLabel nCategoria = new JLabel();
		nCategoria.setBounds(600, 100, 200, 35);
		nCategoria.setFont(interSemiBold);
		
		JLabel nIdCategoria = new JLabel();
		nIdCategoria.setBounds(600, 145, 200, 35);
		nIdCategoria.setFont(interSemiBold);
		
		add(nCategoria);
		add(nIdCategoria);

		btPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Statement state;
				
				Conexao conexao = new Conexao();
				
				String nomeCategoria = txPesquisar.getText();

				if (nomeCategoria == null || nomeCategoria.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe uma categoria válida.");
					return;
				}

				String script = "SELECT idCategoria, categoria FROM tbCategoria WHERE categoria = '" + nomeCategoria + "'";
			
				conexao.conectar();
			
				try {
					state = (Statement) Conexao.con.createStatement();
					ResultSet rs = state.executeQuery(script);

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Categoria encontrada.");
						
						nCategoria.setText("Categoria: " + rs.getString("categoria"));
						nIdCategoria.setText("ID: " + rs.getString("idCategoria"));
						
						btInserir.setEnabled(false);
						btAlterar.setEnabled(true);
						btExcluir.setEnabled(true);
						txCategoria.setEnabled(true);
					} else {
						
						nCategoria.setText("");
						nIdCategoria.setText("");
						btInserir.setEnabled(true);
						btAlterar.setEnabled(false);
						btExcluir.setEnabled(false);
						txCategoria.setEnabled(false);
						
						JOptionPane.showMessageDialog(null, "Nenhuma categoria '" + nomeCategoria + "' encontrada.");
						int option = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma nova categoria?", "Cadastrar?", JOptionPane.YES_NO_OPTION);
						
						if (option == JOptionPane.YES_OPTION) {
							new CadastraCategoria(menu);
						}
					}
				} catch(SQLException error) {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa.");
				}
				
				conexao.desconectar();
			}
		});
		
		JLabel lbCategoria = new JLabel("Categoria:");
		lbCategoria.setBounds(60, 160, 90, 35);
		lbCategoria.setFont(interSemiBold);
		add(lbCategoria);
		
		txCategoria = new JTextField();
		txCategoria.setBounds(160, 160, 200, 35);
		txCategoria.setFont(interRegular);
		txCategoria.setEnabled(false);
		add(txCategoria);
		
		btInserir = new JButton("Inserir");
		btInserir.setUI(new CustomButtonUI());
		btInserir.setBounds(60, 220, 150, 35);
		btInserir.setForeground(Color.WHITE);
		btInserir.setBackground(Color.decode("#5B9BD5"));
		btInserir.setBorderPainted(false);
		btInserir.setFont(interRegular);
		btInserir.setFocusPainted(false);
		btInserir.setEnabled(false);
		add(btInserir);
		
		menu.setResizedImage("src/images/inserir.png", btInserir);
		
		btInserir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Statement state;
				
				Conexao conexao = new Conexao();
				
				String nomeCategoria = txPesquisar.getText();
				
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
		
		btAlterar = new JButton("Alterar");
		btAlterar.setBounds(220, 220, 150, 35);
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
		      String nomeCategoria = txCategoria.getText();

		      if (nomeCategoria == null || nomeCategoria.trim().isEmpty()) {
		          JOptionPane.showMessageDialog(null, "Informe uma categoria válida.");
		          return;
		      }

		      Conexao conexao = new Conexao();
		      
		      String script = "UPDATE tbCategoria SET categoria = '" + nomeCategoria + "' WHERE categoria = '" + txPesquisar.getText() + "'";

		      conexao.conectar();

		      try {
		          Statement state = (Statement) Conexao.con.createStatement();
		          
		          if (state.executeUpdate(script) > 0) {
		        	  JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso.\nA categoria '" + txPesquisar.getText() + "' agora se chama '" + nomeCategoria + "'.");
		          } else {
		        	  JOptionPane.showMessageDialog(null, "A categoria '" + txPesquisar.getText() + "' não existe.");
		          }
		          
		      } catch (SQLException error) {
		          JOptionPane.showMessageDialog(null, "Não foi possível atualizar a categoria.");
		      }

		      conexao.desconectar();
		  }
		});

		btExcluir = new JButton("Excluir");
		btExcluir.setBounds(380, 220, 150, 35);
		btExcluir.setUI(new CustomButtonUI());
		btExcluir.setForeground(Color.WHITE);
		btExcluir.setBackground(Color.decode("#5B9BD5"));
		btExcluir.setBorderPainted(false);
		btExcluir.setFont(interRegular);
		btExcluir.setFocusPainted(false);
		btExcluir.setEnabled(false);
		add(btExcluir);
		
		menu.setResizedImage("src/images/excluir.png", btExcluir);
		
		btExcluir.addActionListener(new ActionListener() {
			
		  @Override
		  public void actionPerformed(ActionEvent e) {
		      String nomeCategoria = txCategoria.getText();

		      if (nomeCategoria == null || nomeCategoria.trim().isEmpty()) {
		          JOptionPane.showMessageDialog(null, "Informe uma categoria válida.");
		          return;
		      }

		      Conexao conexao = new Conexao();
		      
		      String script = "DELETE FROM tbCategoria WHERE categoria = '" + nomeCategoria + "'";

		      conexao.conectar();

		      try {
		          Statement state = (Statement) Conexao.con.createStatement();
		          if (state.executeUpdate(script) > 0) {
		        	  JOptionPane.showMessageDialog(null, "Categoria '" + nomeCategoria + "' excluída com sucesso.");
		          } else {
		        	  JOptionPane.showMessageDialog(null, "A categoria '" + nomeCategoria + "' não existe.");
		          }
		          
		      } catch (SQLException error) {
		          JOptionPane.showMessageDialog(null, "Não foi possível excluir a categoria.");
		      }

		      conexao.desconectar();
		  }
		});
		
		this.setVisible(true);
	}
}
