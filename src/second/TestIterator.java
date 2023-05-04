package second;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Leere Liste von Objekten
        for (int i = 1; i <= 20; ++i) {
            list.add("" + i); // Strings "1" .. "20" anfuegen
        }
        for (Iterator it = list.iterator(); it.hasNext(); ) { // Iterator beschaffen
            if (((String) it.next()).startsWith("1")) { // naechstes Element testen
                it.remove(); // loeschen
            }
        }
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            System.out.print((String) it.next() + " "); // Ausgabe
        }
        System.out.println();
    }
}