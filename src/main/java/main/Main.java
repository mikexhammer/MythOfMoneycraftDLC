package main;

import helper.AusgabeTon;
import helper.Messages;
import logik.Spiel;

import java.util.Locale;


/**
 * Haelt ein Objekt der Klasse Spiel und ruft die start Methode auf
 */
public class Main {

    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        AusgabeTon.background(30);
        spiel.initialize();
        spiel.start();
    }

}
