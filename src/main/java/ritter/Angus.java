package ritter;

import ware.Ruestung;
import ware.Trank;
import ware.Waffe;
import figuren.Kaempfend;

import javax.xml.transform.stream.StreamSource;

public class Angus extends Kaempfend{

    private Waffe waffe;
    private Ruestung ruestung;


    public Angus(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (this.waffe != null) { // Nur, falls Kollege schon waffen hat!
            schadenswert += waffe.zuhauen(geschick);
            System.out.println("Angus haut zu!");
        } else {
            System.out.println("Angus haut mit Faeusten!");
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





}
