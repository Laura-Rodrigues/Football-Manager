import java.util.Objects;

public class Guarda_Redes extends Jogadores {

    private int elasticidade;

    public Guarda_Redes(){
        super();
        this.elasticidade = 0;
    }

    public Guarda_Redes(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe, int elasticidade){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
        this.elasticidade = elasticidade;
    }

    public Guarda_Redes(Guarda_Redes gr){
        super(gr.getNome(), gr.getVelocidade(), gr.getResistencia(), gr.getDestreza(), gr.getImpulsao(), gr.getJogo_cabeca(), gr.getRemate(), gr.getCapacidade_passe());
        this.elasticidade = gr.getElasticidade();
    }

    // GET E SET
    public int getElasticidade() { return this.elasticidade; }
    public void setElasticidade(int elasticidade) { this.elasticidade = elasticidade; }


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
        return super.toString() + "\nelasticidade: " + this.elasticidade + "\n";
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
