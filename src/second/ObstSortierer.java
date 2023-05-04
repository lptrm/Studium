package second;

import java.util.*;
public class ObstSortierer {
    public static void main (String[] args) {
        SortedSet<String> s = new TreeSet<> (); // Menge, natuerliche Sortierung
        s.add ("Kiwi"); // Strings implementieren Comparable
        s.add ("Kirsche");
        s.add ("Ananas");
        s.add ("Zitrone");
        s.add ("Banane");
        s.add ("Apfel");
        s.add ("Erdbeere");
        Iterator it = s.iterator(); // Iterator unterstuetzt Reihenfolge
        while (it.hasNext()) {
            System.out.println (it.next()); // sortierte Ausgabe
        }
    }
}
