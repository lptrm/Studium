package second;

import java.util.BitSet;

public class TestBitSet {
    public static void main (String[] args) {
        int max = Integer.parseInt (args[0]);
        BitSet two = new BitSet(); // leeres BitSet
        BitSet three = new BitSet(); // leeres BitSet
        for (int i = 1; i <= max; i++) {
            if (i%2 == 0) two.set (i); // Vielfache von 2 <= max
        }
        for (int i = 1; i <= max; i++) {
            if (i%3 == 0) three.set (i); // Vielfache von 3 <= max
        }
        System.out.println ("two: "+two+"\n"+ // Ausgabe
                "three:"+three); // ...
        two.and (three); // Durchschnitt: Vielfache von 6 <= max
        System.out.println ("six: "+two); // Ausgabe
    }
}
