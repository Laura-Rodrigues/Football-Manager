//package com.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Equipa {
    // A habilidade global de uma equipa ́e função da habilidadede cada um dos jogadores.

    private ArrayList<Jogadores> jogadores;
    private ArrayList<Jogadores> plantel_Principal;
    private String nome_equipa;
    //1->GRD 2->DEF 3->LAT 4->MED 5->AVA
    private int []plantel_array = new int[5];
    private int golos_marcados;
    private int golos_sofridos;
    private int vitorias;
    private int derrotas;
    private int empates;

    public Equipa(){
        jogadores = new ArrayList<Jogadores>();
        plantel_Principal = new ArrayList<Jogadores>();
        nome_equipa = "";
        setplantel_array();
        golos_marcados = 0;
        golos_sofridos = 0;
        vitorias = 0;
        derrotas = 0;
        empates = 0;

    }
    public Equipa(String nomeE) {
        nome_equipa = nomeE;
        jogadores = new ArrayList<Jogadores>();
        plantel_Principal = new ArrayList<Jogadores>();
        setplantel_array();
        golos_marcados = 0;
        golos_sofridos = 0;
        vitorias = 0;
        derrotas = 0;
        empates = 0;
    }    

    public Equipa(ArrayList<Jogadores> jogadores1,
                  String nome_equipa, int golos_marcados, int golos_sofridos,
                  int vitorias, int derrotas, int empates, int array[])
    {
        this.nome_equipa = nome_equipa;
        this.jogadores = new ArrayList<Jogadores>();
        for (Jogadores j : jogadores1) {
            addJogador(j);
        }
        this.plantel_Principal = new ArrayList<Jogadores>();
        this.golos_marcados = golos_marcados;
        this.golos_sofridos = golos_sofridos;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        setplantel_array(array[1], array[2], array[3], array[4]);
       
    }



    /**
     * 
     * 
     * PARSER
     * @param j
     */
    public void insereJogador(Jogadores j) {
        jogadores.add(j);
        j.addEquipa(nome_equipa);
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void addJogador(Jogadores j){
        jogadores.add(j);
        j.addEquipa(nome_equipa);
    }



   


    public void SortTeam(){
        
        Collections.sort(jogadores);
        
    }

    //Função Principal para Preencher o Array List com os melhores Jogadores
    public void makeBestTeam(){
    SortTeam();
    int []array = new int[]{0,0,0,0,0};
    int max = jogadores.size();
    int pos =0;
    while(pos < max && plantel_Principal.size() < 11)
    {
        Jogadores.Class_jog tipo = jogadores.get(pos).getTipo_jogador();
        boolean insert=true;
        switch(tipo){
            case GRD:
                array[0]++;
                if (array[0]>plantel_array[0]) insert = false;
                break;
            case DEF:
                array[1]++;
                if (array[1]>plantel_array[1]) insert = false;
                break;
            case LAT:
                array[2]++;
                if (array[2]>plantel_array[2]) insert = false;
                break;
            case MED:
                array[3]++;
                if (array[3]>plantel_array[3]) insert = false;
                break;
            default:
                array[4]++;
                if (array[4]>plantel_array[4]) insert = false;
                break;
        }
        if (insert)
        {
            plantel_Principal.add(jogadores.get(pos));
        }
        pos++;
    }
}

    public int getHabilidadeEquipa(){
    int r=0;
    for (Jogadores jog : plantel_Principal){
            r += jog.getHabilidade();
    }
    return r;
    }
     

    public boolean existPlayer(Jogadores j){
        for (Jogadores jogadores2 : jogadores) {
            if (j.equals(jogadores2)){
                return  true;   
            }
        }
        return false;
    }

    //Troca um jogador de equipa,
    //Se existe nesta equipa entao é removido e só depois é que é inserido

    public void changeTeam(Jogadores j,Equipa e1){
        boolean remove1 = false;
        boolean remove2 = false;
        for (Jogadores jogadores2 : jogadores) {
            if (j.equals(jogadores2)){
                remove1 = true;   
            }
        }
        for (Jogadores jogadores3 : plantel_Principal) {
            if (j.equals(jogadores3))
            {
                remove2= true;
            }
        }
        if (remove1) jogadores.remove(j);
        if (remove2) {
            plantel_Principal.remove(j);
            makeBestTeam();
        }

        e1.addJogador(j);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipa)) return false;
        Equipa equipa = (Equipa) o;
        return golos_marcados == equipa.golos_marcados &&
                golos_sofridos == equipa.golos_sofridos &&
                vitorias == equipa.vitorias &&
                derrotas == equipa.derrotas &&
                empates == equipa.empates &&
                Objects.equals(jogadores, equipa.jogadores) &&
                Objects.equals(plantel_Principal, equipa.plantel_Principal) &&
                Objects.equals(nome_equipa, equipa.nome_equipa);
    }



    /**
     *
     * GETTERS AND SETTERS
     *
     */


    public ArrayList<Jogadores> getPlantel_Principal() {
        return plantel_Principal;
    }

    public void setPlantel_Principal(ArrayList<Jogadores> plantel_Principal) {
        this.plantel_Principal = plantel_Principal;
    }
    public ArrayList<Jogadores> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogadores> jogadores) {
        this.jogadores = jogadores;
    }

    public String getNome_equipa() {
        return nome_equipa;
    }

    public void setNome_equipa(String nome_equipa) {
        this.nome_equipa = nome_equipa;
    }

    public int getGolos_marcados() {
        return golos_marcados;
    }

    public void setGolos_marcados(int golos_marcados) {
        this.golos_marcados = golos_marcados;
    }

    public int getGolos_sofridos() {
        return golos_sofridos;
    }

    public void setGolos_sofridos(int golos_sofridos) {
        this.golos_sofridos = golos_sofridos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }


    public int[] getplantel_array(){
        return this.plantel_array;
    }
    public void setplantel_array(){
        this.plantel_array[0] = 1;
        this.plantel_array[1] = 3;
        this.plantel_array[2] = 3;
        this.plantel_array[3] = 3;
        this.plantel_array[4] = 1;

    }
    public void setplantel_array(int def,int lat,int med,int ava){
        this.plantel_array[0] = 1;
        this.plantel_array[1] = def;
        this.plantel_array[2] = lat;
        this.plantel_array[3] = med;
        this.plantel_array[4] = ava;
    }
    public void dumpTeamTotal(){
        System.out.println(jogadores);
    }

    public void dumpTeamPrincipal(){
        System.out.println(plantel_Principal);
    }


    public StringBuilder print_Spaces(int tamanho,String array){
        StringBuilder sb = new StringBuilder();
        int offset = (tamanho - array.length()) / 2;
        for (int i = 0; i < offset; i++)
        {
            sb.append(" ");
        }
        sb.append(array);
        for (int i = 0; i < offset; i++)
        {
            sb.append(" ");
        }
        if (((tamanho -array.length()) % 2) == 1) sb.append(" ");

        return sb;
    }


    //Esta função só imprime jogadores do plantelPrincipal
    public StringBuilder jogadores2String(){
        int size_j = 30;
        int size_p = 15;
        int size_h = 15;
        int size_tracos = size_h + size_p + size_j + 4;

        StringBuilder sb = new StringBuilder();
        sb.append(makeBox(size_tracos));
            sb.append("|").append(print_Spaces(size_j,"JOGADORES"));
            sb.append("|").append(print_Spaces(size_p,"POSICAO"));
            sb.append("|").append(print_Spaces(size_h,"HABILIDADE")).append("|").append("\n");

        
        for (Jogadores jogadores2 : plantel_Principal) {
            String t = jogadores2.tipo_jogador_toString(jogadores2.getTipo_jogador());
            Integer i = jogadores2.getHabilidade();
            
            sb.append(makeBox(size_tracos));
            sb.append("|").append(print_Spaces(size_j,jogadores2.getNome()));
            sb.append("|").append(print_Spaces(size_p,t));
            sb.append("|").append(print_Spaces(size_h,i.toString())).append("|").append("\n");
        }
        sb.append(makeBox(size_tracos));

        
        return sb;
    }
    public StringBuilder makeBox(int start_size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start_size; i++) {
            sb.append("-");
        }
        sb.append("\n");
        return sb;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(makeBox(64));
        sb.append(print_Spaces(64,nome_equipa.toUpperCase())).append("\n");
        sb.append(jogadores2String());
        sb.append("\nGolos Marcados : ").append(golos_marcados);
        sb.append(" Golos Sofridos : ").append(golos_sofridos).append("\n");
        sb.append("V : ").append(vitorias).append(" D : ").append(derrotas).append(" E : ").append(empates).append("\n");
        sb.append("Tática : ");
        for(int i=0;i<plantel_array.length;i++)
        {
            sb.append(plantel_array[i]).append(" ");
        }
        sb.append("\n");
        return sb.toString();
       
    }

}
