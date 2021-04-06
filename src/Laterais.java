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
