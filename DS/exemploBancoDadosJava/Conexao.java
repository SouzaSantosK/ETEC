import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.Connection;

public class Conexao {
       // Cria uma conexão chamada con
	   static Connection con;   

	    // Método responsável pela conexão com o banco de dados
	    public void conectar() {
	        try{
	           // Método que carrega o driver
	           Class.forName("com.mysql.jdbc.Driver");

	           // jdbc - é o driver da sun responsável pela conexão
	           // Estabele uma conexão com o banco
	           con = DriverManager.getConnection("jdbc:mysql://localhost/dbloja", "root", "");

	           System.out.println("Conexão realizada com sucesso.");
	        }
	         catch(ClassNotFoundException ex) {
		        System.out.println("Driver JDBC-ODBC não encontrado"); 
		    }	         
	         catch(SQLException ex) {
	           System.out.println("Problemas na conexão com o banco de dados."); 
	        }
	    }
	    
	    // Método responsável pela desconexão com o banco de dados
	    public void desconectar() {
	         try{	           
	           con.close();
	           System.out.println("Conexao finalizada com sucesso");
	         }
	         catch(SQLException ex){
	            System.out.println("Problemas ao encerrar a conexão."); 
	         }
	    }
    
}