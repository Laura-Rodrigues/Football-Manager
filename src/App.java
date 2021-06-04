import Controller.Interpretador;
import View.Menu;

public class App {

    public static void main(String[] args){
        Menu view = new Menu();
        Interpretador control = new Interpretador();
        control.setView(view);
        control.start();

    }
}
