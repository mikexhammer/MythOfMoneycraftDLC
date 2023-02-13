package logik;

import asciiArt.Graphics;
import helper.*;
import figuren.Kaempfend;
import figuren.Maeve;
import ritter.Angus;
import ritter.Deirdre;
import ritter.Ivan;
import ritter.Rohan;
import ware.Ruestung;
import ware.Trank;
import ware.Waffe;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Hauptklasse der Anwendung
 * Haelt eine Liste an bisher erworbenen Rittern,
 * einen Gegner, welcher Levelabhaengig an Staerke gewinnt,
 * Gold, welches zum Start den Wert 600 bestitzt,
 * die bisher erreichten Level,
 * sowie alle im Spiel moeglichen Ausruestungen und Sprachpakete der Anwendung.
 *
 */
public class Spiel {

    Locale englisch = Locale.GERMAN;
    Locale deutsch = Locale.ENGLISH;
    private List<Kaempfend> kaempfende = new ArrayList<Kaempfend>();
    private Kaempfend maeven;
    private int gold = 500;
    private int lvl = 1;

    public List<Kaempfend> getKaempfende() {
        return kaempfende;
    }

    public int getGold() {
        return gold;
    }

    public int getLvl() {
        return lvl;
    }


    /**
     * Moegliche zu erwerbende Ritter
     */
    private String Rohan = ConsoleColors.YELLOW + "Rohan\t" + ConsoleColors.RESET;
    private String Dierdre = ConsoleColors.YELLOW + "Dierdre\t" + ConsoleColors.RESET;
    private String Angus = ConsoleColors.YELLOW + "Angus\t" + ConsoleColors.RESET;
    private String Ivan = ConsoleColors.YELLOW + "Ivan\t" + ConsoleColors.RESET;
    private String[] ritter;
    /**
     * Moegliche zu erwerbende Ruestung
     */
    private Ruestung[] ruestungen;

    /**
     * Moegliche zu erwerbende Waffen
     */
    private Waffe[] waffen;
    /**
     * Moegliche zu erwerbende Traenke
     */
    private Trank[] trank;
    /**
     * Sprachen Englisch und Deutsch
     */
    private String[] sprache;

    /**
     * intialisiert die Variablen
     * - Ruestung[] ruestung
     * - String[] ritter
     * - Waffe[] waffen
     * - Trank[] trank
     * - String[] sprache
     * die Methode wird in der main()-Methode aufgerufen
     * und jedes mal, wenn die Sprache geändert wird
     */
    public void initialize() {

        sprache = new String[]{
        Messages.getString("Main.57"),
        Messages.getString("Main.58"),
        };

        trank = new Trank[] {
                new Trank(Messages.getString("Main.31"), 10, 50),
                new Trank(Messages.getString("Main.32"), 20, 70),
                new Trank(Messages.getString("Main.33"), 50, 100),
                new Trank(Messages.getString("Main.34"), 90, 150),
        };
        waffen = new Waffe[]{
                new Waffe(Messages.getString("Main.4"), 4, 30),
                new Waffe(Messages.getString("Main.5"), 7, 70),
                new Waffe(Messages.getString("Main.6"), 8, 90),
                new Waffe(Messages.getString("Main.7"), 10, 120)
        };
        ruestungen = new Ruestung[]{
                new Ruestung(Messages.getString("Main.0"), 4, 20),
                new Ruestung(Messages.getString("Main.1"), 6, 50),
                new Ruestung(Messages.getString("Main.2"), 7, 70),
                new Ruestung(Messages.getString("Main.3"), 10, 100)};

        ritter = new String[]{
                Ausgabe.ritterAnzeige(Rohan, 60, 6, 120),
                Ausgabe.ritterAnzeige(Dierdre, 30, 8, 130),
                Ausgabe.ritterAnzeige(Angus, 90, 6, 140),
                Ausgabe.ritterAnzeige(Ivan, 80, 7, 150)};
    }


    /**
     * Einstiegsmethode der Anwendung, startet das Hauptmenu
     * Nutzt Hilfsklasse "Ausgabe" fuer Textausgabe im Terminal
     * erwartet Eingabe des Nutzers, verwendet fuer das einlesen die Hilfklasse "Eingabe"
     * Auf Basis dieser kann zwischen
     * - Spiel starten
     * - Sprache aendern
     * - Information
     * - Spiel beenden
     * entschieden / gewechselt werden
     */
    public void start() {
        ConsoleClear.clear();
        Ausgabe.aktuelleSprache();
        Ausgabe.startMenu();

        int eingabe = -1;

        while (eingabe != 0) {
            Ausgabe.auswahlStartMenu();
            eingabe = Eingabe.leseInt();

            if (eingabe == 1) {
                Ausgabe.auswahlSprache();
                int auswahl = this.auswahl(this.sprache);
                if (auswahl == this.sprache.length) {
                    start();
                }

                if (auswahl == 0) {
                    //Ausgabe.setzeDeutsch();
                    //Ausgabe.aktuelleSprache();
                    Messages.changeLocation(new Locale("de", "DE"));
                    initialize();
                    //Ausgabe.neueSprache();
                    start();
                }

                if (auswahl == 1) {
                    //Ausgabe.setzeEnglisch();
                    //Ausgabe.aktuelleSprache();
                    Messages.changeLocation(new Locale("en", "EN"));
                    initialize();
                    //Ausgabe.neueSprache();
                    start();
                }

            }

            if (eingabe == 2) {
                if(Locale.getDefault().getLanguage() == "de") {
                    Ausgabe.storyDeutsch();
                } else {
                    Ausgabe.storyEnglisch();
                }
                Ausgabe.zurueck();
                int auswahl = Eingabe.leseInt();
                start();
            }

            if (eingabe == 3) {
                return;
            }

        }

        this.mainMenu();
    }


    /**
     * Methode fuer Spielstart
     * generiert einen Levelspezifischen Gegner und zeigt das Hauptmenu an
     * Spieler kann Ritter oder Waren (insofern Ritter bereits vorhandne) erwerben und den Kampf starten oder ins Startmenue wechseln
     *
     */
    public void mainMenu() {
        ConsoleClear.clear();
        maeven = new Maeve(100,5+lvl,100);
        int eingabe = -1;
        while (eingabe != 0) {
            //Aktuelles Level
            Ausgabe.dottedLine(150);
            Ausgabe.aktuellesLvl(this.lvl);
            //Falls vorhanden, uebersicht der aktuellen Ritter
            if (!kaempfende.isEmpty()) {
                Ausgabe.asterikLine(9);
                Ausgabe.aktuelleRitter();
                for (Kaempfend k: kaempfende){
                Ausgabe.listeRitter(k);
                if (kaempfende.size() > 1){
                    Ausgabe.dottedLine(5);
                }
                }
                Ausgabe.asterikLine(9);
            }
            //Menu
            Ausgabe.kampfMenu(this.gold);
            eingabe = Eingabe.leseInt();
            if (eingabe == 1) {
                this.neuerRitter();
            }
            if (eingabe == 2) {
                if (this.kaempfende.isEmpty()) {
                    Ausgabe.keineRitter();
                } else {
                    this.neueWaffe();
                }
            }
            if (eingabe == 3) {
                if (this.kaempfende.isEmpty()) {
                    Ausgabe.keineRitter();
                } else {
                    this.neueRuestung();
                }
            }
            if (eingabe == 4) {
                if (this.kaempfende.isEmpty()) {
                    Ausgabe.keineRitter();
                } else {
                    this.neuerTrank();
                }
            }
            //Beenden
            if (eingabe == 5) {
                Ausgabe.spielBeendet();
                start();
            }


            if (this.gold < 0) {
                Ausgabe.betrugerHingerichtet();
                return;
            }
        }

        if (this.kaempfende.isEmpty()) {
            Ausgabe.keineRitter();
            this.mainMenu();
        } else {
            this.kaempfen();
        }
    }

    /**
     * Hilfsmethode zum Anzeigen und Waehlen der moeglichen Ritter, Waren und Sprachen
     * bekommt ein Array und erweitert dieses um einen weiteren Menuepunkt "zurueck"
     * Gibt Eingabe des Nutzers als int zurueck
     * @param o Array von Objekten
     * @return int Eingabe des Nutzers
     */
    public int auswahl(Object[] o) {
        if (o == null) {
            Ausgabe.aktionVerpufft();
            return -1;
        }
        for (int i = 0; i < o.length; i++) {
            System.out.println("(" + i + ") " + o[i]);
        }
        System.out.println("(" + o.length + ") " + Messages.getString("Main.38"));
        int ergebnis = -1;
        while (ergebnis < 0 || ergebnis >= o.length + 1) {
            ergebnis = Eingabe.leseInt();
        }
        return ergebnis;
    }

    /**
     * Ermoeglicht dem Spieler den Erwerb einer neuen Ruestung
     * prueft ob genuegend Gold vorhanden ist
     * laesst Spieler Ruestung waehlen, verringert Gold um Preis und fuegt diese zu gewaehltem Ritter hinzu
     */
    public void neueRuestung() {
        ConsoleClear.clear();
        Ausgabe.welcheRuestung(this.gold);
        int eingabe = this.auswahl(this.ruestungen);
        if (eingabe == this.ruestungen.length) {
            ConsoleClear.clear();
            return;
        } else if (eingabe >= 0 && eingabe <= this.ruestungen.length - 1) {
            Ruestung r = this.ruestungen[eingabe];
            if (r.getPreis() > this.gold) {
                Ausgabe.zuWenigGold();
                neueRuestung();
            } else {
                Ausgabe.welcherRitter(this.gold);
                eingabe = this.auswahl(this.kaempfende.toArray());
                if (eingabe == this.kaempfende.toArray().length) {
                    neueRuestung();
                } else if (eingabe >= 0 && eingabe <= this.kaempfende.toArray().length - 1) {
                    Kaempfend k = this.kaempfende.get(eingabe);
                    this.gold -= r.getPreis();
                    k.nimmRuestung(r);

                }
            }
        }

    }

    /**
     * Ermoeglicht dem Spieler den Erwerb einer neuen Waffe
     * prueft ob genuegend Gold vorhanden ist
     * laesst Spieler Waffe waehlen, verringert Gold um Preis und fuegt diese zu gewaehltem Ritter hinzu
     */
    public void neueWaffe() {
        ConsoleClear.clear();
        Ausgabe.welcheWaffe(this.gold);
        int eingabe = this.auswahl(this.waffen);
        if (eingabe == this.waffen.length) {
            ConsoleClear.clear();
            return;
        } else if (eingabe >= 0 && eingabe <= this.waffen.length - 1) {
            Waffe w = this.waffen[eingabe];
            if (w.getPreis() > this.gold) {
                Ausgabe.zuWenigGold();
                neueWaffe();
            } else {
                Ausgabe.welcherRitter(this.gold);
                eingabe = this.auswahl(this.kaempfende.toArray());
                if (eingabe == this.kaempfende.toArray().length) {
                    neueWaffe();
                } else if (eingabe >= 0 && eingabe <= this.kaempfende.toArray().length - 1) {
                    Kaempfend k = this.kaempfende.get(eingabe);
                    this.gold -= w.getPreis();
                    k.nimmWaffe(w);

                }
            }
        }


    }

    /**
     * Ermoeglicht dem Spieler den Erwerb eines neuen Tranks
     * prueft ob genuegend Gold vorhanden ist
     * laesst Spieler Trank waehlen, verringert Gold um Preis und fuegt diese zu gewaehltem Ritter hinzu
     */
    private void neuerTrank() {
        ConsoleClear.clear();
        Ausgabe.welcherTrank(this.gold);
        int eingabe = this.auswahl(this.trank);
        if (eingabe == this.trank.length) {
            ConsoleClear.clear();
            return;
        }
        else if (eingabe >= 0 && eingabe <= this.trank.length - 1) {
            Trank t = this.trank[eingabe];
            if (t.getPreis() > this.gold) {
                Ausgabe.zuWenigGold();
                neuerTrank();
            } else {
                Ausgabe.welcherRitter(this.gold);
                eingabe = this.auswahl(this.kaempfende.toArray());
                if (eingabe == this.kaempfende.toArray().length) {
                    neuerTrank();
                } else if (eingabe >= 0 && eingabe <= this.kaempfende.toArray().length - 1) {
                    Kaempfend k = this.kaempfende.get(eingabe);
                    this.gold -= t.getPreis();
                    k.nimmTrank(t);

                }
            }
        }


    }

    /**
     * Ermoeglicht dem Spieler den Erwerb eines neuen Ritters
     * laesst Spieler Ritter waehlen, prueft ob genuegend Gold vorhanden ist
     * verringert Gold um Preis und fuegt diese zur Liste Kaempfende hinzu
     */
    public void neuerRitter() {
        ConsoleClear.clear();
        Ausgabe.welcherRitter(this.gold);
        Kaempfend k = null;
        int wahl = this.auswahl(this.ritter);
        switch (wahl) {
            case 0: {
                k = new Rohan(60, 6, 120);
                break;
            }
            case 1: {
                k = new Deirdre(30, 8, 130);
                break;
            }
            case 2: {
                k = new Angus(90, 4, 140);
                break;
            }
            case 3: {
                k = new Ivan(80, 7, 150);
                break;
            }
            case 4: {
                ConsoleClear.clear();
                break;
            }
            default: {
                throw new IllegalArgumentException(
                        Messages.getString("Main.Exception") + ": " + wahl);
            }
        }
        if (k != null) {
            if (k.getSold() > this.gold) {
                Ausgabe.zuWenigGold();
                neuerRitter();
            } else {
                this.kaempfende.add(k);
                this.gold -= k.getSold();

            }
        }
    }

    /**
     * Iteriert durch Liste Kaempfende
     * fuehrt fuer jeden Eintrag die Methode kaempfen() und anschliessend abwehren() aus
     * bei negativer / nicht vorhandener Gesundheit des Ritters wird dieser aus der Liste entfernt
     * bei negativer / nicht vorhandener Gesundheit des Gegners, Maeve, ist das Level gewonnen
     * Gold wird somit um 500 erhoeht
     * Level wird um 1 erhoeht
     */
    private void kaempfen(){
        ConsoleClear.clear();
        Graphics.kampfStart();
        while (!this.kaempfende.isEmpty()) {
            for (Kaempfend k : kaempfende) {
                maeven.abwehren(k.kaempfen());
                k.abwehren(maeven.kaempfen());
                System.out.println(Messages.getString("Main.28") + k.toString());
                Ausgabe.dottedLine();
                System.out.println(Messages.getString("Main.29") + maeven.toString() + "\n");

                if (maeven.getGesundheit() <= 0) {
                    //Level geschafft
                    Ausgabe.maevenBesiegt(this.lvl);
                    AusgabeTon.besiegt();
                    this.gold += 500;
                    this.lvl++;
                    this.mainMenu();
                }

                if (k.getGesundheit() <= 0) {
                    AusgabeTon.gefallen();
                    Graphics.tot();
                    System.out.println(ConsoleColors.RED_BOLD + k.toString() + Messages.getString("Main.27") + ConsoleColors.RESET);
                    kaempfende.remove(k);
                    break;
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Ausgabe.kampfVerloren();
        AusgabeTon.verloren();
        this.gold = 600;
        this.lvl = 1;
        this.mainMenu();
    }

}

