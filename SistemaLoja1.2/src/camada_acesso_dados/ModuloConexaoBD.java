package camada_acesso_dados;
import java.sql.*;

public class ModuloConexaoBD {
	
	//Metodo responsavel por estabelecer a conexão com o banco de dados
	public static Connection conector() {
		java.sql.Connection conexao=null;	//ira receber a string de conexao
		//a linha abaixo chama o driver do conecter importado
		String driver= "com.mysql.jdbc.Driver";
		//Armazenando informacoes referentes ao bd
		String url="jdbc:mysql://localhost:3306/dbinfox";
		String user= "root";
		String password="";
		//Estabelecendo  a conexao com o bd
		try {
			Class.forName(driver); //exucuta o driver
			conexao= DriverManager.getConnection(url, user, password); //ligacao ao bd
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Nao foi possivel conectar a BD");
			return null;
		}
	};

}
