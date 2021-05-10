//package src;

import java.util.Objects;
import java.util.Random;

public class Avancados extends Jogadores {

    private int desmarcacao;

    public Avancados(){
        super();
        this.desmarcacao = 0;
    }

    public Avancados(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe
                    , int desmarcacao){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
        this.desmarcacao = desmarcacao;
    }
    public Avancados(String nome){
        super.RandomizarJogador_No_Tipo();
        super.setNome(nome);
    }

    public Avancados(Avancados a){
        super(a.getNome(), a.getVelocidade(), a.getResistencia(), a.getDestreza(), a.getImpulsao(), a.getJogo_cabeca(), a.getRemate(), a.getCapacidade_passe());
        this.desmarcacao = a.getDesmarcacao();
    }
    public Avancados(Jogadores a){
        super(a);
        if (a.getClass() == getClass()) {
        Avancados avancados = (Avancados) a;
        this.desmarcacao = avancados.getDesmarcacao();
        }
    }

    public int getDesmarcacao() { return this.desmarcacao; }
    public void setDesmarcacao(int desmarcacao) { this.desmarcacao = desmarcacao; }


    public int getHabilidade(){
        return (int) Math.round(this.getVelocidade() * 0.20 +
                this.getResistencia()*0.08 +
                this.getDestreza()*0.10 +
                this.getImpulsao()*0.10 +
                this.getJogo_cabeca()*0.15 +
                this.getRemate()*0.21 +
                this.getCapacidade_passe()*0.05 +
                this.getDesmarcacao()*0.15);
    }




    public StringBuilder toStringExtra(){
        StringBuilder sb = new StringBuilder();
        sb.append("Desmarcação: ").append(this.getDesmarcacao()).append("\n");
        return sb;
    }

    public void RandomizarExtra(int max,Random rand){
        this.desmarcacao = (int) (rand.nextFloat() * max);

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
                desmarcacao == avancados.desmarcacao &&
                Objects.equals(nome, avancados.nome);
    }


}
