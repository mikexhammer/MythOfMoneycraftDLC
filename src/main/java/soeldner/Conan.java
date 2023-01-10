package soeldner;

import ausruestung.Ruestung;
import ausruestung.Waffe;
import kaempfer.Kaempfend;
import main.ConsoleColors;
//import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Conan extends Kaempfend {

    private List<Waffe> waffen;
    private Ruestung ruestung;

    public Conan(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
        this.waffen = new ArrayList<>(2);

    }

    @Override
    public String toString() {
        return "Conan (Sold:" + sold + ")";
    }

    @Override
    public int kaempfen() {
        int schadenswert = 0;
        if (!this.waffen.isEmpty()) { //Nur, falls Kollege schon waffen hat!
            int hand = 2;
            for (Waffe w : waffen) {
                schadenswert += w.zuhauen(geschick);
                if(hand % 2 == 0) {
                    System.out.println("Conan haut mit links!");
                } else {
                    System.out.println("Conan haut mit rechts!");
                }
                hand++;
            }
        } else {
            System.out.println(ConsoleColors.YELLOW + "Conan haut mit Faeusten!" + ConsoleColors.RESET);
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
        this.waffen.add(w);
    }

    @Override
    public void nimmRuestung(Ruestung r) {
        this.ruestung = r;
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
