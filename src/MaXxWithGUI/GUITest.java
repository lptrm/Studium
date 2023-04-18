package MaXxWithGUI;

import second.Konsole;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUITest extends JFrame {
    ArrayList<JPanel> rowPanels = new ArrayList<>();

    Spielfeld spielfeld;
    Container cp;
    GUITest(Spielfeld spielfeld){
        this.spielfeld = spielfeld;
        cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        drawField();
        drawFigures();


    }
    private void drawField(){
        for (Fraction[] e : spielfeld.getFeld()){
            JPanel panel = new JPanel();
            cp.add(panel);
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

            rowPanels.add(panel);
            for(Fraction f : e){
                JTextField target = new JTextField("" + f);
                target.setPreferredSize(new Dimension(50, 50));

                panel.add(target);
            }
        }
    }
    private void drawFigures(){
        for(var v : spielfeld.getF()){
            int x = v.getSpalte();
            int y = v.getZeile();
            JTextField player = (JTextField) rowPanels.get(y).getComponent(x);
            player.setText(v.getSign());
        }
    }

    public static void main(String[] args) {
        Spielfigur[] figurs = {new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
        Spielfeld spielfeld = new Spielfeld(figurs);
        GUITest guiTest = new GUITest(spielfeld);
        Konsole.run(guiTest, 1000, 1000);
    }
}
