package iProgWS2022;
/**
 * @version 1, 08.11.2022
 * @author Jan Obernberger
 **/

public class Sinus {
    public static void main(String[] args) {
        double n = MyIO.readDbl("Gebe mir eine Zahl, ich werde" +
                " hieraus den Sinus gemäß der Taylorreihe nähern: ");
        MyIO.writeln(sin(n));
    }

    public static double sin(double n) {
        //Festlegung von Pi sowie 2 * Pi
        double pi = 3.14159265358979323846;
        double pi2 = 6.28318530717958647693;
        //n wird auf 2 * Pi, also eine Sinusperiode, skaliert
        n = n % pi2;
         //Festlegung des minimalen Fehlers
        double minInaccuracy = 1e-320;
        //Initialisierung des Akkumulators
        double sum = 0.0;
        //Initialisierung der Variable für Berechnung der aktuellen Iteration
        double term = n;
        //Initialsierung der Variable für den momentanen Fehler (Betrag)
        double curInaccuracy = (term <= 0.0D) ? 0.0D - term : term;
        //Schleife für Approximation (Taylorpolynom)
        for (int i = 1; curInaccuracy >= minInaccuracy || i < 1000; i++){
            //Term wird aufsummiert
            sum += term;
            //Term von -1^n / (2k * (2k+1)) wird als Produkt erweitert
            //Dies entspricht der Änderung von einer Iteration zB. n0 zu n1 der Taylorreihe der Sinusfunktion
            term *= -1 * n * n / (2.0 * i * (2.0 * i + 1.0));
            //Der Betrag des aktuellen Wertes wird in der Variable curError gespeichert
            curInaccuracy = (term <= 0.0D) ? 0.0D - term : term;
        }
        return sum + term;
    }
}







