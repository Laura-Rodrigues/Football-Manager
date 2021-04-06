import java.util.Objects;

public class Defesas extends Jogadores {

    public Defesas(){
        super();
    }

    public Defesas(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
    }

    public Defesas(Defesas def){
        super(def.getNome(), def.getVelocidade(), def.getResistencia(), def.getDestreza(), def.getImpulsao(), def.getJogo_cabeca(), def.getRemate(), def.getCapacidade_passe());
    }

    public String toString() {
        return super.toString();
    }

    public Defesas clone() { return new Defesas(this); }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defesas defesas = (Defesas) o;
        return velocidade == defesas.velocidade &&
                resistencia == defesas.resistencia &&
                destreza == defesas.destreza &&
                impulsao == defesas.impulsao &&
                jogo_cabeca == defesas.jogo_cabeca &&
                remate == defesas.remate &&
                capacidade_passe == defesas.capacidade_passe &&
                Objects.equals(nome, defesas.nome);
    }


}
