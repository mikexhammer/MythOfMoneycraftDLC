package helper;

import java.util.Locale;

public class Ausgabe {

    public static void aktuelleSprache() {
        System.out.println(Messages.getString("Main.60") + Locale.getDefault());
    }

    public static void startMenu() {
              System.out.println("              />\n" +
                           " (           //--------╔╦╗┬ ┬┌─┐┌┬┐┬┌─┐--╦╔═┌┐┌┬┌─┐┬ ┬┌┬┐┌─┐------------------(\n" +
                           "(*)OXOXOXOXO(*>========║║║└┬┘└─┐ │ ││  ==╠╩╗│││││ ┬├─┤ │ └─┐================== \\ \n" +
                           " (           \\\\--------╩ ╩ ┴ └─┘ ┴ ┴└─┘--╩ ╩┘└┘┴└─┘┴ ┴ ┴ └─┘--------------------)\n" +
                           "              \\>\n");
    }
    public static void auswahlStartMenu() {
        System.out.println(Messages.getString("Main.54") +
                           Messages.getString("Main.55") +
                           Messages.getString("Main.62") +
                           Messages.getString("Main.56"));
    }
}
