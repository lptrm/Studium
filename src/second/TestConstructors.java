package second;
import java.lang.reflect.*;
public class TestConstructors { // Programm zum Testen von Konstruktoren
    static Object[] data = {"1111", "zwei"}; // Array mit String-Daten
    public static void main (String[] args) {
        try {
            if (args.length<2) throw new Exception // Zwei Argumente werden gebraucht:
                    ("Classname and number required"); // Klassenname und # String-Parameter
            Class clazz = Class.forName (args[0]); // Laden der Klasse
            int number = Math.min (2,Integer.parseInt(args[1])); // Lesen der Parameter-#
            Class[] formparas = new Class[number]; // Formale Parameter beschreiben
            for (int i=0; i<number; i++) { // ...
                formparas[i] = String.class; // ...
            }
            Constructor cons = clazz.getConstructor (formparas); // Konstruktor suchen
            Object[] actargs = new Object[number]; // Aktuelle Parameter bereitstellen
            for (int i=0; i<number; i++) { // ... und eintragen
                actargs[i] = data[i]; // ...
            }
            Object obj = cons.newInstance (actargs); // Konstruktor aufrufen
            System.out.println (obj); // erzeugtes Objekt ausgeben
        } catch (Exception e) { // alle möglichen Fehler abfangen
            System.err.println(e); // ... und ausgeben
        } // end try
    } // end main
} // end class TestConstructors
class TestClass { // Simple Testklasse
    private String arg1; // private String-Variablen
    private String arg2;
    public TestClass () { // Konstruktor mit 0 Argumenten
        arg1 = "leer";
        arg2 = "leer";
    }
    public TestClass (String s1) { // Konstruktor mit 1 Argument
        this();
        arg1 = s1;
    }
    public TestClass (String s1, String s2) { // Konstruktor mit 2 Argumenten
        this();
        arg1 = s1;
        arg2 = s2;
    }
    public String toString() { // zur Ausgabe
        return this.getClass().getName() +
                ": arg1 = " + arg1 + ", arg2 = " + arg2;
    }
} // end class TestClass