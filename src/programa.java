import java.util.ArrayList;

public class programa{
	public static void main(String[] args){

		Jogadores jog1 = new Jogadores("Andre Goncalves Pinto", 1, 30000, 0,
                        99999999, 100, 101, 0,
                         0,Jogadores.Class_jog.MED);
		Jogadores jog2 = new Jogadores("Andre Goncalves Correia", 20, 30000, 0,
				99999999, 100, 101, 0,
				0,Jogadores.Class_jog.GRD);
		ArrayList<Jogadores> plantel = new ArrayList<Jogadores>();

		plantel.add(jog1);
		plantel.add(jog2);

		 /*
		System.out.println(jog1.toString());
		System.out.println(jog2.toString());
		*/
		Equipa equipa1 = new Equipa(plantel,plantel,"Merelinense",20,31,14,0,0);

		//System.out.println( equipa1.getJogadores().toString());
		boolean ok = equipa1.makeTeam();
		//System.out.println( equipa1.getJogadores().toString());

	}
}