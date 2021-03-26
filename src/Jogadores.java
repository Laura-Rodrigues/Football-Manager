import java.lang.Enum;


public class Jogadores {
    enum Class_jog{
        GRD,LAT,AVA,DEF,MED;
    }
    /**
    if GK then tipo_jogador = GRD;
    */
    private String nome;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogo_cabeca;
    private int remate;
    private int capacidade_passe;
    private int elasticidade;
    private Class_jog tipo_jogador;

    public Jogadores(){
        this.nome = "";
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogo_cabeca = 0;
        this.remate = 0;
        this.capacidade_passe = 0;
        this.elasticidade = 0;
        this.tipo_jogador = Class_jog.GRD;
    }

    public Jogadores(String nome, int velocidade, int resistencia, int destreza,
                        int impulsao, int jogo_cabeca, int remate, int capacidade_passe,
                         int elasticidade,Class_jog tipo_jog)
    {
        this.nome = nome;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogo_cabeca = jogo_cabeca;
        this.remate = remate;
        this.capacidade_passe = capacidade_passe;
        this.elasticidade = elasticidade;
        this.tipo_jogador = tipo_jog;
        
    }

    public Jogadores(Jogadores jog){
        this.nome = jog.getNome();
        this.velocidade = jog.getVelocidade();
        this.resistencia = jog.getResistencia();
        this.destreza = jog.getDestreza();
        this.impulsao = jog.getImpulsao();
        this.jogo_cabeca = jog.getJogo_cabeca();
        this.remate = jog.getRemate();
        this.capacidade_passe = jog.getCapacidade_passe();
        this.elasticidade = jog.getElasticidade();
        this.tipo_jogador = jog.getTipo_jogador();
    }

    
    public String toString() {
        return "Jogador " +
                "\nNome='" + nome + '\'' +
                "\nVelocidade=" + velocidade +
                "\nResistencia=" + resistencia +
                "\nDestreza=" + destreza +
                "\nImpulsao=" + impulsao +
                "\nJogo de cabeça=" + jogo_cabeca +
                "\nRemate=" + remate +
                "\nCapacidade de passe=" + capacidade_passe +
                "\nElasticidade=" + elasticidade +
                "\nTipo jogador=" + tipo_jogador
                ;
    }

    /**
     *
     * Getters
     */

    public String getNome()
    { return this.nome; }

    public int getVelocidade()
    { return this.velocidade; }

    public int getResistencia()
    { return this.resistencia; }

    public int getDestreza()
    { return this.destreza; }

    public int getImpulsao()
    { return this.impulsao; }

    public int getJogo_cabeca()
    { return this.jogo_cabeca; }

    public int getRemate()
    { return this.remate; }

    public int getCapacidade_passe()
    { return this.capacidade_passe; }

    public int getElasticidade()
    { return this.elasticidade; }
    
    public Class_jog getTipo_jogador()
    { return this.tipo_jogador; }

    /**
     *
     * Setters
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public void setJogo_cabeca(int jogo_cabeca) {
        this.jogo_cabeca = jogo_cabeca;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public void setCapacidade_passe(int capacidade_passe) {
        this.capacidade_passe = capacidade_passe;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }
    public void setTipo_jogador(Class_jog tipo_jogador){
        this.tipo_jogador = tipo_jogador;
    }
}
