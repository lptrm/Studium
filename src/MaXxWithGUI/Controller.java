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
    private final GameCharacter[] gameCharacter = new GameCharacter[]{new GameCharacter(Characters.WHITE), new GameCharacter(Characters.BLACK)};
    private final PlayGround playGround = new PlayGround(gameCharacter);
    private final GUIManager guiManager;

    /**
     * Konstruktor
     */

    public Controller() {
        guiManager = new GUIManager(playGround, this);
    }

    /**
     * Schnittstelle für Ausgabe des Punktestandes in der GUI
     *
     * @return : Double-Array, wobei Elem. 0 die Punkte von Weiß und Elem. 1 die Punkte von Schwarz repräsentiert
     */
    public Double[] getPoints() {
        int i = 0;
        for (var v : gameCharacter) {
            points[i++] = v.getPoints().doubleValue();
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
        if (eingabe) playerIndex = playerIndex == 0 ? 1 : 0;    //In Funktion auslagern, die am Ende des Zuges gerufen wird
        Direction direction = switch (command.toUpperCase()) {
            case "N" -> Direction.NORTH;
            case "O" -> Direction.EAST;
            case "S" -> Direction.SOUTH;
            case "W" -> Direction.WEST;
            case "NO" -> Direction.NORTH_EAST;
            case "SW" -> Direction.SOUTH_WEST;
            default -> throw new IllegalStateException("Unexpected value: " + command);
        };
        eingabe = isLegit(direction, gameCharacter[playerIndex]);
        if (eingabe) {
            moveFigure(gameCharacter[playerIndex], direction);
            //For Debug
            System.out.println(playGround);
            guiManager.update(playerIndex);
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
     * @param direction   : wird aus Eingabe ermittelt, gewünschte Zugrichtung des Nutzers
     * @param gameCharacter : Spielfigur, welche den Zug ausführen möchte
     * @return : wahr, wenn die neue Position innerhalb der Spielfeldgrenzen ist
     * falsch, wenn die neue Position außerhalb der Spielfeldgrenzen ist
     */
    private boolean isLegit(Direction direction, GameCharacter gameCharacter) {
        int columnBound = direction.getColumn() + gameCharacter.getColumn();
        int rowBound = direction.getRow() + gameCharacter.getRow();
        return columnBound >= 0 && columnBound <= 7 && rowBound >= 0 && rowBound <= 7;
    }

    /**
     * Wenn ein Spieler den zum gewinnen des Spiels notwendigen Punktestand der END Konstante erreicht hat, wird das
     * der Gewinner gesetzt.
     */
    private void isEnd() {
        for (GameCharacter gameCharacter : playGround.getFigures()) {
            if (gameCharacter.getPoints().doubleValue() >= END) {
                System.out.println(gameCharacter);
                System.exit(0);
            }
        }
    }

    /**
     * Bewegt die Spielfigur des Spielers, der das Kommando gegeben hat in die gewünschte richtung und addiert den Wert
     * des Feldes auf den Punktestand der Spielfigur
     * Die Validierung des Zuges findet in der zug() Methode statt
     *
     * @param gameCharacter : Spielfigur, die ziehen möchte
     * @param direction   : Richtung, in die die Spielfigur ziehen möchte
     */
    private void moveFigure(GameCharacter gameCharacter, Direction direction) {
        gameCharacter.setRow(gameCharacter.getRow() + direction.getRow());
        gameCharacter.setColumn(gameCharacter.getColumn() + direction.getColumn());
        gameCharacter.setPoints(playGround.getFields(gameCharacter.getRow(), gameCharacter.getColumn()));
        playGround.setValue(gameCharacter.getRow(), gameCharacter.getColumn());
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