package Model.Game;

import java.sql.Date;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import Model.Equipa;
import Model.Jogadores;
import Model.Exceptions.InvalidExcepction;
import Model.Jogadores.Class_jog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


//Esta class consegue Simular um jogo entre 2 equipas
//No final do jogo estar calculado, pode ser convertida para a Class JogoFeito

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
    public final boolean enable_Mensagens = false;
    private final int tentativas_remate = 10;
    private final double minima_chance_golo = 0.2;
    private final int intervalo_mensagens = 2000;
  

    //Substituir um jogador aleatorio por um com uma posicao correspondente
    public void Substitute(Equipa e1)
    {
        boolean found = false;
        while(!found)
        {
            Random r = new Random();
            int num_fora = r.nextInt(11);//vai de 0 a 10 aleatoriamente
            Jogadores j1 =  e1.getPlantel_Principal().get(num_fora);
            Jogadores.Class_jog tipo =  j1.getTipo_jogador();
    
            List<Jogadores> j_substituiveis = e1.getJogadores().stream().filter(s -> s.getTipo_jogador() == tipo &&
                                             !e1.getPlantel_Principal().contains(s)).
                                             collect(Collectors.toList());
            
            if(j_substituiveis.size() == 0 ) continue;
            int num_entra = r.nextInt(j_substituiveis.size());

            e1.getPlantel_Principal().remove(j1);
            e1.getPlantel_Principal().add(j_substituiveis.get(num_entra));

            found = true;
        }
    }

    //Substitui se possivel os jogadores
    public void Substitute(Equipa e1,int num_entra,int num_fora) throws InvalidExcepction
    {
        boolean found1 = false,found2 = false;
        for (int i = 0; i < e1.getPlantel_Principal().size() && !found1; i++) {
           Jogadores j1 = e1.getPlantel_Principal().get(i);
           //Encontrado o jogador correspondente
           if (j1.getNum_camisola() == num_fora)
            {
                e1.getPlantel_Principal().remove(j1);
                found1 = true;
            }
        }
        //Se nao existir o jogador entao não há substituicao
        if (!found1)
        throw new InvalidExcepction(" Substituicao não realizada,Jogador a sair nao existe\n");


        for (int i = 0; i < e1.getJogadores().size() && !found2; i++) {
            Jogadores j2 = e1.getJogadores().get(i);
            //Encontrado o jogador para entrar e ele nao pertence à equipa principal
            if (j2.getNum_camisola() == num_entra && !e1.getPlantel_Principal().contains(j2) )
             {

                 e1.getPlantel_Principal().add(j2);
                 found2 = true;
             }
         }
         //Caso nao tenha sido encontrado um substituito adequado
         //É substituido o primeiro jogador disponivel
         if(!found2)
         {
             for (Jogadores j3 : e1.getJogadores()) {
                 if (!e1.getPlantel_Principal().contains(j3))
                 {
                     e1.getPlantel_Principal().add(j3);
                     break;
                 }
             }
             throw new InvalidExcepction(" Jogador substituido por um aleatorio disponivel\n");
         }
  

    }

    public boolean Startgame(){
        if (this.getState() == game_state.Unplayed){
            this.setState(game_state.Playing);
            return true;
        }
        else if(this.getState() == game_state.Playing)
        {
            return true;
        }
        else {
            System.out.println("Jogo já foi jogado");
            return false;
        }
    }

    public void addGoalCasa(){
        if(enable_Mensagens){
        try{Thread.sleep(intervalo_mensagens);}catch(InterruptedException e){System.out.println(e);}
        System.out.println("Golo da Casa Caralhoooo");
        }
        equipa_casa.setGolos_marcados(equipa_casa.getGolos_marcados() + 1);
        equipa_fora.setGolos_sofridos(equipa_fora.getGolos_sofridos() + 1);
        this.golos_casa++;
        //Buscar um avancado;

    }

    public void addGoalFora(){
        if(enable_Mensagens){
        try{Thread.sleep(intervalo_mensagens);}catch(InterruptedException e){System.out.println(e);} 
        System.out.println("Golo Fora man");
        }
        equipa_fora.setGolos_marcados(equipa_fora.getGolos_marcados() + 1);
        equipa_casa.setGolos_sofridos(equipa_casa.getGolos_sofridos() + 1);
        this.golos_fora++;
    }

    public String mensagemTriste(Equipa e1,Equipa e2)
    {
        Random r = new Random();
        int next = r.nextInt(3);

        switch (next)
        {
            default:
            System.out.println(e2.getNome_equipa());
               List<Jogadores> aqui = e2.getPlantel_Principal().stream().filter(s -> s.getTipo_jogador() == Jogadores.Class_jog.GRD).collect(Collectors.toList());
                return " rematou para a baliza mas " + aqui.get(0).getNome() + " defendeu" ;
            case 5:
                return " quase que enquadrava o remate,mas foi ao lado";
            case 10:
                return " atirou com demasiada força";
        }
    }

    public void print_jogada_Falhada(){
        Random r = new Random();
        Equipa e1 = getEquipa_casa();
        Equipa e2 = getEquipa_fora();

        if (r.nextInt(2) == 0){e1 = getEquipa_fora(); e2 = getEquipa_casa();}

        System.out.print(e1.randomJogador().getNome() +
        mensagemTriste(e1,e2) + "\n\n");

       
        try{Thread.sleep(intervalo_mensagens);}catch(InterruptedException e){System.out.println(e);}

    }


    public int bestTeam(){
        int valor_1 = equipa_casa.getHabilidadeEquipa();
       int valor_2 = equipa_fora.getHabilidadeEquipa();
       if (valor_1 > valor_2 ) return 1;
       else return 2;
    }
    
    public void Simulate(){
        //Inicializar o jogo
        if ( !Startgame())
        return;

        if(enable_Mensagens){
        System.out.println("Jogo entre " + equipa_casa.getNome_equipa() + " e "
                             + equipa_fora.getNome_equipa() + " prestes a começar...");
        try{Thread.sleep(intervalo_mensagens);}catch(InterruptedException e){System.out.println(e);}
        }
        int valor_1 = equipa_casa.getHabilidadeEquipa();
        int valor_2 = equipa_fora.getHabilidadeEquipa();
        double chance_min;//Entre 0 e 1
        double chance_max;// Entre 0 e 1

        
        
        //Se a melhor equipa for Fora
        double gap = ((bestTeam() == 1) ? (valor_1/ (double) valor_2) : (valor_2/ (double) valor_1) ) *2;
            
        Random r = new Random();
        chance_min =  (r.nextDouble() * minima_chance_golo) + 0.01;
        chance_max = chance_min * gap;
    
        for (int i = 0; i < tentativas_remate; i++) {
            double tentativa =  r.nextDouble();// Devolve entre 0 e 1
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
            else if (enable_Mensagens)
            print_jogada_Falhada();
            
        }
        printGame();

        this.setState(game_state.Finished);

    }

    /**
     * 
     * Construtores
     * 
     */
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

    /**
     * 
     * 
     * Getters and Setters
     * 
     */
    public Equipa getEquipa_casa() {return this.equipa_casa;}
    public void setEquipa_casa(Equipa equipa_casa) {this.equipa_casa = equipa_casa;}
    public Equipa getEquipa_fora() {return this.equipa_fora;}
    public void setEquipa_fora(Equipa equipa_fora) {this.equipa_fora = equipa_fora;}
    public int getGolos_casa() {return this.golos_casa;}
    public void setGolos_casa(int golos_casa) {this.golos_casa = golos_casa;}
    public int getGolos_fora() {return this.golos_fora;}
    public void setGolos_fora(int golos_fora) {this.golos_fora = golos_fora;}
    public game_state getState() {return this.state;}
    public void setState(game_state state) {this.state = state;}
    public Date getData() {return this.data;}
    public void setData(Date data) {this.data = data;}
    

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