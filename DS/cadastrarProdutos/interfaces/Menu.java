package interfaces;

import javax.swing.*;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu extends JDialog {
	
	public Menu() {
		this.setSize(800, 600);
		this.setTitle("Menu de arquivo");
		this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setModal(true);
		
		JMenu arquivo = new JMenu("Arquivo");
		JMenu cadastrar = new JMenu("Cadastrar");
		JMenu visualizar = new JMenu("Visualizar");
		JMenu ajuda = new JMenu("Ajuda");
		
		JMenuItem sair = new JMenuItem("Sair");
		JMenuItem cdCategoria = new JMenuItem("Categoria");
		JMenuItem cdProduto = new JMenuItem("Produto");
		JMenuItem vCategorias = new JMenuItem("Categorias");
		JMenuItem vProdutos = new JMenuItem("Produtos");
		JMenuItem sobre = new JMenuItem("Sobre");
		
		arquivo.add(sair);
		cadastrar.add(cdCategoria);
		cadastrar.add(cdProduto);
		visualizar.add(vCategorias);
		visualizar.add(vProdutos);
		ajuda.add(sobre);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(arquivo);
		bar.add(cadastrar);
		bar.add(visualizar);
		bar.add(ajuda);
		
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				tryToLeave();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				tryToLeave();
			}
		});
		
		cdCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastraCategoria(Menu.this);
			}
		});
		
		cdProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastraProduto(Menu.this);
			}
		});
		
		vCategorias.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Statement state;
				
				Conexao conexao = new Conexao();

				String script = "SELECT * FROM tbCategoria";
			
				conexao.conectar();
			
				try {
					state = (Statement) Conexao.con.createStatement();
					ResultSet rs = state.executeQuery(script);

					if (rs.next()) {
						new VisualizaCategoria(Menu.this);
						
					} else {
						JOptionPane.showMessageDialog(null, "Cadastre uma categoria primeiro.");
						new CadastraCategoria(Menu.this);
					}
				} catch(SQLException error) {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa.");
				}
				
				conexao.desconectar();
				
				
			}
		});
		
		vProdutos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Statement state;
				
				Conexao conexao = new Conexao();

				String script = "SELECT * FROM tbCategoria";
			
				conexao.conectar();
			
				try {
					state = (Statement) Conexao.con.createStatement();
					ResultSet rs = state.executeQuery(script);

					if (rs.next()) {
						new VisualizaProduto(Menu.this);
						
					} else {
						JOptionPane.showMessageDialog(null, "Cadastre uma categoria primeiro.");
						new CadastraCategoria(Menu.this);
					}
				} catch(SQLException error) {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa.");
				}
				
				conexao.desconectar();
				
				
			}
		});
		
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sobre();
			}
		});
		
		this.setVisible(true);
	}
	
	public void tryToLeave() {
		int option = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void setResizedImage(String imagePath, JButton selectedButton) {
		ImageIcon icon = new ImageIcon(imagePath);
	    Image image = icon.getImage();
	    Image resizedImage = image.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	    selectedButton.setIcon(new ImageIcon(resizedImage));
	}

}


