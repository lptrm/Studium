package iProgWS2022;
/**
 * @version 1, 14.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/

import java.util.ArrayList;
import java.util.Collections;

public class FractionStreams {
    public static void main(String[] args) {

        System.out.println("Lass uns zuerst das einlesen von Fraction Testen... ");
        Fraction f = MyIO.readFct("Bitte gib hierzu eine Fraction ein ");
        System.out.println("Die eingegebene Fraction ist (normalisiert): " + f);
        System.out.println("Nun lass mich die FractionStreams ausgeben: ");

        ArrayList<Fraction> liste = new ArrayList<Fraction>();
        for (int i = -9; i <= 19; i++)
            for (int j = -9; j <= 19; j++) {
                liste.add(new Fraction(i, j));
            }

        /**
         *Gibt Float-Werte aller Brüche der sortierten Liste eindeutig aus
         **/
        System.out.println("Alle Brüche quadriert, sortiert und eindeutig. ");
        liste.stream().sorted().distinct().map(n -> n.multiply(n)).forEach(x -> System.out.print(x + " "));
        /**
         *Gibt Float-Werte aller Brüche der sortierten Liste eindeutig aus
         **/
        System.out.println();
        System.out.println("Alle Brüche in zufälliger Reihenfolge. Nur Primzahlen. ");
        /*
        liste.parallelStream().forEach(n -> {
            if (n.nenner.isProbablePrime(10) && n.zaehler.isProbablePrime(10))
                System.out.print(n + " ");
        });
         */

        ArrayList<Fraction> listt = new ArrayList<Fraction>(liste);
        Collections.shuffle(listt);
        listt.stream().filter(n -> n.numerator.isProbablePrime(10) && n.denominator.isProbablePrime(10)).forEach(x -> System.out.print(x + " "));

                /**
        *Gibt alle Brüche aus, die Integer sind
        **/
        System.out.println();
        System.out.println("Alle Brüche sortiert, die Integer sind. ");
        liste.stream().sorted().filter(Fraction::isInteger)
                .forEach(x -> System.out.print(x + " "));
                        /**
        *Gibt alle Brüche als Double aus, wobei vorher der Sinus des Elementes berechnet wird
        **/
        System.out.println();
        System.out.println("Alle Brüche sortiert, jeweils der Sinuswert, als double. ");
        liste.stream().sorted().map(n -> Math.sin(n.doubleValue()))
                .forEach(x -> System.out.print(x + " "));
    }


}
