package interfacesGraficas;

import java.awt.EventQueue;

public class App {

 
	/* 
	 * 	public static void main(String[] args) {
		
		Formulario formulario = new Formulario();
		System.out.println(formulario);
	}
	 * 
	 * */
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	        	Formulario t = new Formulario();
	           t.setVisible(true);
	        }
	    });
	}
}
