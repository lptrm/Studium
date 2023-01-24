package iProgWS2022;

/**
 * @version 1, 25.10.2022
 * @author Jan Obernberger
 **/


public class Ggt {
    public static void main(String[] args) {

        MyIO.writeln("Lass mich den kleinsten gemeinsamen Nenner zweier Zahlen Finden");

        int a = MyIO.readInt("Gib mir eine Zahl: ");
        int b = MyIO.readInt("Gib mir eine weiter Zahl: ");
        System.out.println("Der Kleinste gemeinsame Nenner ist: " + ggt(a, b));
    }


    public static int ggt (int a, int b) {

        if (b == 0) {

            return a;
        }

        return ggt (b , (a % b));
    }
}
