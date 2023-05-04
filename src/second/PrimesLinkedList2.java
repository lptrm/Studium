package second;

import java.util.*;
public class PrimesLinkedList2 { // Primzahlen mit LinkedList Java 5.0
    public static void main (String[] args) {
        int max = Integer.parseInt (args[0]);
        List<Integer> primes = new LinkedList<Integer>(); // Leere Integer-Liste
        for (int j=2; j<=max; j++) {
            primes.add (j); // Integer-Objekte einfügen (Auto Boxing)
        }
        for (int i=0; i < primes.size(); i++){
            int k = primes.get(i); // Wiedergewinnen der int-Werte
            for (int j=k+k; j <= max; j+=k){
                primes.remove (new Integer (j)); // Entfernen von Werten
            } // Kein Autoboxing !!
        }
        System.out.println ("Primzahlen: "+primes) ; // Ausgabe
    }
}