package second;

import java.util.*;
public class TestLinkedList {
    public static void main (String[] args) {
        long max = Long.parseLong (args[0]);
        LinkedList l = new LinkedList(); // leere Liste
        l.add (new Long (max)); // Einfuegen von Long-Objekten
        l.add (new Long (0));
        l.add (new Long (-max));
        System.out.println ("Liste: "+l) ; // Ausgabe
    }
}