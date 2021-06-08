package Controller;

import Model.*;
import View.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interpretador implements IController{

    //private IModel model;
    private IView view;
    
    private Scanner scan;


    public Interpretador(){
        this.scan = new Scanner(System.in);
    }
/*
    public void setModel (IModel model){
        this.model = model;
    }
*/
    public void setView(IView view){
        this.view = view;
    }

    public void menu1(){
        this.view.menu1();
        int instruction = scan.nextInt();
        this.scan.nextLine();
        switch(instruction){
            case 1:
                this.view.CriarJogadorView();
                break;
            case 2:
                this.view.CriarEquipaView();
                break;
            case 3:
                this.view.GerirEquipaView();
                break;
            case 4:
                this.view.GerirJogadorView();
                break;
            case 5:
                this.view.ListarView();
                break;
            case 6:
                this.view.HabilidadesView();
                break;
        }
        this.view.warningMenus();
    }

    public void menu2(){
        this.view.menu2();
        int instruction = scan.nextInt();
        this.scan.nextLine();
        switch(instruction){
            case 1:
                this.view.CriarJogoView();
                break;
        }
        this.view.warningMenus();
    }


    public void start(){
        while(true){
            this.view.menu();
            int instruction;
            try {
                instruction = this.scan.nextInt();
            }
            catch (InputMismatchException e) { // Não foi inscrito um int
                instruction = 10;
            }
            this.scan.nextLine();
            switch(instruction){
                case -1:
                    this.scan.close();
                    return;

                case 0:
                //Menu.clearScreen();
                this.view.menu();

                    break;

                case 1:
                //Menu.clearScreen();
                    menu1();


                    break;

                case 2:
                //Menu.clearScreen();
                    menu2();


                    break;
            }
            if(instruction != 0) this.view.waitingInstruction();
        }

    }
}
