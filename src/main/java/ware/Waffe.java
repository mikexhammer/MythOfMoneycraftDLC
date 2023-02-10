package ware;

/**
 * Erweitert Ausruestung um spezifischen Wert "staerke"
 * Kann von Spielern erworben werden um Angriffe zu verstaerken
 * @author mihammer
 */
public class Waffe extends Ausruestung{

    private int staerke;

    public Waffe(String name, int staerke, int preis) {
        super(name, preis);
        this.setStaerke(staerke);
    }

    public void setStaerke(int staerke) {
        if (staerke >= 0 && staerke <= 10) {
            this.staerke = staerke;
        }
    }

    public int getStaerke() {
        return staerke;
    }

    /**
     * Erhoeht auf Basis von Geschick und Staerke den Angriff der Spielfigur
     * @param geschick Geschick der Spielfigur
     * @return neuen Angriffswert
     */
    public int zuhauen(int geschick) {
        return this.staerke + geschick;
    }


}
