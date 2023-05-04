package second;

import java.util.*;
public class UmgekehrterObstSortierer {
    public static void main (String[] args) {
        SortedSet<String> s = new TreeSet<> (new ReverseStringComparator2());
// erzwungene Sortierung
        s.add ("Kiwi"); // unsortierte Einfuegungen
        s.add ("Kirsche");
        s.add ("Ananas");
        s.add ("Zitrone");
        s.add ("Banane");
        s.add ("Apfel");
        s.add ("Erdbeere");
        System.out.println (s); // TreeSet Ausgabe
    }
}
class ReverseStringComparator implements Comparator<String> { // Eigener Vergleicher
    public int compare(String s1, String s2) {
        return s2.compareTo(s1); // Invertiere uebliche String-Sortierung
    }
}