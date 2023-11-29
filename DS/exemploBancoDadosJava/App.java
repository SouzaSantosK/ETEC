import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class App {
   
    public static void main(String[] args) {
        
		// Controla e executa uma instrução SQL
		Statement state;
			
		// Conjunto de dados retornado por uma consulta SQL
		ResultSet resultset;
	
		// Instancia um objeto chamado conex através da classe Conexao
		Conexao conex = new Conexao();     
	
		String selectCommand = "SELECT * FROM tbCategoria";
					
		conex.conectar();      
					
		try{                  
				
			state = (Statement) Conexao.con.createStatement();
			resultset = state.executeQuery(selectCommand);
				
				while(resultset.next()) {
					//System.out.print(" "+resultset.getString("nomeDaColuna"));
					System.out.print(" "+resultset.getString(1));
					System.out.print(" "+resultset.getString(2)+"\n");
				}                         
		}
		catch(SQLException e) {
			System.out.println("Nao foi possível realizar a consulta");
		}
			
		conex.desconectar();
		
		// restante do seu código...
    }    
}