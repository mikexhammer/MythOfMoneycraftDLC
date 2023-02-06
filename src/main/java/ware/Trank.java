package ware;

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

    public int heilen(int gesundheit) {
        if (gesundheit - aufbau <= 0) {
            return 0;
        }
        return gesundheit + this.aufbau;
    }




}
