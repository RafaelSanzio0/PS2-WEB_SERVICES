package dao;

public class Jogo {

    private int id;
    private String nome_time_A;
    private String nome_time_B;
    private int gols_time_A;
    private int gols_time_B;

    public Jogo() {
    }

    public Jogo(int id, String nome_time_A, String nome_time_B, int gols_time_A, int gols_time_B) {
        this.id = id;
        this.nome_time_A = nome_time_A;
        this.nome_time_B = nome_time_B;
        this.gols_time_A = gols_time_A;
        this.gols_time_B = gols_time_B;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_time_A() {
        return nome_time_A;
    }

    public void setNome_time_A(String nome_time_A) {
        this.nome_time_A = nome_time_A;
    }
    
    public String getNome_time_B() {
        return nome_time_B;
    }

    public void setNome_time_B(String nome_time_B) {
        this.nome_time_B = nome_time_B;
    }

    public int getGols_time_A() {
        return gols_time_A;
    }

    public void setGols_time_A(int gols_time_A) {
        this.gols_time_A = gols_time_A;
    }

    public int getGols_time_B() {
        return gols_time_B;
    }

    public void setGols_time_B(int gols_time_B) {
        this.gols_time_B = gols_time_B;
    }
}
