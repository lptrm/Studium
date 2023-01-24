/**
 * @version 1, 08.11.2022
 * @author Jan Obernberger
 **/
package iProgWS2022;

public class WordLcm {
    public static void main(String[] args) {

        //Initialisierung der Variablen
        long eng2 = 1L;
        long eng1 = 0L;
        String s;
        //Endlosschleife für die Eingabe

        while (true) {
            //Erstes Zahlenwort wird entgegengenommen
            s = MyIO.promptAndRead("Gib mir ein zahlenwort: ");
            //Prüfung auf Leereingabe als Abbruchbedingung
            if (s.isEmpty() && eng1 != 0) break;
            //Übersetzen des ersten bzw. nächsten Zahlenwortes
            eng1 = translate(s);
            //Kontrollschleife
            s = MyIO.promptAndRead("Gib mir ein Zahlenwort: ");
            //Prüfung auf Leereingabe als Abbruchbedingung
            if (s.isEmpty()) break;
            //Übersetzen des nächsten Zahlenwortes
            eng2 = translate(s);
            }

        //Augabe des kgV als a * b / ggT(a, b)
        MyIO.writeln("Das kleinste gemeinsame Vielfache von " +
                eng1 +
                " und " +
                eng2 +
                " ist " +
                (eng1 * eng2) / Ggt(eng1, eng2));
    }

    public static long translate(String txt){
        //Switch-Case, um die Texteingabe in eine long Zahl zu übersetzen
        switch (txt.toLowerCase()){
            case "eins" : return 1L; case "zwei" : return 2L; case "drei" : return 3L; case "vier" : return 4L;
            case "fünf" : return 5L; case "sechs" : return 6L; case "sieben" : return 7L; case "acht" : return 8L;
            case "neun" : return 9L; case "zehn" : return 10L; case "elf" : return 11L; case "zwölf" : return 12L;
            case "dreizehn" : return 13L; case "vierzehn" : return 14L; case "fünfzehn" : return 15L;
            case "sechzehn" : return 16L; case "siebzehn" : return 17L; case "achtzehn" : return 18L;
            case "neunzehn" : return 19L; case "zwanzig" : return 20L; case "einundzwanzig" : return 21L;
            case "zweiundzwanzig" : return 22L; case "dreiundzwanzig" : return 23L; case "vierundzwanzig" : return 24L;
            case "fünfundzwanzig" : return 25L; case "sechsundzwanzig" : return 26L;
            case "siebenundzwanzig" : return 27L; case "achtundzwanzig" : return 28L;
            case "neunundzwanzig" : return 29L; case "dreissig" : return 30L;
            //default-Wert für fehlerhafte Eingaben
            default : return translate(MyIO.promptAndRead("Falscheingabe des Zahlenwortes: "));
        }
    }
    //Rekursiver Algorithmus zur Berechnung des ggT
    public static long Ggt(long m, long n){
        if (n == 0){
            return m;
        }
        return Ggt (n, m % n);
    }
}
