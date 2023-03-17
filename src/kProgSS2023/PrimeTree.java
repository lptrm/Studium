package kProgSS2023;

import java.math.BigInteger;

/**
 * @version 42, 17.03.2023
 * @author Jan Obernberger
 * Es kann beobachtet werden, dass durch exponentielles Wachstum sehr viele Threads erzeugt werden. Außerdem wird die im
 * ursprünglichen Programm gegebene Art der Limitierung durch die Manipulation der Zahlen gemäß Aufgabe (3*n+1) umgangen.
 * Im Allgemein muss der Abbruch des Programms erzwungen werden.
 **/
public class PrimeTree extends Thread {
    private final int p;
    private static int tier = 1;
    private PrimeTree left, right;
    private final int column;
    private static BigInteger counter = BigInteger.valueOf(0);

    PrimeTree(int prime, int column) {
        super("Primer-" + prime);
        p = prime;
        this.column = column;
        counter = counter.add(BigInteger.valueOf(1));
        this.start();
    }

    public static void main(String args[]) {
        threadGen(100);

    }

    public static void threadGen(int limit) {
        new Thread(() -> {
            PrimeTree first = new PrimeTree(2, 1);
            for (int i = 3; i <= limit; first.send(i++)) ;
            first.send(0);
        }).start();

    }

    public void run() {

        while (true) {
            int n = receive();
            if (n == 0) {
                if (left != null) left.send(n);
                if (right != null) right.send(n);
                break;
            }
            if (n % p != 0) {
                System.out.println("Tier: " + tier + " Number of Primers: " + counter.toString());
                if (left != null) left.send(n);
                else left = new PrimeTree(n, this.column + 1);
                System.out.println(currentThread() + " Left: " + n);
                if (right != null) right.send(((3 * n) + 1));
                else right = new PrimeTree(((3 * n) + 1), this.column + 1);
                System.out.println(currentThread() + " Right: " + ((3 * n) + 1));
                tier = Math.max(this.column, tier);
            }
        }
    }

    private int buffer = -1;

    synchronized void send(int i) {
        try {
            while (buffer >= 0) wait();
            buffer = i;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized int receive() {
        int result = 0;
        try {
            while ((result = buffer) < 0) wait();
            buffer = -1;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }


}
