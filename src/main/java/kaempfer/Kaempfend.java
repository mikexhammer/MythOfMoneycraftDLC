package kaempfer;

import ausruestung.Ruestung;
import ausruestung.Waffe;

public abstract class Kaempfend {
    protected int gesundheit, geschick, sold;

    public Kaempfend() {}

    public Kaempfend(int gesundheit, int geschick, int sold) {
        this.setGesundheit(gesundheit);
        this.setGeschick(geschick);
        this.setSold(sold);
    }

    //Getter und Setter
    public int getGesundheit() {
        return gesundheit;
    }
    public void setGesundheit(int gesundheit) {
        this.gesundheit = gesundheit;
    }
    public int getGeschick() {
        return geschick;
    }
    public void setGeschick(int geschick) {
        if (geschick >= 0 && geschick <= 10) {
            this.geschick = geschick;
        }
    }
    public int getSold() {
        return sold;
    }
    public void setSold(int sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Kaempfend (Sold: " + sold + ")";
    }

    //Zu ueberschreibende Methoden
    public abstract int kaempfen();
    public abstract int abwehren(int angriff);
    public abstract void nimmWaffe(Waffe w);
    public abstract void nimmRuestung(Ruestung r);




}
