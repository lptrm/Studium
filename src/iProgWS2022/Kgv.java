package iProgWS2022;

import java.math.BigInteger;

/**
 * @version 1, 02.11.2022
 * @author Yagmur Simsek
 **/

public class Kgv {
    public static void main(String[] args) {

        MyIO.writeln("Lass mich das kleinsten gemeinsame Vielfache zweier Zahlen finden");

        BigInteger a = MyIO.readBigInt("Gib mir eine Zahl: ");
        BigInteger b = MyIO.readBigInt("Gib mir eine weiter Zahl: ");

        System.out.println("Das Kleinste gemeinsame Vielfache ist: " + kgV(a, b));
    }

    public static BigInteger kgV(BigInteger a, BigInteger b) {
        return (a.multiply(b)).divide(ggt(a, b));
    }

    public static BigInteger ggt(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        } else {
            return ggt(b, a.remainder(b));
        }
    }
}
