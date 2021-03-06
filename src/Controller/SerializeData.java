package Controller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import Model.*;
import Model.Game.*;
import java.lang.String;

import Controller.Parser.*;

public class SerializeData implements Serializable{
   public static String s1 = "/tmp/loadableparser.ser";

   /* Cria um ficheiro serializable e escreve os dados */
   public static void serialize_LoadableParser(Loadable_Parser p) {

        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/loadableparser.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in tmp/loadableparser.ser\n");
         } catch (IOException i) {
            i.printStackTrace();
         }
    }

   /* Lê de um ficheiro serializable */
    public static void deserialize_LoadableParser(String s) throws ClassNotFoundException {
    
         Loadable_Parser l;
         try {
            if (s.compareTo("") == 0) s = s1;
            FileInputStream fileIn = new FileInputStream(s);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            l = (Loadable_Parser) in.readObject();
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
            return;
         }
         Parser.Loadable_to_Parser(l);
         System.out.println("Ficheiro desserializado com sucesso\n");
    }

    /* Permite guardar o jogador em ficheiro para mais tarde poder ser carregado */
    public static void serialize_Jogador(Jogadores j) {
        try {
            FileOutputStream fileOut =
            new FileOutputStream("/tmp/jogador.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(j);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in tmp/jogador.ser");
         } catch (IOException i) {
            i.printStackTrace();
         }
    }

    /* Permite guardar o jogo em ficheiro para mais tarde poder ser carregado */
    public static void serialize_Jogo(Jogo j) {
        try {
            FileOutputStream fileOut =
            new FileOutputStream("/tmp/jogo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(j);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in tmp/jogo.ser");
         } catch (IOException i) {
            i.printStackTrace();
         }
    }

    /* Permite guardar a equipa em ficheiro para mais tarde poder ser carregada */
    public static void serialize_Equipa(Equipa e) {
        try {
            FileOutputStream fileOut =
            new FileOutputStream("/tmp/equipa.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in tmp/equipa.ser");
         } catch (IOException i) {
            i.printStackTrace();
         }
    }

    /* Lê de um ficheiro serializable um jogador */
    public static Jogadores deserialize_Jogador() throws ClassNotFoundException {
    
         Jogadores novo_jogador;
         try {
            FileInputStream fileIn = new FileInputStream("/tmp/jogador.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            novo_jogador = (Jogadores) in.readObject();
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
            return null;
         }
         return novo_jogador;
    }

    /* Lê de um ficheiro serializable um jogo */
    public static Jogo deserialize_Jogo() throws ClassNotFoundException {
    
         Jogo jogo;
         try {
            FileInputStream fileIn = new FileInputStream("/tmp/jogo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            jogo = (Jogo) in.readObject();
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
            return null;
         }
         return jogo;
    }

    /* Lê de um ficheiro serializable uma equipa */
    public static Equipa deserialize_Equipa() throws ClassNotFoundException {
    
         Equipa e;
         try {
            FileInputStream fileIn = new FileInputStream("/tmp/equipa.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Equipa) in.readObject();
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
            return null;
         }
         return e;
    }
   
    
}
