package Model.Game;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Esta Class só guarda valores

public class JogoFeito implements Serializable{
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;

    //Chave é o jogador a sair e o valor é o jogador a entrar
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substitucoesFora = new HashMap<>();

    public JogoFeito (String ec, String ef, int gc, int gf, LocalDate d,
      List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
    }
    //Constroi um JogoFeito a partir de uma String formatada
    public static JogoFeito parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new JogoFeito(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                        LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        jc, subsC, jf, subsF);
    }

    public String toString() {
        StringBuilder s1 = new StringBuilder();

        for (Map.Entry<Integer,Integer> n : substituicoesCasa.entrySet()) {
            s1.append(n.getKey()).append(" -> ").append(n.getValue()).append(",");
        }
        //Apaga o ultimo ','
        s1.deleteCharAt(s1.length()-1);

        StringBuilder s2 = new StringBuilder();
        for (Map.Entry<Integer,Integer> n : substitucoesFora.entrySet()) {
            s2.append(n.getKey()).append(" -> ").append(n.getValue()).append(",");
        }
        //Apaga o ultimo ','
        s2.deleteCharAt(s2.length()-1);


        return  "\n" + equipaCasa + " " + golosCasa + " - " + golosFora + " " + equipaFora
                + "\nSubs Casa " + s1.toString()
                + "\nSubs Fora " + s2.toString() ;
}

}