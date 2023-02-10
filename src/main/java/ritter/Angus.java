package ritter;

import ware.Ruestung;
import ware.Trank;
import ware.Waffe;
import figuren.Kaempfend;

public class Angus extends Kaempfend{

    private Waffe waffe;
    private Ruestung ruestung;


    public Angus(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
    }

    @Override
    public int kaempfen() {

        //Hier Rechteck
        int schadenswert = 0;
        if (this.waffe != null) { // Nur, falls Kollege schon waffen hat!
            schadenswert += waffe.zuhauen(geschick);
            System.out.println("Angus schlaegt mit seiner Waffe!");
        } else {
            System.out.println("Angus schlaegt mit Faeusten!");
            schadenswert = geschick;
        }

        return schadenswert;
    }

    @Override
    public void abwehren(int angriff) {
        this.gesundheit -= angriff;
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
            System.out.println("Angus ist vollstaendig geheilt!");
        } else {
            System.out.println("Angus auf " + this.gesundheit + " geheilt.");
        }
    }

    @Override
    public String toString() {
        return "Angus: "  + this.gesundheit;
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
