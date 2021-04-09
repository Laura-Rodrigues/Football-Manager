import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.List;


public class Equipa {
    // A habilidade global de uma equipa ́e função da habilidadede cada um dos jogadores.

    private ArrayList<Jogadores> jogadores;
    private ArrayList<Jogadores> plantel_Principal;
    private String nome_equipa;
    private int golos_marcados;
    private int golos_sofridos;
    private int vitorias;
    private int derrotas;
    private int empates;

    public Equipa(){
        jogadores = new ArrayList<Jogadores>();
        plantel_Principal = new ArrayList<Jogadores>();
        nome_equipa = "";
        golos_marcados = 0;
        golos_sofridos = 0;
        vitorias = 0;
        derrotas = 0;
        empates = 0;

    }

    public Equipa(ArrayList<Jogadores> jogadores,ArrayList<Jogadores> plantel_Principal,
                  String nome_equipa, int golos_marcados, int golos_sofridos,
                  int vitorias, int derrotas, int empates)
    {
        this.jogadores = jogadores;
        this.plantel_Principal = plantel_Principal;
        this.nome_equipa = nome_equipa;
        this.golos_marcados = golos_marcados;
        this.golos_sofridos = golos_sofridos;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }


    public boolean addJogador(Jogadores jog){
        int i=0;boolean r = true;
        for (;i<jogadores.size() && r ; i++)
        {
            if (jog.getTipo_jogador() == jogadores.get(i).getTipo_jogador() )
                r = false;
        }
        if (r)
        jogadores.add(jog);
        return r;
    }


    public void SortTeam(){
        /*List<Jogadores> players = new ArrayList<>();
        players.add(jogadores.get(0));
        players.add(jogadores.get(1));

         */

        if (jogadores.size() < 11)
        {

            Collections.sort(jogadores);
            System.out.println(jogadores);

        }



    }



    /**
     *
     * Nesta Função falta ser definido a variavel Habilidade na Class Jogadores

     public int getHabilidadeEquipa(){
        for (Jogadores jog : jogadores){
            r += jog.getHabilidade;
        }
        return r;
    }
     */







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


    public String toString() {
        return "Equipa{" +
                "jogadores=" + jogadores +
                ", plantel_Principal=" + plantel_Principal +
                ", nome_equipa='" + nome_equipa + '\'' +
                ", golos_marcados=" + golos_marcados +
                ", golos_sofridos=" + golos_sofridos +
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                '}';
    }

    //public int habilidadeEquipa(ArrayList<Guarda_Redes> grs)
}
