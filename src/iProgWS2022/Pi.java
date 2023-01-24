package iProgWS2022;

/**
 * @version 1, 02.11.2022
 * @author Yagmur Simsek
 **/

public class Pi {
    public static void main(String[] args) {
        MyIO.writeln("Lass uns Pi annähern.");
        long a = MyIO.readLng("Gib mir die Anzahl der Iterationen: ");
        while (a <= 1) {
            a = MyIO.readLng("Error, die Anzahl muss >=1 sein: ");
        }
        MyIO.writeln("Iterativ: " +
                piIterativ(a));

        MyIO.writeln("Rekursiv: " +
                Math.sqrt(piRekursiv(a)));


    }
    public static double piIterativ(long a){
        double result = 0;
        while(a != 0){

            result = result + 6D / (a*a);
            a--;
        }
        return Math.sqrt(result);
    }

    public static double piRekursiv(long a) {

        return a == 0 ? 0 : (double) 6 / (a * a) + piRekursiv(a - 1);
    }

/*
    public static BigDecimal pi3(long a){
        BigDecimal result = new BigDecimal(0);
        MathContext mc = new MathContext(100);
        BigDecimal test = BigDecimal.valueOf(a * a);
        BigDecimal test2 = BigDecimal.valueOf(6);
        while(a != 0){
            result = result.add(test2.divide(test));
            a--;
        }
        return result;
    }

 */

}
