package View;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu implements IView{

    public void waitingInstruction(){
        System.out.print("\t>");
    }

    public void warningMenus(){
        System.out.print("A voltar para o primeiro menu..........\n");
    }

    public void menu(){
        StringBuilder sb = new StringBuilder("\n-------------------------------------------\n\t\t\t Football Manager\n-------------------------------------------\n");
        sb.append("0) Mostrar menu.\n");
        sb.append("1) Gerir entidades\n");
        sb.append("2) Resultado de Jogo\n");
        sb.append("-1) Sair.\n");
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }

    public void menu1(){
        StringBuilder sb = new StringBuilder("\n-------------------------------------------\n  Requisitos base de gestão das entidades\n-------------------------------------------\n");
        sb.append("1) Criar Jogador\n");
        sb.append("2) Criar equipa\n");
        sb.append("3) Gerir equipa\n");
        sb.append("4) Gerir jogador\n");
        sb.append("5) Listar jogadores e equipas\n");
        sb.append("6) Habilidades\n");
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }

    public void menu2(){
        StringBuilder sb = new StringBuilder("\n-------------------------------------------\n\t  Calcular o resultado de um jogo\n-------------------------------------------\n");
        sb.append("1) Criar Jogo\n");
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }

    public void CriarJogadorView(){

    }
    public void CriarEquipaView(){

    }
    public void GerirEquipaView(){

    }
    public void GerirJogadorView(){

    }
    public void ListarView(){

    }
    public void HabilidadesView(){

    }
    public void CriarJogoView(){

    }


/*
    private List<String> opcoes;
    private int op;

    public Menu(String[] opcoes) {
        this.opcoes = Arrays.asList(opcoes);
        this.op = 0;
    }

    public void executa() {
        do {
            showMenu();
            this.op = lerOpcao();
        } while (this.op == -1);
    }

    private void showMenu() {
        System.out.println("\n *** Menu *** ");
        for (int i=0; i<this.opcoes.size(); i++) {
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.println("0 - Sair / Voltar atrás");
    }

    private int lerOpcao() {
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("Opção: ");
        try {
            op = is.nextInt();
        }
        catch (InputMismatchException e) { // Não foi inscrito um int
            op = -1;
        }
        if (op<0 || op>this.opcoes.size()) {
            System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }

    public int getOpcao() {
        return this.op;
    }


    public static void main(String[] args){

    String[] s1 = {"Gerir entidades", "Resultado de Jogo"};
    String[] s2 = {"Criar Jogador", "Criar equipa","Gerir equipa","Gerir jogador","Listar jogadores e equipas","Habilidades"};
    String[] s3 = {"Criar jogo"};

    Menu m1 = new Menu(s1);
    Menu m2 = new Menu(s2);
    Menu m3 = new Menu(s3);
    int op;

        do {
            m1.executa();
            op = m1.getOpcao();
            int i;

            System.out.println("Option read: " + op);

            switch (op) {
                case 1:
                    m2.executa();
                    System.out.println("...");
                    break;
                case 2:
                    m3.executa();
                    break;
                default:
                    System.out.println("Option?? " + op);
                    break;
            }
        } while (op != 0); System.out.println("Ending program ...");
    }
*/
}
