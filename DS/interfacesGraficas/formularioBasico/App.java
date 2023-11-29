package formularioBasico;
import java.awt.EventQueue;

public class App {
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	        	Janela j = new Janela();
	           j.setVisible(true);
	        }
	    });
	}
}
