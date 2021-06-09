package Parser;

import Model.*;
import Model.Exceptions.LinhaIncorretaException;
import Model.Game.JogoFeito;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parser implements Serializable {
    private static List<String> linhas;
    private static Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
    private static Map<String, Jogadores> jogadores = new HashMap<>(); //numero, Jogadores
    private static List<JogoFeito> jogos = new ArrayList<>();
    private static Equipa ultima = null; 
    private static Jogadores j = null;
    private static String[] linhaPartida;
    private static final boolean debug = false;
    private static Jogadores j1 = new Guarda_Redes();
    private static Jogadores j2 = new Avancados();
    private static Jogadores j3 = new Medios();
    private static Jogadores j4 = new Laterais();
    private static Jogadores j5 = new Defesas();

    public static void parse(String path) throws LinhaIncorretaException {
        linhas = lerFicheiro(path);
        //Se o tamanho do ficheiro for 0.   
        if (linhas.size() == 0) throw  new LinhaIncorretaException();
        for (String linha : linhas) {
            j = null;
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    if(ultima != null)
                    {
                        ultima.makeBestTeam();
                        equipas.put(ultima.getNome_equipa(),ultima);
                    }
                
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = j1.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    j.addEquipa(ultima.getNome_equipa());
                    jogadores.put(j.getNome(), j);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = j5.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    j.addEquipa(ultima.getNome_equipa());
                    jogadores.put(j.getNome(), j);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = j3.parse(linhaPartida[1]);
                    j.addEquipa(ultima.getNome_equipa());
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team

                    jogadores.put(j.getNome(), j);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = j4.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    j.addEquipa(ultima.getNome_equipa());
                    jogadores.put(j.getNome(), j);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = j2.parse(linhaPartida[1]);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    j.addEquipa(ultima.getNome_equipa());
                    jogadores.put(j.getNome(), j);
                    ultima.insereJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    JogoFeito jo = JogoFeito.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }
        if(ultima != null)
        {
            ultima.makeBestTeam();
            equipas.put(ultima.getNome_equipa(),ultima);
        }
        
        if (debug)
        {
            for (Equipa e: equipas.values()){
                System.out.println(e.toString());
            }
            for (JogoFeito jog: jogos){
                System.out.println(jog.toString());
            }
            for(Jogadores jf : jogadores.values())
            {
                System.out.println(jf.toString());
            }
        }
    }

    public static List<String> lerFicheiro(String nomeFich){
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { 
            System.out.println("Nome do ficheiro incorreto.");
            lines = new ArrayList<>(); }
        return lines;
    }

    public static Map<String,Jogadores> getJogadores(){
        return Parser.jogadores;
    }

    public static Map<String, Equipa> getEquipas(){
        return Parser.equipas;
    }
    
}
