package MaXxWithGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class Controller implements ActionListener {
    //Objekte, welche bereits vorher initialisiert, werden (Default Objekte)
    private boolean eingabe = false;


    private int playerIndex = 0;

    private static final int END = 53;


    private final Double[] points = new Double[2];
    //Hier ggf. Reihenfolge beachte? TODO: testen
    private final Spielfigur[] spielfigur = new Spielfigur[]{new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
    private final Spielfeld spielfeld = new Spielfeld(spielfigur);
    private final GUITest guiTest;

    /**
     * Konstruktor
     */

    public Controller() {
        guiTest = new GUITest(spielfeld, this);
    }

    /**
     * Schnittstelle für Ausgabe des Punktestandes in der GUI
     *
     * @return : Double-Array, wobei Elem. 0 die Punkte von Weiß und Elem. 1 die Punkte von Schwarz repräsentiert
     */
    public Double[] getPoints() {
        int i = 0;
        for (var v : spielfigur) {
            points[i++] = v.getPunkte().doubleValue();
        }
        return points;
    }

    /**
     * Bei Eingabe einer Zugrichtung wird diese Funktion aufgerufen,
     * wenn keine Fehleingabe vorliegt, wird der Spieler gewechselt und die Zugrichtung interpretiert
     * isLegit() überprüft, ob die Zugrichtung für den Spieler valide ist, befände er sich außerhalb des Spielfeldes,
     * so wird eine Fehleingabe erkannt
     * anschließend wird die Spielfigur mit der Methode moveFigure() bewegt und die Schnittstelle der GUI update()
     * gerufen
     *
     * @param command : Eingabestring, enthalten im Wort "NOSW"
     */
    private void zug(String command) {
        if (eingabe) playerIndex = playerIndex == 0 ? 1 : 0;
        Richtung richtung = switch (command.toUpperCase()) {
            case "N" -> Richtung.Nord;
            case "O" -> Richtung.Ost;
            case "S" -> Richtung.Sued;
            case "W" -> Richtung.West;
            case "NO" -> Richtung.Nordost;
            case "SW" -> Richtung.Suedwest;
            default -> throw new IllegalStateException("Unexpected value: " + command);
        };
        eingabe = isLegit(richtung, spielfigur[playerIndex]);
        if (eingabe) {
            moveFigure(spielfigur[playerIndex], richtung);
            //For Debug
            System.out.println(spielfeld);
            guiTest.update();
        } else {
            System.out.println("Fehleingabe");
        }
    }

    /**
     * TODO: implementer oder streichen
     */
    private void menuCall() {
        System.out.println("Gratulation, Sie sind im Menü");
    }

    /**
     * Validiert den gewünschten Zug des Spielers
     *
     * @param richtung   : wird aus Eingabe ermittelt, gewünschte Zugrichtung des Nutzers
     * @param spielfigur : Spielfigur, welche den Zug ausführen möchte
     * @return : wahr, wenn die neue Position innerhalb der Spielfeldgrenzen ist
     * falsch, wenn die neue Position außerhalb der Spielfeldgrenzen ist
     */
    private boolean isLegit(Richtung richtung, Spielfigur spielfigur) {
        int spalteMax = richtung.getSpalte() + spielfigur.getSpalte();
        int zeileMax = richtung.getZeile() + spielfigur.getZeile();
        return spalteMax >= 0 && spalteMax <= 7 && zeileMax >= 0 && zeileMax <= 7;
    }

    /**
     * Wenn ein Spieler den zum gewinnen des Spiels notwendigen Punktestand der END Konstante erreicht hat, wird das
     * der Gewinner gesetzt.
     */
    private void isEnd() {
        for (Spielfigur spielfigur : spielfeld.getF()) {
            if (spielfigur.getPunkte().doubleValue() >= END) {
                System.out.println(spielfigur);
                System.exit(0);
            }
        }
    }

    /**
     * Bewegt die Spielfigur des Spielers, der das Kommando gegeben hat in die gewünschte richtung und addiert den Wert
     * des Feldes auf den Punktestand der Spielfigur
     * Die Validierung des Zuges findet in der zug() Methode statt
     *
     * @param spielfigur : Spielfigur, die ziehen möchte
     * @param richtung   : Richtung, in die die Spielfigur ziehen möchte
     */
    private void moveFigure(Spielfigur spielfigur, Richtung richtung) {
        spielfigur.setZeile(spielfigur.getZeile() + richtung.getZeile());
        spielfigur.setSpalte(spielfigur.getSpalte() + richtung.getSpalte());
        spielfigur.setPunkte(spielfeld.getValue(spielfigur.getZeile(), spielfigur.getSpalte()));
        spielfeld.setValue(spielfigur.getZeile(), spielfigur.getSpalte());
        isEnd();

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String turn = "NOSW";
        String command = e.getActionCommand();
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
}