package iProgWS2022;

public class PowerTowerIterative {
        public static void main(String[] args) {
            MyIO.writeln("Lass uns einen Power Tower Bauen");
            double a = MyIO.readDbl("Gib mir die Zahl, die mit sich selbst potentiert werden soll: ");
            int b = MyIO.readInt("Gib mir die Anzahl der Potenzenierungsschritte an: ");
            MyIO.writeln("Der Funktionswert des Towers ist: " + powerTower(a, b));
        }

        public static double powerTower(double a, int b) {
            double h = a;
            if (b == 0) {
                return 1;
            }
            for (int i = b; i > 1; i--){

                a = Math.pow(h, a);
            }

            return a;
        }

}