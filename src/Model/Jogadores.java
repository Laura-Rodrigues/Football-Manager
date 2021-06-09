package Model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.Random;

public abstract class Jogadores implements Comparable<Jogadores> {



    public enum Class_jog{
        GRD,LAT,AVA,DEF,MED;
    }

    protected String nome;
    protected int num_camisola;
   //                          limitar valores de 0 - 100:
    protected int velocidade;
    protected int resistencia;
    protected int destreza;
    protected int impulsao;
    protected int jogo_cabeca;
    protected int remate;
    protected int capacidade_passe;
   
    protected Class_jog tipo_jogador;
    protected ArrayList<String> equipa_List;

   

  
    public abstract int getHabilidade();
    public abstract StringBuilder toStringExtra();
    public abstract void RandomizarExtra(int max,Random rand);
    public abstract Jogadores parse(String s);

    public Jogadores(){
        this.nome = "";
        define_class_jog();
        RandomizarJogador_No_Tipo();
        equipa_List = new ArrayList<String>();
    }

    public Jogadores(String nome, int velocidade, int resistencia, int destreza,
                     int impulsao, int jogo_cabeca, int remate,
                     int capacidade_passe, Class_jog tipo_jogador){
        this.nome = nome;
        this.num_camisola = -1;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeca = jogo_cabeca;
        this.remate = remate;
        this.capacidade_passe = capacidade_passe;
        this.tipo_jogador = tipo_jogador;
        equipa_List = new ArrayList<String>();
    }

    
    public Jogadores(String nome,int num_camisola, int velocidade, int resistencia, int destreza,
                    int impulsao, int jogo_cabeca, int remate,
                    int capacidade_passe, Class_jog tipo_jogador)
{
        this.nome = nome;
        this.num_camisola = num_camisola;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeca = jogo_cabeca;
        this.remate = remate;
        this.capacidade_passe = capacidade_passe;
        this.tipo_jogador = tipo_jogador;
        equipa_List = new ArrayList<String>();
}

    

    /*
    Construtor para o menu
     */
    public Jogadores(String nome, int num, int velocidade, int resistencia, int destreza,
                     int impulsao, int jogo_cabeca, int remate, int capacidade_passe){
        this.nome = nome;
        this.num_camisola = num;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeca = jogo_cabeca;
        this.remate = remate;
        this.capacidade_passe = capacidade_passe;
        define_class_jog();
        equipa_List = new ArrayList<String>();

    }

    public Jogadores(Jogadores j){
        this.nome = j.getNome();
        this.num_camisola = j.getNum_camisola();
        this.velocidade = j.getVelocidade();
        this.resistencia = j.getResistencia();
        this.destreza = j.getDestreza();
        this.impulsao = j.getImpulsao();
        this.jogo_cabeca = j.getJogo_cabeca();
        this.remate = j.getRemate();
        this.capacidade_passe = j.getCapacidade_passe();
        this.tipo_jogador = j.getTipo_jogador();
        define_class_jog();
        equipa_List = new ArrayList<String>();

    }

    public Jogadores(String nome,Class_jog tipo){
        RandomizarJogador_No_Tipo();
        this.nome= nome;
        this.tipo_jogador = tipo;
    }



    public void addEquipa(String equipa1){
        
        equipa_List.add(equipa1);
    }

    public void RandomizarJogador_No_Tipo(){
        Random rand = new Random();
        int max = 100;
        this.num_camisola = (int) (rand.nextFloat() * max);
        this.velocidade = (int)  (rand.nextFloat() * max);
        this.resistencia = (int)  (rand.nextFloat() * max);
        this.destreza = (int) (rand.nextFloat() * max);
        this.impulsao = (int) (rand.nextFloat() * max);
        this.jogo_cabeca = (int) (rand.nextFloat() * max);
        this.remate = (int) (rand.nextFloat() * max);
        this.capacidade_passe = (int) (rand.nextFloat() * max);
        RandomizarExtra(max,rand);

    }


    public void define_class_jog(){
        Class c = this.getClass();
        if      (c == Medios.class)         this.tipo_jogador = Jogadores.Class_jog.MED;
        else if (c == Avancados.class)      this.tipo_jogador = Jogadores.Class_jog.AVA;
        else if (c == Guarda_Redes.class)   this.tipo_jogador = Jogadores.Class_jog.GRD;
        else if (c == Defesas.class)        this.tipo_jogador = Jogadores.Class_jog.DEF;
        else                                this.tipo_jogador = Jogadores.Class_jog.LAT;
    }


    // GETTERS E SETTERS
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }


    public int getNum_camisola() { return this.num_camisola;}
    public void setNum_camisola(int num_camisola) { this.num_camisola = num_camisola;}

    public int getVelocidade() { return this.velocidade; }
    public void setVelocidade(int velocidade) { this.velocidade = velocidade; }

    public int getResistencia() { return this.resistencia; }
    public void setResistencia(int resistencia) { this.resistencia = resistencia; }

    public int getDestreza() { return this.destreza; }
    public void setDestreza(int destreza) { this.destreza = destreza; }

    public int getImpulsao() { return this.impulsao; }
    public void setImpulsao(int impulsao) { this.impulsao = impulsao; }

    public int getJogo_cabeca() { return this.jogo_cabeca; }
    public void setJogo_cabeca(int jogo_cabeca) { this.jogo_cabeca = jogo_cabeca; }

    public int getRemate() { return this.remate; }
    public void setRemate(int remate) { this.remate = remate; }

    public int getCapacidade_passe() { return this.capacidade_passe; }
    public void setCapacidade_passe(int capacidade_passe) { this.capacidade_passe = capacidade_passe; }


    public Class_jog getTipo_jogador() { return tipo_jogador; }
    public void setTipo_jogador(Class_jog tipo_jogador) { this.tipo_jogador = tipo_jogador; }

    public ArrayList<String> getEquipa_List() {
        return this.equipa_List;
    }

    public void setEquipa_List(ArrayList<String> equipa_List) {
        this.equipa_List = equipa_List;
    }

    public String tipo_jogador_toString(Class_jog tipo_jogador){
        String r;
        switch (tipo_jogador){
            case AVA:
                r = "Avançado";
                break;
            case DEF:
                r = "Defesa";
                break;
            case MED:
                r = "Médio";
                break;
            case LAT:
                r = "Lateral";
                break;
            default:
                r = "Guarda-Redes";
                break;
        }
        return r;
    }

    // CLONE Nao se pode fazer isto
    public Jogadores clone() { 
        switch(this.getTipo_jogador())
        {
            case AVA:
            return new Avancados(this);
        case DEF:
            return new Defesas(this);
        case MED:
            return new Medios(this);
        case LAT:
            return new Laterais(this);
        default:
            return new Guarda_Redes(this);
        }
    }

    // EQUALS
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogadores jogadores = (Jogadores) o;
        return velocidade == jogadores.velocidade &&
                num_camisola == jogadores.num_camisola &&
                resistencia == jogadores.resistencia &&
                destreza == jogadores.destreza &&
                impulsao == jogadores.impulsao &&
                jogo_cabeca == jogadores.jogo_cabeca &&
                remate == jogadores.remate &&
                capacidade_passe == jogadores.capacidade_passe &&
                Objects.equals(nome, jogadores.nome);
    }

    // TOSTRING
    public String toString() {
        int i=1;
        StringBuilder sb = new StringBuilder(" ");
        sb.append("\n-----------------------\n");
        sb.append("Jogador: ").append(this.nome).append("\n");
        sb.append("Nº Camisola: ").append(this.num_camisola).append("\n");
        sb.append("Velocidade: ").append(this.velocidade).append("\n");
        sb.append("Resistencia: ").append(this.resistencia).append("\n");
        sb.append("Destreza: ").append(this.destreza).append("\n");
        sb.append("Impulsao: ").append(this.impulsao).append("\n");
        sb.append("Jogo de cabeca: ").append(this.jogo_cabeca).append("\n");
        sb.append("Remate: ").append(this.remate).append("\n");
        sb.append("Capacidade de passe: ").append(this.capacidade_passe).append("\n");
        sb.append("Historial de Equipas : ");
        for (String string : equipa_List) {
            sb.append(i).append("ª ");
            i++;
            sb.append(string);
            sb.append(" | ");
        }
        sb.append("<- Atual\n");
        sb.append(this.toStringExtra());
        sb.append(this.toStringfinal());

        return sb.toString();
    }

    public StringBuilder toStringfinal(){
        StringBuilder sb = new StringBuilder("");
        sb.append("Tipo Jogador -> ").append(this.tipo_jogador_toString(this.tipo_jogador)).append("\n");
        sb.append("Habilidade Total --> ").append(this.getHabilidade()).append(" <--\n");
        sb.append("-----------------------\n");
        return sb;
    }

    public StringBuilder toString_short() {
        String t = this.tipo_jogador_toString(this.getTipo_jogador());
        Integer i = this.getHabilidade();

        StringBuilder sb = new StringBuilder();
        
        sb.append("|").append(Equipa.print_Spaces(70,this.getNome()));
        sb.append("|").append(Equipa.print_Spaces(15,t));
        sb.append("|").append(Equipa.print_Spaces(15,i.toString())).append("|");
      
        return sb;

    }


    @Override
    /**
     * Se um jogador tiver uma habilidade superior então retorna -1,
     * dessa forma Jogadores melhores estão na cabeça da lista;
     */
    public int compareTo(Jogadores jogadores) {
        int hab1 = this.getHabilidade(); // getHabilidade deve ser usado isto é so para testar
        int hab2 = jogadores.getHabilidade();

        if ( hab1 > hab2)
            return -1;
        if ( hab1 < hab2)
            return 1;
        else return 0;
    }
}
