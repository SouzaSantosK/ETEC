package interfaces;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.Connection;

public class Conexao {
	   static Connection con;   

	    public void conectar() {
	        try {
	           Class.forName("com.mysql.jdbc.Driver");

	           con = DriverManager.getConnection("jdbc:mysql://localhost/dbloja", "root", "");

	        }
	         catch(ClassNotFoundException ex) {
		        System.out.println("Driver JDBC-ODBC não encontrado"); 
		    }	         
	         catch(SQLException ex) {
	           System.out.println("Problemas na conexão com o banco de dados."); 
	        }
	    }
	    
	    public void desconectar() {
	         try{	           
	           con.close();
	         }
	         catch(SQLException ex) {
	         }
	    }
}