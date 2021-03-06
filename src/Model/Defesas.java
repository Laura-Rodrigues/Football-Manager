package Model;

import java.util.Objects;
import java.util.Random;

public class Defesas extends Jogadores {

    private int corte;

    /*
     * CONSTRUTORES
     */

    public Defesas(){
        super();
        this.corte = 0;
    }

    public Defesas(String nome, int num,int velocidade, int resistencia, int destreza, int impulsao, int jogo_cabeca, int remate, int capacidade_passe
                    ,int corte){
        super(nome, num, velocidade, resistencia, destreza, impulsao, jogo_cabeca, remate, capacidade_passe,Jogadores.Class_jog.DEF);
        this.corte = corte;
    }

    public Defesas(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p,Jogadores.Class_jog.DEF);
        Random r = new Random();
        this.corte =  (int) (r.nextDouble() * 100);
    }

    public Defesas(Defesas def){
        super(def.getNome(), def.getNum_camisola(), def.getVelocidade(), def.getResistencia(), def.getDestreza(), def.getImpulsao(), def.getJogo_cabeca(), def.getRemate(), def.getCapacidade_passe());
        this.corte = def.getCorte();
    }

    public Defesas(Jogadores a){
        super(a);
        if (a.getClass() == getClass()){
            Defesas d = (Defesas) a;
            this.corte = d.getCorte();
        }
    }

    public Defesas(String nome){
        super.RandomizarJogador_No_Tipo();
        super.setNome(nome);
    }


    /*
     * PARSER
     */
    public  Defesas parse(String input){
        String[] campos = input.split(",");
        return new Defesas(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }

    /* GETTERS E SETTERS */
    public int getCorte() { return this.corte; }
    public void setCorte(int corte) { this.corte = corte; }

    /* Calcula a habilidade de um defesa priveligiando o corte */
    public int getHabilidade(){
        return (int) Math.round(this.getVelocidade() * 0.15 +
                this.getResistencia()*0.10 +
                this.getDestreza()*0.08 +
                this.getImpulsao()*0.15 +
                this.getJogo_cabeca()*0.12 +
                this.getRemate()*0.05 +
                this.getCapacidade_passe()*0.15 +
                this.getCorte()*0.20);
    }

    /* Randomiza par??metros que n??o aparecem no ficheiro logs */
    public void RandomizarExtra(int max,Random rand){
        this.corte = (int) (rand.nextFloat() * max);

    }

    /*
     * CLONE, EQUALS E TOSTRING
     */

    public StringBuilder toStringExtra(){
        StringBuilder sb = new StringBuilder();
        sb.append("Corte: ").append(this.getCorte()).append("\n");
        return sb;
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
                corte == defesas.corte &&
                Objects.equals(nome, defesas.nome);
    }


}
