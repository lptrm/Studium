package iProgWS2022;

/**
 * @version 1, 25.10.2022
 * @author Jan Obernberger
 **/


public class PowerTower {
    public static void main(String[] args) {
        MyIO.writeln("Lass uns einen Power Tower Bauen");
        double a = MyIO.readDbl("Gib mir die Zahl, die mit sich selbst potentiert werden soll: ");
        int b = MyIO.readInt("Gib mir die Anzahl der Potenzenierungsschritte an: ");
        MyIO.writeln("Der Funktionswert des Towers ist: " + powerTower(a, b));
    }

    public static double powerTower(double a, int b) {

        if (b == 0) {
            return 1;
        }
        else
        {
            return Math.pow(a, powerTower(a, b - 1));
        }
    }

}