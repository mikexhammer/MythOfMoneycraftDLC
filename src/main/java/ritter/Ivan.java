package ritter;

import figuren.Kaempfend;
import ware.Ruestung;
import ware.Trank;
import ware.Waffe;

public class Ivan extends Kaempfend{

    private Waffe waffe;

    public Ivan(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (this.waffe != null) { // Nur, falls Kollege schon waffen hat!
            schadenswert += waffe.zuhauen(geschick);
            System.out.println("Ivan haut zu!");
        } else {
            System.out.println("Ivan haut mit Faeusten!");
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
        System.out.println("Ivan kann keine Ruestung tragen!");
        System.out.println("Das Geld verlierst Du trotzdem.");
    }

    public void nimmTrank(Trank t) {
        this.setGesundheit(this.gesundheit + t.getAufbau());
        if (this.gesundheit == 100) {
            System.out.println("Ivan ist vollstaendig geheilt!");
        } else {
            System.out.println("Ivan auf " + this.gesundheit + " geheilt.");
        }
    }

    @Override
    public String toString() {
        return "Ivan: " + this.gesundheit;
    }

    public Waffe getWaffe() {
        return waffe;
    }

    public void setWaffe(Waffe waffe) {
        this.waffe = waffe;
    }





}
