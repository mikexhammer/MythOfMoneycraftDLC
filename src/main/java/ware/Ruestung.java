package ware;


/**
 * Erweitert Ausruestung um spezifischen Wert "schutz"
 * Kann von Spielern erworben werden um Angriffe zu schmaelern
 * @author mihammer
 */
public class Ruestung extends Ausruestung{

    private int schutz;

    public Ruestung(String name, int schutz, int preis) {
        super(name, preis);
        this.setSchutz(schutz);
    }

    public void setSchutz(int schutz) {
        if (schutz >= 0 && schutz <= 10) {
            this.schutz = schutz;
        }
    }

    public int getSchutz() {
        return schutz;
    }


    /**
     * Verringert uebergebenen Wert um schutz und gibt diesen zurueck
     * bei zu schwachem Angriff wird 0 statt negativem Wert zurueckgegeben
     * @param angriff durch abwehr() uebergebener Wert
     * @return neuer verringerter Angriff
     */
    public int abwehr(int angriff) {
        if (angriff - schutz <= 0) {
            return 0;
        }
        return angriff - this.schutz;
    }



}
