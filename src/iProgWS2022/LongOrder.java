package iProgWS2022;
/**
 * @version 1, 08.11.2022
 * @author Jan Obernberger
 **/
import java.util.Arrays;

public class LongOrder {
    public static void main(String[] args) {
        //Variable für Anzahl der Elemente, die Sortiert werden sollen
        int n = MyIO.readInt("Bitte gib die Anzahl der Elemente ein: ");
        long[] zahlen = new long[n];
        for (int i = 0; i < zahlen.length; i++){
            zahlen[i] = MyIO.readLng("Bitte gib die " + (i+1) + ". Zahl ein: ");
        }

        /*
        long[] zahlen = new long[4];
        zahlen[0] = MyIO.readLng("Bitte gebe die erste Zahl ein: ");
        zahlen[1] = MyIO.readLng("Bitte gebe die zweite Zahl ein: ");
        zahlen[2] = MyIO.readLng("Bitte gebe die dritte Zahl ein: ");
        zahlen[3] = MyIO.readLng("Bitte gebe die vierte Zahl ein: ");


        Arrays.sort(zahlen);
        MyIO.writeln(Arrays.toString(zahlen));


         */
        //Bubblesort
        //Compareable Interface
        //Schleife für Durchlauf des Arrays
        for (int i = 0; i < zahlen.length - 1; i++){
            //Schleife für Durchlauf an zahlen[i]
            for (int j = 0; j < zahlen.length - 1 - i; j++){
                //Temporärer Variable wird das aktuelle Element zugewiesen
                long temp = zahlen[j];
                //Prüfung: ist aktuelles Element größer als nächstes Element?
                if (zahlen[j] > zahlen[j+1]){
                //Wenn ja werden die Zahlen getauscht
                zahlen[j] = zahlen[j +1];
                zahlen[j + 1] = temp;
                }
                //Wenn nein springt die Schleife zum nächsten Element
            }
        }
        MyIO.writeln(Arrays.toString(zahlen));
    }



}
