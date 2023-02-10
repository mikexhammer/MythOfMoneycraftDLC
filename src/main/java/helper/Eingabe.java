package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Nicht dokumentierte Klasse, um direkt Eingaben von der Tastatur/
 * Konsole zu lesen. Die Methoden fangen Fehler ab und geben bei
 * falschen Eingaben "Standardwerte" zurueck.
 * @author kleuker
 */
public class Eingabe {

    public static String leseString() {
        AusgabeTon.waehlen();
        String ergebnis;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            ergebnis = in.readLine();
        } catch (IOException e) {
            ergebnis = "";
        }
        return ergebnis;
    }

    public static int leseInt() {
        int ergebnis;
        try {
            ergebnis = Integer.decode(leseString()).intValue();
        } catch (NumberFormatException e) {
            ergebnis = 0;
        }

        return ergebnis;
    }

    public static float leseFloat() {
        float ergebnis;
        try {
            ergebnis = Float.valueOf(leseString()).floatValue();
        } catch (NumberFormatException e) {
            ergebnis = 0f;
        }

        return ergebnis;
    }

    public static double leseDouble() {
        double ergebnis;
        try {
            ergebnis = Double.valueOf(leseString()).doubleValue();
        } catch (NumberFormatException e) {
            ergebnis = 0d;
        }

        return ergebnis;
    }

    public static boolean leseBoolean() {
        boolean ergebnis;
        try {
            ergebnis = Boolean.valueOf(leseString()).booleanValue();
        } catch (NumberFormatException e) {
            ergebnis = false;
        }

        return ergebnis;
    }
}

