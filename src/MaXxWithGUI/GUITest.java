package MaXxWithGUI;

import second.Konsole;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class GUITest extends JFrame {
    ArrayList<ArrayList<PlayGroundPanel>> allFieldsRows = new ArrayList<>();
    //Eigene Dateien erstellen
    IOPanel ioPanel = new IOPanel();
    StatusPanel statusPanel = new StatusPanel();
    StartPanel startPanel = new StartPanel();



    Spielfeld spielfeld;
    Container cp = getContentPane();
    GUITest(Spielfeld spielfeld){
        this.spielfeld = spielfeld;
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        attachStatus();


        drawField();
        drawFigures();

        attachIOpanel();

        Konsole.run(this, 1000, 1000);

    }
    private void attachIOpanel(){
        for(var v : ioPanel.buttons){
            ioPanel.add(v);
        }
        cp.add(ioPanel);
    }
    private void attachStatus(){
        cp.add(statusPanel);
        JLabel test = new JLabel("Progress Bar, ILLE was los, mach mal");
        test.setMaximumSize(new Dimension(1000,100));
        statusPanel.add(test);
    }
    private void drawField(){
        JPanel panel = new JPanel();
        cp.add(panel);
        panel.setLayout(new GridLayout(8,8));
        for (Fraction[] e : spielfeld.getFeld()){

            ArrayList<PlayGroundPanel> list = new ArrayList<>();

            allFieldsRows.add(list);
            for(Fraction f : e){

                PlayGroundPanel targetB = new PlayGroundPanel(f);

                list.add(targetB);
                panel.add(targetB);
            }
        }
    }
    private void drawFigures(){
        int i = 0;
        for(var v : spielfeld.getF()){
            int x = v.getSpalte();
            int y = v.getZeile();
            PlayGroundPanel player = allFieldsRows.get(y).get(x);
            player.value = Fraction.NaN;
            player.text = v.getSign();
            player.occupied = true;
            player.repaint();
        }
    }
    public void update(){
        allFieldsRows.forEach(row -> row.forEach( column -> column.occupied = false));

        repaint();


        drawFigures();
    }
}
