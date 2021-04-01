import java.util.Objects;

public class Laterais {
    private String nome;
    private int velocidade;  // 3
    private int resistencia;  // 3
    private int destreza;  // 2
    private int impulsao;  // 1
    private int jogo_cabeca;  // 1
    private int remate;  // 1
    private int capacidade_passe;  // 3

    public Laterais(){
        this.nome = "";
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogo_cabeca = 0;
        this.remate = 0;
        this.capacidade_passe = 0;
    }

    public Laterais(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe){
        this.nome = nome;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeca = jogo_cabeca;
        this.remate = remate;
        this.capacidade_passe = capacidade_passe;
    }

    public Laterais(Laterais gr){
        this.nome = gr.getNome();
        this.velocidade = gr.getVelocidade();
        this.resistencia = gr.getResistencia();
        this.destreza = gr.getDestreza();
        this.impulsao = gr.getImpulsao();
        this.jogo_cabeca = gr.getJogo_cabeca();
        this.remate = gr.getRemate();
        this.capacidade_passe = gr.getCapacidade_passe();
    }

    public String getNome()
    { return this.nome; }

    public int getVelocidade()
    { return this.velocidade; }

    public int getResistencia()
    { return this.resistencia; }

    public int getDestreza()
    { return this.destreza; }

    public int getImpulsao()
    { return this.impulsao; }

    public int getJogo_cabeca()
    { return this.jogo_cabeca; }

    public int getRemate()
    { return this.remate; }

    public int getCapacidade_passe()
    { return this.capacidade_passe; }


    public String toString() {
        return "Laterais{" +
                "nome='" + nome + '\'' +
                ", velocidade=" + velocidade +
                ", resistencia=" + resistencia +
                ", destreza=" + destreza +
                ", impulsao=" + impulsao +
                ", jogo_cabeca=" + jogo_cabeca +
                ", remate=" + remate +
                ", capacidade_passe=" + capacidade_passe +
                '}';
    }

    public Laterais clone() { return new Laterais(this); }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laterais laterais = (Laterais) o;
        return velocidade == laterais.velocidade &&
                resistencia == laterais.resistencia &&
                destreza == laterais.destreza &&
                impulsao == laterais.impulsao &&
                jogo_cabeca == laterais.jogo_cabeca &&
                remate == laterais.remate &&
                capacidade_passe == laterais.capacidade_passe &&
                Objects.equals(nome, laterais.nome);
    }


}
