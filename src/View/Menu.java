package View;

import Model.Equipa;
import Model.Jogadores;
import Parser.Parser;
import java.util.*;

public class Menu implements IView{
    public int t = 40;//tamanho 

    public void waitingInstruction(){
        System.out.print("\t> ");
    }

    public void warningMenus(){
        System.out.print("\n\nA voltar para o primeiro menu..........\n");
    }

    public StringBuilder print_Espacos(int tamanho,String array){
        StringBuilder sb = new StringBuilder();
        int offset = (tamanho - array.length()) / 2;
        for (int i = 0; i < offset; i++)
        {
            sb.append(" ");
        }
        sb.append(array);
        for (int i = 0; i < offset; i++)
        {
            sb.append(" ");
        }
        if (((tamanho -array.length()) % 2) == 1) sb.append(" ");
        sb.append("\n");

        return sb;
    }

    public StringBuilder makemyBox(int start_size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start_size; i++) {
            sb.append("-");
        }
        sb.append("\n");
        return sb;
    }

    public void menu(){
        StringBuilder sb = new StringBuilder();
        
        
        sb.append(makemyBox(t));
        sb.append(print_Espacos(t,"Football Manager"));
        sb.append(makemyBox(t));
        sb.append("0) Mostrar menu\n");
        sb.append("1) Gerir entidades\n");
        sb.append("2) Resultado de Jogo\n");
        sb.append("3) Simulação de Jogo\n");
        sb.append("-1) Sair\n");
        sb.append(makemyBox(t));
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }

    public void menu1(){
        StringBuilder sb = new StringBuilder();
        sb.append(makemyBox(t));
        sb.append(print_Espacos(t,"Requisitos base de gestão das entidades"));
        sb.append(makemyBox(t));
        sb.append("1) Criar Jogador\n");
        sb.append("2) Criar equipa\n");
        sb.append("3) Gerir equipa\n");
        sb.append("4) Gerir jogador\n");
        sb.append("5) Listar jogadores e suas habilidades\n");
        sb.append("6) Listar equipas e suas habilidades\n");
        sb.append(makemyBox(t));
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }

    public void menu2(){
        StringBuilder sb = new StringBuilder();
        sb.append(makemyBox(t));
        sb.append(print_Espacos(t,"Calcular o resultado de um jogo"));
        sb.append(makemyBox(t));
        sb.append("1) Criar Jogo\n");
        sb.append("2) 1 equipa vs. todas\n");
        sb.append(makemyBox(t));
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }

    public void CriarJogadorView(){
        StringBuilder sb = new StringBuilder();
        sb.append(makemyBox(t));
        sb.append(print_Espacos(t,"Tipo de jogador"));
        sb.append(makemyBox(t));
        sb.append("1) Guarda-Redes\n");
        sb.append("2) Lateral\n");
        sb.append("3) Defesa\n");
        sb.append("4) Médio\n");
        sb.append("5) Avançado\n");
        sb.append(makemyBox(t));
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }

    public void CriarGR(){
        StringBuilder sb = new StringBuilder("Insira os dados na seguinte ordem (dando enter após cada):\n");
        sb.append("Nome\n");
        sb.append("Nº de camisola\n");
        sb.append("Velocidade\n");
        sb.append("Resistência\n");
        sb.append("Destreza\n");
        sb.append("Impulsão\n");
        sb.append("Jogo de cabeça\n");
        sb.append("Remate\n");
        sb.append("Capacidade de passe\n");
        sb.append("Elasticidade\n");
        sb.append("Posicionamento\n");
        sb.append("Reflexos\n");
        System.out.println(sb);
    }

    public void CriarLAT(){
        StringBuilder sb = new StringBuilder("Insira os dados na seguinte ordem (dando enter após cada):\n");
        sb.append("Nome\n");
        sb.append("Nº de camisola\n");
        sb.append("Velocidade\n");
        sb.append("Resistência\n");
        sb.append("Destreza\n");
        sb.append("Impulsão\n");
        sb.append("Jogo de cabeça\n");
        sb.append("Remate\n");
        sb.append("Capacidade de passe\n");
        sb.append("Cruzamentos\n");
        System.out.println(sb);
    }

    public void CriarDEF(){
        StringBuilder sb = new StringBuilder("Insira os dados na seguinte ordem (dando enter após cada):\n");
        sb.append("Nome\n");
        sb.append("Nº de camisola\n");
        sb.append("Velocidade\n");
        sb.append("Resistência\n");
        sb.append("Destreza\n");
        sb.append("Impulsão\n");
        sb.append("Jogo de cabeça\n");
        sb.append("Remate\n");
        sb.append("Capacidade de passe\n");
        sb.append("Corte\n");
        System.out.println(sb);
    }

    public void CriarMED(){
        StringBuilder sb = new StringBuilder("Insira os dados na seguinte ordem (dando enter após cada):\n");
        sb.append("Nome\n");
        sb.append("Nº de camisola\n");
        sb.append("Velocidade\n");
        sb.append("Resistência\n");
        sb.append("Destreza\n");
        sb.append("Impulsão\n");
        sb.append("Jogo de cabeça\n");
        sb.append("Remate\n");
        sb.append("Capacidade de passe\n");
        sb.append("Visão de Jogo\n");
        System.out.println(sb);
    }

    public void CriarAVA(){
        StringBuilder sb = new StringBuilder("Insira os dados na seguinte ordem (dando enter após cada):\n");
        sb.append("Nome\n");
        sb.append("Nº de camisola\n");
        sb.append("Velocidade\n");
        sb.append("Resistência\n");
        sb.append("Destreza\n");
        sb.append("Impulsão\n");
        sb.append("Jogo de cabeça\n");
        sb.append("Remate\n");
        sb.append("Capacidade de passe\n");
        sb.append("Desmarcação\n");
        System.out.println(sb);
    }

    public void CriarEquipaView(){
        System.out.println("A equipa vai ser criada vazia. Para introduzir jogadores escolha no menu GERIR EQUIPA\n\tIntroduza o nome da nova equipa: ");
    }
    public void GerirEquipaView(){
        StringBuilder sb = new StringBuilder();
        sb.append(makemyBox(t));
        sb.append(print_Espacos(t,"Gerir Equipa"));
        sb.append(makemyBox(t));
        sb.append("1) Adicionar jogadores\n");
        sb.append("2) Remover jogadores\n");
        sb.append(makemyBox(t));
        sb.append("Escreva o número correspondente à opção pretendida.\n\t> ");
        System.out.print(sb);
    }
    public void Add(){
        System.out.println("Introduza o nome do jogador e da Equipa a que quer adicioná-lo\n");
    }

    public void Remove(){
        System.out.println("Introduza o nome do jogador e da Equipa de onde quer removê-lo\n");
    }

    public void GerirJogadorView(){
        System.out.println("Introduza o nome do jogador e a sua Equipa atual. A qual Equipa quer adicioná-lo?\n");
    }
    public void ListarView() {
        for (Jogadores jf : Parser.getJogadores().values()) {
            System.out.println(jf.toString_short());
        }
    }
    public void ListarEquipaView(){
        for (Equipa jf : Parser.getEquipas().values()) {
            System.out.println(jf.sb_short());
        }
    }
    public void CriarJogoView(){

    }
    public void SimulateJogo(){
        System.out.println("Introduza o nome das duas equipas\n");
    }

}
