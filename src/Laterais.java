import java.util.Objects;

public class Laterais extends Jogadores {

    public Laterais(){
        super();
    }

    public Laterais(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
    }

    public Laterais(Laterais l){
        super(l.getNome(), l.getVelocidade(), l.getResistencia(), l.getDestreza(), l.getImpulsao(), l.getJogo_cabeca(), l.getRemate(), l.getCapacidade_passe());
    }

    public String toString() {
        return super.toString();
    }

    public int habilidadeLat (Laterais lat){
        return (int) Math.round(this.getVelocidade() * 0.23 +
                this.getResistencia()*0.18 +
                this.getDestreza()*0.15 +
                this.getImpulsao()*0.08 +
                this.getJogo_cabeca()*0.06 +
                this.getRemate()*0.08 +
                this.getCapacidade_passe()*0.22);
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
