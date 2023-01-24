package iProgWS2022;

/**
 * @version 1, 18.10.2022
 * @author Jan Obernberger
 **/


import java.io.*;

public class FileMirror {

    public static void main (String[] Args ) throws IOException {

        System.out.println("Lass mich den Inhalt einer Textdatei spiegelverkehrt kopieren.");
        System.out.println("Gib hierzu zuerst den Pfad der Quelldatei ein");
        System.out.println("Bestätige deine Eingabe mit der Enter-Taste.");
        System.out.println("Gib nun den Pfad der Zieldatei ein und bestätige diesen.");
        BufferedReader k1FmBr = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader k2FmBr = new BufferedReader(new InputStreamReader(System.in));

        String frageQuelle = k1FmBr.readLine();
        String frageZiel = k2FmBr.readLine();

        BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(frageQuelle))));

        String fInputLine = fbr.readLine();

        PrintStream target = new PrintStream(new FileOutputStream(new File(frageZiel)));

        while (fInputLine != null) {
            target.println(invertieren(fInputLine));
            fInputLine = fbr.readLine();

        }

    }
    public static String invertieren(String a) {

        return a.length() <= 1 ? a :
                invertieren(a.substring(1))+a.substring(0,1);

    }

}