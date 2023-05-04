package second;

import java.util.*; // Paket mit BitSet
public class Eratostenes { // Primzahlen mit Sieb des Eratostenes
    public static void main (String[] args) {
        int max = 50; // max. Primzahl
        BitSet primes = new BitSet(); // leeres BitSet
        for (int i = 2; i <= max; i++) { // alle Zahlen in [2..max]
            primes.set (i); // sind Kandidaten
        }
        for (int i = 2; i <= max; i++) { // fuer jedes i in [2..max]:
            if (primes.get (i)) { // falls i Primzahl:
                for (int j = i+i; j<= max; j+=i){ // betrachte jedes Vielfache von i
                    primes.clear (j); // und loesche es
                }
            }
        }
        System.out.println ("Primzahlen <= " + max + ":\n"+primes); // Ausgabe
    }
}
