package iProgWS2022;

public class GgtIterativ {
    public static void main(String[] args) {

        MyIO.writeln("Lass mich den kleinsten gemeinsamen Nenner zweier Zahlen Finden");

        int a = MyIO.readInt("Gib mir eine Zahl: ");
        int b = MyIO.readInt("Gib mir eine weiter Zahl: ");
        System.out.println("Der Kleinste gemeinsame Nenner ist: " + ggt(a, b));
    }


    public static int ggt(int a, int b) {

        while ( b > 0) {

            int h = a % b;
            a = b;
            b = h;

      /*
        if (b == 0) {
            return a;
        }
        return ggt (b , (a % b));

       */
        }

        return a;
    }

}