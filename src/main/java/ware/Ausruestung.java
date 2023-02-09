package ware;


/**
 * Zu erweiternde Klasse aller Waren
 * haelt spezifischen Namen und Preis
 */
public class Ausruestung {
    protected String name;
    protected int preis;

    public Ausruestung(String name, int preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return name + " (Preis:" + preis + ")";
    }


}
