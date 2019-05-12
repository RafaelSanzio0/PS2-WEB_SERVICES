package dao;


import classes.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {
    private PreparedStatement stmtC;
    private PreparedStatement stmcR;
    private PreparedStatement stmcU;
    private PreparedStatement stmcD;
    
    @SuppressWarnings("CallToPrintStackTrace") // ?
    public JogoDAO() {
        try{
            String url = "jdbc:derby://localhost:1527/jogo";
            String usuario = "root";
            String senha = "";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            
            String sqlC =  "INSERT INTO jogo(nome_time_A, nome_time_B, gols_time_A, gols_time_B) VALUES (????)";       
            String sqlR =  "SELECT * FROM jogo";
            String sqlU =  "UPDATE jogo SET nome_time_A=?, nome_time_B=?,gols_time_A=?,gols_time_B=? WHERE id =?";
            String sqlD =  "DELETE FROM jogo WHERE id=?";
            
            this.stmtC = connection.prepareStatement(sqlC, Statement.RETURN_GENERATED_KEYS);
            this.stmcR = connection.prepareStatement(sqlR);
            this.stmcU = connection.prepareStatement(sqlU);
            this.stmcD = connection.prepareStatement(sqlD);
            
        }catch(ClassNotFoundException | SQLException exception){
            exception.printStackTrace();
        }
    }
        
        @SuppressWarnings("CallToPrintSTack")
         public List<Jogo> lerTodos(){
            try{
                ResultSet resultSet = this.stmcR.executeQuery();
                List<Jogo> jogos = new ArrayList<>();
                
            }catch(SQLException exception){
                exception.printStackTrace();
            }
            return null;
         }
}
        
        
        
         

