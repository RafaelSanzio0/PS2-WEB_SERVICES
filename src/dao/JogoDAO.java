package dao;

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
        try {
            String url = "jdbc:derby://localhost:1527/jogo";
            String usuario = "root";
            String senha = "";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            
            String sqlC = "INSERT INTO jogo(nome_time_A, nome_time_B, gols_time_A, gols_time_B) VALUES (????)";
            String sqlR = "SELECT * FROM jogo";
            String sqlU = "UPDATE jogo SET nome_time_A=?, nome_time_B=?,gols_time_A=?,gols_time_B=? WHERE id =?";
            String sqlD = "DELETE FROM jogo WHERE id=?";
            
            this.stmtC = connection.prepareStatement(sqlC, Statement.RETURN_GENERATED_KEYS);
            this.stmcR = connection.prepareStatement(sqlR);
            this.stmcU = connection.prepareStatement(sqlU);
            this.stmcD = connection.prepareStatement(sqlD);
            
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintSTack")
    public List<Jogo> lerTodos() {
        try {
            ResultSet resultSet = this.stmcR.executeQuery();
            List<Jogo> jogos = new ArrayList<>();
            
            while (resultSet.next()) {
                Jogo aux = new Jogo();
                aux.setId(resultSet.getInt("id"));
                aux.setNome_time_A(resultSet.getString("nome_time_A"));
                aux.setNome_time_B(resultSet.getString("nome_time_B"));
                aux.setGols_time_A(resultSet.getInt("gols_time_A"));
                aux.setGols_time_B(resultSet.getInt("gols_time_B"));
                jogos.add(aux);
            }
            return jogos;
            
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings("CallToPrintSTack")
    public Jogo criar(Jogo jogo){
        try{
            this.stmtC.setString(1, jogo.getNome_time_A());
            this.stmtC.setString(2, jogo.getNome_time_B());
            this.stmtC.setInt(3, jogo.getGols_time_A());
            this.stmtC.setInt(4, jogo.getGols_time_A());
            this.stmtC.executeUpdate();
            
            ResultSet resultSet = this.stmtC.getGeneratedKeys();
            
            if(resultSet.next()){
                int id = resultSet.getInt(1);
                jogo.setId(id);
                return jogo;
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean atualzar(Jogo jogo){
        try{
            this.stmcU.setString(1, jogo.getNome_time_A());
            this.stmcU.setString(2, jogo.getNome_time_B());
            this.stmcU.setInt(3, jogo.getGols_time_A());
            this.stmcU.setInt(4, jogo.getGols_time_B());

        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
    
    
    @SuppressWarnings("CallToPrintStackTrace")
    public boolean apagar(Jogo jogo) {
        try{
            this.stmcD.setInt(1, (int) jogo.getId());
            return this.stmcD.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}