package iProgWS2022;
/**
 * @version 1, 21.11.2022
 * @author Jan Obernberger
 **/
import java.util.Arrays;

public class Fractrain {
    public static void main(String[] args) {
        Fraction[] L = {
                new Fraction(17,91), new Fraction(78,85), new Fraction(19,51),
                new Fraction(23,38), new Fraction(29,33), new Fraction(77,29),
                new Fraction(95,23), new Fraction(77,19), new Fraction(1,17),
                new Fraction(11,13), new Fraction(13,11), new Fraction(15,2),
                new Fraction(1,7), new Fraction(55,1),
        };
        System.out.println("Der erste Bruch multipliziert mit dem zweiten ergibt: " + L[0].multiply(L[1]));
        System.out.println(Arrays.toString(L));
        Fraction b = new Fraction(8, 1);
        System.out.println("Der vorgegebene Bruch ist: " + b);
        Fraction z = new Fraction(1, 1);
        Fraction max = b;
        System.out.println("Lass uns den Fractrain starten.....\n");
        int maxpos = 0;
        for (int i = 0; i <= 19199; i++) {
            for (Fraction f : L) {
                z = b.multiply(f);
                if (z.isInteger()){
                    b = z;
                    break;
                }
            }
            if (i <= 3824){
                System.out.println(z + " zahl nummer " + (i+1)+ ", ");
            }
            /*
            if ((i+1) % 5 == 0 && i <= 3824){
                System.out.println();
            }
            */

            if (i <= 7999){
                if (z.compareTo(max) > 0){
                    max = z;
                    maxpos = i+1;
                }
            }
            if (i == 7999) System.out.println("\nDie " + (i+1) + ". Zahl ist " + z+"\n");
            if (i == 19199) System.out.println("Die " + (i+1) + ". Zahl ist " + z+"\n");
        }
        System.out.println("Die größte Zahl der ersten 8000 ist: " + max + " an der Stelle " + maxpos);
    }
}
