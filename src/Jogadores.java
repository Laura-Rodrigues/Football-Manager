import java.util.Objects;
import java.util.Comparator;

public class Jogadores implements Comparable<Jogadores> {



    enum Class_jog{
        GRD,LAT,AVA,DEF,MED;
    }
    /**
    if GK then tipo_jogador = GRD;
    */
    protected String nome;
   //                          limitar valores de 0 - 20:
    protected int velocidade;
    protected int resistencia;
    protected int destreza;
    protected int impulsao;
    protected int jogo_cabeca;
    protected int remate;
    protected int capacidade_passe;
   
    protected Class_jog tipo_jogador;

  


    public Jogadores(){
        this.nome = "";
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogo_cabeca = 0;
        this.remate = 0;
        this.capacidade_passe = 0;
    }

    public Jogadores(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe){
        this.nome = nome;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeca = jogo_cabeca;
        this.remate = remate;
        this.capacidade_passe = capacidade_passe;
    }

    public Jogadores(Jogadores j){
        this.nome = j.getNome();
        this.velocidade = j.getVelocidade();
        this.resistencia = j.getResistencia();
        this.destreza = j.getDestreza();
        this.impulsao = j.getImpulsao();
        this.jogo_cabeca = j.getJogo_cabeca();
        this.remate = j.getRemate();
        this.capacidade_passe = j.getCapacidade_passe();
    }


    // GETTERS E SETTERS
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }


    public int getVelocidade() { return this.velocidade; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }

    public int getResistencia() { return this.resistencia; }
    public void setResistencia(int resistencia) { this.resistencia = resistencia; }

    public int getDestreza() { return this.destreza; }
    public void setDestreza(int destreza) { this.destreza = destreza; }

    public int getImpulsao() { return this.impulsao; }
    public void setImpulsao(int impulsao) { this.impulsao = impulsao; }

    public int getJogo_cabeca() { return this.jogo_cabeca; }
    public void setJogo_cabeca(int jogo_cabeca) { this.jogo_cabeca = jogo_cabeca; }

    public int getRemate() { return this.remate; }
    public void setRemate(int remate) { this.remate = remate; }


    

    public int getCapacidade_passe() { return this.capacidade_passe; }
    public void setCapacidade_passe(int capacidade_passe) { this.capacidade_passe = capacidade_passe; }


    // CLONE
    public Jogadores clone() { return new Jogadores(this); }

    // EQUALS
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogadores jogadores = (Jogadores) o;
        return velocidade == jogadores.velocidade &&
                resistencia == jogadores.resistencia &&
                destreza == jogadores.destreza &&
                impulsao == jogadores.impulsao &&
                jogo_cabeca == jogadores.jogo_cabeca &&
                remate == jogadores.remate &&
                capacidade_passe == jogadores.capacidade_passe &&
                Objects.equals(nome, jogadores.nome);
    }

    // TOSTRING
    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        sb.append("Jogador: ").append(this.nome).append("\n");
        sb.append("velocidade: ").append(this.velocidade).append("\n");
        sb.append("resistencia: ").append(this.resistencia).append("\n");
        sb.append("destreza: ").append(this.destreza).append("\n");
        sb.append("impulsao: ").append(this.impulsao).append("\n");
        sb.append("jogo de cabeca: ").append(this.jogo_cabeca).append("\n");
        sb.append("remate: ").append(this.remate).append("\n");
        sb.append("capacidade de passe: ").append(this.capacidade_passe).append("\n");
        return sb.toString();
    }



    @Override
    public int compareTo(Jogadores jogadores) {
        int hab1 = this.getVelocidade(); // getHabilidade deve ser usado isto é so para testar
        int hab2 = jogadores.getVelocidade();

        if ( hab1 > hab2)
            return -1;
        if ( hab1 < hab2)
            return 1;
        else return 0;
    }
}
