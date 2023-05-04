package second;

import java.util.*;
/**
 * @author Jan Obernberger: 215470
 * @version 4.20, 04.05.2023
 **/
public class Umfuelllisten {
    static int A, B, C, D, E;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Geben Sie die Füllstände A, B, C, D und E ein und bestätigen Sie jedes Element mit Enter.");
        A = readInt("A: ");
        B = readInt("B: ");
        C = readInt("C: ");
        D = readInt("D: ");
        E = readInt("E: ");
        sc.close();
        System.out.printf("Kapazitäten sind ( %d %d %d %d %d )\n", A, B, C, D, E);

        Set<State> seen = new TreeSet<>(); // Menge bereits gesehener Zustände, TreeSet für Einhalten der Ordnung
        Stack<State> stack = new Stack<>(); // Stack für Tiefensuche, alternativ mit Queue als BFS
        stack.push(new State(A, 0, 0, 0, 0)); // Anfangszustand

        // DFS-Schleife
        while (!stack.isEmpty()) {
            State currentState = stack.pop(); // aktuellen Knoten holen
            if (!seen.contains(currentState)) {
                seen.add(currentState); // aktuellen Knoten zu den bereits besuchten Knoten hinzufügen
                int[][] successors = {  // alle möglichen nächsten Knoten im Array ablegen
                        currentState.pourAB(),
                        currentState.pourAD(),
                        currentState.pourBC(),
                        currentState.pourCD(),
                        currentState.pourDB(),
                        currentState.pourED()
                };
                for (int[] successor : successors) {
                    if (successor != null) {    // kann ein Gefäß nicht gefüllt werden, so ist ein null Element im Array
                        State possibleState =   // neues State Objekt erzeugen
                                new State(successor[0], successor[1], successor[2], successor[3], successor[4]);
                        if (!seen.contains(possibleState)) {
                            stack.push(possibleState); //State Objekt in die BFS-Queue legen
                        }
                    }
                }
            }
        }
        System.out.println("Fünftupel sind:");
        for (State state : seen) {
            System.out.println(state);
        }
        System.out.printf("Es gab genau %d Fünftupel", seen.size());
    }

    /**
     * Funktion zum Lesen eines Integers über die Konsole
     * @param prompt : Textausgabe vor dem Einlesen
     * @return : eingegebenes int Element
     */
    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (true) try {
            return sc.hasNextLine() ? Integer.parseInt(sc.nextLine().trim()) : null;
        } catch (Exception e) {
            System.out.println(e + "Error, bitte nochmal versuchen");
        }
    }

    /**
     * Datenstruktur der Tupel für den Füllstand
     * @param a : Behälter Nr. 1
     * @param b : Behälter Nr. 2
     * @param c : Behälter Nr. 3
     * @param d : Behälter Nr. 4
     * @param e : Behälter Nr. 5
     */
    private record State(int a, int b, int c, int d, int e) implements Comparable<State> {

        /**
         * @return : Zustand nach einem 1 -> 2-Umfüllen zurück, oder null falls nicht möglich
         */
        public int[] pourAB() {
            if (a > 0 && b < B) {
                int difference = Math.min(a, B - b);
                return new int[]{a - difference, b + difference, c, d, e};
            }
            return null;
        }

        /**
         * @return : Zustand nach einem 1 -> 4-Umfüllen zurück, oder null falls nicht möglich
         */
        public int[] pourAD() {
            if (a > 0 && d < D) {
                int difference = Math.min(a, D - d);
                return new int[]{a - difference, b, c, d + difference, e};
            }
            return null;
        }

        /**
         * @return : Zustand nach einem 2 -> 3-Umfüllen zurück, oder null falls nicht möglich
         */
        public int[] pourBC() {
            if (b > 0 && c < C) {
                int difference = Math.min(b, C - c);
                return new int[]{a, b - difference, c + difference, d, e};
            }
            return null;
        }

        /**
         * @return : Zustand nach einem 3 -> 5-Umfüllen zurück, oder null falls nicht möglich
         */
        public int[] pourCD() {
            if (c > 0 && e < E) {
                int difference = Math.min(c, E - e);
                return new int[]{a, b, c - difference, d, e + difference};
            }
            return null;
        }

        /**
         * @return : nach einem 4 -> 2-Umfüllen zurück, oder null falls nicht möglich
         */
        public int[] pourDB() {
            if (d > 0 && b < B) {
                int difference = Math.min(d, B - b);
                return new int[]{a, b + difference, c, d - difference, e};
            }
            return null;
        }

        /**
         * @return : Zustand nach einem 5 -> 4-Umfüllen zurück, oder null falls nicht möglich
         */
        public int[] pourED() {
            if (e > 0 && d < D) {
                int difference = Math.min(e, D - d);
                return new int[]{a, b, c, d + difference, e - difference};
            }
            return null;
        }

        @Override
        public String toString() {
            return String.format("( %d %d %d %d %d )", a, b, c, d, e);
        }

        @Override
        public int compareTo(State o) {
            return a != o.a ? Integer.compare(a, o.a) : b != o.b ? Integer.compare(b, o.b) : c != o.c ? Integer.compare(c, o.c) :
                    d != o.d ? Integer.compare(d, o.d) : e != o.e ? Integer.compare(e, o.e) : 0;
        }
    }
}