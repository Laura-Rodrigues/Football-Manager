package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interpretador implements IController{

    //private IModel model;
    private IView view;

    ArrayList<Jogadores> jogadores = new ArrayList<>();

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
                menuCriarJogador();
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
                this.view.ListarView(jogadores);
                break;
            case 6:
                this.view.HabilidadesView();
                break;
        }
        this.view.warningMenus();
    }

    public void menuCriarJogador(){
        this.view.CriarJogadorView();
        int instruction = scan.nextInt();
        this.scan.nextLine();
        switch(instruction){
            case 1:
                this.view.CriarGR();
                String nome = this.scan.nextLine();
                int velocidade = this.scan.nextInt(), num = this.scan.nextInt(), resistencia = this.scan.nextInt(), destreza = this.scan.nextInt(),
                        impulsao = this.scan.nextInt(), jogo_cabeca = this.scan.nextInt(), remate = this.scan.nextInt(),
                        capacidade_passe = this.scan.nextInt(), elasticidade = this.scan.nextInt(),
                        posicionamento = this.scan.nextInt(), reflexos = this.scan.nextInt();
                Jogadores jog = new Guarda_Redes(nome,num,velocidade, resistencia,destreza,impulsao,jogo_cabeca,remate,capacidade_passe,elasticidade,posicionamento,reflexos);
                jogadores.add(jog);
                break;
            case 2:
                this.view.CriarLAT();
                String nome2 = this.scan.nextLine();
                int velocidade2 = this.scan.nextInt(), num2 = this.scan.nextInt(), resistencia2 = this.scan.nextInt(), destreza2 = this.scan.nextInt(),
                        impulsao2 = this.scan.nextInt(), jogo_cabeca2 = this.scan.nextInt(), remate2 = this.scan.nextInt(),
                        capacidade_passe2 = this.scan.nextInt(), cruzamentos = this.scan.nextInt();
                Jogadores jog2 = new Guarda_Redes(nome2,num2,velocidade2, resistencia2,destreza2,impulsao2,jogo_cabeca2,remate2,capacidade_passe2,cruzamentos);
                jogadores.add(jog2);
                break;
            case 3:
                this.view.CriarDEF();
                String nome3 = this.scan.nextLine();
                int velocidade3 = this.scan.nextInt(), num3 = this.scan.nextInt(), resistencia3 = this.scan.nextInt(), destreza3 = this.scan.nextInt(),
                        impulsao3 = this.scan.nextInt(), jogo_cabeca3 = this.scan.nextInt(), remate3 = this.scan.nextInt(),
                        capacidade_passe3 = this.scan.nextInt(), corte = this.scan.nextInt();
                Jogadores jog3 = new Guarda_Redes(nome3,num3,velocidade3, resistencia3,destreza3,impulsao3,jogo_cabeca3,remate3,capacidade_passe3,corte);
                jogadores.add(jog3);
                break;
            case 4:
                this.view.CriarMED();
                String nome4 = this.scan.nextLine();
                int velocidade4 = this.scan.nextInt(), num4 = this.scan.nextInt(), resistencia4 = this.scan.nextInt(), destreza4 = this.scan.nextInt(),
                        impulsao4 = this.scan.nextInt(), jogo_cabeca4 = this.scan.nextInt(), remate4 = this.scan.nextInt(),
                        capacidade_passe4 = this.scan.nextInt(), visaoDeJogo = this.scan.nextInt();
                Jogadores jog4 = new Guarda_Redes(nome4,num4,velocidade4, resistencia4,destreza4,impulsao4,jogo_cabeca4,remate4,capacidade_passe4,visaoDeJogo);
                jogadores.add(jog4);
                break;
            case 5:
                this.view.CriarAVA();
                String nome5 = this.scan.nextLine();
                int velocidade5 = this.scan.nextInt(), num5 = this.scan.nextInt(), resistencia5 = this.scan.nextInt(), destreza5 = this.scan.nextInt(),
                        impulsao5 = this.scan.nextInt(), jogo_cabeca5 = this.scan.nextInt(), remate5 = this.scan.nextInt(),
                        capacidade_passe5 = this.scan.nextInt(), desmarcacao = this.scan.nextInt();
                Jogadores jog5 = new Guarda_Redes(nome5,num5,velocidade5, resistencia5,destreza5,impulsao5,jogo_cabeca5,remate5,capacidade_passe5,desmarcacao);
                jogadores.add(jog5);
                break;
        }
        //this.view.warningMenus();
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
                    this.view.menu();
                    break;

                case 1:
                    menu1();
                    break;

                case 2:
                    menu2();
                    break;
            }
            if(instruction != 0) this.view.waitingInstruction();
        }

    }
}
