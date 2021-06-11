import Model.*;
import Model.Exceptions.LinhaIncorretaException;
import Model.Game.Jogo;

import java.util.ArrayList;

import Controller.Parser.Loadable_Parser;
import Controller.Parser.Parser;
import Controller.*;

public class programa{
	public static void main(String[] args) throws Exception {

		Jogadores jog3 = new Avancados("Madelena Silva");
		Jogadores jog4 = new Avancados("Tino Costa");
		Jogadores jog5 = new Medios("Artur Veloz");
		Jogadores jog6 = new Guarda_Redes("Arturito Veloz");
		Jogadores jog7 = new Laterais("Aars");
		Jogadores jog8 = new Defesas("Veloz");
		Jogadores jog9 = new Avancados("Rei");
		Jogadores jog10 = new Medios("DInossauro");
		Jogadores jog11 = new Avancados("Ovo");
		Jogadores jog12 = new Medios("Banana");
		Jogadores jog13 = new Defesas("Avestruz");
		Jogadores jog14 = new Defesas("Camelo");
		Jogadores jog15 = new Medios("Girafa");
		Jogadores jog16 = new Medios("Leao");
		Jogadores jog17 = new Medios("Crocodilo");
		Jogadores jog18 = new Medios("Tubarao");
		Jogadores jog19 = new Medios("Morcego");
		Jogadores jog20 = new Guarda_Redes("Ave");
		Jogadores jog21 = new Medios("Cao");


		ArrayList<Jogadores> plantel = new ArrayList<Jogadores>();

		
		plantel.add(jog3);
		plantel.add(jog4);
		plantel.add(jog5);
		plantel.add(jog7);
		plantel.add(jog8);
		plantel.add(jog9);
		plantel.add(jog10);
		plantel.add(jog11);
		plantel.add(jog12);
		plantel.add(jog13);
		plantel.add(jog14);
		plantel.add(jog15);
		plantel.add(jog16);
		plantel.add(jog17);
		
		int meu_plantel_array[] = new int[]{1,2,3,4,1};
		Equipa equipa1 = new Equipa(plantel,"Merelinense",0,0,0,0,0,meu_plantel_array);
		equipa1.insereJogador(jog6);
		equipa1.makeBestTeam();
		

		Equipa equipa2 = new Equipa(plantel,"Vila Verde",0,31,0,20,0,meu_plantel_array);
		equipa2.insereJogador(jog18);
		equipa2.insereJogador(jog19);
		equipa2.insereJogador(jog20);
		equipa2.insereJogador(jog21);

		equipa2.makeBestTeam();

		


		// Jogo game = new Jogo(equipa1,equipa2);
		// game.Simulate();

		// System.out.println(equipa2);


		try {Parser.parse("output.txt");}
		catch(LinhaIncorretaException e) {
			System.out.println("Ocorreu um erro lendo do ficheiro.");
		}
		Equipa e5 = Parser.getEquipas().get("Sporting Club Schubert");
		Equipa e6 = Parser.getEquipas().get("Handel Athletic");
		System.out.println(e6);
		Jogo game = new Jogo(e5,e6);
		//game.Substitute(e5);

		try{game.Substitute(e5, 51, 214);}
		catch(Exception e){System.out.println(e);};

		game.Simulate();

		// Jogo game1;
		// for (Equipa equipa_file : Parser.getEquipas().values()) {
		// 	game1 = new Jogo(equipa1,equipa_file);
		// 	game1.Simulate();
		// }
			
		//SerializeData.serialize_Parser(Parser.);

		Loadable_Parser l = Parser.parser_toLoadable();
		SerializeData.serialize_LoadableParser(l);
		SerializeData.deserialize_LoadableParser();


		System.out.println(Parser.getJogadores());

	}
}