package kaempfer;

import java.util.Random;
import main.ConsoleColors;

import ausruestung.Ruestung;
import ausruestung.Waffe;

public class SchwarzerRitter extends Kaempfend{

    public SchwarzerRitter() {
        this.gesundheit = 100;
        this.geschick = 5;
        this.sold = 200;
    }

    public SchwarzerRitter(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
        this.gesundheit = gesundheit;
        this.geschick = geschick;
        this.sold = sold;
    }

    public int kaempfen() {
        System.out.println(ConsoleColors.WHITE_BOLD + "Schwarzer Ritter schlaegt zu!" + ConsoleColors.RESET);
        //Geschick ist 5, also gerne multiplizieren mit 0 bis 5
        //Minimaler Schlag = 0
        //Maximaler Schlag = 25
        return geschick * this.getRandomNumber(1, 5);
    }

    private int getRandomNumber(int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public int abwehren(int angriff) {
        //Angriff wird mit 0 oder 1 multipliziert, manchmal wehrt er also vollkommen ab!
        return this.gesundheit -= angriff*(Math.round(Math.random()));
    }

    @Override
    public void nimmWaffe(Waffe w) {
        System.out.println("Schwarzer Ritter braucht keine Waffen");
    }

    @Override
    public void nimmRuestung(Ruestung r) {
        System.out.println("Schwarzer Ritter braucht keine Ruestung");
    }

}
