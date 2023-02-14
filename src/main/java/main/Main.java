package main;

import helper.AusgabeTon;
import logik.Spiel;


/**
 * Haelt ein Objekt der Klasse Spiel und ruft die start Methode auf
 */
public class Main {

    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        AusgabeTon.backgroundSound(30,"melodie.wav");
        spiel.initialize();
        spiel.start();
    }

}
