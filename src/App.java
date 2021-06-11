import Controller.IController;
import Controller.Interpretador;
import Model.Exceptions.LinhaIncorretaException;
import Parser.Parser;
import View.IView;
import View.Menu;

public class App {

    public static void main(String[] args){

/*        try {
            Parser.parse("src/output.txt"); }
        catch(LinhaIncorretaException e) {
        	System.out.println("Ocorreu um erro lendo do ficheiro.");
        }
*/
        IView view = new Menu();
        IController control = new Interpretador();
        control.setView(view);
        control.start();

    }
}
