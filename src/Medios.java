import java.util.Objects;

public class Medios extends Jogadores{

    public Medios (){
        super();
    }

    public Medios(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
    }

    public Medios(Medios m){
        super(m.getNome(), m.getVelocidade(), m.getResistencia(), m.getDestreza(), m.getImpulsao(), m.getJogo_cabeca(), m.getRemate(), m.getCapacidade_passe());
    }

    public int habilidadeMed (Medios med){
        return (int) Math.round(this.getVelocidade() * 0.15 +
                this.getResistencia()*0.20 +
                this.getDestreza()*0.20 +
                this.getImpulsao()*0.05 +
                this.getJogo_cabeca()*0.05 +
                this.getRemate()*0.15 +
                this.getCapacidade_passe()*0.20);
    }




    public String toString() {
        return super.toString();
    }

    public Medios clone() { return new Medios(this); }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medios medios = (Medios) o;
        return velocidade == medios.velocidade &&
                resistencia == medios.resistencia &&
                destreza == medios.destreza &&
                impulsao == medios.impulsao &&
                jogo_cabeca == medios.jogo_cabeca &&
                remate == medios.remate &&
                capacidade_passe == medios.capacidade_passe &&
                Objects.equals(nome, medios.nome);
    }


}
