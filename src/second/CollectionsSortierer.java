package second;

import java.util.*;
public class CollectionsSortierer {
    public static void main (String[] args) {
        List<String> l = new ArrayList<> (); // leere ArrayList
        l.add ("Kiwi"); // zufaellige Einfuegungen
        l.add ("Kirsche"); // ...
        l.add ("Ananas");
        l.add ("Zitrone");
        l.add ("Banane");
        System.out.println ("Zufaellig: "+l); // Ausgabe
        Collections.sort (l); // natuerliche Sortierung
        System.out.println ("Alphabetisch: "+l); // Ausgabe
        Collections.sort (l, new ReverseStringComparator2()); // erzwungene Sortierung
        System.out.println ("Reverse alphabetisch: "+l); // Ausgabe
    }
}
class ReverseStringComparator2 implements Comparator<String> {
    public int compare (String s1, String s2) {
        return -s1.compareTo(s2);
    }
}
