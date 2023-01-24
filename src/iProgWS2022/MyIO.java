package iProgWS2022;
/**
 * @version 1, 14.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class MyIO {

    private MyIO() {

    }

    static Scanner sc = new Scanner(System.in);

    public static String readString() {
        return sc.hasNextLine() ? sc.nextLine() : null;
    }

    public static String promptAndRead(String prompt) {
        System.out.println(prompt);
        return sc.hasNextLine() ? sc.nextLine() : null;
    }

    public static Fraction readFct(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                String frc = sc.hasNextLine() ? sc.nextLine().trim() : null;
                String[] arr = frc.split("/");
                return new Fraction(BigInteger.valueOf(Long.parseLong(arr[0])), BigInteger.valueOf(Long.parseLong(arr[1])));
            } catch (Exception e) {
                System.out.println(e + "Error, bitte nochmal versuchen");
            }

        }
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (true) try {
            return sc.hasNextLine() ? Integer.parseInt(sc.nextLine().trim()) : null;
        } catch (Exception e) {
            System.out.println(e + "Error, bitte nochmal versuchen");

        }
    }

    public static long readLng(String prompt) {
        System.out.print(prompt);
        while (true) try {
            return sc.hasNextLine() ? Long.parseLong(sc.nextLine().trim()) : null;
        } catch (Exception e) {
            System.out.println(e + "Error, bitte nochmal versuchen");
        }
    }

    public static BigInteger readBigInt(String prompt) {
        System.out.print(prompt);
        while (true) try {
            return sc.hasNextLine() ? new BigInteger(sc.nextLine().trim()) : null;
        } catch (Exception e) {
            System.out.println(e + "Error, bitte nochmal versuchen");
        }
    }

    public static float readFlt(String prompt) {
        System.out.print(prompt);
        while (true) try {
            return sc.hasNextLine() ? Float.parseFloat(sc.nextLine().trim()) : null;
        } catch (Exception e) {
            System.out.println(e + "Error, bitte nochmal versuchen");

        }
    }

    public static double readDbl(String prompt) {
        System.out.print(prompt);
        while (true) try {
            return sc.hasNextLine() ? Double.parseDouble(sc.nextLine().trim()) : null;
        } catch (Exception e) {
            System.out.println(e + "Error, bitte nochmal versuchen");

        }
    }

    public static BigDecimal readBigDec(String prompt) {
        System.out.print(prompt);
        while (true) try {
            return sc.hasNextLine() ? new BigDecimal(sc.nextLine().trim()) : null;
        } catch (Exception e) {
            System.out.println(e + "Error, bitte nochmal versuchen");
        }
    }

    public static void write(String s) {
        System.out.print(s);
        return;
    }

    public static void write(int a) {
        System.out.println(a);
        return;
    }

    public static void write(long a) {
        System.out.println(a);
        return;
    }

    public static void write(float a) {
        System.out.println(a);
        return;
    }

    public static void write(double a) {
        System.out.println(a);
        return;
    }

    public static void writeln(String s) {
        System.out.println(s);
        return;
    }

    public static void writeln(int a) {
        System.out.println(a);
        return;
    }

    public static void writeln(long a) {
        System.out.println(a);
        return;
    }

    public static void writeln(float a) {
        System.out.println(a);
        return;
    }

    public static void writeln(double a) {
        System.out.println(a);
        return;
    }
}
