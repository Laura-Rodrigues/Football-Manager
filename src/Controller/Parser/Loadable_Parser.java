package Controller.Parser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import Model.*;
import Model.Game.*;

public class Loadable_Parser implements Serializable{
    public  Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
    public  Map<String, Jogadores> jogadores = new HashMap<>(); //nome, Jogadores
    public  List<JogoFeito> jogos = new ArrayList<>();


    public Loadable_Parser( Map<String, Equipa> equipas,Map<String, Jogadores> jogadores,List<JogoFeito> jogos)
    {
        Map<String,Equipa> novo_equipa = equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        this.equipas = novo_equipa;

        Map<String,Jogadores> novo_j = jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        this.jogadores = novo_j;

        List<JogoFeito> novo_jogos = jogos.stream().collect(Collectors.toList());// jogos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        this.jogos = novo_jogos;
    }
}
