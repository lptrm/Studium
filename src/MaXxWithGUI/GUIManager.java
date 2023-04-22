package MaXxWithGUI;

import second.Konsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class GUIManager extends JFrame {
    //Matrix Array List als Datenstruktur für die Spielfeldpanele
    private final ArrayList<ArrayList<PlayGroundPanel>> allFieldsRows = new ArrayList<>();
    //Eigene Dateien erstellen
    private final OutputPanel outputPanel = new OutputPanel();
    private final StatusPanel statusPanel = new StatusPanel();



    private final StartPanel startPanel = new StartPanel();



    private final Spielfeld spielfeld;
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
     * @param spielfeld : Schnittstelle zum MaXx Backend - Referenz auf Anzuzeigendes Spiel(-feld)
     */
    GUIManager(Spielfeld spielfeld, Controller controller){
        this.spielfeld = spielfeld;
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        attachStatus();


        attachField();
        drawFigures();

        attachIOpanel();
        attachListeners(controller);

        Konsole.run(this, 1000, 1000);

    }
    private void attachListeners(ActionListener actionListener){
        for (var v : outputPanel.getButtons()){
            v.addActionListener(actionListener);
        }
    }
    /**
     * TODO: add Description
     */
    private void attachIOpanel(){
        for(var jButton : outputPanel.getButtons()){
            outputPanel.add(jButton);
        }
        container.add(outputPanel);
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
        for (Fraction[] fractions : spielfeld.getFields()){

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
        for(var spielfigur : spielfeld.getFigures()){
            int row = spielfigur.getColumn();
            int column = spielfigur.getRow();
            PlayGroundPanel player = allFieldsRows.get(column).get(row);
            player.value = Fraction.NaN;
            player.text = spielfigur.getSign();
            player.occupied = true;
            player.repaint();
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
        allFieldsRows.forEach(row -> row.forEach( column -> column.occupied = false));


        drawFigures();

        drawAccessOptions(playerIndex);

        repaint();
    }
    public OutputPanel getOutputPanel() {
        return outputPanel;
    }
}
