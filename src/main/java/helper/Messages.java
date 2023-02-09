package helper;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * Hilfsklasse die auf Basis der angegebenen Location im dazugehoerigen Resource Bundle nach dem Sprachpaket sucht und den geforderten Wert als String liefert
 * @author kleuker
 * modifiert mihammer
 */
public class Messages {

    /**
     * Name des Sprachpakets ohne Laenderangabe
     */
    private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

    public static ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);

    private Messages() {
    }


    /**
     * Hilfsmethode zum aendern der Location
     * @param newLocation neue Location
     */
    public static void changeLocation(Locale newLocation) {
        Locale.setDefault(newLocation);
        RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
    }


    /**
     * Liefert bei keiner uebereinstimmung "! #key !"
     * @param key Name des gesuchten String der message_xx.properties
     * @return gesuchter String in Sprache der Location
     */
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
