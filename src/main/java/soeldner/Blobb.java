package soeldner;

import ausruestung.Ruestung;
import ausruestung.Waffe;
import kaempfer.Kaempfend;

public class Blobb extends Kaempfend{

    private Waffe waffe;

    public Blobb(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (this.waffe != null) { // Nur, falls Kollege schon waffen hat!
            schadenswert += waffe.zuhauen(geschick);
            System.out.println("Blobb haut zu!");
        } else {
            System.out.println("Blobb haut mit Faeusten!");
            schadenswert = geschick;
        }
        return schadenswert;
    }

    @Override
    public int abwehren(int angriff) {
        return this.gesundheit -= angriff;
    }

    @Override
    public void nimmWaffe(Waffe w) {
        this.waffe = w;
    }

    @Override
    public void nimmRuestung(Ruestung r) {
        System.out.println("Blobb kann keine Ruestung tragen!");
        System.out.println("Das Geld verlierst Du trotzdem.");
    }

    @Override
    public String toString() {
        return "Blobb (Sold:" + sold + ")";
    }

    public Waffe getWaffe() {
        return waffe;
    }

    public void setWaffe(Waffe waffe) {
        this.waffe = waffe;
    }





}
