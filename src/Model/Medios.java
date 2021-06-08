package Model;

import java.util.Objects;
import java.util.Random;

public class Medios extends Jogadores {

    private int visaoDeJogo;

    public Medios (){
        super();
        this.visaoDeJogo = 0;
    }


    public Medios(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int rec) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p,Jogadores.Class_jog.MED);
        this.visaoDeJogo = rec;
    }

    public Medios(Medios m){
        super(m.getNome(),m.getNum_camisola(), m.getVelocidade(), m.getResistencia(), m.getDestreza(), m.getImpulsao(),
         m.getJogo_cabeca(), m.getRemate(), m.getCapacidade_passe());
         this.visaoDeJogo = m.getVisaoDeJogo();
    }
    public Medios(Jogadores a){
        super(a);
        if (a.getClass() == getClass()){
        Medios d = (Medios) a;
        this.visaoDeJogo = d.getVisaoDeJogo();
        }
    }

    public Medios(String nome){
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
        return new Medios(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
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
