package ritter;

import figuren.Kaempfend;
import helper.Ausgabe;
import helper.ConsoleColors;
import helper.Messages;
import ware.Ruestung;
import ware.Trank;
import ware.Waffe;

public class Ivan extends Kaempfend{

    private String name = ConsoleColors.YELLOW + "Ivan\t" + ConsoleColors.RESET;
    private Waffe waffe;
    private Ruestung ruestung;


    public Ivan(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (this.waffe != null) { // Nur, falls Kollege schon waffen hat!
            schadenswert += waffe.zuhauen(geschick);
            System.out.println(name + Messages.getString("Main.69"));
        } else {
            System.out.println(name + Messages.getString("Main.70"));
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

    public void nimmTrank(Trank t) {
        this.setGesundheit(this.gesundheit + t.getAufbau());
        if (this.gesundheit == 100) {
            System.out.println(name + Messages.getString("Main.73"));
        } else {
            System.out.println(name + Messages.getString("Main.75") + this.gesundheit + Messages.getString("Main.76"));
        }
    }

    @Override
    public String toString() {
        return Ausgabe.ritterAnzeige(this, name, waffe,ruestung);
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
