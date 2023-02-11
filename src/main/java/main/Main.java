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
        Messages.changeLocation(new Locale("de","DE"));
        Spiel spiel = new Spiel();
        AusgabeTon.melodieNEU();
        spiel.initialize();
        spiel.start();
    }

}
