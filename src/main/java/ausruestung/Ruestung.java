package ausruestung;

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

    public int abwehr(int angriff) {
        if (angriff - schutz <= 0) {
            return 0;
        }
        return angriff - this.schutz;
    }



}
