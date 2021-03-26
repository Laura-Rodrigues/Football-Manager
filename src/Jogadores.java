public class Jogadores {
    enum Class_jog{
        GRD,LAT,AVA,DEF,MED;
    }
    
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
                        int impulsao, int jogo_cabeca, int remate, int capacidade_passe, int elasticidade,Class_jog tipo_jog)
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

    public Jogadores(Jogadores gr){
        this.nome = gr.getNome();
        this.velocidade = gr.getVelocidade();
        this.resistencia = gr.getResistencia();
        this.destreza = gr.getDestreza();
        this.impulsao = gr.getImpulsao();
        this.jogo_cabeca = gr.getJogo_cabeca();
        this.remate = gr.getRemate();
        this.capacidade_passe = gr.getCapacidade_passe();
        this.elasticidade = gr.getElasticidade();
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
