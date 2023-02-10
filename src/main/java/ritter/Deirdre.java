package ritter;

import ware.Ruestung;
import ware.Trank;
import ware.Waffe;
import figuren.Kaempfend;

public class Deirdre extends Kaempfend {

    private Waffe waffe;
    private Ruestung ruestung;

    public Deirdre(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
    }

    @Override
    public String toString() {
        return "Deirdre: "  + this.gesundheit;
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (this.waffe != null) { // Nur, falls Kollege schon waffen hat!
            schadenswert += waffe.zuhauen(geschick);
            System.out.println("Deirdre schlaegt mit ihrer Waffe!");
        } else {
            System.out.println("Deirdre schlaegt mit Faeusten!");
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

    @Override
    public void nimmTrank(Trank t) {
        this.setGesundheit(this.gesundheit + t.getAufbau());
        if (this.gesundheit == 100) {
            System.out.println("Deirdre ist vollstaendig geheilt!");
        } else {
            System.out.println("Deirdre auf " + this.gesundheit + " geheilt.");
        }
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
