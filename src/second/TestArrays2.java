package second;
import java.lang.reflect.*;
public class TestArrays2 {
    public static void createArray1() {
        Object ar = Array.newInstance (Integer.TYPE, 3); // Array-Erzeugung
        for (int i = 0; i < Array.getLength (ar); ++i) { // Laegenbestimmung
            Array.set (ar, i, new Integer(i)); // Element setzen
            System.out.println (Array.getInt(ar, i)); // Element zugreifen
        };
    }
    public static void createArray2() {
        Object ar = Array.newInstance (String.class, new int[]{7, 4}); // Array-Erzeugung
        for (int i = 0; i < Array.getLength (ar); ++i) { // Laegenbestimmung
            Object subArray = Array.get (ar, i); // Teil-Array zugreifen
            for (int j = 0; j< Array.getLength(subArray); ++j) { // Laegenbestimmung
                String value = "(" + i + "," + j + ")"; // String-Wert erzeugen
                Array.set (subArray, j, value); // Wert in Teil-Array setzen
                System.out.print (Array.get (subArray, j) + " "); // Ausgabe
            }
            System.out.println();
        };
    }
    public static void main (String[] args) { // Test-Methode
        createArray1 (); // Ergebnis wie Programm
        System.out.println ("--"); // TestArrays
        createArray2 ();
    }
}