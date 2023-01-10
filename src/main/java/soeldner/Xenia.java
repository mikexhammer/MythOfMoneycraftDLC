package soeldner;

import ausruestung.Ruestung;
import ausruestung.Waffe;
import kaempfer.Kaempfend;

public class Xenia extends Kaempfend {

    private Waffe waffe;
    private Ruestung ruestung;

    public Xenia(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
    }

    @Override
    public String toString() {
        return "Xenia (Sold:" + sold + ")";
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (this.waffe != null) { // Nur, falls Kollege schon waffen hat!
            schadenswert += waffe.zuhauen(geschick);
            System.out.println("Xenia haut zu!");
        } else {
            System.out.println("Xenia haut mit Faeusten!");
            schadenswert = geschick;
        }
        return schadenswert;
    }

    @Override
    public int abwehren(int angriff) {
        int schadenswert = angriff;
        if (this.ruestung != null) {
            schadenswert = ruestung.abwehr(schadenswert);
        }
        return this.gesundheit -= schadenswert;
    }

    @Override
    public void nimmWaffe(Waffe w) {
        this.waffe = w;
    }

    @Override
    public void nimmRuestung(Ruestung r) {
        this.ruestung = r;
    }

    public Waffe getWaffe() {
        return waffe;
    }

    public void setWaffe(Waffe waffe) {
        this.waffe = waffe;
    }

    public Ruestung getRuestung() {
        return ruestung;
    }

    public void setRuestung(Ruestung ruestung) {
        this.ruestung = ruestung;
    }

}
