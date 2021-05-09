
import java.sql.Date;
import java.util.Objects;
import java.util.Random;

import javax.swing.plaf.synth.SynthStyleFactory;
public class Jogo {
    enum game_state{
        Unplayed,
        Playing,
        Finished;
    }
    private Equipa equipa_casa;
    private Equipa equipa_fora;
    private int golos_casa;
    private int golos_fora;
    private game_state state;
    private Date data;

    public Jogo() {
        this.equipa_casa = new Equipa();
        this.equipa_fora = new Equipa();
        this.golos_casa = 0;
        this.golos_fora = 0;
        this.state = game_state.Unplayed;
        data = new Date(System.currentTimeMillis());

    }

    public Jogo(Equipa equipa_casa, Equipa equipa_fora, int golos_casa, int golos_fora, game_state state, Date data) {
        this.equipa_casa = equipa_casa;
        this.equipa_fora = equipa_fora;
        this.golos_casa = golos_casa;
        this.golos_fora = golos_fora;
        this.state = state;
        this.data = data;
    }

    public Jogo(Equipa equipa_casa, Equipa equipa_fora) {
        this.equipa_casa = equipa_casa;
        this.equipa_fora = equipa_fora;
        this.golos_casa = 0;
        this.golos_fora = 0;
        this.state = game_state.Unplayed;
        data = new Date(System.currentTimeMillis());
    }


    public boolean Startgame(){
        if (this.getState() == game_state.Unplayed){
            this.setState(game_state.Playing);
            return true;
        }
        else return false;
    }

    public void addGoalCasa(){
        equipa_casa.setGolos_marcados(equipa_casa.getGolos_marcados() + 1);
        equipa_fora.setGolos_sofridos(equipa_fora.getGolos_sofridos() + 1);
        this.golos_casa++;
        //Buscar um avancado;

    }

    public void addGoalFora(){
        equipa_fora.setGolos_marcados(equipa_fora.getGolos_marcados() + 1);
        equipa_casa.setGolos_sofridos(equipa_casa.getGolos_sofridos() + 1);
        this.golos_fora++;
    }



    public double SkillDisparity(){
       int valor_1 = equipa_casa.getHabilidadeEquipa();
       int valor_2 = equipa_fora.getHabilidadeEquipa();
       int max;
       int min;

       if (valor_1 > valor_2){
           max = valor_1;
           min = valor_2;
       }
       else{
           max = valor_2;
           min= valor_1;
       }

       double gap = (max/ (double) min)*2;

       Random r = new Random();
       double chance_min =  (r.nextDouble() * 0.1) + 0.01;
       double chance_max = chance_min * gap;
       System.out.println(chance_max);
       System.out.println(chance_min);


       return chance_min;


    }

    public int bestTeam(){
        int valor_1 = equipa_casa.getHabilidadeEquipa();
       int valor_2 = equipa_fora.getHabilidadeEquipa();
       if (valor_1 > valor_2 ) return 1;
       else return 2;
    }
    
    public void Simulate(){

        // for (int i = 0; i < 100; i++) {
        //     try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
        //     addGoalCasa();
        //     printGame();
             
        // }
        int valor_1 = equipa_casa.getHabilidadeEquipa();
        int valor_2 = equipa_fora.getHabilidadeEquipa();
        double chance_min;//Entre 0 e 1
        double chance_max;// Entre 0 e 1
        if ( bestTeam() == 1)
        {
            //Se a melhor equipa for a Casa
            double gap = (valor_1/ (double) valor_2)*2;
            Random r = new Random();
             chance_min =  (r.nextDouble() * 0.1) + 0.01;
             chance_max = chance_min * gap;
        }
        else
        {
            //Se a melhor equipa for Fora
            double gap = (valor_2/ (double) valor_1)*2;
            Random r = new Random();
            chance_min =  (r.nextDouble() * 0.2) + 0.01;
            chance_max = chance_min * gap;
        }
        Random t = new Random();
        System.out.println(valor_1);
        System.out.println(valor_2);
        System.out.println(chance_min);
        System.out.println(chance_max);
        for (int i = 0; i < 10; i++) {
            double tentativa =  t.nextDouble();// Devolve entre 0 e 1
            if (tentativa < chance_min) 
            {
                if (bestTeam() == 1)
                addGoalFora();
                else addGoalCasa();
            }
            else if (tentativa > chance_min && tentativa < chance_max)
            {
                if (bestTeam() == 1)
                addGoalCasa();
                else addGoalFora();
            } 
        }
        printGame();
    }
    /**
     * 
     * 
     * Getters and Setters
     * 
     */

    public Equipa getEquipa_casa() {
        return this.equipa_casa;
    }

    public void setEquipa_casa(Equipa equipa_casa) {
        this.equipa_casa = equipa_casa;
    }

    public Equipa getEquipa_fora() {
        return this.equipa_fora;
    }

    public void setEquipa_fora(Equipa equipa_fora) {
        this.equipa_fora = equipa_fora;
    }

    public int getGolos_casa() {
        return this.golos_casa;
    }

    public void setGolos_casa(int golos_casa) {
        this.golos_casa = golos_casa;
    }

    public int getGolos_fora() {
        return this.golos_fora;
    }

    public void setGolos_fora(int golos_fora) {
        this.golos_fora = golos_fora;
    }

    public game_state getState() {
        return this.state;
    }

    public void setState(game_state state) {
        this.state = state;
    }

    public void equipa_casa(Equipa equipa_casa) {
        setEquipa_casa(equipa_casa);
    }

    public void equipa_fora(Equipa equipa_fora) {
        setEquipa_fora(equipa_fora);
    }

    public void golos_casa(int golos_casa) {
        setGolos_casa(golos_casa);
    }

    public void golos_fora(int golos_fora) {
        setGolos_fora(golos_fora);
    }

    public void state(game_state state) {
        setState(state);
    }


    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Jogo)) {
            return false;
        }
        Jogo jogo = (Jogo) o;
        return Objects.equals(equipa_casa, jogo.equipa_casa)
        && Objects.equals(equipa_fora, jogo.equipa_fora)
        && golos_casa == jogo.golos_casa
        && golos_fora == jogo.golos_fora
        && Objects.equals(state, jogo.state)
        && data.equals(jogo.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipa_casa, equipa_fora, golos_casa, golos_fora, state,data);
    }


    public void printGame(){
        StringBuilder sb = new StringBuilder();
        sb.append(equipa_casa.getNome_equipa()).append(" ").append(golos_casa);
        sb.append(" - ").append(golos_fora).append(" ").append(equipa_fora.getNome_equipa());
        System.out.println( sb.toString());
    }
    @Override
    public String toString() {
        return "{" +
            " equipa_casa='" + getEquipa_casa() + "'" +
            ", equipa_fora='" + getEquipa_fora() + "'" +
            ", golos_casa='" + getGolos_casa() + "'" +
            ", golos_fora='" + getGolos_fora() + "'" +
            ", state='" + getState() + "'" +
            ", Data = " + getData() +
            "}";
    }

}
