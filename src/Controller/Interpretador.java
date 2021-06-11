package Controller;

import Model.*;
import Model.Exceptions.LinhaIncorretaException;
import Model.Game.Jogo;
import View.*;
import Parser.Parser;

import java.util.ArrayList;
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
                menuCriarJogador();
                break;
            case 2:
                this.view.CriarEquipaView();
                String nome = this.scan.nextLine();
                Equipa eq = new Equipa(new ArrayList<>(),nome,0,0,0,0,0,new int[5]);
                Parser.getEquipas().put(nome,eq);
                break;
            case 3:
                menuGerirEquipa();
                break;
            case 4:
                this.view.GerirJogadorView();
                String nome1 = this.scan.nextLine();
                String eq1 = this.scan.nextLine();
                Jogadores j1 = Parser.getJogadores().get(nome1);
                Equipa e1 = Parser.getEquipas().get(eq1);
                String eq2 = this.scan.nextLine();
                Equipa e2 = Parser.getEquipas().get(eq2);
                e1.changeTeam(j1,e2);
                e1.makeBestTeam();
                e2.makeBestTeam();
                break;
            case 5:
                this.view.ListarView();
                break;
            case 6:
                this.view.ListarEquipaView();
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
                Parser.getJogadores().put(nome,jog);
                break;
            case 2:
                this.view.CriarLAT();
                String nome2 = this.scan.nextLine();
                int velocidade2 = this.scan.nextInt(), num2 = this.scan.nextInt(), resistencia2 = this.scan.nextInt(), destreza2 = this.scan.nextInt(),
                        impulsao2 = this.scan.nextInt(), jogo_cabeca2 = this.scan.nextInt(), remate2 = this.scan.nextInt(),
                        capacidade_passe2 = this.scan.nextInt(), cruzamentos = this.scan.nextInt();
                Jogadores jog2 = new Guarda_Redes(nome2,num2,velocidade2, resistencia2,destreza2,impulsao2,jogo_cabeca2,remate2,capacidade_passe2,cruzamentos);
                Parser.getJogadores().put(nome2,jog2);
                break;
            case 3:
                this.view.CriarDEF();
                String nome3 = this.scan.nextLine();
                int velocidade3 = this.scan.nextInt(), num3 = this.scan.nextInt(), resistencia3 = this.scan.nextInt(), destreza3 = this.scan.nextInt(),
                        impulsao3 = this.scan.nextInt(), jogo_cabeca3 = this.scan.nextInt(), remate3 = this.scan.nextInt(),
                        capacidade_passe3 = this.scan.nextInt(), corte = this.scan.nextInt();
                Jogadores jog3 = new Guarda_Redes(nome3,num3,velocidade3, resistencia3,destreza3,impulsao3,jogo_cabeca3,remate3,capacidade_passe3,corte);
                Parser.getJogadores().put(nome3,jog3);
                break;
            case 4:
                this.view.CriarMED();
                String nome4 = this.scan.nextLine();
                int velocidade4 = this.scan.nextInt(), num4 = this.scan.nextInt(), resistencia4 = this.scan.nextInt(), destreza4 = this.scan.nextInt(),
                        impulsao4 = this.scan.nextInt(), jogo_cabeca4 = this.scan.nextInt(), remate4 = this.scan.nextInt(),
                        capacidade_passe4 = this.scan.nextInt(), visaoDeJogo = this.scan.nextInt();
                Jogadores jog4 = new Guarda_Redes(nome4,num4,velocidade4, resistencia4,destreza4,impulsao4,jogo_cabeca4,remate4,capacidade_passe4,visaoDeJogo);
                Parser.getJogadores().put(nome4,jog4);
                break;
            case 5:
                this.view.CriarAVA();
                String nome5 = this.scan.nextLine();
                int velocidade5 = this.scan.nextInt(), num5 = this.scan.nextInt(), resistencia5 = this.scan.nextInt(), destreza5 = this.scan.nextInt(),
                        impulsao5 = this.scan.nextInt(), jogo_cabeca5 = this.scan.nextInt(), remate5 = this.scan.nextInt(),
                        capacidade_passe5 = this.scan.nextInt(), desmarcacao = this.scan.nextInt();
                Jogadores jog5 = new Guarda_Redes(nome5,num5,velocidade5, resistencia5,destreza5,impulsao5,jogo_cabeca5,remate5,capacidade_passe5,desmarcacao);
                Parser.getJogadores().put(nome5,jog5);
                break;
        }
    }

    public void menuGerirEquipa(){
        this.view.GerirEquipaView();
        int instruction = scan.nextInt();
        this.scan.nextLine();
        switch(instruction){
            case 1:
                this.view.Add();
                String nome = this.scan.nextLine();
                String eq = this.scan.nextLine();
                Jogadores j = Parser.getJogadores().get(nome);
                Equipa e = Parser.getEquipas().get(eq);
                e.getJogadores().add(j);
                if (e.getJogadores().size() >= 11){
                    e.makeBestTeam();
                }
                break;
            case 2:
                this.view.Remove();
                String nome2 = this.scan.nextLine();
                String eq2 = this.scan.nextLine();
                Jogadores j2 = Parser.getJogadores().get(nome2);
                Equipa e2 = Parser.getEquipas().get(eq2);
                e2.getJogadores().remove(j2);
                if (e2.getJogadores().size() >= 11){
                    e2.makeBestTeam();
                }
                break;
        }
    }

    public void menu2(){
        this.view.menu2();
        int instruction = scan.nextInt();
        this.scan.nextLine();
        switch(instruction){
            case 1:
                this.view.CriarJogoView();
                String eq1 = this.scan.nextLine();
                Equipa e1 = Parser.getEquipas().get(eq1);
                String eq2 = this.scan.nextLine();
                Equipa e2 = Parser.getEquipas().get(eq2);
                Jogo jogo = new Jogo(e1,e2);

/*
                System.out.println("Quantas substituições vai ter " + eq1 + " ? ");
                int sub1 = this.scan.nextInt();
                for (int i=0; i<sub1; i++){
                    int n1 = this.scan.nextInt();

                    System.out.println(" -> ");
                    int n2 = this.scan.nextInt();
                    Jogadores j1 = Parser.getEquipas().get(eq1).getJogadores().get(n1);
                    Jogadores j2 = Parser.getEquipas().get(eq2).getJogadores().get(n2);
                    jogo.addSubstitucao(j1,j2,1);
                }

                System.out.println("Quantas substituições vai ter " + eq2 + " ? ");
                int sub2 = this.scan.nextInt();
                for (int i=0; i<sub2; i++){
                    int n1 = this.scan.nextInt();
                    Jogadores j1 = Parser.getEquipas().get(eq1).getJogadores().get(n1);
                    System.out.println(" -> ");
                    int n2 = this.scan.nextInt();
                    Jogadores j2 = Parser.getEquipas().get(eq2).getJogadores().get(n2);
                    jogo.addSubstitucao(j1,j2,2);
                }
*/              jogo.Simulate();
                break;
            case 2:
                this.view.EquipaVsView();
                String eq = this.scan.nextLine();
                Equipa e = Parser.getEquipas().get(eq);

                Jogo game1;
                for (Equipa equipa_file : Parser.getEquipas().values()) {
                    if (e != equipa_file){
                        game1 = new Jogo(e,equipa_file);
                        game1.Simulate();
                    }
                }

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
                case 1:
                    menu1();
                    break;
                case 2:
                    menu2();
                    break;
                case 3:
                    this.view.CriarJogadorView();
                    String eq1 = this.scan.nextLine();
                    Equipa e1 = Parser.getEquipas().get(eq1);
                    String eq2 = this.scan.nextLine();
                    Equipa e2 = Parser.getEquipas().get(eq2);

                    Jogo game = new Jogo(e1,e2);

                    game.Simulate(true);
                    break;
                case 4:
                    // Guardar logs em ficheiro
                    break;
                case 5:
                    this.view.load();
                    String path = this.scan.nextLine();
                    try {
                        Parser.parse(path); }
                    catch(LinhaIncorretaException e) {
                        System.out.println("Ocorreu um erro lendo do ficheiro.");
                    }
                    break;
            }
        }

    }
}
