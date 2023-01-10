package ausruestung;

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

    public int zuhauen(int geschick) {
        return this.staerke + geschick;
    }

    @Override
    public String toString() {
        return name + " (Preis: " + preis + ")";
    }
}
