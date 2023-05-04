package second;

import java.util.*;
public class PrimesLinkedList { // Primzahlen mit LinkedList
    public static void main (String[] args) {
        int max = Integer.parseInt (args[0]);
        LinkedList primes = new LinkedList(); // Leere Liste fuer bel Objekte
        for (int j=2; j<=max; j++) {
            primes.add (new Integer (j)); // Integer-Objekte einfügen
        }
        for (int i=0; i < primes.size(); i++){
            int k = ((Integer) primes.get(i)).intValue(); // Wiedergewinnen der int-Werte
            for (int j=k+k; j <= max; j+=k){
                primes.remove (new Integer (j)); // Entfernen von Werten
            }
        }
        System.out.println ("Primzahlen: "+primes) ; // Ausgabe
    }
}