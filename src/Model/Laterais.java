package Model;

import java.util.Objects;
import java.util.Random;

public class Laterais extends Jogadores {

    private int cruzamentos;

    public Laterais(){
        super();
        this.cruzamentos = 0;
    }

    //Construtor para funcionar com o codigo dos professores
    public Laterais(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruz) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p,Jogadores.Class_jog.LAT);
       this.cruzamentos = cruz;
    }

    public Laterais(Laterais l){
        super(l.getNome(),l.getNum_camisola(), l.getVelocidade(), l.getResistencia(), l.getDestreza(), l.getImpulsao(), l.getJogo_cabeca(), l.getRemate(), l.getCapacidade_passe());
        this.cruzamentos = l.getCruzamentos();
    }

    public Laterais(Jogadores a){
        super(a);
        if (a.getClass() == getClass()) {
        Laterais d = (Laterais) a;
        this.cruzamentos = d.getCruzamentos();
        }
    }

    public Laterais(String nome){
        super.RandomizarJogador_No_Tipo();
        super.setNome(nome);
    }


    /**
     * 
     * 
     * PARSER
     * @return
     */
    public  Jogadores parse(String input){
        String[] campos = input.split(",");
        return new Laterais(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
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