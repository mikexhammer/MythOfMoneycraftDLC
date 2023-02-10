package figuren;

import ware.Ruestung;
import ware.Trank;
import ware.Waffe;

/**
 * Interface fuer alle Spielfiguren
 * Figuren besitzen einen individuellen Gesundheitswert, Geschick sowie Preis
 */
public abstract class Kaempfend {

    /**
     * Notwendie Variablen Gesundheit, Geschick der Figur und dessen Preis
     */
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
        if (gesundheit > 100) {
            this.gesundheit = 100;
        } else {
        this.gesundheit = gesundheit;
        }
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

    /**
     * Wird beim Angriff der Spielfigur aufgerufen, errechnet sich aus dem Geschick und der getragenen Waffe
     * @return Schadenswert welcher dem Gegner entgegenwirkt
     */
    public abstract int kaempfen();

    /**
     * Methode soll uebergebenen Wert aus kaempfen() des Gegners mindern
     * anschliessend wird Gesundheit um diesen Wert reduziert
     *
     * @param angriff Wert welcher aus Methode kaempfen() des Gegners uebergeben wird
     */
    public abstract void abwehren(int angriff);

    /**
     * Dient zum aufnehmen einer neuen Waffe
     * @param w erworbene Waffe
     */
    public abstract void nimmWaffe(Waffe w);

    /**
     * Dient zum aufnehmen einer neuen Ruestung
     * @param r erworbene Ruestung
     */
    public abstract void nimmRuestung(Ruestung r);

    /**
     * Dient zum aufnehmen eines Trankes
     * Erhoeht die Gesundheit der Spielfigur
     * @param t erworbener Trank
     */
    public abstract void nimmTrank(Trank t);



}
