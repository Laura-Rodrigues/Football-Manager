import java.util.ArrayList;

public class programa{
	public static void main(String[] args){


		Jogadores jog1 = new Jogadores("Andre Goncalves Pinto", 1, 30000, 0,
                        99999999, 100, 101,
                         0,Jogadores.Class_jog.MED);
		Jogadores jog2 = new Jogadores("Andre Goncalves Correia", 20, 30000, 0,
				99999999, 100, 101, 0,
				Jogadores.Class_jog.GRD);
		Jogadores jog3 = new Jogadores("Madelena Silva", Jogadores.Class_jog.AVA);
		Jogadores jog4 = new Jogadores("Tino Costa", Jogadores.Class_jog.AVA);
		Jogadores jog5 = new Jogadores("Artur Veloz", Jogadores.Class_jog.MED);


		ArrayList<Jogadores> plantel = new ArrayList<Jogadores>();

		plantel.add(jog1);
		plantel.add(jog2);
		plantel.add(jog3);
		plantel.add(jog4);
		plantel.add(jog5);

		 /*

		System.out.println(jog1.toString());
		System.out.println(jog2.toString());
		*/


		Equipa equipa1 = new Equipa(plantel,plantel,"Merelinense",20,31,14,0,0);

		//System.out.println( equipa1.getJogadores().toString());
		equipa1.SortTeam();
		//System.out.println( equipa1.getJogadores().toString());

	}
}