package helper;

import ascii_art.Game;


import java.util.List;
import java.util.Locale;

public class Ausgabe {

    //Menues
    public static void startMenu() {
        Game.title();
    }


    public static void kampfMenu(int gold) {
        System.out.println(Messages.getString("Main.10") + gold
                + Messages.getString("Main.11")
                + Messages.getString("Main.12")
                + Messages.getString("Main.13")
                + Messages.getString("Main.14")
                + Messages.getString("Main.15")
                + Messages.getString("Main.35")
                + Messages.getString("Main.30"));//$NON-NLS-1$
    }


    public static void auswahlStartMenu() {
        System.out.println(Messages.getString("Main.54") +
                Messages.getString("Main.55") +
                Messages.getString("Main.62") +
                Messages.getString("Main.56"));
    }

    public static void spielHistorie(){
        Game.infoSpiel();
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


    //Waren kaufen
    public static void welcheRuestung() {
        System.out.println(Messages.getString("Main.20"));
    }

    public static void zuWenigGold() {
        System.out.println(Messages.getString("Main.53"));
    }

    public static void welcherRitter(){
        System.out.println(Messages.getString("Main.21"));
    }

    public static void welcheWaffe(){
        System.out.println(Messages.getString("Main.22"));
    }

    public static void welcherTrank() {
        System.out.println(Messages.getString("Main.36"));
    }


    //Aktionen
    public static void zurueck() {
        System.out.println("(1)" + Messages.getString("Main.38"));
    }

    public static void aktionVerpufft() {
        System.out.println(Messages.getString("Main.17"));
    }

    public static void spielBeendet(){
        System.out.println(Messages.getString("Main.37"));
    }

    public static void aktuellesLvl(int lvl){
        System.out.println(Messages.getString("Main.45") + lvl);
    }

    public static void keineRitter() {
        System.out.println(Messages.getString("Main.39"));
    }

    public static void listeRitter(List kaempfende) {
        System.out.println(Messages.getString("Main.48") + kaempfende);
    }

    public static void betrugerHingerichtet(){
        System.out.println(Messages.getString("Main.16"));
    }

}
