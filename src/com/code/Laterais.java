package com.code;

import java.util.Objects;
import java.util.Random;

public class Laterais extends Jogadores {

    private int cruzamentos;

    public Laterais(){
        super();
        this.cruzamentos = 0;
    }

    public Laterais(String nome, int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe,
                    int cruzamentos){
        super(nome, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe);
        this.cruzamentos = cruzamentos;
    }

    public Laterais(Laterais l){
        super(l.getNome(), l.getVelocidade(), l.getResistencia(), l.getDestreza(), l.getImpulsao(), l.getJogo_cabeca(), l.getRemate(), l.getCapacidade_passe());
        this.cruzamentos = l.getCruzamentos();
    }
    public Laterais(String nome){
        super.RandomizarJogador_No_Tipo();
        super.setNome(nome);
    }

    public int getCruzamentos() { return this.cruzamentos; }
    public void setCruzamentos(int cruzamentos) { this.cruzamentos = cruzamentos; }

    public StringBuilder toStringExtra(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cruzamentos: ").append(this.getCruzamentos()).append("\n");
        return sb;
    }

    public int getHabilidade(){
        return (int) Math.round(this.getVelocidade() * 0.23 +
                this.getResistencia()*0.15 +
                this.getDestreza()*0.15 +
                this.getImpulsao()*0.05 +
                this.getJogo_cabeca()*0.06 +
                this.getRemate()*0.05 +
                this.getCapacidade_passe()*0.20 +
                this.getCruzamentos()*0.11 );
    }

    public void RandomizarExtra(int max,Random rand){
        this.cruzamentos = (int) (rand.nextFloat() * max);

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
                cruzamentos == laterais.cruzamentos &&
                Objects.equals(nome, laterais.nome);
    }

}