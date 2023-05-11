package second;
import java.lang.reflect.*;
public class TestArrays{
    public static void createArray1(){
        Object ar = Array.newInstance (Integer.TYPE, 3); // 1-dim int-Array, 3-Elem.
        int[] iar = (int[])ar; // Cast nach int-Array
        for (int i = 0; i < iar.length; ++i) { // fuer alle Elemente:
            iar[i] = i; // Belegung
            System.out.println (iar[i]); // und Ausgabe
        };
    }
    public static void createArray2(){
        Object ar = Array.newInstance (String.class, new int[]{7, 4}); // 2-dim String-Array
        String[][] sar = (String[][])ar; // Cast
        for (int i = 0; i < sar.length; ++i) { // fuer jede Zeile:
            for (int j = 0; j < sar[i].length; ++j) { // fuer jede Spalte:
                sar[i][j] = "(" + i + "," + j + ")"; // Belegung
                System.out.print (sar[i][j] + " "); // und Ausgabe
            }
            System.out.println(); // Zeilenende
        };
    }
    public static void main (String[] args){ // Test-Methode
        createArray1 ();
        System.out.println ("--");
        createArray2 ();
    }
}