package dao;

public class Cidade {   
    private int id;
    private String nome;
    private String estado;
    private String pais;
    private double populacao;
    
    
    
    public Cidade(){
        this.nome = "";
        this.estado = "";
        this.pais = "";
        
    } 
    
    Cidade(int id, String nome, String estado, String pais, double populacao){
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
        this.populacao = populacao;
    } 
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getPais(){
        return pais;
    }
    
    public void setPais(String pais){
        this.pais = pais;
    }
    
    public double getPopulacao(){
        return populacao;
    }
    
    public void setPopulacao(double populacao){
        this.populacao = populacao;
    }
}
