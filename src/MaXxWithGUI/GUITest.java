package MaXxWithGUI;

import second.Konsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUITest extends JFrame {
    ArrayList<JPanel> rowPanels = new ArrayList<>();
    JPanel panelIO = new JPanel();
    JButton[] buttons = {new JButton("N"), new JButton("O"), new JButton("S"), new JButton("W"),
    new JButton("NO"), new JButton("SW"), new JButton("Menü"), new JButton("Exit")};


    Spielfeld spielfeld;
    Container cp = getContentPane();
    GUITest(Spielfeld spielfeld){
        this.spielfeld = spielfeld;
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));



        drawField();
        drawFigures();

        buildIOpanel();

        Konsole.run(this, 1000, 1000);

    }
    private void buildIOpanel(){
        panelIO.setLayout(new BoxLayout(panelIO, BoxLayout.X_AXIS));
        for(var v : buttons){
            panelIO.add(v);
        }
        cp.add(panelIO);
    }
    private void drawField(){
        for (Fraction[] e : spielfeld.getFeld()){
            JPanel panel = new JPanel();
            cp.add(panel);
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

            rowPanels.add(panel);
            for(Fraction f : e){
                MaXxTupel targetB = new MaXxTupel(f);
                JTextField target = new JTextField("" + f);
                target.setPreferredSize(new Dimension(50, 50));

                panel.add(targetB);
            }
        }
    }
    private void drawFigures(){
        for(var v : spielfeld.getF()){
            int x = v.getSpalte();
            int y = v.getZeile();
            MaXxTupel player = (MaXxTupel) rowPanels.get(y).getComponent(x);
            player.text = v.getSign();
            player.repaint();
        }
    }
    public void update(){
        //drawField();
        drawFigures();
    }
    class MaXxTupel extends JPanel{
        public String text = "";
        private Fraction value;

            @Override
            public void paintComponent(Graphics g) {
                this.setBackground(Color.white);
                super.paintComponent(g);
                if(text.equals("")){
                    g.drawString(value.numerator.toString(), 50, 30);
                    g.drawString("\u2500\u2500\u2500", 50, 40);
                    g.drawString(value.denominator.toString(), 50, 50);
                    g.setColor(Color.black);
                } else {
                    g.drawString(text, 50, 40);
                }



            }
        MaXxTupel(Fraction fraction){
            value = fraction;
        }
    }
    public static void main(String[] args) {
        Spielfigur[] figurs = {new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
        Spielfeld spielfeld = new Spielfeld(figurs);
        GUITest guiTest = new GUITest(spielfeld);

    }
}
