//package src;

import java.util.Objects;
import java.util.Random;

public class Avancados extends Jogadores {

    private int desmarcacao;

    public Avancados(){
        super();
        this.desmarcacao = 0;
    }

    

    //Construtor para funcionar com os stores
    public Avancados(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p,Jogadores.Class_jog.AVA);
        Random r = new Random();
        this.desmarcacao = (int) (r.nextDouble() * 100);
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


    /**
     * 
     * PARSER
     * @return
     */
    public  Jogadores parse(String input){
        String[] campos = input.split(",");
        return new Avancados(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
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
