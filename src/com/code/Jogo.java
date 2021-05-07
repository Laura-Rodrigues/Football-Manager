
import java.util.Objects;
import java.util.Random;
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

    public Jogo() {
        this.equipa_casa = new Equipa();
        this.equipa_fora = new Equipa();
        this.golos_casa = 0;
        this.golos_fora = 0;
        this.state = game_state.Unplayed;
    }

    public Jogo(Equipa equipa_casa, Equipa equipa_fora, int golos_casa, int golos_fora, game_state state) {
        this.equipa_casa = equipa_casa;
        this.equipa_fora = equipa_fora;
        this.golos_casa = golos_casa;
        this.golos_fora = golos_fora;
        this.state = state;
    }
    public Jogo(Equipa equipa_casa, Equipa equipa_fora) {
        this.equipa_casa = equipa_casa;
        this.equipa_fora = equipa_fora;
        this.golos_casa = 0;
        this.golos_fora = 0;
        this.state = game_state.Unplayed;
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
    }

    public void addGoalFora(){
        this.golos_fora++;
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
        && Objects.equals(state, jogo.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipa_casa, equipa_fora, golos_casa, golos_fora, state);
    }

    @Override
    public String toString() {
        return "{" +
            " equipa_casa='" + getEquipa_casa() + "'" +
            ", equipa_fora='" + getEquipa_fora() + "'" +
            ", golos_casa='" + getGolos_casa() + "'" +
            ", golos_fora='" + getGolos_fora() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }

}
