package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import Model.Jogadores.Class_jog;


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
            j.addEquipa(nome_equipa);
            insereJogador(j);
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
       // j.addEquipa(nome_equipa);
    }


    public Jogadores randomJogador()
    {
       Random r = new Random();
       int r_jog = (int)  (r.nextDouble() * getPlantel_Principal().size());
       return getPlantel_Principal().get(r_jog);
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
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
    int tipo_num;
    while(pos < max && plantel_Principal.size() < 11)
    {
        Jogadores.Class_jog tipo = jogadores.get(pos).getTipo_jogador();
        switch(tipo){
            case GRD:
                tipo_num=0;
                break;
            case DEF:
                tipo_num=1;
                break;
            case LAT:
                tipo_num=2;
                break;
            case MED:
                tipo_num=3;
                break;
            default:
                tipo_num=4;
                break;
        }

        array[tipo_num]++;
        //Se for possivel inserir essa Posicao no plantel
        if (array[tipo_num]> plantel_array[tipo_num]) break;
    
        plantel_Principal.add(jogadores.get(pos).clone());
        pos++;
    }

    while(plantel_Principal.size() < 11)
    {
        //Caso o plantel nao tenha 11 jogadores
        int min=1;
        int i;
        Jogadores.Class_jog tipo2;
        for (i = 2; i < array.length; i++) {
            if(array[min] < array[i])
            min = i;
        }
        switch(min)
        {
            case 1:
            tipo2 = Class_jog.DEF;
            case 2:
            tipo2 = Class_jog.LAT;
            case 3:
            tipo2 = Class_jog.MED;
            default:
            tipo2 = Class_jog.AVA;
        }
        for (Jogadores j : jogadores) {
            if (j.getTipo_jogador() == tipo2 && !plantel_Principal.contains(j) )
            {
                plantel_Principal.add(j.clone());
                break;
            }
        }
        array[min]++;
    }
    
    //Muda a configuracao do array para a desejada
    setplantel_array(array[1],array[2],array[3],array[4]);
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
        j.addEquipa(e1.getNome_equipa());
        e1.insereJogador(j);
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


    public static StringBuilder print_Spaces(int tamanho,String array){
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

    public static  StringBuilder makeBox(int start_size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start_size; i++) {
            sb.append("-");
        }
        sb.append("\n");
        return sb;
    }

    //Esta função só imprime jogadores do plantelPrincipal
    public StringBuilder jogadores2String(){
        int size_j = 50;
        int size_p = 15;
        int size_h = 15;
        int size_tracos = size_h + size_p + size_j + 4;

        StringBuilder sb = new StringBuilder();
        sb.append(makeBox(size_tracos));
            sb.append("|").append(print_Spaces(size_j,"JOGADORES"));
            sb.append("|").append(print_Spaces(size_p,"POSICAO"));
            sb.append("|").append(print_Spaces(size_h,"HABILIDADE")).append("|").append("\n");

        
        for (Jogadores jogadores2 : jogadores) {
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
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(makeBox(84));
        sb.append(print_Spaces(84,nome_equipa.toUpperCase())).append("\n");
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

    public StringBuilder sb_short(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(print_Spaces(85,nome_equipa.toUpperCase())).append("\n");
        sb.append(makeBox(88));


        for (Jogadores jog : jogadores) {
            String t = jog.tipo_jogador_toString(jog.getTipo_jogador());

            sb.append("|").append(print_Spaces(70,jog.getNome()));
            sb.append("|").append(print_Spaces(15,t)).append("|\n");
        }
        sb.append(makeBox(88));
        Integer i = this.getHabilidadeEquipa();
        sb.append("\tHABILIDADE EQUIPA: ").append(i).append("\n");
        sb.append(makeBox(88));

        return sb;

    }

}
