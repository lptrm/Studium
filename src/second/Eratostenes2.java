package second;

import java.util.*;
public class Eratostenes2 { // Primzahlen mit Sieb des Eratostenes
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        BitSet primes = new BitSet(); // leeres BitSet
        for (int i = 2; i <= max; i++) {
            primes.set(i); // Kandidaten
        }
        for (int i = 2; i <= max; i++) {
            BitSet discard = new BitSet(); // Streich-Menge, erst leer
            for (int j = i + i; j <= max; j += i) {
                discard.set(j); // alle Vielfachen von i
            }
            primes.andNot(discard); // andNot-Operator: streiche in primes
        }
        System.out.println("Primzahlen <= " + max + ":\n" + primes);
    }
}

