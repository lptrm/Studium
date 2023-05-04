package second;

import java.util.*;
import static java.lang.Math.*;
public class LottoGlueck {
    public static void main (String[] args){
        Set<Integer> set = new HashSet<Integer> (10); // Reicht fuer 6 Integers
        while (set.size() < 6) { // bis Mengengroesse == 6
            int num = (int)(random() * 49) + 1; // Zufallszahl aus [1 .. 49]
            if (!set.add (num)) { // Einfuegeversuch
                System.out.println (""+num+" war schon da"); // wenn erfolglos ...
            }
        }
        System.out.println ("Lottozahlen: " + set); // Ausgabe
    }
}