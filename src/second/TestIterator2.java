package second;

import java.util.*;
public class TestIterator2{
    public static void main (String[] args) {
        List<String> list = new ArrayList<String>(); // Leere String-Liste
        for (int i = 1; i <= 20; ++i) {
            list.add ("" + i); // ArrayList mit Strings "1" .. "20"
        }
        for (Iterator<String> it=list.iterator(); it.hasNext() ;) { // String-Iterator
            if (it.next().startsWith("1")) { // naechstes Element testen
                it.remove(); // loeschen
            }
        }
        for (String str : list) { // Automatisch erzeugter Iterator
            System.out.print (str + " "); // Ausgabe
        }
        System.out.println ();
    }
}