package MaXxWithGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class GUIManager extends JFrame implements IDesignConstants {

    //Matrix Array List als Datenstruktur für die Spielfeldpanele
    private final ArrayList<ArrayList<PlayGroundPanel>> allFieldsRows = new ArrayList<>();
    //Eigene Dateien erstellen
    private final InputPanel inputPanel = new InputPanel();
    private final StatusPanel statusPanel = new StatusPanel();



    private final StartPanel startPanel = new StartPanel();



    private final PlayGround playGround;
    private final Container container = getContentPane();

    /**
     * Standardkonstruktor
     * Instanzvariable spielfeld wir mit anzuzeigendem Spielfeld initialisiert
     * BoxLayout wird als Layoutmanager gesetzt
     * die Statusleiste wird als erstes Element hinzugefügt
     * die Felder werden hinzugefügt,
     * das Eingabe panel wird hinzugefügt
     * über die run() Methode des Hilfsprogramms Konsole wird der JFrame gestartet, als Parameter wir die gewünschte
     * Startauflösung mitgegeben
     * @param playGround : Schnittstelle zum MaXx Backend - Referenz auf Anzuzeigendes Spiel(-feld)
     */
    GUIManager(PlayGround playGround, Controller controller){
        this.playGround = playGround;
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        attachStatus();


        attachField();
        drawFigures();

        //drawPossiblities();

        attachIOpanel();
        attachListeners(controller);

        display();



        //setSize(Toolkit.getDefaultToolkit().getScreenSize());

    }
    private void display(){
        setBackground(BACKGROUND_COLOR);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MaXx 4.20");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setVisible(true);
        //setUndecorated(true);         Vollbild, ggf. am Ende nutzen
    };
    private void attachListeners(ActionListener actionListener){
        for (var v : inputPanel.getButtons()){
            v.addActionListener(actionListener);
        }
    }
    /**
     * TODO: add Description
     */
    private void attachIOpanel(){
        for(var jButton : inputPanel.getButtons()){
            inputPanel.add(jButton);
        }
        container.add(inputPanel);
    }
    /**
     * TODO: add Description
     */
    private void attachStatus(){
        container.add(statusPanel);
        JLabel test = new JLabel("Progress Bar, ILLE was los, mach mal");
        test.setMaximumSize(new Dimension(1000,100));
        statusPanel.add(test);
    }
    /**
     * TODO: add Description
     */
    private void attachField(){
        JPanel panel = new JPanel();
        container.add(panel);
        panel.setLayout(new GridLayout(8,8));
        for (Fraction[] fractions : playGround.getFields()){

            ArrayList<PlayGroundPanel> temporaryList = new ArrayList<>();

            allFieldsRows.add(temporaryList);
            for(Fraction fraction : fractions){

                PlayGroundPanel target = new PlayGroundPanel(fraction);

                temporaryList.add(target);
                panel.add(target);
            }
        }
    }
    /**
     * TODO: add Description
     */
    private void drawFigures(){
        for(var spielfigur : playGround.getFigures()){
            int column = spielfigur.getColumn();
            int row = spielfigur.getRow();
            PlayGroundPanel player = allFieldsRows.get(row).get(column);
            player.setValue(Fraction.NaN);
            player.setText(spielfigur.toString());
            player.setOccupied(true);
            player.repaint();
        }
    }
    private void drawPossiblities(){
        for(var figure : playGround.getFigures()){
            int column = figure.getColumn();
            int row = figure.getRow();
            for ( var direction : figure.getCharacters().directions){
                column += direction.getColumn();
                row += direction.getRow();
                PlayGroundPanel neighbor = allFieldsRows.get(row).get(column);
                neighbor.setPossibleMove(true);
                column = figure.getColumn();
                row = figure.getRow();
            }
        }
    }
    /**
     * TODO: add Description
     */
    private void drawAccessOptions(int playerIndex){

    }
    /**
     * playerIndex = Schnittstelle für Anezeige der Zugmöglichkeiten
     * TODO: add Description
     */
    public void update(int playerIndex){
        allFieldsRows.forEach(row -> row.forEach( column -> column.setOccupied(false)));


        drawFigures();

        drawAccessOptions(playerIndex);

        repaint();
    }
    public InputPanel getOutputPanel() {
        return inputPanel;
    }
}
