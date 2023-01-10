package classmodel;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Diese Klasse ermoeglicht es nach selbstgeschriebenen Klassen zu suchen
 * und einige ihrer Eigenschaften zu pruefen. Die Klasse kann z. B.
 * im Uebungsbereich genutzt werden, bei dem die Implementierung
 * bestimmter Klassen gefordert wird, es aber bewusst keine
 * vollstaendigen Anforderungen zur Paketstruktur gibt. Bei Tests
 * der Struktur ist dann nur bekannt, dass es nach Anforderung eine
 * Klasse XY geben muss, aber nicht, in welchem Paket sie liegt.
 * Methoden dieser Klasse unterstützen bei der Suche nach XY, wobei es
 * beliebig viele Klassen geben kann, die sich nur in anderen Paketen
 * binden. In den Methoden der Klasse werden alle diese moeglichen
 * Implementierung beruecksichtigt.
 *
 * Wenn moeglich, sind als Parameter immer vollqualifizierte Klassennamen,
 * wie java.util.List zu nutzen, damit die Klassen eindeutig gefunden
 * werden. Nur bei Klassen aus dem Paket java.lang, kann die Paketinformation
 * weggelassen werden. Basistypen können als einfache Strings, wie "int"
 * uebergeben werden. Bei Arrays ist die eigentuemliche Notation mit
 * den oeffnen eckigen Klammern und dem abschließenden Semikolon zu
 * beachten, weiterhin muss hier bei Klassen der vollqualifizierte Name
 * genutzt werden. So steht "[[Ljava.lang.String;" z.B. fuer String[][].
 * Da Java Collections zur Laufzeit vergessen, welche Typen ihre Elemente
 * haben sollen, ist hier keine detaillierte Pruefung moeglich, es ist z. B.
 * nur auf HashMap und nicht auf HashMap&lt;Integer,String&gt; pruefbar.
 * Innere Klassen werden in dieser Klasse nicht beruecksichtigt, da
 * generell einiges dafuer spricht, auf sie zu verzichten.
 * <br>
 * Die Klasse selbst nutzt Reflexion, bei der Nutzung sind Kenntnisse
 * über Reflexion, insbesondere ueber die Klasse Class, notwaendig.
 * <br>
 * Wegen der Komplexitaet moeglicher Testszenarien ist die Klasse nur
 * grob getestet und kann Fehler enthalten.
 * <br>
 * <br>
 * Versionsinformation
 * Version 1.0: Basisfunktionalitaet, 31.3.2016
 * Version 1.01: Korrektur wegen Problemen auf UNIX-Systemen
 * Version 1.02: leichte Erweiterung der Fehlerausgaben
 * Version 1.03: Beruecksichtigung des module-path (18.10.2019)
 * Version 1.04: Generics mit <?> (unbekannter Typ)  ergaenzt (7.12.2020)
 * Version 1.05: Anpassung fuer Module (4.7.2021)
 *
 */

public class Alle {
    //naechste zwei Deklarationen unsauber, da eigenlich eine Map gemeint
    private static String[] basis = {"char", "byte", "long", "int"
            , "double", "float", "boolean", "void"};
    private static Class<?>[] basisClass = {char.class, byte.class, long.class
            , int.class, double.class, float.class, boolean.class, void.class};

    // zum Merken Form
    // Klassenname -> Sammlung passender vollqualifizierter Klassennamen
    private static Map<String, List<String>> klassen = new HashMap<>();

    // zum Merken aller Klassennamen
    private static Set<String> alleNamen = new HashSet<>();

    // zum Merken aller Klassen-Class-Objekte
    private static Set<Class<?>> alleClasses = new HashSet<>();

    private static boolean initialisiert = false;

    private Alle() {
    }

    /** Methode sucht nach allen als .class-Dateien vorhandenen Klassen
     * und speichert dies in einer Map der Form (einfacher Klassennanme
     * -> Sammlung zugehoeriger vollqualifizierter Klassennamen).
     * @param klassen zu fuellende Map mit allen bekannten Klassen
     * @param alleNamen  zu fuellende Menge mit allen bekannten Klassen
     * @param datei Ausgangspfad, aber dem rekursiv gesucht wird
     * @param paket vor eine Klasse zu haengender Paketname
     */
    private static void suchen(Map<String,List<String>> klassen
            , Set<String> alleNamen , Set<Class<?>> alleClasses
            , File datei, String paket){
        for(String d: datei.list()){
            File tmp = new File(datei.getAbsolutePath()+File.separator+d);
            if(tmp.isDirectory()){
                if(paket.equals("")){
                    suchen(klassen, alleNamen, alleClasses, tmp, d);
                } else {
                    suchen(klassen, alleNamen, alleClasses, tmp, paket+"."+d);
                }
            } else {
                if(tmp.isFile() && d.endsWith(".class")){
                    String name = d.substring(0, d.length()-6);
                    List<String> list = new ArrayList<>();
                    if(paket.equals("")){
                        list.add(name);
                        klassen.put(name, list);
                        alleNamen.add(name);
                        try {
                            if (!"module-info".equals(name)) {
                                //System.out.println("name:" + name);
                                alleClasses.add(Class.forName(name));
                            }
                        } catch (ClassNotFoundException ex) {
                            throw new IllegalArgumentException("Problem mit "
                                                               + "nicht gefundener Klasse " + name + ": " + ex);
                        }
                    }else {
                        List<String> bevor = klassen.get(name);
                        String tmps = paket + "." + name;
                        list.add(tmps);
                        alleNamen.add(tmps);
                        try {
                            alleClasses.add(Class.forName(tmps));
                        } catch (ClassNotFoundException ex) {
                            throw new IllegalArgumentException("Problem mit "
                                                               + "nicht gefundener Klasse " + tmps + ": " + ex);
                        }
                        if(bevor == null){
                            klassen.put(name, list);
                        } else {
                            bevor.addAll(list);
                        }
                    }
                }
            }
        }
        alleNamen.remove("module-info");
    }


    /** Initialisiert die Klassenvariable alle, die eine Uebersicht ueber
     * alle nutzbaren Klassen enthaelt. Sollten zur Laufzeit weitere jar-Dateien
     * über den Class-Loader geladen werden, muesste init erneut aufgerufen
     * werden.
     */
    private static void init() {
        if(!initialisiert){
            String path = System.getProperty("jdk.module.path");
            if (path == null) {
                path = System.getProperty("java.class.path");
            }
            // System.out.println("Path: " + path);
            String[] pfadetmp = path.split(System.getProperty("path.separator"));
            //System.out.println("pfadetmp: " + pfadetmp.length);
            //if(pfadetmp.length ==1 && pfadetmp[0].equals("")) {
            //System.out.println("nutze Module Path");
            //path = System.getProperty("jdk.module.path");
            //System.out.println("Path: " + path);
            pfadetmp = path.split(System.getProperty("path.separator"));
            //}
            for(String s:pfadetmp){
                //System.out.println("Teilpfad: " + s);
                if(!s.endsWith(".jar")){
                    suchen(klassen, alleNamen, alleClasses, new File(s), "");
                }
            }
            initialisiert = true;
        }
    }

    /**
     * Klassenmethode zum Suchen einer Klasse, deren einfacher Name
     * nur bekannt ist, liefert dazu passende
     * vollqualifizierte Klassennamen, eventuell mehr als einen, wenn
     * Klassenname mehrfach vorkommt; es werden nur neu
     * geschriebene Klassen beachtet.
     *
     * @param name gesuchte Klasse (ohne Pfadnamen)
     * @return Liste von vollqualifizierten Klassennamen, die zu einer Klasse
     * mit dem gegenbenen Namen gehoeren
     */
    public static List<String> findeKlasse(String name) {
        init();
        List<String> ergebnisse = new ArrayList<>();

        if(name == null){
            throw new IllegalArgumentException("null kann nicht als "
                                               + "Klassenname gesucht werden");
        }
        String vor = "";  // fuer Arrays merken
        String nach = "";
        // von Arraymarkierungen befreien
        if (name.startsWith("[")) {
            if (name.endsWith(";")) {
                nach = ";";
                for (int i = 0; name.charAt(i) == '['; i++) {
                    vor += "[";
                }
                String[] split = name.split("(\\[|;)");
                if(split[split.length - 1].charAt(0) != 'L'){
                    throw new IllegalArgumentException("Buchstabe "
                                                       + split[split.length - 1].charAt(0)
                                                       +" in " + name + " passt nicht zur Array-Deklaration");
                }
                name = split[split.length - 1].substring(1);
                vor += "L";
                // System.out.println("Suche nach " + name);
            } else {
                throw new IllegalArgumentException("Bei Versuch Array anzugeben,"
                                                   + " abschliessendes Semikolon vergessen: " + name);
            }
        }

        if (klassen.get(name) != null) {
            ergebnisse = klassen.get(name);
        }

        // eventuellArray-Informationen wieder einbauen
        if (nach.equals(";")) {
            List<String> tmp = new ArrayList<>();
            for (String s : ergebnisse) {
                tmp.add(vor + s + nach);
            }
            return tmp;
        }

        return ergebnisse;
    }

    /** Berechnet Liste aller Methoden, die in der angegebenen Klasse den
     * angegebenen Methodennamen, Rüeckgabetypen und die dazu angegebenene
     * Parameterliste haben, wobei die genauen Typen des Rueckgabetypens
     * und der Parameter bekannt sein muessen.
     * Geerbte Methoden werden auch gefunden.
     * Da einfacher Klassenname nicht eindeutig, koennen mehrere Methoden (in
     * verschiedenen Klassen) gefunden werden, was zur Ergebnissammlung fuehrt.
     * Insofern die Kombination aus Klassenname, Methodenname und Parameterliste
     * eindeutig ist, (also hoffentlich immer) enthaelt die Liste eine Methode.
     *
     * @param klasse gesuchte Klasse, einfacher Name ohne Pfad
     * @param rueckgabetyp geforderter Rueckgabetyp der gesuchten Methode
     * @param methode gesuchte Methode
     * @param parametertypen geforderte Parametertypen
     * @return Liste gefundener Methoden
     */
    public static List<Method> klasseHatMethodeParametertypenBekannt(String klasse
            ,Class<?> rueckgabetyp, String methode, Class<?>... parametertypen) {
        List<Method> ergebnis = new ArrayList<>();
        if( klasse == null){
            throw new IllegalArgumentException("nach Klasse null gesucht");
        }
        if( rueckgabetyp == null ){
            throw new IllegalArgumentException("nach Rueckgabetyp null gesucht");
        }
        if( methode == null){
            throw new IllegalArgumentException("nach Methode null gesucht");
        }
        List<Class<?>> classes = moeglicheClassObjekteFuer(klasse);
        for (Class<?> clazz : classes) {
            try {
                Method tmp = clazz.getDeclaredMethod(methode, parametertypen); // mit geerbten
                if(tmp.getReturnType().equals(rueckgabetyp)){
                    ergebnis.add(tmp);
                }
            } catch (NoSuchMethodException|SecurityException ex) {
            }
            try { // auch geerbte Methoden finden
                Method tmp = clazz.getMethod(methode, parametertypen); // mit geerbten
                if(!ergebnis.contains(tmp) && tmp.getReturnType().equals(rueckgabetyp)){
                    ergebnis.add(tmp);
                }
            } catch (NoSuchMethodException|SecurityException ex) {
            }
        }
        return ergebnis;
    }

    /** Berechnet Liste aller Konstruktoren, die in der angegebenen Klasse
     * die dazu angegebenene Parameterliste haben, wobei die genauen Typen
     * der Parameter bekannt sein muessen.
     * Da einfacher Klassenname nicht eindeutig, koennen mehrere Konstruktoren (in
     * verschiedenen Klassen) gefunden werden, was zur Ergebnissammlung fuehrt.
     * Insofern die Kombination aus Klassenname und Parameterliste
     * eindeutig ist, (also hoffentlich immer) enthaelt die Liste einen Konstruktor.
     *
     * @param klasse gesuchte Klasse, einfacher Name ohne Pfad
     * @param parametertypen geforderte Parametertypen
     * @return Liste gefundener Konstruktoren
     */
    public static List<Constructor<?>> klasseHatKonstruktorParametertypenBekannt(String klasse
            , Class<?>... parametertypen) {
        List<Constructor<?>> ergebnis = new ArrayList<>();
        if(klasse == null){
            throw new IllegalArgumentException("Konstruktor fuer Klasse null gesucht");
        }
        List<Class<?>> classes = moeglicheClassObjekteFuer(klasse);
        //System.out.println("klasse: "+ klasse + "  pfade: " + classes);
        for (Class<?> clazz : classes) {
            try {
                Constructor<?> tmp = clazz.getDeclaredConstructor(parametertypen);
                ergebnis.add(tmp);
            } catch (NoSuchMethodException|SecurityException ex) {
            }
        }
        return ergebnis;
    }

    /**Berechnet Liste aller Methoden, die in der angegebenen Klasse den
     * angegebenen Methodennamen, den Rueckgabetypen und die dazu
     * angegebene Parameterliste haben, wobei der genaue Typ der
     * Rueckgabe und der Parameter nicht bekannt sein muss.
     * Da einfacher Klassenname nicht eindeutig, koennen mehrere Methoden (in
     * verschiedenen Klassen) gefunden werden, was zur Ergebnissammlung fuehrt.
     * Insofern die Kombination aus Klassenname, Methodenname und Parameterliste
     * eindeutig ist, (also hoffentlich immer) enthaelt die Liste eine Methode.
     *
     * @param klasse gesuchte Klasse, einfacher Name ohne Pfad
     * @param rueckgabetyp geforderter Rueckgabetyp der gesuchten Methode
     * @param methode gesuchte Methode
     * @param parametertypen geforderte Parametertypen
     * @return Liste gefundener Methoden
     */
    public static List<Method> klasseHatMethodeParametertypenUnbekannt(
            String klasse, String rueckgabetyp, String methode
            , String... parametertypen) {
        List<Method> ergebnis = new ArrayList<>();
        if( klasse == null){
            throw new IllegalArgumentException("nach Klasse null gesucht");
        }
        if( rueckgabetyp == null ){
            throw new IllegalArgumentException("nach Rueckgabetyp null gesucht");
        }
        if( methode == null){
            throw new IllegalArgumentException("nach Methode null gesucht");
        }

        List<List<Class<?>>> parvarianten = parametertypvariantenBerechnen(parametertypen);
        // System.out.println(parvarianten);
        // Berechne aus allen moeglichen Parametern alle Kombinationen
        List<Class<?>[]> aufrufe = new ArrayList<>();
        Class<?>[] par = new Class[parametertypen.length];
        kombinationenBerechnen(aufrufe, par, 0, parvarianten);

        List<Class<?>> rueckgabe = moeglicheClassObjekteFuer(rueckgabetyp);
        if(rueckgabe.isEmpty()){
            throw new IllegalArgumentException("Rueckgabetyp " + rueckgabetyp + " existiert nicht");
        }
        for(Class<?> rueck: rueckgabe){
            for (Class<?>[] carr : aufrufe) {
                ergebnis.addAll(klasseHatMethodeParametertypenBekannt(klasse
                        , rueck, methode, carr));
            }
        }
        return ergebnis;
    }

    /** Methode sucht Klassen zu angegebenen Parametertypen, die dann
     * in einer Liste pro Parameter stehen.
     *
     * @param parametertypen Array von Strings zu den konkrete Typen gesucht
     *                       werden
     * @return Sammlung von passenden Typen, pro parametertyp eine Liste
     * @throws IllegalArgumentException
     */
    private static List<List<Class<?>>> parametertypvariantenBerechnen(
            String[] parametertypen) throws IllegalArgumentException {
        if(parametertypen == null){
            throw new IllegalArgumentException("Parameter vom Typ null gesucht");
        }
        List<List<Class<?>>> parvarianten = new ArrayList<>();
        for (int i = 0; i < parametertypen.length; i++) {
            List<Class<?>> tmp = moeglicheClassObjekteFuer(parametertypen[i]);
            if (tmp.isEmpty()) {
                throw new IllegalArgumentException("keine Klasse fuer "
                                                   + "Parametertyp " + parametertypen[i] + " gefunden");
            }
            parvarianten.add(tmp);
        }
        return parvarianten;
    }

    /**Berechnet Liste aller Konstruktoren, die in der angegebenen Klasse
     * die dazu angegebene Parameterliste haben, wobei der genaue Typ der
     * Parameter nicht bekannt sein muss.
     * Da einfacher Klassenname nicht eindeutig, koennen mehrere Konstruktoren
     * (in verschiedenen Klassen) gefunden werden, was zur Ergebnissammlung fuehrt.
     * Insofern die Kombination aus Klassenname und Parameterliste
     * eindeutig ist, (also hoffentlich immer) enthaelt die Liste einen Konstruktor.
     *
     * @param klasse gesuchte Klasse, einfacher Name ohne Pfad
     * @param parametertypen geforderte Parametertypen
     * @return Liste gefundener Konstruktoren
     */

    public static List<Constructor<?>> klasseHatKonstruktorParametertypenUnbekannt(
            String klasse, String... parametertypen) {
        List<Constructor<?>> ergebnis = new ArrayList<>();
        if(klasse == null){
            throw new IllegalArgumentException("Konstruktor fuer Klasse null gesucht");
        }

        List<List<Class<?>>> parvarianten = parametertypvariantenBerechnen(parametertypen);

        // Berechne aus allen moeglichen Parametern alle Kombinationen
        List<Class<?>[]> aufrufe = new ArrayList<>();
        Class<?>[] par = new Class[parametertypen.length];
        kombinationenBerechnen(aufrufe, par, 0, parvarianten);

        //System.out.println("pv: " + parvarianten + "aufrufe: " + aufrufe);
        for (Class<?>[] carr : aufrufe) {
            //System.out.println("carr: " + carr.length);
            ergebnis.addAll(klasseHatKonstruktorParametertypenBekannt(klasse, carr));
        }
        return ergebnis;
    }

    /**
     * Methode berechnet fuer einen uebergebenen Typnamen zugehoerige
     * Class-Objekte, dies koennen mehrere sein, wenn der genaue Pfad zur Klasse
     * nicht bekannt ist.
     *
     * @param parametertyp zu ueberpruefender Typname
     * @return Liste von zugehoerigen Class-Objekten, die typischerweise leer
     * ist, wenn der Typ nicht existiert und ein Element enthaelt, wenn der
     * Klassenname eindeutig ist
     */
    public static List<Class<?>> moeglicheClassObjekteFuer(String parametertyp) {
        if(parametertyp == null){
            throw new IllegalArgumentException("Class-Objekte der Klasse null versucht zu finden");
        }
        List<Class<?>> tmp = new ArrayList<>();
        Class<?> erg = existiertKlasse(parametertyp);
        if (erg != null) {
            tmp.add(erg);
        } else {
            for (String s : findeKlasse(parametertyp)) {
                tmp.add(existiertKlasse(s));
            }
        }
        // System.out.println("moeglicheClassObjekteFuer " + parametertyp +", tmp: " + tmp);
        return tmp;
    }

    /**
     * Interne rekursive Methode, um aus Varianten von moeglichen
     * Parameterklassen alle moeglichen Parameterlisten zu berechen.
     *
     * @param ergebnis Ergebnis als Sammulung von Parameterlisten jeweils als
     * Arrays
     * @param aktuell bisher berechnetes Array mit konkret besetzen Parametern
     *                bis zu position-1
     * @param position bis zu dieser Position ist aktuell bearbeitet, es soll
     *        jetzt die Liste parvarianten.get(position) abgearbeitet werden
     * @param parvarianten Sammlung von Parametervarianten fuer jeweilige
     *                     Position
     */
    private static void kombinationenBerechnen(List<Class<?>[]> ergebnis
            , Class<?>[] aktuell, int position, List<List<Class<?>>> parvarianten) {
        if (position >= aktuell.length) {
            ergebnis.add(aktuell);
            return;
        }
        List<Class<?>> pars = parvarianten.get(position);
        aktuell[position] = pars.get(0);
        kombinationenBerechnen(ergebnis, aktuell, position + 1, parvarianten);
        for (int pos = 1; pos < pars.size(); pos++) {
            Class<?>[] tmp = new Class[aktuell.length];
            for (int i = 0; i < position; i++) {
                tmp[i] = aktuell[i];
            }
            aktuell[position] = pars.get(pos);
            kombinationenBerechnen(ergebnis, tmp, position + 1, parvarianten);
        }
    }

    /**
     * Prueft ob eine Methode mit den uebergebenen Parametern das erwartete
     * Ergebnis liefert, wobei die Pruefung nur auf Basis eines toString-
     * Vergleichs erfolgt, bei void-Methoden wird ein leerer Ergebnis-String
     * als Uebergabewert erwartet, die zur Methode gehoerende Klasse muss einen
     * Default-Lonstruktor (parameterlos) haben.
     *
     * @param erwartet erwartetes Methodenergebnis nach Anwendung von toString
     * @param methode aufzurufende Methode
     * @param parameter fuer Methode zu nutzende Parameter
     * @return liefert Methodenaufruf erwartetes Ergebnis?
     */
    public static boolean methodeLiefertErgebnis(String erwartet,
                                                 Method methode, Object... parameter) {
        if( methode == null){
            throw new IllegalArgumentException("nach Methode null gesucht");
        }
        Class<?> clazz = methode.getDeclaringClass();

        // suche parameterlosen (leeren) KOnstruktor
        Constructor<?> leer = null;
        for (Constructor<?> c : clazz.getConstructors()) {
            if (c.getParameterCount() == 0) {
                leer = c;
            }
        }
        if (leer == null) {
            throw new IllegalArgumentException("Klasse "
                                               + methode.getDeclaringClass()
                                               + " fehlt parameterloser Konstruktor");
        }

        // erzeuge Objekt und fuehre Merhode aus
        leer.setAccessible(true);
        try {
            Object o = leer.newInstance(new Object[]{});
            methode.setAccessible(true);
            //System.out.println("*** " + methode.invoke(o, parameter));
            Object ergebnis = methode.invoke(o, parameter);
            if (ergebnis == null) {
                return erwartet.equals(""); // auch anderer Wert denkbar
            }
            return ergebnis.toString().equals(erwartet);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("Von Klasse "
                                               + methode.getDeclaringClass() + " oder von "
                                               + methode.toGenericString() + " mit Parameter:"
                                               + zeigeArray(parameter)
                                               + " darf ein Aufruf nicht stattfinden: " + ex.getCause());
        }
    }

    private static String zeigeArray(Object[] arr){
        StringBuilder erg = new StringBuilder("{ ");
        for(Object o:arr){
            erg.append(o + " ");
        }
        return erg.append("}").toString();
    }

    /** Methode prueft, ob die Klasse das Interface realisiert, was
     * entweder die Klasse direkt oder eine ihrer beerbten Klassen macht,
     * wenn statt einer Klasse ein Interface betrachtet wird, wird
     * untersucht, ob das Interface das zweite erweitert.
     * Da Klassen- und Interface-Namen nicht eindeutig sein muessen,
     * werden alle zugehoerigen Kombinationen betrachtet.
     * @param klasse zu analysierende Klasse
     * @param schnitt gesuchtes Interface
     * @return realisiert Klasse klasse Interface schnitt?
     */
    public static boolean klasseImplementiertInterface(
            String klasse, String schnitt){
        if(klasse == null){
            throw new IllegalArgumentException("Klasse null existiert nicht");
        }
        if(schnitt == null){
            throw new IllegalArgumentException("Schnittstelle null existiert nicht");
        }
        for (Class<?> klas : moeglicheClassObjekteFuer(klasse)) {
            for (Class<?> schnit : moeglicheClassObjekteFuer(schnitt)) {
                //System.out.println("schnit: " + schnit +"  klas: " + klas);
                // Klasse implementiert Schnittstelle direkt
                if(interfaceIstEnthaltenIn(schnit, klas.getInterfaces())){
                    return true;
                }
                // betrachte beerbte Klassen
                for(Class<?> ober: oberklassenVon(klas)){
                    if(interfaceIstEnthaltenIn(schnit, ober.getInterfaces())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Prueft ob die erste uebergebene Klasse von der zweiten
     * uebergebenen Klasse direkt oder indirekt erbt, was bei Klassen
     * und Interfaces moeglich ist.
     * @param unterklasse zu untersuchende Klasse
     * @param oberklasse frage ob die Klasse beerbt wurde
     * @return erbt unterklasse von oberklasse?
     */
    public static boolean erbtVon(String unterklasse, String oberklasse) {
//        System.out.println("uo: " + moeglicheClassObjekteFuer(unterklasse)
//                + " - " + moeglicheClassObjekteFuer(oberklasse));
        if(unterklasse == null){
            throw new IllegalArgumentException("Klasse null kann nicht von etwas erben");
        }
        if(oberklasse == null){
            throw new IllegalArgumentException("Klasse null kann nicht beerbt werden");
        }
        for (Class<?> u : moeglicheClassObjekteFuer(unterklasse)) {
            for (Class<?> o : moeglicheClassObjekteFuer(oberklasse)) {
                for (Class<?> beerbt : oberklassenVon(u)) {
                    if (beerbt.equals(o)) {
                        return true;
                    }
                }
                if(u.isInterface() && interfaceIstEnthaltenIn(o,u.getInterfaces())){
                    return true;
                }
            }
        }
        return false;
    }
    /** Berechnet alle Oberklassen der uebergebenen Klasse bis
     * einschliesslich Objekt.
     * @param clazz Klasse, fuer die Oberklassen berechnet werden sollen
     * @return Liste von Class-Objekten der Oberklassen
     */
    private static List<Class<?>> oberklassenVon(Class<?> clazz) {
        List<Class<?>> ergebnis = new ArrayList<>();
        Class<?> tmp = clazz.getSuperclass();
        while (tmp != null) {
            ergebnis.add(tmp);
            tmp = tmp.getSuperclass();
        }
        return ergebnis;
    }

    /** Methode berechnet, ob gesuchtes Interface im uebergebenen Array von
     * Interfaces oder von Interfaces, die dieses Interfaces implementieren,
     * vorkommen.
     * @param gesucht Interface, dass in uebergebenen bzw. deren beerbten
     *                Interfaces vorkommen kann
     * @param liste Array mit Interfaces in denen bzw. deren beerbten
     *              Interfaces gesucht werden soll
     * @return kommt gesuchtes Interface in uebergebenen Interfaces vor?
     */
    private static boolean interfaceIstEnthaltenIn(Class<?> gesucht, Class<?>[] liste) {
        //System.out.println("iEV: " + gesucht + " - " + Arrays.asList(liste));
        if (liste.length > 0) {
            for (Class<?> o : liste) {
                if (o.equals(gesucht)) {
                    return true;
                }
                if (interfaceIstEnthaltenIn(gesucht, o.getInterfaces())){
                    return true;
                }
            }
        }
        return false;
    }
// falsche Implementierung
//    private static boolean interfaceIstEnthaltenIn(Class<?> gesucht, Class[] liste){
//        //System.out.println("iEV: " + gesucht + " - " + liste.length);
//        for(Class<?> o:liste){
//            if (o.equals(gesucht)){
//                //System.out.println("i: " + gesucht + " - " + o);
//                return true;
//            }
//            return interfaceIstEnthaltenIn(gesucht, o.getInterfaces());
//        }
//        return false;
//    }

    /** Methode prueft ob die angegebene Klasse eine Variable mit dem
     * Namen variable hat und gibt gegebenenfalls die vollqualifizierten
     * Klassennamen zurueck. Man beachte, dass eine Klasse und dort jeweils der
     * Variablenname mehrfach vorkommen koennen.
     * @param klasse zu untersuchende Klasse
     * @param variable gesuchter Variablenname
     * @return Liste mit vollqualifizierten Typen der gesuchten Variable
     */
    public static List<String> klasseHatVariableMitName(String klasse
            , String variable){
        if(klasse == null){
            throw new IllegalArgumentException("Klasse null existiert nicht "
                                               + "und hat damit keine Variable");
        }
        if(variable == null){
            throw new IllegalArgumentException("Variable kann nicht den "
                                               + "Namen null haben");
        }
        List<String> ergebnis = new ArrayList<>();
        List<Class<?>> klassen = moeglicheClassObjekteFuer(klasse);
        for (Class<?> k : klassen) {
            try {
                Field tmp = k.getDeclaredField(variable);
                ergebnis.add(tmp.getType().getName()); // getCanonicalName());
            } catch (NoSuchFieldException | SecurityException ex) {
            } // Variable mit diesem Namen existiert nicht; hier ignorieren
        }
        return ergebnis;
    }
    /** Methode prueft, ob Klasse eine Variable vom angegebenen Typ hat,
     * die Namen aller Variablen des Typs werden zurückgegegeben.
     * @param klasse zu analysierende Klasse
     * @param typ gesuchter Typ
     * @return Namen der Variablen dieses Typs in der Klasse klasse
     */
    public static List<String> klasseHatVariableMitTyp(String klasse
            , String typ){
        if(klasse == null){
            throw new IllegalArgumentException("Klasse null existiert nicht "
                                               + "und hat damit keine Variable");
        }
        if(typ == null){
            throw new IllegalArgumentException("Typ kann nicht null sein");
        }
        List<String> ergebnis = new ArrayList<>();
        List<Class<?>> klassen = moeglicheClassObjekteFuer(klasse);
        List<Class<?>> typen = moeglicheClassObjekteFuer(typ);
        for (Class<?> k : klassen) {
            for (Class<?> t : typen) {
                for (Field f : k.getDeclaredFields()) {
                    // System.out.println("f: " + f);
                    if (f.getType().equals(t)) {
                        ergebnis.add(f.getName());
                    }
                }
            }
        }
        return ergebnis;
    }

    /** Methode prueft, ob in der uebergebenen Klasse eine Variable mit
     * Namen variable, vom Typ typ und den optionalen Modifikatoren
     * ("static", "private", "public", "protected", "", "final") vorkommt.
     * Da weder die Klasse noch der Typ eindeutig sein muessen, werden
     * Kombinationen untersucht.
     * @param klasse Name der analysierten Klasse
     * @param variable Name der gesuchten Variable
     * @param typ Typ der gesuchten Variable
     * @param sichtbarkeitUndArt Array mit zusaetzlich geforderten
     *                           Modifikatoren
     * @return hat Klasse Variable mit passenden Namen, Typ und Modifikatoren?
     */
    public static boolean klasseHatVariableVomTypMitSichtbarkeitUndArt(
            String klasse, String variable, String typ, String... sichtbarkeitUndArt) {
        if(klasse == null){
            throw new IllegalArgumentException("Klasse null existiert nicht "
                                               + "und hat damit keine Variable");
        }
        if(variable == null){
            throw new IllegalArgumentException("Variable kann nicht den "
                                               + "Namen null haben");
        }
        if(typ == null){
            throw new IllegalArgumentException("Typ kann nicht null sein");
        }
        List<Class<?>> klassen = moeglicheClassObjekteFuer(klasse);
        List<Class<?>> typen = moeglicheClassObjekteFuer(typ);
        //System.out.println(klassen + " - " + typen);
        for (Class<?> k : klassen) {
            for (Class<?> t : typen) {
                for (Field f : k.getDeclaredFields()) {
                    // System.out.println("f: " + f);
                    if (f.getName().equals(variable) && f.getType().equals(t)) {
                        if (sichtbarkeitUndArt.length == 0) {
                            return true;
                        }

                        // pruefe Modifier
                        boolean ok = true;
                        for (String s : sichtbarkeitUndArt) {
                            ok = ok && hatModifier(f.getModifiers(), s);
                        }
                        if (ok) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean hatModifier(int mod, String text) {
        if (text.equals("abstract") && Modifier.isAbstract(mod)) {
            return true;
        }
        if (text.equals("final") && Modifier.isFinal(mod)) {
            return true;
        }
        if (text.equals("interface") && Modifier.isInterface(mod)) {
            return true;
        }
        if (text.equals("native") && Modifier.isNative(mod)) {
            return true;
        }
        if (text.equals("private") && Modifier.isPrivate(mod)) {
            return true;
        }
        if (text.equals("protected") && Modifier.isProtected(mod)) {
            return true;
        }
        if (text.equals("public") && Modifier.isPublic(mod)) {
            return true;
        }
        if (text.equals("") && !Modifier.isPublic(mod)
            && !Modifier.isProtected(mod) && !Modifier.isPrivate(mod)) {
            return true;
        }
        if (text.equals("static") && Modifier.isStatic(mod)) {
            return true;
        }
        if (text.equals("strict") && Modifier.isStrict(mod)) {
            return true;
        }
        if (text.equals("synchronized") && Modifier.isSynchronized(mod)) {
            return true;
        }
        if (text.equals("transient") && Modifier.isTransient(mod)) {
            return true;
        }
        if (text.equals("volatile") && Modifier.isVolatile(mod)) {
            return true;
        }
        return false;
    }

    private static boolean istBasistyp(String name) {
        for (String t : basis) {
            if (t.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Methode prueft, ob es sich beim uebergebenen Parameter um einen direkt
     * nutzbaren Typen oder nutzbare Klasse handelt, ist dies der Fall, wird ein
     * zugehoeriges Class-Objekt zurueckgeliefert, ansonsten null. Arrays
     * muessen in der Java-ueblichen Notation angegeben werden. Basistypen
     * wie int werden einfach direkt als "int" angegeben. Nur bei Klassen des
     * Pakets java.lang kann diese Kennzeichnung weggelassen werden. Falls
     * das Paket der Klasse nicht bekannt ist, ist dieses aufwaendiger mit
     * findeKlasse(name) zu suchen. Die dort berechneten vollqualifizierten
     * Klassennamen können dann als Parameter für diese Methode genutzt werden,
     * um ein passendes Class-Objekt zu erhalten.
     *
     * @param name zu ueberpruefender Name, ob Typ dazu existiert
     * @return Class-Objekt zum uebergebenen Typen, null, wenn dieses micht
     * existiert
     */
    public static Class<?> existiertKlasse(String name) {
        if(name == null){
            throw new IllegalArgumentException("Existenz der Klasse null "
                                               + "versucht zu pruefen");
        }
        if (istBasistyp(name)) {
            for (int i = 0; i < basis.length; i++) {
                if (basis[i].equals(name)) {
                    return basisClass[i];
                }
            }
        }
        if (!name.contains(".")) {
            try {
                Class<?> cl = Class.forName(name);
                return cl;
            } catch (ClassNotFoundException ex) {
                // ok, nicht im Default-Paket gefunden
            }
            name = "java.lang." + name;
        }
        try {
            Class<?> cl = Class.forName(name);
            return cl;
        } catch (ClassNotFoundException ex) {
            // ok, keine vorhandene Klasse
        }
        return null;
    }

    /** Der uebergebene Konstruktor wird mit den uebergebenen
     *  Parametern ausgefuehrt, das resultierende Objekt ist
     *  das Ergebnis
     * @param konstruktor zu nutzender Konstruktor
     * @param parameter zu nutzende Parameter
     * @return neu erzeugtes Objekt
     */
    public static Object erzeugeObjektMitKonstruktor(
            Constructor<?> konstruktor , Object... parameter){
        if(konstruktor == null){
            throw new IllegalArgumentException("Konstruktor kann nicht null sein");
        }
        try {
            konstruktor.setAccessible(true);
            // System.out.println("erzeuge: " + konstruktor + " : " + zeigeArray(parameter) + ":" + parameter.length);
            return konstruktor.newInstance(parameter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Konstruktornutzung von "
                                               + konstruktor + " mit Parametern "
                                               + Arrays.asList(parameter) + " gescheitert: " + e.getCause());
        }
    }

    /** Die angegebene Methode wird auf dem uebergebenen Objekt mit
     *  den uebergebenen Parametern ausgefuehrt, der Rückgabewert der
     *  Ausfuehrung ist das Ergebnis dieser Methode, der bei einer
     *  Methode mit Rueckgabetyp void null ist.
     * @param objekt Objekt, auf dem Methode ausgefuehrt werden soll
     * @param methode auszufuehrende Methode
     * @param parameter zu nutzende Parameter
     * @return Resultat der Methodenausfuehrung
     */
    public static Object fuehreAufObjektMethodeMitParameternAus(
            Object objekt, Method methode, Object... parameter){
        if(objekt == null){
            throw new IllegalArgumentException("Zu nutzendes Objekt kann nicht null sein");
        }
        if(methode == null){
            throw new IllegalArgumentException("Zu nutzende Methode kann nicht null sein");
        }
        try {
            methode.setAccessible(true);
            return methode.invoke(objekt, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Methodenaufruf gescheitert: "
                                               + "Klasse:" + objekt.getClass()
                                               + " Methode:" + methode
                                               + " Parameter:" + Arrays.asList(parameter)
                                               + " :"+ e.getCause());
        }
    }

    /** Methode berechnet die Menge aller vollqualifitierte Klassennamen des
     *  Projekts, die in diesem Projekt entwickelt wurden, also als
     *  class-Dateien vorliegen.
     * @return Menge aller Klassen
     */
    public static Set<String> alleKlassen(){
        if(!initialisiert){
            init();
        }
        return alleNamen;
    }

    /** Berechnet die Class-Objekte aller neu geschriebenen Klassen,
     *  die eine Methode mit dem gesuchten Namen haben oder eine solche
     *  geerbt haben.
     * @param methodenname gesuchter Methodenname
     * @return Menge aller Klassen, beidenen eine Methode mit dem
     *         namen aufgerufen werden koennte
     */
    public static Set<Class<?>> alleKlassenMitMethodenname(String methodenname){
        if( methodenname == null){
            throw new IllegalArgumentException("nach Methode null gesucht");
        }
        Set<Class<?>> ergebnis = new HashSet<>();
        for(Class<?> c: alleClasses){
            for(Method m: c.getDeclaredMethods()){
                if (m.getName().equals(methodenname)){
                    ergebnis.add(c);
                }
            }
            for(Method m: c.getMethods()){ // auch geerbte betrachten
                if (m.getName().equals(methodenname)){
                    ergebnis.add(c);
                }
            }
        }
        return ergebnis;
    }

    /** Berechnet fuer eine gegebene Klasse alle Methoden-Objekte,
     *  die den angegebenen Namen haben; es werden auch geerbte
     *  Methoden als Ergebnis geliefert. Da der Klassenname nicht
     *  eindeutig sein muss, koennen Methoden verschiedener Klassen
     *  im Ergebnis stehen.
     * @param klasse zu analysierende Klasse
     * @param methodenname Methoden dieses Namens werden gesucht
     * @return Liste aller Methoden-Objekte in der gegebenen Klasse
     *         mit dem gegebenen Namen
     */
    public static List<Method> alleMethodenInKlasseMitName(String klasse, String methodenname){
        if( methodenname == null){
            throw new IllegalArgumentException("nach Methode null gesucht");
        }
        if(klasse == null){
            throw new IllegalArgumentException("Klasse null existiert nicht");
        }
        List<Method> ergebnis = new ArrayList<>();
        for(Class<?> c: moeglicheClassObjekteFuer(klasse)){
            for(Method m: c.getDeclaredMethods()){
                if (m.getName().equals(methodenname)){
                    ergebnis.add(m);
                }
            }
            for(Method m: c.getMethods()){ // auch geerbte betrachten
                if (m.getName().equals(methodenname) && !ergebnis.contains(m)){
                    ergebnis.add(m);
                }
            }
        }
        return ergebnis;
    }

    /** Hilfsmethode, um zu pruefen, ob eine Liste nur ein Element enthaelt
     *  und dieses dann zurückzugeben; andernfalls eine Exception zu erhalten.
     *  Da in dieser Klasse häufig nach einem Element gesucht wird, aber es
     *  theoretisch mehrere geben kann, geben viele Methoden Listen zurueck,
     *  die hiermit auf ein eindeutiges Element geprueft werden koennen.
     * @param <T> Typ der Listenelemente
     * @param liste zu analysierende Liste
     * @return das einzige Element der Liste, sonst IllegalArgumentException
     */
    public static <T>  T einzig(List<T> liste){
        if (liste.size() == 1){
            return liste.get(0);
        }
        if (liste.isEmpty()){
            throw new IllegalArgumentException("benutze Liste hat kein Element");
        }
        throw new IllegalArgumentException("Liste hat mehr als das geforderte "
                                           + "einzige Element");
    }
}
