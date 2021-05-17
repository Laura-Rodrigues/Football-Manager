//package proj;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Parser {
    private static List<String> linhas = lerFicheiro("output.txt");
    private static Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
    private static Map<Integer, Jogadores> jogadores = new HashMap<>(); //numero, Jogadores
    private static List<JogoFeito> jogos = new ArrayList<>();
    private static Equipa ultima = null; 
    private static Jogadores j = null;
    private static String[] linhaPartida;
    private static Jogadores j1 = new Guarda_Redes();
    private static Jogadores j2 = new Avancados();
    private static Jogadores j3 = new Medios();
    private static Jogadores j4 = new Laterais();
    private static Jogadores j5 = new Defesas();

    public static void parse() throws LinhaIncorretaException {

        
        for (String linha : linhas) {
            j = null;
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome_equipa(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = j1.parse(linhaPartida[1]);
                    jogadores.put(j.getNum_camisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = j5.parse(linhaPartida[1]);
                    jogadores.put(j.getNum_camisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = j3.parse(linhaPartida[1]);
                    jogadores.put(j.getNum_camisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = j4.parse(linhaPartida[1]);
                    jogadores.put(j.getNum_camisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = j2.parse(linhaPartida[1]);
                    jogadores.put(j.getNum_camisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.insereJogador(j); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    JogoFeito jo = JogoFeito.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }
        //debug
        for (Equipa e: equipas.values()){
            System.out.println(e.toString());
        }
        for (JogoFeito jog: jogos){
            System.out.println(jog.toString());
        }
        // for(Jogadores jf : jogadores.values())
        // {
        //     System.out.println(jf.toString());
        // }


    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }

    

    public static Map getJogadores(){
        return Parser.jogadores;
    }
}
