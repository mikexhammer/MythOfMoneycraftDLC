package ritter;

import helper.Ausgabe;
import helper.Messages;
import ware.Ruestung;
import ware.Trank;
import ware.Waffe;
import figuren.Kaempfend;
import helper.ConsoleColors;

import java.util.ArrayList;
import java.util.List;

public class Rohan extends Kaempfend {
    private String name = ConsoleColors.YELLOW + "Rohan\t" + ConsoleColors.RESET;
    private List<Waffe> waffen;
    private Ruestung ruestung;

    public Rohan(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
        this.waffen = new ArrayList<>(2);

    }

    @Override
    public String toString() {
        return Ausgabe.ritterAnzeige(name,this.gesundheit,this.geschick);
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (!this.waffen.isEmpty()) { //Nur, falls Kollege schon waffen hat!
            int hand = 2;
            for (Waffe w : waffen) {
                schadenswert += w.zuhauen(geschick);
                if(hand % 2 == 0) {
                    System.out.println("Rohan schlaegt mit seiner linken Waffe!");
                } else {
                    System.out.println("Rohan schlaegt mit seiner rechten Waffe!");
                }
                hand++;
            }
        } else {
            System.out.println(ConsoleColors.YELLOW + "Rohan haut mit Faeusten!" + ConsoleColors.RESET);
            schadenswert = geschick;
        }
        return schadenswert;
    }

    @Override
    public void abwehren(int angriff) {
        int schadenswert = angriff;
        if (this.ruestung != null) {
            schadenswert = ruestung.abwehr(schadenswert);
        }
        this.gesundheit -= schadenswert;
    }


    @Override
    public void nimmWaffe(Waffe w) {
        this.waffen.add(w);
    }

    @Override
    public void nimmRuestung(Ruestung r) {
        this.ruestung = r;
    }

    public void nimmTrank(Trank t) {
        this.setGesundheit(this.gesundheit + t.getAufbau());
        if (this.gesundheit == 100) {
            System.out.println("Rohan ist vollstaendig geheilt!");
        } else {
            System.out.println("Rohan auf " + this.gesundheit + " geheilt.");
        }
    }
    public List<Waffe> getWaffen() {
        return waffen;
    }

    public void setWaffen(List<Waffe> waffe) {
        this.waffen = waffe;
    }

    public Ruestung getRuestung() {
        return ruestung;
    }

    public void setRuestung(Ruestung ruestung) {
        this.ruestung = ruestung;
    }



}
