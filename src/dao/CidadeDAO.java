package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    private PreparedStatement stmtC;
    private PreparedStatement stmtR;
    private PreparedStatement stmtU;
    private PreparedStatement stmtD;
    
    
    public CidadeDAO() {
        try {
            String url = "jdbc:derby://localhost:1527/jogo;";
     
            String usuario = "root";
            String senha = "root";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            
            String sqlC = "INSERT INTO cidades(nome, estado, pais, populacao) VALUES(?,?,?,?)";
            String sqlR = "SELECT * FROM cidades";
            String sqlU = "UPDATE cidades SET nome=?, estado=?, pais=?, populacao=? WHERE id=? ";
            String sqlD = "DELETE FROM cidades WHERE id=?";
            
            // O segundo parametro indica que iremos precisar obter o id
            // gerado automaticamente pelo banco
            this.stmtC = conn.prepareStatement(sqlC, Statement.RETURN_GENERATED_KEYS);
            this.stmtR = conn.prepareStatement(sqlR);
            this.stmtU = conn.prepareStatement(sqlU);
            this.stmtD = conn.prepareStatement(sqlD);
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
              }
    }
    
   
    public List<Cidade> lerTodos() {
        try{
            ResultSet rs = this.stmtR.executeQuery();
            List<Cidade> cidades = new ArrayList<>();
            
            while(rs.next()) {
                Cidade aux = new Cidade();
                
                aux.setId(rs.getInt("id"));
                aux.setNome(rs.getString("nome"));
                aux.setEstado(rs.getString("estado"));
                aux.setPais(rs.getString("pais"));
                aux.setPopulacao(rs.getDouble("populacao"));
                cidades.add(aux);
            }
            return cidades;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
        
public Cidade criar(Cidade c) {
        try{
            this.stmtC.setString(1, c.getNome());
            this.stmtC.setString(2, c.getEstado());
            this.stmtC.setString(3, c.getPais());
            this.stmtC.setDouble(4,c.getPopulacao());
            
            this.stmtC.executeUpdate();
            ResultSet rs = this.stmtC.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                c.setId(id);
                return c;
            } 
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
    public boolean atualizar(Cidade c) {
        try{
            this.stmtU.setString(1, c.getNome());
            this.stmtU.setString(2, c.getEstado());
            this.stmtU.setString(3, c.getPais());
            this.stmtU.setDouble(4, c.getPopulacao());
            this.stmtU.setInt(5, c.getId());

            
            return this.stmtU.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean apagar(int id) {
        try{
            this.stmtD.setInt(1, id);
            return this.stmtD.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

