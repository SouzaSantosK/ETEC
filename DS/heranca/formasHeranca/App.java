package formasHeranca;

import java.util.Scanner; 
import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int opcao;
		opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Escolha uma opção: \n[ 1 ] - Quadrado \n[ 2 ] - Triangulo \n[ 3 ] - Retangulo \n[ 4 ] - Trapezio \n", "Calculador de Area", 
				JOptionPane.QUESTION_MESSAGE));
		
		switch (opcao) {
			case 1: {
				Quadrado quadrado = new Quadrado();
				
				String base = JOptionPane.showInputDialog(null, "Informe a base do quadrado");
				quadrado.setBase(Double.parseDouble(base));
				
				JOptionPane.showMessageDialog(null, "Area do quadrado: " + quadrado.calcularArea(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 2: {
				Triangulo triangulo = new Triangulo();
				
				String base = JOptionPane.showInputDialog(null, "Informe a base do triangulo");
				triangulo.setBase(Double.parseDouble(base));
				
				String altura = JOptionPane.showInputDialog(null, "Informe a altura do triangulo");
				triangulo.setAltura(Double.parseDouble(altura));
				
				JOptionPane.showMessageDialog(null, "Area do triangulo: " + triangulo.calcularArea(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 3: {
				Retangulo retangulo = new Retangulo();
				
				String base = JOptionPane.showInputDialog(null, "Informe a base do retangulo");
				retangulo.setBase(Double.parseDouble(base));
				
				String altura = JOptionPane.showInputDialog(null, "Informe a altura do retangulo");
				retangulo.setAltura(Double.parseDouble(altura));
				JOptionPane.showMessageDialog(null, "Area do retangulo: " + retangulo.calcularArea(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			case 4: {
				Trapezio trapezio = new Trapezio();
				
				String base = JOptionPane.showInputDialog(null, "Informe a base menor do trapezio");
				trapezio.setBase(Double.parseDouble(base));
				
				String altura = JOptionPane.showInputDialog(null, "Informe a altura do trapezio");
				trapezio.setAltura(Double.parseDouble(altura));
				
				String baseMaior = JOptionPane.showInputDialog(null, "Informe a base maior do trapezio");
				trapezio.setBaseMaior(Double.parseDouble(baseMaior));
				
				JOptionPane.showMessageDialog(null, "Area do trapezio: " + trapezio.calcularArea(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			default: {
				System.out.println("Encerrando o programa, pois nenhuma opção válida foi selecionada");
			}
		}
		
		in.close();
	}
}
