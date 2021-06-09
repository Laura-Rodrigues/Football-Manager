import Controller.Interpretador;
import Model.Exceptions.LinhaIncorretaException;
import Parser.Parser;
import View.Menu;

public class App {

    public static void main(String[] args){

/*        try {
            Parser.parse("src/output.txt"); }
        catch(LinhaIncorretaException e) {
        	System.out.println("Ocorreu um erro lendo do ficheiro.");
        }
*/
        Menu view = new Menu();
        Interpretador control = new Interpretador();
        control.setView(view);
        control.start();

    }
}
