package MaXxServerClient; /**
 * @version X, 11.01.2023
 * @author Jan Obernberger, Kevin Goldmann, Lau Kailany, Florijan Deljija, Benno Dinsch
 **/

import java.io.IOException;
import java.util.Scanner;

public class HMI {
    private static Scanner sc = new Scanner(System.in);
    private static Server server = null;

    public static String read() {
        return sc.hasNextLine() ? sc.nextLine() : null;
    }

    public static void print(String prompt) throws IOException {
        System.out.println(prompt);
        if (Controller.isOnline()){
            server.write(prompt);
        }
    }

    public static void fehleingabe() throws IOException {
        print("Fehleingabe, bitte wiederholen: ");
    }

    public static void resume(String player, String visualisierung) throws IOException {
        print(visualisierung);
        print("Bitte setze deinen Zug fort: " + player);
    }

    public static void begin() throws IOException {
        print("""
                Herzlich Willkommen bei MaXx!
                Kurz die Regeln; zwei Spieler (W, B) spielen auf einem 8 x 8 Feld gefüllt mit Brüchen.
                Abwechselnd könnt ihr mit den Eingaben N, O, S, W und NO (nur W) oder SW (nur B)
                ziehen und die Brüche "fressen", hierbei bekommt ihr den Bruch auf euer Punktekonto addiert.
                Mit der Eingabe von "menu" kommst du ins Menü.
                Das Spiel endet, sobald ein Spieler 53 Punkte erreicht hat.
                Weiß beginnt, viel Spaß!""");
    }

    public static void menuEntry() throws IOException {
        print("""
                Du bist jetzt im Menü
                Mit resume kannst du das Spiel fortsetzten
                Mit exit kannst du es beenden""");
    }

    public static void showResults(String player, String pointsFrc, double pointsDbl) throws IOException {
        print(player + " hat " + pointsFrc + "Punkte." + " ca." + pointsDbl);
    }

    public static String askDirection(String player) throws IOException, ClassNotFoundException {
        print(player + " In welche Richtung möchtest du ziehen?");
        return player.equalsIgnoreCase("B")&&Controller.isOnline() ? server.read() : read();
    }

    public static void end(Spielfigur player) throws IOException {
        print("Gewonnen hat: " + player.getSign() + " mit\n "
                + player.getPunkte() + " oder ca." + player.getPunkte().doubleValue());
    }
    public static boolean getMode() throws IOException {
        print("""
                Gebe "online" ein, um übers Netzwerk zu spielen und "offline",
                um offline zu spielen.
                """);
        String s = read();
        return s.equalsIgnoreCase("online");
    }
    public static void attachServer(Server server){
        HMI.server = server;
    }
}