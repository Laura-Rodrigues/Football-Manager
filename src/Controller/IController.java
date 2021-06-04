package Controller;

//import Model.IModel;
import View.IView;

public interface IController {

    //void setModel(IModel model);
    void setView(IView view);
    void start();
}
