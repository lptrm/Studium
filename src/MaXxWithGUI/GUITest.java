package MaXxWithGUI;

import second.Konsole;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class GUITest extends JFrame {
    //Matrix Array List als Datenstruktur für die Spielfeldpanele
    private final ArrayList<ArrayList<PlayGroundPanel>> allFieldsRows = new ArrayList<>();
    //Eigene Dateien erstellen
    private final IOPanel ioPanel = new IOPanel();
    private final StatusPanel statusPanel = new StatusPanel();



    private final StartPanel startPanel = new StartPanel();



    Spielfeld spielfeld;
    Container container = getContentPane();
    GUITest(Spielfeld spielfeld){
        this.spielfeld = spielfeld;
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        attachStatus();


        drawField();
        drawFigures();

        attachIOpanel();

        Konsole.run(this, 1000, 1000);

    }
    private void attachIOpanel(){
        for(var jButton : ioPanel.buttons){
            ioPanel.add(jButton);
        }
        container.add(ioPanel);
    }
    private void attachStatus(){
        container.add(statusPanel);
        JLabel test = new JLabel("Progress Bar, ILLE was los, mach mal");
        test.setMaximumSize(new Dimension(1000,100));
        statusPanel.add(test);
    }
    private void drawField(){
        JPanel panel = new JPanel();
        container.add(panel);
        panel.setLayout(new GridLayout(8,8));
        for (Fraction[] fractions : spielfeld.getFeld()){

            ArrayList<PlayGroundPanel> temporaryList = new ArrayList<>();

            allFieldsRows.add(temporaryList);
            for(Fraction fraction : fractions){

                PlayGroundPanel target = new PlayGroundPanel(fraction);

                temporaryList.add(target);
                panel.add(target);
            }
        }
    }
    private void drawFigures(){
        for(var spielfigur : spielfeld.getF()){
            int row = spielfigur.getSpalte();
            int column = spielfigur.getZeile();
            PlayGroundPanel player = allFieldsRows.get(column).get(row);
            player.value = Fraction.NaN;
            player.text = spielfigur.getSign();
            player.occupied = true;
            player.repaint();
        }
    }
    public void update(){
        allFieldsRows.forEach(row -> row.forEach( column -> column.occupied = false));

        repaint();


        drawFigures();
    }
    public IOPanel getIoPanel() {
        return ioPanel;
    }
}
