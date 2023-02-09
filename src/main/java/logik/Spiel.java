package logik;

import helper.ConsoleColors;
import figuren.Kaempfend;
import figuren.Maeve;
import helper.Ausgabe;
import helper.Eingabe;
import helper.Messages;
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

public class Spiel {


    Locale defaultLocale = Locale.GERMAN;
    private List<Kaempfend> kaempfende = new ArrayList<Kaempfend>();
    private Kaempfend maeven;
    private int gold = 160;
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


    private String[] ritter = {Messages.getString("Main.49"), Messages.getString("Main.50"), Messages.getString("Main.51"), Messages.getString("Main.52")};
    private Ruestung[] ruestungen = {
            new Ruestung(Messages.getString("Main.0"), 4, 20),
            new Ruestung(Messages.getString("Main.1"), 6, 50),
            new Ruestung(Messages.getString("Main.2"), 7, 70),
            new Ruestung(Messages.getString("Main.3"), 10, 100)};

    private Waffe[] waffen = {
            new Waffe(Messages.getString("Main.4"), 4, 30),
            new Waffe(Messages.getString("Main.5"), 7, 70),
            new Waffe(Messages.getString("Main.6"), 8, 90),
            new Waffe(Messages.getString("Main.7"), 10, 120)
    };

    private Trank[] trank = {
            new Trank(Messages.getString("Main.31"), 10, 50),
            new Trank(Messages.getString("Main.32"), 20, 70),
            new Trank(Messages.getString("Main.33"), 50, 100),
            new Trank(Messages.getString("Main.34"), 90, 150),
    };

    private String[] sprache = {
            Messages.getString("Main.57"),
            Messages.getString("Main.58"),
    };

    public void start() {
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
                    Ausgabe.setzeDeutsch();
                    Ausgabe.aktuelleSprache();
                    Messages.changeLocation(new Locale("de", "DE"));
                    Ausgabe.neueSprache();
                    start();
                }

                if (auswahl == 1) {
                    Ausgabe.setzeEnglisch();
                    Ausgabe.aktuelleSprache();
                    Messages.changeLocation(new Locale("en", "EN"));
                    Ausgabe.neueSprache();
                    start();
                }

            }

            if (eingabe == 2) {
                Ausgabe.spielHistorie();
                Ausgabe.zurueck();
                int auswahl = Eingabe.leseInt();
                if (auswahl == 1) {
                    start();
                }
            }

            if (eingabe == 3) {
                return;
            }

        }

        this.mainMenu();
    }

    public void mainMenu() {
        maeven = new Maeve();
        int eingabe = -1;
        while (eingabe != 0) {
            //Aktuelles Level
            Ausgabe.aktuellesLvl(this.lvl);
            //Falls vorhanden, uebersicht der aktuellen Ritter
            if (!kaempfende.isEmpty()) {
                Ausgabe.listeRitter(this.kaempfende);
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
                return;
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

    public int auswahl(Object[] o) {
        if (o == null) {
            Ausgabe.aktionVerpufft();
            return -1;
        }
        for (int i = 0; i < o.length; i++) {
            System.out.println("(" + i + ") " + o[i]);
        }
        //Zurueck
        System.out.println("(" + o.length + ") " + Messages.getString("Main.38"));
        int ergebnis = -1;
        while (ergebnis < 0 || ergebnis >= o.length + 1) {
            ergebnis = Eingabe.leseInt();
        }
        return ergebnis;
    }

    public void neueRuestung() {
        Ausgabe.welcheRuestung();
        int eingabe = this.auswahl(this.ruestungen);

        if (eingabe == this.ruestungen.length) {
            return;
        } else if (eingabe >= 0 && eingabe <= this.ruestungen.length - 1) {
            Ruestung r = this.ruestungen[eingabe];
            if (r.getPreis() > this.gold) {
                Ausgabe.zuWenigGold();
            } else {
                Ausgabe.welcherRitter();
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

    public void neueWaffe() {
        Ausgabe.welcheWaffe();
        int eingabe = this.auswahl(this.waffen);
        if (eingabe == this.waffen.length) {
            return;
        } else if (eingabe >= 0 && eingabe <= this.waffen.length - 1) {
            Waffe w = this.waffen[eingabe];
            if (w.getPreis() > this.gold) {
                Ausgabe.zuWenigGold();
            } else {
                Ausgabe.welcherRitter();
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

    private void neuerTrank() {
        Ausgabe.welcherTrank();
        //Eingabe wird zwischengemerkt
        int eingabe = this.auswahl(this.trank);
        //Wenn zurueck gewaehlt
        if (eingabe == this.trank.length) {
            return;
        }
        //Bei gueltiger Auswahl
        else if (eingabe >= 0 && eingabe <= this.trank.length - 1) {
            Trank t = this.trank[eingabe];
            if (t.getPreis() > this.gold) {
                Ausgabe.zuWenigGold();
            } else {
                Ausgabe.welcherRitter();
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

    public void neuerRitter() {
        Ausgabe.welcherRitter();
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
                break;
            }
            default: {
                throw new IllegalArgumentException(
                        Messages.getString("Main.Exception") + ": " + wahl);
            }
        }
        if (k != null) {
            //Probe ob genug Gold
            if (k.getSold() > this.gold) {
                Ausgabe.zuWenigGold();
            } else {
                this.kaempfende.add(k);
                this.gold -= k.getSold();
            }
        }
    }

    private void kaempfen() {

        while (!this.kaempfende.isEmpty()) {
            for (Kaempfend k : kaempfende) {
                maeven.abwehren(k.kaempfen());
                k.abwehren(maeven.kaempfen());
                //Gesundheit Ritter
                System.out.println(Messages.getString("Main.28") + k.toString());
                //Gesundheit Maeven
                System.out.println(Messages.getString("Main.29") + maeven.getGesundheit() + "\n");

                if (maeven.getGesundheit() <= 0) {
                    //Level geschafft
                    Ausgabe.maevenBesiegt(this.lvl);
                    this.gold += 500;
                    this.lvl++;
                    this.mainMenu();
                }

                if (k.getGesundheit() <= 0) {
                    //Kaempfer besiegt
                    System.out.println(ConsoleColors.RED_BOLD + k.toString() + Messages.getString("Main.27") + ConsoleColors.RESET);
                    kaempfende.remove(k);
                    break;
                }
            }
        }
        //Spiel verloren, faengt bei Level 1 mit 600 Gold an
        Ausgabe.kampfVerloren();
        this.gold = 600;
        this.lvl = 1;
        this.mainMenu();
    }


    public static void main(String[] args) {
        Locale.setDefault(new Locale("de", "DE"));
        new Spiel().start();
    }

}

