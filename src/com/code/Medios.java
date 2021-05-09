//package com.code;

import java.util.Objects;
import java.util.Random;

public class Medios extends Jogadores {

    private int visaoDeJogo;

    public Medios (){
        super();
        this.visaoDeJogo = 0;
    }

    public Medios(String nome, int velocidade, int resistencia,
     int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe, int visao_jogo){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
        this.visaoDeJogo = visao_jogo;
    }

    public Medios(Medios m){
        super(m.getNome(), m.getVelocidade(), m.getResistencia(), m.getDestreza(), m.getImpulsao(),
         m.getJogo_cabeca(), m.getRemate(), m.getCapacidade_passe());
         this.visaoDeJogo = m.getVisaoDeJogo();
    }
    public Medios(Jogadores a){
        super(a);
        if (a.getClass() != getClass()) return;
        else{
        Medios d = (Medios) a;
        this.visaoDeJogo = d.getVisaoDeJogo();
        }
    }

    public Medios(String nome){
        super.RandomizarJogador_No_Tipo();
        super.setNome(nome);
    }

    public int getVisaoDeJogo() { return this.visaoDeJogo; }
    public void setVisaoDeJogo(int visao_jogo) { this.visaoDeJogo = visao_jogo; }

    public int getHabilidade (){
        return (int) Math.round(this.getVelocidade() * 0.15 +
                this.getResistencia()*0.15 +
                this.getDestreza()*0.07 +
                this.getImpulsao()*0.05 +
                this.getJogo_cabeca()*0.05 +
                this.getRemate()*0.13 +
                this.getCapacidade_passe()*0.15 +
                this.getVisaoDeJogo()*0.25 );
    }

    public StringBuilder toStringExtra(){
        StringBuilder sb = new StringBuilder();
        sb.append("Visao de Jogo: ").append(this.getVisaoDeJogo()).append("\n");
        return sb;
    }


    public void RandomizarExtra(int max,Random rand){
        this.visaoDeJogo = (int) (rand.nextFloat() * max);

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
                visaoDeJogo == medios.visaoDeJogo &&
                Objects.equals(nome, medios.nome);
    }


}
