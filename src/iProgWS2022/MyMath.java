package iProgWS2022;
/**
 * @version 3, 08.11.2022
 * @author Jan Obernberger
 **/
import java.math.BigInteger;


public class MyMath {
/*
    static int[] zahlenfolge1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
    static long[] zahlenfolge2 = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L, 21L};
    static double[] zahlenfolge3 = {1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d, 19d, 20d, 21d};
    static String[] zahlenfolge4 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"};
*/
    public static void main(String[] Args) {
        /*
        int[] zahlenfolge1;
        int[] zahlenfolge2;
        long[] zahlenfolge3;
        long[] zahlenfolge4;
        float[] zahlenfolge5;
        float[] zahlenfolge6;
        double[] zahlenfolge7;
        double[] zahlenfolge8;

         */
        /*
        MyIO.writeln("Gib mir eine Zahl und ich erstelle je zwei Zahlenfolgen der Datentypen" );
        MyIO.writeln("int[], long[], float[], double[], wobei eine nur positive, die andere" );
        MyIO.writeln("ebenso negative Zahlen enthält. Anschließend suche ich den kleinsten" );
        MyIO.writeln("sowie den größten Wert aus jeder Zahlenfolge. :)" );

         */

        long a = MyIO.readLng(      "Gib mir eine Zahl, ich werde schauen" +
                " ob es sich um eine Primzahl handelt und" +
                " dir die nächstgrößere Primzahl ausgeben:  ");
        while (a < 0) {
            a = MyIO.readLng(      "Error, bitte nur Zahlen <=0 eingeben: ");
        }

        if (isPrime(a)) {
            MyIO.writeln("Deine Zahl ist eine Primzahl");
        } else {
            MyIO.writeln("Deine Zahl ist keine Primzahl");
        }
        MyIO.writeln("Die nächstgrößere Primzahl zu deiner Zahl ist " + nextPrime(a));



    }


    public static int addAll(int... a) {
        int add = 0;

        for (int i = 0; i <= a.length - 1; i++) {

            add = add + a[i];
            System.out.println("a");

        }
        return add;

    }

    public static double addAll(double... a) {
        double add = 0;

        for (int i = 0; i <= a.length - 1; i++) {

            add = add + a[i];
            System.out.println("b");

        }
        return add;

    }

    public static double multiplyAll(int ... a) {
        double mul = 1;

        for (int i = 0; i <= a.length - 1; i++) {

            mul = mul * a[i];

        }
        return mul;

    }

    public static String catAll(int... a) {
        String con = new String();

        for (int i = 0; i <= a.length - 1; i++) {

            con = con + ", " + a[i];

        }
        return "[" + con.substring(1) + "]";

    }

    public static int minAll(int ... a) {
        int max = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] < max) {
                max = a[i];
            }
        return max;
    }

    public static long minAll(long ... a) {
        long max = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] < max) {
                max = a[i];
            }
        return max;
    }

    public static float minAll(float ... a) {
        float max = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] < max) {
                max = a[i];
            }
        return max;
    }

    public static double minAll(double ... a) {
        double max = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] < max) {
                max = a[i];
            }
        return max;
    }

    public static int maxAll(int ... a) {
        int min = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] > min) {
                min = a[i];
            }
        return min;
    }

    public static long maxAll(long ... a) {
        long min = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] > min) {
                min = a[i];
            }
        return min;
    }

    public static float maxAll(float ... a) {
        float min = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] > min) {
                min = a[i];
            }
        return min;
    }

    public static double maxAll(double ... a) {
        double min = a[0];

        for (int i = 1; i < a.length; i++)
            if (a[i] > min) {
                min = a[i];
            }
        return min;
    }
/*
    public static int[] generateInt(int n) {

        int[] row = new int[n];

        for (int i = 0; i < n; i++) {
            row[i] = i + 1;
        }
        return row;
    }
    public static int[] generateInt2(int n) {

        int[] row = new int[2 * n];

        for (int i = 0; i < n; i++) {
            row[i] = i;
        }
        for (int i = 0; i < n; i++) {
            row[i + n] = -i -1;
        }
        return row;
    }
    public static long[] generateLng(int n) {

        long[] row = new long[n];

        for (int i = 0; i < n; i++) {
            row[i] = (long) i + 1L;
        }
        return row;
    }
    public static long[] generateLng2(int n) {

        long[] row = new long[2 * n];
        for (int i = 0; i < n; i++) {
            row[i] = (long) i;
        }
        for (int i = 0; i < n; i++) {
            row[i + n] = (long) -i - 1L;
        }
        return row;
    }
    public static float[] generateFlt(int n) {

        float[] row = new float[n];

        for (int i = 0; i < n; i++) {
            row[i] = (float) i + 1f;
        }
        return row;
    }
    public static float[] generateFlt2(int n) {

        float[] row = new float[2 * n];
        for (int i = 0; i < n; i++) {
            row[i] = (float) i;
        }
        for (int i = 0; i < n; i++) {
            row[i + n] = (float) -i - 1f;
        }
        return row;
    }
    public static double[] generateDbl(int n) {

        double[] row = new double[n];

        for (int i = 0; i < n; i++) {
            row[i] = (double) i + 1d;
        }
        return row;
    }
    public static double[] generateDbl2(int n) {

        double[] row = new double[2 * n];
        for (int i = 0; i < n; i++) {
            row[i] = (double) i;
        }
        for (int i = 0; i < n; i++) {
            row[i + n] = (double) -i - 1d;
        }
        return row;
    }
*/

    public static boolean isPrime (long n){
        if (n < 2){
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; (long) i * i <= n; i += 2){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime (BigInteger n){
        //Hier werden Tests auf n angewendet, mit dem Attribut der Fuktion kann
        //Die Anzahl/Genauigkeit der Tests verändernt werden
        //Is das Ergebnis false, dann ist asd
        return n.isProbablePrime(10);
    }
    public static long nextPrime(long n){
        if (n < 2){
            return 2L;
        }
        do {
            n++;
        } while (!isPrime(n));
        return n;
    }
    public static BigInteger nextPrime(BigInteger n){
        if (n.equals(BigInteger.TWO)){
            return BigInteger.TWO;
        }
        do {
            n.add(BigInteger.ONE);
        } while (!n.isProbablePrime(10));
        return n;
    }
}

