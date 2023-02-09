package figuren;

import java.util.Random;
import helper.ConsoleColors;

import ware.Ruestung;
import ware.Trank;
import ware.Waffe;


/**
 * Gegner Spielfigur gegen welche jede Runde gekaempft wird
 */
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

    /**
     * Spezielle Implementierung, nutzt Zufallszahl um Schadenswert zu generieren um variable Spielergebnisse zu erzielen
     * @return Schadenswert
     */
    public int kaempfen() {
        System.out.println(ConsoleColors.WHITE_BOLD + "Maeve schlaegt zu!" + ConsoleColors.RESET);
        return geschick * this.getRandomNumber(1, 5);
    }


    /**
     * Hilfsklasse die Zufallszahl zwischen angegebenen mininmal- und maximal Werten liefert
     * @param max maximaler Wert
     * @param min minimaler Wert
     * @return Zufallszahl
     */
    private int getRandomNumber(int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
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
