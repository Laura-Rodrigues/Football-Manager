import java.util.Objects;

public class Guarda_Redes extends Equipa {
    private String nome;
    // valores de 0 - 20
    private int velocidade;  // 2
    private int resistencia;  // 1
    private int destreza;  // 2
    private int impulsao;  // 3
    private int jogo_cabeca;  // 1
    private int remate;  // 1
    private int capacidade_passe; // 2
    private int elasticidade;  // 3

    public Guarda_Redes(){
        this.nome = "";
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogo_cabeca = 0;
        this.remate = 0;
        this.capacidade_passe = 0;
        this.elasticidade = 0;
    }

    public Guarda_Redes(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe, int elasticidade){
        this.nome = nome;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeca = jogo_cabeca;
        this.remate = remate;
        this.capacidade_passe = capacidade_passe;
        this.elasticidade = elasticidade;
    }

    public Guarda_Redes(Guarda_Redes gr){
        this.nome = gr.getNome();
        this.velocidade = gr.getVelocidade();
        this.resistencia = gr.getResistencia();
        this.destreza = gr.getDestreza();
        this.impulsao = gr.getImpulsao();
        this.jogo_cabeca = gr.getJogo_cabeca();
        this.remate = gr.getRemate();
        this.capacidade_passe = gr.getCapacidade_passe();
        this.elasticidade = gr.getElasticidade();
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

    public int getElasticidade()
    { return this.elasticidade; }




    public int habilidadeGR (Guarda_Redes gr){
        return (int) Math.round(this.getVelocidade() * 0.15 +
                this.getResistencia()*0.05 +
                this.getDestreza()*0.15 +
                this.getImpulsao()*0.20 +
                this.getJogo_cabeca()*0.01 +
                this.getRemate()*0.04 +
                this.getCapacidade_passe()*0.15 +
                this.getElasticidade()*0.25);
    }




    // CLONE
    public Guarda_Redes clone() { return new Guarda_Redes(this); }

    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        sb.append("Guarda Redes: ").append(this.nome).append("\n");
        sb.append("velocidade: ").append(this.velocidade).append("\n");
        sb.append("resistencia: ").append(this.resistencia).append("\n");
        sb.append("destreza: ").append(this.destreza).append("\n");
        sb.append("impulsao: ").append(this.impulsao).append("\n");
        sb.append("jogo de cabeca: ").append(this.jogo_cabeca).append("\n");
        sb.append("remate: ").append(this.remate).append("\n");
        sb.append("capacidade de passe: ").append(this.capacidade_passe).append("\n");
        sb.append("elasticidade: ").append(this.elasticidade).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guarda_Redes that = (Guarda_Redes) o;
        return velocidade == that.velocidade &&
                resistencia == that.resistencia &&
                destreza == that.destreza &&
                impulsao == that.impulsao &&
                jogo_cabeca == that.jogo_cabeca &&
                remate == that.remate &&
                capacidade_passe == that.capacidade_passe &&
                elasticidade == that.elasticidade &&
                Objects.equals(nome, that.nome);
    }









}
