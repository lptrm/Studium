package MaXxWithGUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class PlayGroundPanel extends JPanel {
    public String text = "";
    public boolean occupied = false;
    public Fraction value;

    @Override
    public void paintComponent(Graphics g) {
        this.setBackground(Color.white);
        super.paintComponent(g);
        //g.setFont(new Font(..));
        if (occupied) {
            g.drawString(text, 50, 40);
        } else if (value.equals(Fraction.NaN)) {
            g.clearRect(0, 0, getWidth(), getHeight());
        } else {

            g.drawString(value.numerator.toString(), 50, 30);
            g.drawString("\u2500\u2500\u2500", 50, 40);
            g.drawString(value.denominator.toString(), 50, 50);
            g.setColor(Color.black);
        }


    }

    PlayGroundPanel(Fraction fraction) {
        value = fraction;
    }
}