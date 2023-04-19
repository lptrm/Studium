package MaXxWithGUI;

import second.Konsole;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class GUITest extends JFrame {
    ArrayList<JPanel> rowPanels = new ArrayList<>();
    ArrayList<MaXxTupel> allFields = new ArrayList<>();
    JPanel panelIO = new JPanel();
    JButton[] buttons = {new JButton("N"), new JButton("O"), new JButton("S"), new JButton("W"),
    new JButton("NO"), new JButton("SW"), new JButton("Menü"), new JButton("Exit")};


    Spielfeld spielfeld;
    Container cp = getContentPane();
    int[] figureBuffer = new int[4];
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
                allFields.add(targetB);
                panel.add(targetB);
            }
        }
    }
    private void drawFigures(){
        int i = 0;
        for(var v : spielfeld.getF()){
            int x = v.getSpalte();
            int y = v.getZeile();
            MaXxTupel player = (MaXxTupel) rowPanels.get(y).getComponent(x);
            player.value = Fraction.NaN;
            player.text = v.getSign();
            player.occupied = true;
            player.repaint();
            figureBuffer[i++] = x;
            figureBuffer[i++] = y;
        }
    }
    public void update(){
        allFields.forEach(e -> e.occupied=false);

        repaint();


        drawFigures();
    }
    class MaXxTupel extends JPanel{
        public String text = "";
        public boolean occupied = false;
        private Fraction value;

            @Override
            public void paintComponent(Graphics g) {
                this.setBackground(Color.white);
                super.paintComponent(g);

                if(occupied){
                    g.drawString(text, 50, 40);
                } else if (value.equals(Fraction.NaN)) {
                    g.clearRect(0,0,getWidth(),getHeight());
                    System.out.println(value.numerator);
                } else {
                    g.drawString(value.numerator.toString(), 50, 30);
                    g.drawString("\u2500\u2500\u2500", 50, 40);
                    g.drawString(value.denominator.toString(), 50, 50);
                    g.setColor(Color.black);
                }



            }
        MaXxTupel(Fraction fraction){
            value = fraction;
        }
    }
}
