package ware;
/**
 * Erweitert Ausruestung um spezifischen Wert "aufbau"
 * Kann von Spielern erworben werden um Gesundheit zu erhoehen
 * @author mihammer
 */
public class Trank extends Ausruestung{

    private int aufbau;

    public Trank(String name, int aufbau, int preis) {
        super(name, preis);
        this.setAufbau(aufbau);
    }

    public void setAufbau(int aufbau) {
            this.aufbau = aufbau;
    }

    public int getAufbau() {
        return aufbau;
    }





}
