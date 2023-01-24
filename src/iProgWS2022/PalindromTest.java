package iProgWS2022;

/**
 * @version 1, 18.10.2022
 * @author Jan Obernberger
 **/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromTest {

    public static void main (String[] Args ) throws IOException {

        System.out.println("Lass mich versuchen, ein Palindrom zu finden");
        System.out.println("Bitte gib hierfür eine beliebige Textzeile ein.");
        BufferedReader kqBr = new BufferedReader(new InputStreamReader(System.in));


        String frageQuelle = kqBr.readLine();

        System.out.println((frageQuelle.toLowerCase().equals(invertieren(frageQuelle.toLowerCase())))
                ? "Es ist ein Palindrom"
                : "Es ist kein Palindrom");

        // System.out.println((frageQuelle.toLowerCase() == invertieren(frageQuelle.toLowerCase())) ? "gut" : "schlecht");
        //Hierbei wird nicht der Wert, sondern ide Referenz vergleichen, deshalb kommt ein falsches Ergebnis heraus.


        }


    public static String invertieren(String a) {

        return a.length() <= 1 ? a :
                invertieren(a.substring(1))+a.substring(0,1);

    }

}