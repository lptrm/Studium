package MaXxWithGUI;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class Controller {
    /**
     * Steuerflags
     */
    private boolean menu, end, eingabe, player, recWat;

    private GUITest guiTest;

    private int playerIndex;
    private final Spielfeld spielfeld;
    private Spielfigur winner;
    private final Spielfigur[] spielfigur;

    private final Double[] points = new Double[2];

    public Controller(Spielfeld spielfeld) {
        this.menu = false;
        this.end = false;
        this.eingabe = true;
        this.player = true;
        this.recWat = true;
        this.playerIndex = 0;
        this.spielfeld = spielfeld;
        this.winner = null;
        this.spielfigur = spielfeld.getF();
        guiTest = new GUITest(spielfeld);
        for (var v : guiTest.panelIO.buttons) {
            v.addActionListener(e -> {
                action(e.getActionCommand());
                System.out.println(e.getActionCommand());
            });
        }
    }

    private void action(String command) {
        String turn = "NOSW";
        if (turn.contains(command)) {
            zug(command);
        }
        if (command.equals("Menü")) {
            menuCall();
        }
        if (command.equals("Exit")) {
            System.exit(0);
        }

    }

    //Schnittstelle für ILLE
    private Double[] getPoints() {
        int i = 0;
        for (var v : spielfigur) {
            points[i++] = v.getPunkte().doubleValue();
        }
        return points;
    }

    /**
     * Methode, welche die zwei Spielfiguren abwechselnd mit dem Spielfeld interagierend lässt (siehe Aufga-
     * benstellung von Herrn Heinz im Wintersemester 2022 Einleitung 9 Spiel "MaXx". Als void, da Informationen zum
     * aktuellen Spielverlauf in der Instanz des Spielfeldes bzw. der Spielfiguren (durch Referenzen aneinander gebunden)
     */

    public void zug(String command) {
        playerIndex = player ? 0 : 1;
        String s2 = command;
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
                System.out.println(spielfeld);
                guiTest.update();
            }

        }
        if (!eingabe) {
            System.out.println("Fehleingabe");
        }
    }

    private void menuCall() {
        System.out.println("Gratulation, Sie sind im Menü");
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

    private void moveFigure(Spielfigur spielfigur, Richtung richtung) {
        spielfigur.setZeile(spielfigur.getZeile() + richtung.getZeile());
        spielfigur.setSpalte(spielfigur.getSpalte() + richtung.getSpalte());
        spielfigur.setPunkte(spielfeld.getValue(spielfigur.getZeile(), spielfigur.getSpalte()));
        spielfeld.setValue(spielfigur.getZeile(), spielfigur.getSpalte());
        isEnd();
        player = !player;

    }
}