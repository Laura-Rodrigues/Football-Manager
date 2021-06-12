import Controller.IController;
import Controller.Interpretador;
import View.IView;
import View.Menu;

public class App {

    public static void main(String[] args){

        IView view = new Menu();
        IController control = new Interpretador();
        control.setView(view);
        control.start();

    }
}
