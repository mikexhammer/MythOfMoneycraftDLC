package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ware.*;
import figuren.*;
import ritter.*;

public class Main {

    private List<Kaempfend> kaempfende = new ArrayList<Kaempfend>();
    private Kaempfend maeven;
    private int gold = 600;
    private String[] ritter = {"Rohan","Deirdre","Angus", "Ivan"};
    private Ruestung[] ruestungen = {
            new Ruestung(Messages.getString("Main.0"), 4, 20), //$NON-NLS-1$
            new Ruestung(Messages.getString("Main.1"), 6, 50), //$NON-NLS-1$
            new Ruestung(Messages.getString("Main.2"), 7, 70), //$NON-NLS-1$
            new Ruestung(Messages.getString("Main.3"), 10, 100)}; //$NON-NLS-1$

    private Waffe[] waffen = {
            new Waffe(Messages.getString("Main.4"), 4, 30), //$NON-NLS-1$
            new Waffe(Messages.getString("Main.5"), 7, 70), //$NON-NLS-1$
            new Waffe(Messages.getString("Main.6"), 8, 90), //$NON-NLS-1$
            new Waffe(Messages.getString("Main.7"), 10, 120) //$NON-NLS-1$
    };

    private Trank[] trank = {
            new Trank(Messages.getString("Main.31"), 10, 50),
            new Trank(Messages.getString("Main.32"), 20, 70),
            new Trank(Messages.getString("Main.33"), 50, 100),
            new Trank(Messages.getString("Main.34"), 90, 150),
    };

    public void starten() {
        maeven = new Maeve();
        System.out.println(Messages.getString("Main.8")
                           + "===============\n"); //$NON-NLS-1$
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.println(Messages.getString("Main.10") + this.gold //$NON-NLS-1$
                               + Messages.getString("Main.11") //$NON-NLS-1$
                               + Messages.getString("Main.12") //$NON-NLS-1$
                               + Messages.getString("Main.13") //$NON-NLS-1$
                               + Messages.getString("Main.14") //$NON-NLS-1$
                               + Messages.getString("Main.15") //$NON-NLS-1$
                               + Messages.getString("Main.35") //$NON-NLS-1$
                               + Messages.getString("Main.30")); //$NON-NLS-1$
            eingabe = Eingabe.leseInt();
            if (eingabe == 1) {
                this.neuerRitter();
            }
            if (eingabe == 2) {
                this.neueWaffe();
            }
            if (eingabe == 3) {
                this.neueRuestung();
            }
            if (eingabe == 4) {
                this.neuerTrank();
            }
            if (eingabe == 5) {
                System.out.println(Messages.getString("Main.37"));
                return;
            }

            if (this.gold < 0) {
                System.out.println(Messages.getString("Main.16")); //$NON-NLS-1$
                return;
            }
        }
        this.kaempfen();
    }

    public int auswahl(Object[] o) {
        if (o == null) {
            System.out.println(Messages.getString("Main.17")); //$NON-NLS-1$
            return -1;
        }
        for (int i = 0; i < o.length; i++) {
            System.out.println("(" + i + ") " + o[i]); //$NON-NLS-1$ //$NON-NLS-2$
        }
        int ergebnis = -1;
        while (ergebnis < 0 || ergebnis >= o.length) {
            ergebnis = Eingabe.leseInt();
        }
        return ergebnis;
    }

    //Absturz, wenn vorher kein Kaempfend gewaehlt
    public void neueRuestung() {
        System.out.println(Messages.getString("Main.20")); //$NON-NLS-1$
        Ruestung r = this.ruestungen[this.auswahl(this.ruestungen)];
        this.gold -= r.getPreis();
        System.out.println(Messages.getString("Main.21")); //$NON-NLS-1$
        Kaempfend k = this.kaempfende.get(this.auswahl(this.kaempfende.toArray()));
        k.nimmRuestung(r);
    }

    //Absturz, wenn vorher kein Kaempfend gewaehlt
    public void neueWaffe() {
        System.out.println(Messages.getString("Main.22")); //$NON-NLS-1$
        Waffe w = this.waffen[this.auswahl(this.waffen)];
        this.gold -= w.getPreis();
        System.out.println(Messages.getString("Main.23")); //$NON-NLS-1$
        Kaempfend k = this.kaempfende.get(this.auswahl(this.kaempfende.toArray()));
        k.nimmWaffe(w);
    }

    private void neuerTrank() {
        System.out.println(Messages.getString("Main.36"));
        Trank t = this.trank[this.auswahl(this.trank)];
        this.gold -= t.getPreis();
        System.out.println(Messages.getString("Main.23"));
        Kaempfend k = this.kaempfende.get(this.auswahl(this.kaempfende.toArray()));
        k.nimmTrank(t);
    }

    public void neuerRitter() {
        System.out.println(Messages.getString("Main.24")); //$NON-NLS-1$
        Kaempfend k = null;
        String wahl = this.ritter[this.auswahl(this.ritter)];
        switch(wahl){
            case "Rohan": {
                k = new Rohan(40, 6, 120);
                break;
            }
            case "Deirdre": {
                k = new Deirdre(60, 8, 110);
                break;
            }
            case "Angus": {
                k = new Angus(80, 10, 100);
                break;
            }
            case "Ivan": {
                k = new Ivan(100, 9, 90);
                break;
            }
            default: {
                throw new IllegalArgumentException(
                        Messages.getString("Main.Exception") + ": " + wahl);
            }
        }
        this.kaempfende.add(k);
        this.gold -= k.getSold();
    }

    private void kaempfen() {
        // TODO
        //hier fehlt was
        //missing code
        /*
         * Ja irgendwie so
         * iteriere durch alle deine Soeldner
         * angreifen aufrufen / abwehren beim ritter
         * ritter greift an / abwerhren beim söldner
         * dazwischen immer Main.28 "Gesundheit von" etc
         * if Schwarzer ritter Gesundheit <=0 dann Main.26
         * sonst auch bei den anderen <= dann toString Main.27
         */
        while(!this.kaempfende.isEmpty()) {
            for (Kaempfend k : kaempfende) {
                maeven.abwehren(k.kaempfen());
                k.abwehren(maeven.kaempfen());
                //Gesundheit Soeldner
                System.out.println(Messages.getString("Main.28") + k.toString() + ": " + k.getGesundheit());
                //Gesundheit Schwarzer-Ritter
                System.out.println(Messages.getString("Main.29") + maeven.getGesundheit() + "\n");

                if (maeven.getGesundheit() <= 0) {
                    System.out.println(ConsoleColors.GREEN_BOLD + Messages.getString("Main.26") + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + Messages.getString("Main.25") + ConsoleColors.RESET); //$NON-NLS-1$
                    this.gold += 500;
                    this.starten();
                }

                if (k.getGesundheit() <= 0) {
                    //Kaempfer besiegt
                    System.out.println(ConsoleColors.RED_BOLD + k.toString() + Messages.getString("Main.27") + ConsoleColors.RESET);
                    kaempfende.remove(k);
                    break;
                }
            }
        }
        System.out.println(ConsoleColors.RED_UNDERLINED + Messages.getString("Main.25") + ConsoleColors.RESET); //$NON-NLS-1$

        this.starten();
    }

    public int getDuplosen() {
        return this.gold;
    }

    public void setDuplosen(int duplosen) {
        this.gold = duplosen;
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("de", "DE")); //$NON-NLS-1$ //$NON-NLS-2
        new Main().starten();
    }

}
