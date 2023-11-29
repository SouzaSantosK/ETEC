package concessionaria;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.beans.Customizer;
import java.io.IOException;
import java.io.File;

public class Orcamento extends JFrame {
	
	JComboBox<String> cbMarca;
	JComboBox<String> cbModelo;
	JLabel car;
	
	JRadioButton rdBranco;
	JRadioButton rdAzul;
	JRadioButton rdCinza;
	JRadioButton rdPreto;
    
	public Orcamento() {

		this.setTitle("Orçamento");
		this.setSize(1200, 600);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		
		Font interBold = null;
		try {
			interBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Inter/Inter-Bold.ttf"));
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}

		interBold = interBold.deriveFont(Font.PLAIN, 20);
        
		JLabel logo = new JLabel();
		logo.setBounds(20, 20, 80, 80);
		
	    Image imagem = new ImageIcon("src/images/logo.png").getImage();
	    int width = logo.getWidth();
	    int height = logo.getHeight();
	  
	    Image resizedImage = imagem.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
	    
	    logo.setIcon(resizedIcon);
		add(logo);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(120, 40, 100, 20);
		add(lbNome);
		
		JTextField txNome = new JTextField();
		txNome.setBounds(120, 65, 150, 30);
        add(txNome);
        
        JLabel lbCelular = new JLabel("Celular:");
        lbCelular.setBounds(280, 40, 100, 20);
		add(lbCelular);
		
		JTextField txCelular = new JTextField();
		txCelular.setBounds(280, 65, 150, 30);
        add(txCelular);
        
        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setBounds(440, 40, 100, 20);
		add(lbEmail);
		
		JTextField txEmail = new JTextField();
		txEmail.setBounds(440, 65, 150, 30);
        add(txEmail);
        
        JLabel lbMarca = new JLabel("Marca:");
        lbMarca.setBounds(20, 120, 50, 20);
		add(lbMarca);
		
        String[] opcoes = {"BMW", "Porsche", "Lamborghini"};
		
		cbMarca = new JComboBox<>(opcoes);
		cbMarca.setBounds(20, 150, 200, 20);
        add(cbMarca);
        
        JLabel lbModelo = new JLabel("Modelo:");
        lbModelo.setBounds(250, 120, 50, 20);
		add(lbModelo);
		
		String[] inicializacao = {"X6", "M3"};
		
		cbModelo = new JComboBox<>(inicializacao);
		cbModelo.setBounds(250, 150, 200, 20);
        add(cbModelo);
        
        String[][] modelosCarros = {
        		{"X6", "M3"},
        		{"GT3", "Carrera"},
        		{"Urus", "Húracan STO"}
        		};
        
        cbMarca.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int marcaSelecionadaIndex = cbMarca.getSelectedIndex();
				
				cbModelo.removeAllItems();
				
				for (String modelo : modelosCarros[marcaSelecionadaIndex]) {
					cbModelo.addItem(modelo);
				}
				
				cbModelo.setSelectedIndex(0);
			}
        });
        
        JLabel lbCores = new JLabel("Cores:");
        lbCores.setBounds(20, 200, 560, 40);
        lbCores.setFont(interBold);
		add(lbCores);
        
        
        rdBranco = new JRadioButton("Branco");
        rdBranco.setBounds(20, 250, 80, 20);
        rdBranco.setBackground(Color.white);
        changeCarColor(rdBranco);
        add(rdBranco);
        
        rdAzul = new JRadioButton("Azul");
        rdAzul.setBounds(140, 250, 80, 20);
        rdAzul.setBackground(Color.white);
        changeCarColor(rdAzul);
        add(rdAzul);
        
        rdCinza = new JRadioButton("Cinza");
        rdCinza.setBounds(260, 250, 80, 20);
        rdCinza.setBackground(Color.white);
        changeCarColor(rdCinza);
        add(rdCinza);
        
        rdPreto = new JRadioButton("Preto");
        rdPreto.setBounds(380, 250, 80, 20);
        rdPreto.setBackground(Color.white);
        changeCarColor(rdPreto);
        rdPreto.setSelected(true);
        add(rdPreto);
        
        ButtonGroup bgCores = new ButtonGroup();
        bgCores.add(rdBranco);
        bgCores.add(rdAzul);
        bgCores.add(rdPreto);
        bgCores.add(rdCinza);
        
        // Opcionais
        
        JLabel lbOpcionais = new JLabel("Opcionais:");
        lbOpcionais.setBounds(20, 280, 560, 40);
        lbOpcionais.setFont(interBold);
		add(lbOpcionais);
		
		
		JCheckBox ckRodasAluminio = new JCheckBox("Rodas alumínio");
        ckRodasAluminio.setBounds(20, 330, 120, 20);
        ckRodasAluminio.setBackground(Color.white);
        add(ckRodasAluminio);
        
        JCheckBox ckBancoCouro = new JCheckBox("Banco de Couro");
        ckBancoCouro.setBounds(220, 330, 120, 20);
        ckBancoCouro.setBackground(Color.white);
        add(ckBancoCouro);
        
        JCheckBox ckbancoConcha = new JCheckBox("Bancos em Concha");
        ckbancoConcha.setBounds(20, 360, 150, 20);
        ckbancoConcha.setBackground(Color.white);
        add(ckbancoConcha);
        
        JCheckBox ckfibraCarbono = new JCheckBox("Fibra de carbono");
        ckfibraCarbono.setBounds(220, 360, 120, 20);
        ckfibraCarbono.setBackground(Color.white);
        add(ckfibraCarbono);
        
		
        
        JButton btEnviar = new JButton("<html><h3>Enviar</h3></html>");
		btEnviar.setBounds(20, 400, 100, 40);
		
		add(btEnviar);
		
		JButton btCancelar = new JButton("<html><h3>Cancelar</h3></html>");
		btCancelar.setBounds(140, 400, 100, 40);
		add(btCancelar);
		
		btCancelar.addActionListener(new ActionListener() {
      	  @Override
      	  public void actionPerformed(ActionEvent e) {
      		  
      		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar o orçamento?");
      		if (resposta == 0) {
      			System.exit(0);
      		}
      	  }
      	});
		
		btEnviar.addActionListener(new ActionListener() {
      	  @Override
      	  public void actionPerformed(ActionEvent e) {
      		  
      		String cor;
    		
    		if(rdBranco.isSelected()) {
    			cor = "Branca";
    		}else if(rdAzul.isSelected()) {
    			cor = "Azul";
    		}else if(rdCinza.isSelected()) {
    			cor = "Cinza";
    		}else{
    			cor = "Preta";
    		}
      		  
    		JCheckBox[] ckOpcionais = {ckRodasAluminio, ckBancoCouro, ckbancoConcha, ckfibraCarbono};
    		
      		String[] opcionais = {"❌", "❌", "❌", "❌"};
      		
      		for (int i = 0; i < ckOpcionais.length; i++) {
      			if (ckOpcionais[i].isSelected()) {
      				opcionais[i] = "✔";
      			}
      		}
    		
    		JOptionPane.showMessageDialog(null, "Nome: " + txNome.getText()
    		+ "\nCelular: " + txCelular.getText()
    		+ "\nEmail: " + txEmail.getText()
    		+ "\nMarca: " + cbMarca.getSelectedItem()
    		+ "\nModelo: " + cbModelo.getSelectedItem()
    		+ "\nCor: " + cor
    		+ "\n\nOpcionais:"
    		+ "\nRodas alumínio: " + opcionais[0]
    		+ "\nBanco de Couro: " + opcionais[1]
			+ "\nBancos em  Concha: " + opcionais[2]
			+ "\nFibra de Carbono: " + opcionais[3]);
      	  }
      	});
		
		JLabel lbCarName = new JLabel("BMW X6");
		lbCarName.setBounds(600, 20, 560, 40);
		lbCarName.setFont(interBold);
		lbCarName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbCarName);
		
		car = new JLabel();
		car.setBounds(600, 60, 600, 300);
		add(car);
		
		setCarImage("src/images/X6 Preto.png");
		
		cbModelo.addActionListener(new ActionListener() {
      	  @Override
      	  public void actionPerformed(ActionEvent e) {
      		  String color = getSelectedColor();
      	    
      	    if(!color.equals("")) {
      	      setCarImage("src/images/" + cbModelo.getSelectedItem() + " " + color + ".png");
      	    }
      	    
      	    lbCarName.setText(cbMarca.getSelectedItem() + " " + cbModelo.getSelectedItem());
      	    
      	  }
      	});
		
		this.setVisible(true);
	}
	
	private void changeCarColor(JRadioButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setCarImage("src/images/" + cbModelo.getSelectedItem() + " " + getSelectedColor() + ".png");
			}
		});
	}
	
	private void setCarImage(String imagePath) {
		ImageIcon carIcon = new ImageIcon(imagePath);
	    Image carImage = carIcon.getImage();
	    Image resizedCar = carImage.getScaledInstance(car.getWidth(), car.getHeight(), Image.SCALE_SMOOTH);
	    car.setIcon(new ImageIcon(resizedCar));
	}
	
	private String getSelectedColor() {
		if(rdBranco.isSelected()) {
	      return "Branco";
	    } else if(rdAzul.isSelected()) {
	      return "Azul";
	    } else if(rdCinza.isSelected()) {
	      return "Cinza";
	    } else if(rdPreto.isSelected()) {
	      return "Preto";
	    } else {
	      return "";
	    }
	}
	
	private JComboBox<String> createComboBox(String[] strings) {
	    JComboBox<String> comboBox = new JComboBox<>(strings);
	    return comboBox;
	}
}
