package helper;

import java.awt.*;
import java.io.Console;

/**
 * Nicht dokumentierte Hilfsklasse für alles was die Steuerung der Konsole betrifft
 */
public class ConsoleClear {

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
