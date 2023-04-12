package MaXxWithGUI;
/**
 * @version X, 11.01.2023
 * @author Jan Obernberger, Kevin Goldmann, Lau Kailany, Florijan Deljija, Benno Dinsch
 **/

import java.util.Scanner;

public class HMI {
    private static Scanner sc = new Scanner(System.in);

    public static String read() {
        return sc.hasNextLine() ? sc.nextLine() : null;
    }

    public static void print(String prompt) {
        System.out.println(prompt);
    }

    public static void fehleingabe() {
        print("Fehleingabe, bitte wiederholen: ");
    }

    public static void resume(String player, String visualisierung) {
        print(visualisierung);
        print("Bitte setze deinen Zug fort: " + player);
    }

    public static void begin() {
        print("""
                Herzlich Willkommen bei MaXx!
                Kurz die Regeln; zwei Spieler (W, B) spielen auf einem 8 x 8 Feld gefüllt mit Brüchen.
                Abwechselnd könnt ihr mit den Eingaben N, O, S, W und NO (nur W) oder SW (nur B)
                ziehen und die Brüche "fressen", hierbei bekommt ihr den Bruch auf euer Punktekonto addiert.
                Mit der Eingabe von "menu" kommst du ins Menü.
                Das Spiel endet, sobald ein Spieler 53 Punkte erreicht hat.
                Weiß beginnt, viel Spaß!""");
    }

    public static void menuEntry() {
        print("""
                Du bist jetzt im Menü
                Mit resume kannst du das Spiel fortsetzten
                Mit exit kannst du es beenden""");
    }

    public static void showResults(String player, String pointsFrc, double pointsDbl) {
        print(player + " hat " + pointsFrc + "Punkte." + " ca." + pointsDbl);
    }

    public static String askDirection(String player) {
        print(player + " In welche Richtung möchtest du ziehen?");
        return read();
    }

    public static void end(Spielfigur player) {
        print("Gewonnen hat: " + player.getSign() + " mit\n "
                + player.getPunkte() + " oder ca." + player.getPunkte().doubleValue());
    }
}