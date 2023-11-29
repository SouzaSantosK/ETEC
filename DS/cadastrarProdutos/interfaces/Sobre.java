package interfaces;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.File;

public class Sobre extends JDialog {

	JLabel profileImage;
	JLabel githubImage;

	public Sobre() {
		setResizable(false);
		this.setSize(600, 400);
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

		JLabel lbTitulo = new JLabel("Sistema desenvolvido por");
		lbTitulo.setBounds(0, 20, getWidth() / 2, 40);
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setOpaque(true);
		lbTitulo.setBackground(Color.decode("#5B9BD5"));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(interRegular);
		add(lbTitulo);

		JLabel lbName = new JLabel("Kauã de Souza");
		lbName.setBounds(0, 50, getWidth() / 2, 50);
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setOpaque(true);
		lbName.setBackground(Color.decode("#5B9BD5"));
		lbName.setForeground(Color.WHITE);
		lbName.setFont(interBold);
		add(lbName);

		profileImage = new JLabel();
		profileImage.setBounds(getWidth() / 4 - 60, 120, 120, 120);
		add(profileImage);
		setResizedImage("src/images/profile-icon1.png", profileImage);

		JLabel leftSide = new JLabel("");
		leftSide.setBounds(0, 0, getWidth() / 2, getHeight());
		leftSide.setOpaque(true);
		leftSide.setBackground(Color.decode("#5B9BD5"));
		leftSide.setForeground(Color.WHITE);
		add(leftSide);

		githubImage = new JLabel();
		githubImage.setBounds(getWidth() / 2 + getWidth() / 4 - 60, getHeight() / 6, 120, 120);
		add(githubImage);
		setResizedImage("src/images/github-logo2.png", githubImage);

		JLabel rightSide = new JLabel("");
		rightSide.setBounds(getWidth() - getWidth() / 2, 0, getWidth() / 2, getHeight());
		rightSide.setOpaque(true);
		rightSide.setBackground(Color.BLACK);
		add(rightSide);

		JButton githubButton = new JButton("@SouzaSantosK");
		githubButton.setBounds(getWidth() / 2 + getWidth() / 4 - 75, getHeight() / 2 + 20, 150, 40);
		githubButton.setFont(interRegular);
		githubButton.setBackground(Color.BLACK);
		githubButton.setForeground(Color.WHITE);
		githubButton.setFocusPainted(false);

		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		githubButton.setBorder(border);

		githubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/SouzaSantosK"));
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
		add(githubButton);

		this.setVisible(true);
	}

	public void setResizedImage(String imagePath, JLabel selectedLabel) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(selectedLabel.getWidth(), selectedLabel.getHeight(),
				Image.SCALE_SMOOTH);
		selectedLabel.setIcon(new ImageIcon(resizedImage));
	}
}
