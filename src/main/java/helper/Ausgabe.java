package helper;

import ascii_art.Game;
import figuren.Kaempfend;
import java.util.List;
import java.util.Locale;

public class Ausgabe {

    public static void dottedLine(){
        String line2 = "";
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 60; i++) {
            line.append("-");
        }
        System.out.println(line);
    }

    public static String dottedLineReturn(){
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 60; i++) {
            line.append("-");
        }
        return line.toString();
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
        Game.titel();
    }


    public static void kampfMenu(int gold) {
        System.out.println(
                  Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11") +"\n"
                + Ausgabe.dottedLineReturn()
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

    public static void spielHistorie(){
        Game.infoSpielNeu();
    }


    //Sprachen
    public static void aktuelleSprache() {
        System.out.println(Messages.getString("Main.60") + Locale.getDefault());
    }

    public static void auswahlSprache() {
        System.out.println(Messages.getString("Main.59"));
    }

    public static void setzeDeutsch() {
        System.out.println("Setze auf Deutsch");
    }

    public static void setzeEnglisch() {
        System.out.println("Setze auf Englisch");
    }

    public static void neueSprache() {
        System.out.println(Messages.getString("Main.61") + Locale.getDefault());
    }


    //Im Kampf
    public static void maevenBesiegt(int lvl) {
        System.out.println(ConsoleColors.GREEN_BOLD + Messages.getString("Main.26") + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + Messages.getString("Main.25") + ConsoleColors.RESET);
        System.out.println(Messages.getString("Main.45") + lvl + Messages.getString("Main.46"));
    }

    public static void kampfVerloren() {
        System.out.println(ConsoleColors.RED_UNDERLINED + Messages.getString("Main.47") + ConsoleColors.RESET);
    }

    public static void gesundheitKaempfer(Kaempfend k){
        System.out.println(Messages.getString("Main.28") + k.toString());
    }

    public static void gesundheitMaeven(Kaempfend maeven){
        System.out.println(Messages.getString("Main.29") + maeven.getGesundheit() + "\n");
    }

    public static void kaempferTot(Kaempfend k) {
        System.out.println(ConsoleColors.RED_BOLD + k.toString() + Messages.getString("Main.27") + ConsoleColors.RESET);
    }

    //Waren kaufen
    public static void welcheRuestung(int gold) {
        Game.schild();
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.20"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }

    public static void zuWenigGold() {
        System.out.println(Messages.getString("Main.53"));
    }

    public static void welcherRitter(int gold){
        Game.mysticKnights();
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.21"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }


    public static void welcheWaffe(int gold){
        Game.waffen();
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.22"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }

    public static void welcherTrank(int gold) {
        Game.elixier();
        Ausgabe.dottedLine();
        System.out.println(Messages.getString("Main.36"));
        System.out.println(Messages.getString("Main.10") + ConsoleColors.YELLOW_UNDERLINED + gold + ConsoleColors.RESET + Messages.getString("Main.11"));
        Ausgabe.dottedLine();
    }


    //Aktionen
    public static void zurueck() {
        System.out.println("(Taste)" + Messages.getString("Main.38"));
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

    public static void listeRitter(List kaempfende) {
        System.out.println(Messages.getString("Main.48") + kaempfende);
    }

    public static void betrugerHingerichtet(){
        System.out.println(Messages.getString("Main.16"));
    }

}
