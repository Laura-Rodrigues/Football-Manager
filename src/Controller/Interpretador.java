package Controller;

import Model.*;
import Model.Exceptions.LinhaIncorretaException;
import Model.Game.Jogo;
import View.*;
import Parser.Loadable_Parser;
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
            Equipa e1,e2;
            Jogadores j1;
            do {
                this.view.GerirJogadorView();
                String nome1 = this.scan.nextLine();
                String eq1 = this.scan.nextLine();
                j1 = Parser.getJogadores().get(nome1);
                e1 = Parser.getEquipas().get(eq1);
                String eq2 = this.scan.nextLine();
                e2 = Parser.getEquipas().get(eq2);
            } while (j1 == null || e1 == null || e2 == null);
                
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
            break;
            case 2:
            this.view.CriarLAT();
            break;
            case 3:
            this.view.CriarDEF();
            break;
            case 4:
            this.view.CriarMED();
            break;
            case 5:
            this.view.CriarAVA();
            break;
        }
        String nome = this.scan.nextLine();
        int velocidade = this.scan.nextInt(), num = this.scan.nextInt(), resistencia = this.scan.nextInt(), destreza = this.scan.nextInt(),
        impulsao = this.scan.nextInt(), jogo_cabeca = this.scan.nextInt(), remate = this.scan.nextInt(),capacidade_passe = this.scan.nextInt();
        Jogadores jog;
        switch(instruction){
            case 1:
            int elasticidade = this.scan.nextInt(), posicionamento = this.scan.nextInt(), reflexos = this.scan.nextInt();
            jog = new Guarda_Redes(nome,num,velocidade, resistencia,destreza,impulsao,jogo_cabeca,remate,capacidade_passe,elasticidade,posicionamento,reflexos);
            Parser.getJogadores().put(nome,jog);
            break;

            case 2:
            int cruzamentos = this.scan.nextInt();
            jog = new Laterais(nome,num,velocidade, resistencia,destreza,impulsao,jogo_cabeca,remate,capacidade_passe,cruzamentos);
            Parser.getJogadores().put(nome,jog);
            break;

            case 3:
            int corte = this.scan.nextInt();
            jog = new Defesas(nome,num,velocidade, resistencia,destreza,impulsao,jogo_cabeca,remate,capacidade_passe,corte);
            Parser.getJogadores().put(nome,jog);
            break;

            case 4:
            int visaoDeJogo = this.scan.nextInt();
            jog = new Medios(nome,num,velocidade, resistencia,destreza,impulsao,jogo_cabeca,remate,capacidade_passe,visaoDeJogo);
            Parser.getJogadores().put(nome,jog);
            break;

            case 5:
            int desmarcacao = this.scan.nextInt();
            jog = new Avancados(nome,num,velocidade, resistencia,destreza,impulsao,jogo_cabeca,remate,capacidade_passe,desmarcacao);
            Parser.getJogadores().put(nome,jog);

            break;
        }
        
    }

    public void menuGerirEquipa(){
        this.view.GerirEquipaView();
        int instruction = scan.nextInt();
        this.scan.nextLine();
        switch(instruction){
            case 1:
                
                Jogadores j;
                Equipa e;
                do{
                    this.view.Add();
                    String nome = this.scan.nextLine();
                    String eq = this.scan.nextLine();
                    j = Parser.getJogadores().get(nome);
                    e = Parser.getEquipas().get(eq);
                } while(j == null || e == null);

                e.getJogadores().add(j);
                if (e.getJogadores().size() >= 11){
                    e.makeBestTeam();
                }
                break;
            case 2:
                Jogadores j2;
                Equipa e2;
                do{
                    this.view.Remove();
                    String nome2 = this.scan.nextLine();
                    String eq2 = this.scan.nextLine();
                    j2 = Parser.getJogadores().get(nome2);
                    e2 = Parser.getEquipas().get(eq2);
                } while(j2 == null || e2 == null);

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
            Equipa e1,e2;
            do{
                this.view.CriarJogoView();
                String eq1 = this.scan.nextLine();
                e1 = Parser.getEquipas().get(eq1);
                String eq2 = this.scan.nextLine();
                e2 = Parser.getEquipas().get(eq2);
            } while(e1 == null || e2 == null);

                Jogo jogo = new Jogo(e1,e2);

               jogo.Simulate();
                break;
            case 2:
            Equipa e;
                do 
                {
                    this.view.EquipaVsView();
                    String eq = this.scan.nextLine();
                    e = Parser.getEquipas().get(eq);
                } while (e == null);
              

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

    public void menuFicheiros(){
        this.view.menuFicheiros();
        int instruction = scan.nextInt();
        this.scan.nextLine();
        switch(instruction){
            case 1:
                // guardar ficheiro
                Loadable_Parser l = Parser.parser_toLoadable();
		        SerializeData.serialize_LoadableParser(l);
                break;
            case 2:
                // carregar ficheiro
                String s =  this.scan.nextLine();

		        try{
                SerializeData.deserialize_LoadableParser(s);}
                catch (Exception e){System.out.println(e);}

                break;
        }
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
                    this.view.CriarJogoView();
                    String eq1,eq2;
                    Equipa e1,e2;
                    for (Equipa e_fake : Parser.getEquipas().values()) {
                        System.out.println(e_fake.getNome_equipa());
                    }
                    do {
                    System.out.print("\nEquipa 1: ");
                    eq1 = this.scan.nextLine();
                    e1 = Parser.getEquipas().get(eq1);
                    System.out.print("\nEquipa 2: ");
                    eq2 = this.scan.nextLine();
                    e2 = Parser.getEquipas().get(eq2);
                    } while ( (e1==null || e2 == null) && 
                    e1.getNome_equipa().compareTo(e2.getNome_equipa()) != 0);

                    Jogo game = new Jogo(e1,e2);

                    game.Simulate(true);
                    break;
                case 4:
                    menuFicheiros();
                    break;
                case 5:
                    this.view.load();
                    String path = this.scan.nextLine();
                    try {
                        if (path.compareTo("") == 0) Parser.parse();
                        else
                        Parser.parse(path); }
                    catch(LinhaIncorretaException e) {
                        System.out.println("Ocorreu um erro lendo do ficheiro.");
                    }
                    break;
            }
        }

    }
}
