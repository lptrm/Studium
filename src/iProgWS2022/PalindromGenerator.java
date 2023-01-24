package iProgWS2022;

/**
 * @version 1, 18.10.2022
 * @author Jan Obernberger
 **/

import java.io.*;

public class PalindromGenerator {

    public static void main(String[] Args) throws IOException {

        System.out.println("Lass uns ein Palindrom basteln!");
        System.out.println("Bitte gib hierfür zwei beliebige Textzeile ein.");
        System.out.println("Bestätige jede Textzeile mit der Enter-Taste.");
        BufferedReader k1Br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader k2Br = new BufferedReader(new InputStreamReader(System.in));

        String eingabe1 = k1Br.readLine();
        String eingabe2 = k2Br.readLine();

        String Ausgabe1 = eingabe1 + invertieren(eingabe1);
        String Ausgabe2 = eingabe2 + invertieren(eingabe2);
        String Ausgabe3 = zip(eingabe1, eingabe2) + invertieren(zip(eingabe1, eingabe2));
        String Ausgabe4 = zip(eingabe2, eingabe1) + invertieren(zip(eingabe2, eingabe1));
        String Ausgabe5 = zip(zip(eingabe1, eingabe2), zip(eingabe2, eingabe1)) + invertieren(zip(zip(eingabe1, eingabe2), zip(eingabe2, eingabe1)));

        System.out.println(palindrom(Ausgabe1));
        System.out.println(palindrom(Ausgabe2));
        System.out.println(palindrom(Ausgabe3));
        System.out.println(palindrom(Ausgabe4));
        System.out.println(palindrom(Ausgabe5));


        System.out.println("Lass uns die Palindrome nun speichern als Palindrom.txt speichern!");

        PrintStream target = new PrintStream(new FileOutputStream(new File("Palindrom.txt")));
        target.println(palindrom(Ausgabe1));
        target.println(palindrom(Ausgabe2));
        target.println(palindrom(Ausgabe3));
        target.println(palindrom(Ausgabe4));
        target.println(palindrom(Ausgabe5));


    }

    public static String zip(String a, String b){



        return a.length() == 0 ? b : b.length() == 0 ? a :
                a.substring(0, 1) + b.substring(0, 1) + zip(a.substring(1), b.substring(1));

    }
    public static String invertieren(String a) {

        return a.length() <= 1 ? a :
                invertieren(a.substring(1))+a.substring(0,1);

    }

    public static String palindrom(String a) {
       return a.substring(0,1).toUpperCase()
                + (a.substring(1, (  a.length() -1)).toLowerCase())
                + (a.substring(a.length() - 1).toUpperCase());
    }

}

