package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ausruestung.*;
import kaempfer.*;
import soeldner.*;

//Robin hier alles AGAGAGAG

public class Main {

    private List<Kaempfend> kaempfende = new ArrayList<Kaempfend>();
    private Kaempfend sr = new SchwarzerRitter();
    private int duplosen = 600;
    private String[] soeldner = {"Conan","Xenia","Blobb"};
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

    public void starten() {
        System.out.println(Messages.getString("Main.8")
                           + "==================\n"); //$NON-NLS-1$
        int eingabe = -1;
        while (eingabe != 0) {
            System.out.println(Messages.getString("Main.10") + this.duplosen //$NON-NLS-1$
                               + Messages.getString("Main.11") //$NON-NLS-1$
                               + Messages.getString("Main.12") //$NON-NLS-1$
                               + Messages.getString("Main.13") //$NON-NLS-1$
                               + Messages.getString("Main.14") //$NON-NLS-1$
                               + Messages.getString("Main.15")); //$NON-NLS-1$
            eingabe = Eingabe.leseInt();
            if (eingabe == 1) {
                this.neuerSoeldner();
            }
            if (eingabe == 2) {
                this.neueWaffe();
            }
            if (eingabe == 3) {
                this.neueRuestung();
            }
            if (this.duplosen < 0) {
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
        this.duplosen -= r.getPreis();
        System.out.println(Messages.getString("Main.21")); //$NON-NLS-1$
        Kaempfend k = this.kaempfende.get(this.auswahl(this.kaempfende.toArray()));
        k.nimmRuestung(r);
    }

    //Absturz, wenn vorher kein Kaempfend gewaehlt
    public void neueWaffe() {
        System.out.println(Messages.getString("Main.22")); //$NON-NLS-1$
        Waffe w = this.waffen[this.auswahl(this.waffen)];
        this.duplosen -= w.getPreis();
        System.out.println(Messages.getString("Main.23")); //$NON-NLS-1$
        Kaempfend k = this.kaempfende.get(this.auswahl(this.kaempfende.toArray()));
        k.nimmWaffe(w);
    }

    public void neuerSoeldner() {
        System.out.println(Messages.getString("Main.24")); //$NON-NLS-1$
        Kaempfend k = null;
        String wahl = this.soeldner[this.auswahl(this.soeldner)];
        switch(wahl){
            case "Conan": {
                k = new Conan(40, 6, 120);
                break;
            }
            case "Xenia": {
                k = new Xenia(60, 8, 110);
                break;
            }
            case "Blobb": {
                k = new Blobb(80, 10, 100);
                break;
            }
            default: {
                throw new IllegalArgumentException(
                        Messages.getString("Main.Exception") + ": " + wahl);
            }
        }
        this.kaempfende.add(k);
        this.duplosen -= k.getSold();
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
                sr.abwehren(k.kaempfen());
                k.abwehren(sr.kaempfen());
                //Gesundheit Soeldner
                System.out.println(Messages.getString("Main.28") + k.toString() + ": " + k.getGesundheit());
                //Gesundheit Schwarzer-Ritter
                System.out.println(Messages.getString("Main.29") + sr.getGesundheit() + "\n");

                if (sr.getGesundheit() <= 0) {
                    System.out.println(ConsoleColors.GREEN_BOLD + Messages.getString("Main.26") + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + Messages.getString("Main.25") + ConsoleColors.RESET); //$NON-NLS-1$
                    return;
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
    }

    public int getDuplosen() {
        return this.duplosen;
    }

    public void setDuplosen(int duplosen) {
        this.duplosen = duplosen;
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("de", "DE")); //$NON-NLS-1$ //$NON-NLS-2
        new Main().starten();
    }

}
