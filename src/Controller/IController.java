package Controller;

import View.IView;

public interface IController {

    void setView(IView view);
    void start();
}
