//package com.code;

//import code.*;

import java.util.ArrayList;


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
		Jogadores jog20 = new Medios("Ave");
		Jogadores jog21 = new Medios("Cao");


		ArrayList<Jogadores> plantel = new ArrayList<Jogadores>();

		
		plantel.add(jog3);
		plantel.add(jog4);
		plantel.add(jog5);
		plantel.add(jog6);
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
		Equipa equipa1 = new Equipa(plantel,"Merelinense",20,31,14,0,0,meu_plantel_array);
		equipa1.makeBestTeam();
		

		Equipa equipa2 = new Equipa(plantel,"Vila Verde",0,31,0,20,0,meu_plantel_array);

		equipa2.addJogador(jog18);
		equipa2.addJogador(jog19);
		equipa2.addJogador(jog20);
		equipa2.addJogador(jog21);

		equipa2.makeBestTeam();

		System.out.println(equipa1.existPlayer(jog15));
		
		equipa1.changeTeam(jog15,equipa2);

		System.out.println(equipa1.existPlayer(jog15));

		System.out.println(jog15.toString());

		Jogo game = new Jogo(equipa1,equipa2);
		game.Startgame();
		game.Simulate();

		System.out.println(equipa2);


		String s = "Laura Nunes Rodrigues,20,59,51,73,75,6,100,60,70";
		
		Jogadores meu_gr = new Guarda_Redes();
		Jogadores grzinho =  meu_gr.parse(s);
		System.out.println(grzinho.toString());

		Parser.parse();
		Jogadores fake = (Jogadores) Parser.getJogadores().get(10);
		equipa1.changeTeam(fake,equipa2);
		System.out.println(fake);

	}
}