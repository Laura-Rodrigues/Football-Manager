import java.util.Objects;

public class Avancados extends Jogadores {

    public Avancados(){
        super();
    }

    public Avancados(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
    }

    public Avancados(Avancados a){
        super(a.getNome(), a.getVelocidade(), a.getResistencia(), a.getDestreza(), a.getImpulsao(), a.getJogo_cabeca(), a.getRemate(), a.getCapacidade_passe());

    }


    public int habilidadeAv (Avancados av){
        return (int) Math.round(this.getVelocidade() * 0.20 +
                this.getResistencia()*0.08 +
                this.getDestreza()*0.16 +
                this.getImpulsao()*0.10 +
                this.getJogo_cabeca()*0.16 +
                this.getRemate()*0.25 +
                this.getCapacidade_passe()*0.05);
    }





    public String toString() {
        return super.toString();
    }

    public Avancados clone() { return new Avancados(this); }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avancados avancados = (Avancados) o;
        return velocidade == avancados.velocidade &&
                resistencia == avancados.resistencia &&
                destreza == avancados.destreza &&
                impulsao == avancados.impulsao &&
                jogo_cabeca == avancados.jogo_cabeca &&
                remate == avancados.remate &&
                capacidade_passe == avancados.capacidade_passe &&
                Objects.equals(nome, avancados.nome);
    }


}
