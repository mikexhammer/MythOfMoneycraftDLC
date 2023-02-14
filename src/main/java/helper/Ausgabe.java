package helper;

import asciiArt.Graphics;
import figuren.Kaempfend;
import figuren.Maeve;
import ware.Ruestung;
import ware.Waffe;

import java.util.List;
import java.util.Locale;


/**
 * Hilfsklasse für Klasse Spiel() in package logik
 * übernimmt die Ausgabe für die o.g. Klasse
 * Ziel: die Klasse Spiel() überischtlicher und
 * modularer zu gestalten
 */
public class Ausgabe {

    public static String ritterAnzeige(String ritter, int life, int skill, int coins){
        int life_temp = life;
        life_temp /=10;
        ritter+= Messages.getString("Main.63") + "[";
        if (life >0 ){
            ritter += ConsoleColors.GREEN_BACKGROUND + " " + life + ConsoleColors.RESET;
            for (int i = 0; i < life_temp; i++) {
                ritter += ConsoleColors.GREEN_BACKGROUND + " " + ConsoleColors.RESET;
            }
            for (int j = life_temp; j < 10; j++) {
                ritter += " ";
            }
        } else {
            for (int i = 0; i < 10; i++) {
                ritter += ConsoleColors.RED_BACKGROUND + " " + ConsoleColors.RESET;
            }
        }
        ritter+="]" + "\t" + Messages.getString("Main.64") + "[";
        ritter += ConsoleColors.PURPLE_BACKGROUND + " " + skill + ConsoleColors.RESET;
        for (int k = 0; k < skill; k++) {
            ritter+=ConsoleColors.PURPLE_BACKGROUND+" "+ ConsoleColors.RESET;
        }
        for (int l = skill; l < 10; l++) {
            ritter+=" ";
        }
        ritter+="]"+ "\t" + Messages.getString("Main.65") + "[" + ConsoleColors.YELLOW_BACKGROUND + " " + coins + " " + ConsoleColors.RESET + "]\n" + Ausgabe.dottedLineReturn();
        return ritter;
    }

    public static String ritterAnzeige(Kaempfend k, String ritter, Waffe w, Ruestung r){
        int life = k.getGesundheit();
        life/=10;
        ritter+= Messages.getString("Main.63") + "[";
        //Lebensanzeige
        if (k.getGesundheit() >0 ){
            ritter += ConsoleColors.GREEN_BACKGROUND + " " + k.getGesundheit() + ConsoleColors.RESET;
            for (int i = 0; i < life; i++) {
                ritter += ConsoleColors.GREEN_BACKGROUND + " " + ConsoleColors.RESET;
            }
            for (int j = life; j < 10; j++) {
                ritter += " ";
            }
        } else {
            ritter += ConsoleColors.RED_BACKGROUND + " " + k.getGesundheit() + ConsoleColors.RESET;
            for (int i = 0; i < 10; i++) {
                ritter += ConsoleColors.RED_BACKGROUND + " " + ConsoleColors.RESET;
            }
        }
        ritter+="]" + "\t" + Messages.getString("Main.64") + "[";
        //Skillanzeige
        ritter+=ConsoleColors.PURPLE_BACKGROUND+ " " + k.getGeschick() + ConsoleColors.RESET;
        for (int e = 0; e < k.getGeschick(); e++) {
            ritter+=ConsoleColors.PURPLE_BACKGROUND+" "+ ConsoleColors.RESET;
        }
        for (int l = k.getGeschick(); l < 10; l++) {
            ritter+=" ";
        }
        ritter+="]";

        if(w != null){
            ritter+="   " + Messages.getString("Main.66") + "[";
            ritter+= ConsoleColors.RED_BACKGROUND + w.getName() + ConsoleColors.RESET;
            for (int i = w.getName().length(); i < 12; i++) {
                ritter+= " ";
            }
            ritter+="]";
        }

        if (r != null){
            ritter+="   " + Messages.getString("Main.67") + "[";
            ritter+= ConsoleColors.BLUE_BACKGROUND + r.getName() + ConsoleColors.RESET;
            for (int i = r.getName().length(); i < 15; i++) {
                ritter+= " ";
            }
            ritter+="]";
        }
        return ritter;
    }

    public static String ritterAnzeige(Kaempfend k, String ritter, List<Waffe> w, Ruestung r){
        int life = k.getGesundheit();
        life/=10;
        ritter+= Messages.getString("Main.63") + "[";
        //Lebensanzeige
        if (k.getGesundheit() >0 ){
            ritter += ConsoleColors.GREEN_BACKGROUND + " " + k.getGesundheit() + ConsoleColors.RESET;
            for (int i = 0; i < life; i++) {
                ritter += ConsoleColors.GREEN_BACKGROUND + " " + ConsoleColors.RESET;
            }
            for (int j = life; j < 10; j++) {
                ritter += " ";
            }
        } else {
            ritter += ConsoleColors.RED_BACKGROUND + " " + k.getGesundheit() + ConsoleColors.RESET;
            for (int i = 0; i < 10; i++) {
                ritter += ConsoleColors.RED_BACKGROUND + " " + ConsoleColors.RESET;
            }
        }
        ritter+="]" + "\t" + Messages.getString("Main.64") + "[";
        //Skillanzeige
        ritter+=ConsoleColors.PURPLE_BACKGROUND+ " " + k.getGeschick() + ConsoleColors.RESET;
        for (int e = 0; e < k.getGeschick(); e++) {
            ritter+=ConsoleColors.PURPLE_BACKGROUND+" "+ ConsoleColors.RESET;
        }
        for (int l = k.getGeschick(); l < 10; l++) {
            ritter+=" ";
        }
        ritter+="]";

        if(w.size() != 0){
            ritter+="   " + Messages.getString("Main.66") + "[";
            ritter+= ConsoleColors.RED_BACKGROUND + w.get(0).getName() + ConsoleColors.RESET;
                if (w.size() == 2) {
                    ritter+= ConsoleColors.RED_BACKGROUND + ", " + w.get(1).getName() + ConsoleColors.RESET;
                for (int i = (w.get(0).getName().length()+w.get(1).getName().length()); i < 12; i++) {
                    ritter+= " ";
                }
                } else {
                    for (int i = w.get(0).getName().length(); i < 12; i++) {
                        ritter+= " ";}
                }
            ritter+="]";
        }

        if (r != null){
            ritter+="   " + Messages.getString("Main.67") + "[";
            ritter+= ConsoleColors.BLUE_BACKGROUND + r.getName() + ConsoleColors.RESET;
            for (int i = r.getName().length(); i < 15; i++) {
                ritter+= " ";
            }
            ritter+="]";
        }
        return ritter;
    }

    public static String maveAnzeige(Maeve m) {
        int life = m.getGesundheit();
        life/= 10;
        String maeve = "";
        maeve+= Messages.getString("Main.63") + "\t[";
        //Lebensanzeige
        if (m.getGesundheit() > 0 ){
            maeve += ConsoleColors.GREEN_BACKGROUND + " " + m.getGesundheit() + ConsoleColors.RESET;
            for (int i = 0; i < life; i++) {
                maeve += ConsoleColors.GREEN_BACKGROUND + " " + ConsoleColors.RESET;
            }
            for (int j = life; j < 10; j++) {
                maeve += " ";
            }
        } else {
            maeve += ConsoleColors.RED_BACKGROUND + " " + m.getGesundheit() + ConsoleColors.RESET;
            for (int i = 0; i < 10; i++) {
                maeve += ConsoleColors.RED_BACKGROUND + " " + ConsoleColors.RESET;
            }
        }
        maeve+="]" + "\t" + Messages.getString("Main.64") + "[";
        //Skillanzeige
        maeve+=ConsoleColors.PURPLE_BACKGROUND+" " + m.getGeschick() + ConsoleColors.RESET;
        for (int e = 0; e < m.getGeschick(); e++) {
            maeve+=ConsoleColors.PURPLE_BACKGROUND+" "+ ConsoleColors.RESET;
        }
        for (int l = m.getGeschick(); l < 10; l++) {
            maeve+=" ";
        }
        maeve+="]";
        return maeve;
    }


    public static void dottedLine(){
        String line2 = "";
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            line.append("-");
        }
        System.out.println(line);
    }

    public static void dottedLine(int j){
        String line2 = "";
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < j; i++) {
            line.append("-");
        }
        System.out.println(line);
    }

    public static String dottedLineReturn(){
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            line.append("-");
        }
        return line.toString();
    }

    public static String dottedLineReturn(int j){
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < j; i++) {
            line.append("-");
        }
        return line.toString();
    }

    public static void asterikLine(int j){
        String line2 = "";
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < j; i++) {
            line.append("*");
        }
        System.out.println(line);
    }

    public static String paddingText(int size){

    int paddingSize = size;
    String padding = "";
        for (int i = 0; i < paddingSize; i++) {
        padding += "\t";
    }
        return padding;
    }



    //Menues
    public static void startMenu() {
        Graphics.titel();
    }


    public static void kampfMenu(int gold) {
        System.out.println(
                  Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11") +"\n"
                + Ausgabe.dottedLineReturn(150)
                + Messages.getString("Main.12")
                + Messages.getString("Main.13")
                + Messages.getString("Main.14")
                + Messages.getString("Main.15")
                + Messages.getString("Main.35")
                + Messages.getString("Main.30"));
    }


    public static void auswahlStartMenu() {
        System.out.println(
                paddingText(9) + Messages.getString("Main.54") +
                paddingText(9) + Messages.getString("Main.55") +
                paddingText(9) + Messages.getString("Main.62") +
                paddingText(9) + Messages.getString("Main.56"));
    }

    public static void storyDeutsch(){
        Graphics.infoSpielDeutsch();
    }

    public static void storyEnglisch(){
        Graphics.infoSpielEnglisch();
    }


    //Sprachen
    public static void aktuelleSprache() {
        System.out.println(Messages.getString("Main.60") + Locale.getDefault());
    }

    public static void auswahlSprache() {
        System.out.println(Messages.getString("Main.59"));
    }



    //Im Kampf
    public static void maevenBesiegt(int lvl) {
        System.out.println(ConsoleColors.GREEN_BOLD + Messages.getString("Main.26") + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + Messages.getString("Main.25") + ConsoleColors.RESET);
        System.out.println(Messages.getString("Main.45") + " " + lvl + Messages.getString("Main.46"));
    }

    public static void kampfVerloren() {
        System.out.println(ConsoleColors.RED_UNDERLINED + Messages.getString("Main.47") + ConsoleColors.RESET);
    }

    //Waren kaufen
    public static void welcheRuestung(int gold, boolean no_gold) {
        Graphics.schild();
        if(no_gold){
            zuWenigGold();
        }
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.20"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }

    public static void zuWenigGold() {
        System.out.println(Messages.getString("Main.53"));
    }

    public static void welcherRitter(int gold){
        Graphics.mysticKnights();
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.21"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }


    public static void welcheWaffe(int gold, boolean no_gold){
        Graphics.waffen();
        if(no_gold){
            zuWenigGold();
        }
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.22"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }

    public static void welcherTrank(int gold, boolean no_gold) {
        Graphics.elixier();
        if(no_gold){
            zuWenigGold();
        }
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.36"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }


    //Aktionen
    public static void zurueck() {
        System.out.println("()" + Messages.getString("Main.38"));
    }

    public static void aktionVerpufft() {
        System.out.println(Messages.getString("Main.17"));
    }

    public static void spielBeendet(){
        System.out.println(Messages.getString("Main.37"));
    }

    public static void aktuellesLvl(int lvl){
        System.out.println(ConsoleColors.GREEN_BOLD + Messages.getString("Main.45") + " " + lvl + ConsoleColors.RESET);
    }

    public static void keineRitter() {
        System.out.println(ConsoleColors.RED_BOLD + Messages.getString("Main.39") + ConsoleColors.RESET);
    }

    public static void aktuelleRitter(){
        System.out.println(ConsoleColors.WHITE_BOLD + Messages.getString("Main.48") + ConsoleColors.RESET);
    }

    public static void listeRitter(Kaempfend kaempfende) {
        System.out.println(kaempfende);
    }

    public static void betrugerHingerichtet(){
        System.out.println(Messages.getString("Main.16"));
    }

}
