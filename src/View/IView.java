package View;

import Model.Jogadores;

import java.util.ArrayList;

public interface IView {
    public void waitingInstruction();
    public void warningMenus();
    public void menu();
    public void menu1();
    public void menu2();
    public void CriarJogadorView();
    public void CriarGR();
    public void CriarLAT();
    public void CriarDEF();
    public void CriarMED();
    public void CriarAVA();
    public void CriarEquipaView();
    public void GerirEquipaView();
    public void Add();
    public void Remove();
    public void GerirJogadorView();
    public void ListarView();
    public void ListarEquipaView();
    public void CriarJogoView();
    public void EquipaVsView();
    public void menuFicheiros();
    public void load();
}
