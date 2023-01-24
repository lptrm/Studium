package iProgWS2022;
/**
 * @version 1, 08.11.2022
 * @author Jan Obernberger
 **/

public class FifthRoot {
    public static void main(String[] args) {
        //Eingabeaufforderung und Speichern der Eingabe in Variable
        double x = MyIO.readDbl("Gib mir eine Zahl und ich werde" +
                "ihre fünfte Wurzel nähern! ");
        //Festlegung des minimalen Fehlers
        double minInaccuracy = 1e-10;
        //Festlegung aktueller X-Wert
        double x0 = 2d;
        //Feslegung nächster X-Wert
        double x0Plus1 = 1d;
        //Schleife für Näherung der Wurzel
        double curInaccuracy = x0 - x0Plus1;

        for (int i = 0; curInaccuracy >= minInaccuracy || i <= 1000; i++){
            //Nächster X-Wert wird aktueller X-Wert
            x0 = x0Plus1;
            //Nächster X-Wert wird berechnet gemäß https://de.wikipedia.org/wiki/Newtonverfahren
            //Math Bibliothek, kann hier komplexe Zahlen ergeben, sodass die Ergebnisse nicht korrekt sind
            x0Plus1 = x0 - (x0 * x0 * x0 * x0 * x0  - x) / (5d *x0 * x0 * x0 * x0);
            curInaccuracy = (x0Plus1 - x0 <= 0.0D) ?  x0 - x0Plus1: x0Plus1 - x0;
        }
        //Ausgabe des Akkumaltors
        MyIO.writeln(x0Plus1);
    }
}
