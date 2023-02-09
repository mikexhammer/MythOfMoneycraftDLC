package figuren;

import java.util.Random;
import helper.ConsoleColors;

import ware.Ruestung;
import ware.Trank;
import ware.Waffe;

public class Maeve extends Kaempfend{

    public Maeve() {
        this.gesundheit = 100;
        this.geschick = 5;
        this.sold = 200;
    }

    public Maeve(int gesundheit, int geschick, int sold) {
        super(gesundheit, geschick, sold);
        this.gesundheit = gesundheit;
        this.geschick = geschick;
        this.sold = sold;
    }

    public int kaempfen() {
        System.out.println(ConsoleColors.WHITE_BOLD + "Maeve schlaegt zu!" + ConsoleColors.RESET);
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
        System.out.println("Maeve braucht keine Waffen");
    }

    @Override
    public void nimmRuestung(Ruestung r) {
        System.out.println("Maeve traegt keine Ruestung");
    }

    @Override
    public void nimmTrank(Trank t) {
        System.out.println("Maeve trinkt keine Traenke");
    }
}
