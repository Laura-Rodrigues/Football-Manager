import java.util.Objects;
import java.util.Random;

public class Guarda_Redes extends Jogadores {

    private int elasticidade;
    private int posicionamento;
    private int reflexos;

    public Guarda_Redes(){
        super();
        this.elasticidade = 0;
        this.posicionamento = 0;
        this.reflexos = 0;
    }

    public Guarda_Redes(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe, 
                        int elasticidade, int posicionamento, int reflexos){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
        this.elasticidade = elasticidade;
        this.posicionamento = posicionamento;
        this.reflexos = reflexos;

    }

    public Guarda_Redes(Guarda_Redes gr){
        super(gr.getNome(), gr.getVelocidade(), gr.getResistencia(), gr.getDestreza(), gr.getImpulsao(), gr.getJogo_cabeca(), gr.getRemate(), gr.getCapacidade_passe());
        this.elasticidade = gr.getElasticidade();
        this.posicionamento = gr.getPosicionamento();
        this.reflexos = gr.getReflexos();
    }
    public Guarda_Redes(Jogadores a){
        super(a);
        if (a.getClass() == getClass()) {
            Guarda_Redes gr = (Guarda_Redes) a;
            this.elasticidade = gr.getElasticidade();
            this.posicionamento = gr.getPosicionamento();
            this.reflexos = gr.getReflexos();
        }
    }
    public Guarda_Redes(String nome){
        super.RandomizarJogador_No_Tipo();
        super.setNome(nome);
    }

    // GET E SET
    public int getElasticidade() { return this.elasticidade; }
    public int getPosicionamento() { return this.posicionamento; }
    public int getReflexos() { return this.reflexos; }
    public void setElasticidade(int elasticidade) { this.elasticidade = elasticidade; }
    public void setPosicionamento(int posicionamento) { this.posicionamento = posicionamento; }
    public void setReflexos(int reflexos) { this.reflexos = reflexos; }


    public int getHabilidade(){
        return (int) Math.round(this.getVelocidade() * 0.05 +
                this.getPosicionamento()*0.12 +
                this.getReflexos()*0.20 +
                this.getResistencia()*0.05 +
                this.getDestreza()*0.05 +
                this.getImpulsao()*0.15 +
                this.getJogo_cabeca()*0.01 +
                this.getRemate()*0.02 +
                this.getCapacidade_passe()*0.15 +
                this.getElasticidade()*0.20);
    }

    public StringBuilder toStringExtra(){
        StringBuilder sb = new StringBuilder();
        sb.append("Elasticidade: ").append(this.getElasticidade()).append("\n");
        sb.append("Posicionamento: ").append(this.getPosicionamento()).append("\n");
        sb.append("Reflexos: ").append(this.getReflexos()).append("\n");
        return sb;
    }
    
    public void RandomizarExtra(int max,Random rand){
        this.elasticidade = (int) (rand.nextFloat() * max);
        this.posicionamento = (int) (rand.nextFloat() * max);
        this.reflexos = (int) (rand.nextFloat() * max);
        
    }


    // CLONE
    public Guarda_Redes clone() { return new Guarda_Redes(this); }

    

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
                posicionamento == that.posicionamento &&
                reflexos == that.reflexos &&
                Objects.equals(nome, that.nome);
    }









}
