package MaXx; /**
 * @author Jan Obernberger, Kevin Goldmann, Lau Kailany, Florijan Deljija, Benno Dinsch
 * @version X, 11.01.2023
 **/

import java.io.IOException;
import java.math.BigInteger;

public class Controller {
    /**
     * Steuerflags
     */
    private boolean menu;
    private boolean end;
    private boolean eingabe;
    private boolean player;
    private boolean recWat;
    private static boolean online;
    private int playerIndex;
    private final Spielfeld spielfeld;
    private Spielfigur winner;
    private final Spielfigur[] spielfigur;
    private final Visualisierung visualisierung;
    private final Server server;

    public Controller(Spielfeld spielfeld, Visualisierung visualisierung) throws IOException {
        this.menu = false;
        this.end = false;
        this.eingabe = true;
        this.player = true;
        this.recWat = true;
        this.playerIndex = 0;
        this.spielfeld = spielfeld;
        this.visualisierung = visualisierung;
        this.winner = null;
        this.spielfigur = spielfeld.getF();
        online = HMI.getMode();
        this.server = online ? new Server() : null;
        visualisierung.init(spielfeld);
        HMI.begin();
    }

    /**
     * Methode, welche die zwei Spielfiguren abwechselnd mit dem MaXx.Spielfeld interagierend lässt (siehe Aufga-
     * benstellung von Herrn Heinz im Wintersemester 2022 Einleitung 9 Spiel "MaXx.MaXx". Als void, da Informationen zum
     * aktuellen Spielverlauf in der Instanz des Spielfeldes bzw. der Spielfiguren (durch Referenzen aneinander gebunden)
     */
    public void zug() throws IOException, ClassNotFoundException {
        playerIndex = player ? 0 : 1;
        if (eingabe) {
            HMI.print(spielfeld.toString());
            for (Spielfigur f : spielfigur) {
                Fraction points = f.getPunkte();
                if (!points.getNumerator().equals(BigInteger.ZERO) && !points.getDenominator().equals(BigInteger.ZERO))
                    //Anzeige des Punktestands des Spielers nur, wenn Punkte > 0!
                    HMI.showResults(f.getSign(), f.getPunkte().toString(), f.getPunkte().doubleValue());
            }
        }
        String s2 = HMI.askDirection(spielfigur[playerIndex].getSign());
        eingabe = false;
        for (Richtung r : spielfigur[playerIndex].getDir()) {
            if (r.getShrt().equalsIgnoreCase(s2)) {
                //Eingabe wird true, wenn der eingegebene String mit einer legitimen MaXx.Richtung der MaXx.Spielfigur des
                //spieler übereinstimmt
                eingabe = true;
                break;
            }
        }
        if (eingabe) {
            Richtung richtung = switch (s2.toUpperCase()) {
                case "N" -> Richtung.Nord;
                case "O" -> Richtung.Ost;
                case "S" -> Richtung.Sued;
                case "W" -> Richtung.West;
                case "NO" -> Richtung.Nordost;
                case "SW" -> Richtung.Suedwest;
                default -> throw new IllegalStateException("Unexpected value: " + s2);
            };
            if (!isLegit(richtung, spielfigur[playerIndex])) {
                eingabe = false;
            } else {
                moveFigure(spielfigur[playerIndex], richtung);
                visualisierung.update(spielfeld);
            }

        } else if (s2.equalsIgnoreCase("menu")) {
            menuCall();
            if (recWat || end) {
                recWat = !recWat;
                return;
            }

        }
        if (!eingabe) {
            HMI.fehleingabe();
            zug();
        }
    }

    private void menuCall() throws IOException, ClassNotFoundException {
        menu = true;
        HMI.menuEntry();
        while (menu) {
            String s3 = HMI.read();
            switch (s3.toLowerCase()) {
                case "resume" -> {
                    recWat = true;
                    menu = false;
                    HMI.resume(spielfigur[playerIndex].getSign(), visualisierung.toString());
                    zug();
                }
                case "exit" -> {
                    end = true;
                    recWat = true;
                    return;

                }
                default -> HMI.fehleingabe();
            }

        }
    }

    public boolean isLegit(Richtung richtung, Spielfigur spielfigur) {
        int spalteMax = richtung.getSpalte() + spielfigur.getSpalte();
        int zeileMax = richtung.getZeile() + spielfigur.getZeile();
        return spalteMax >= 0 && spalteMax <= 7 && zeileMax >= 0 && zeileMax <= 7;
    }

    public boolean isEnd() {
        if (!end) {
            for (Spielfigur spielfigur : spielfeld.getF()) {
                end = spielfigur.getPunkte().doubleValue() >= 53;
                if (end) {
                    winner = spielfigur;
                    break;
                }
            }
        }
        return end;
    }

    public void setEnd() throws IOException {
        if (!menu) {
            HMI.print(visualisierung.toString());
            HMI.end(winner);
        }
    }

    private void moveFigure(Spielfigur spielfigur, Richtung richtung) {
        spielfigur.setZeile(spielfigur.getZeile() + richtung.getZeile());
        spielfigur.setSpalte(spielfigur.getSpalte() + richtung.getSpalte());
        spielfigur.setPunkte(spielfeld.getValue(spielfigur.getZeile(), spielfigur.getSpalte()));
        spielfeld.setValue(spielfigur.getZeile(), spielfigur.getSpalte());
        isEnd();
        player = !player;

    }
    public static boolean isOnline(){
        return online;
    }
}
