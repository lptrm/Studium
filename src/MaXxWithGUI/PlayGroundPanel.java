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
        //neu rendern
        g.clearRect(0, 0, getWidth(), getHeight());

        g.setFont(new Font("SansSerif", Font.BOLD, 28));
        if (occupied) {
            g.drawString(text, getWidth()/2, getHeight()/2);
        } else if (value.equals(Fraction.NaN)) {
            g.clearRect(0, 0, getWidth(), getHeight());
        } else {
            //g.drawString(value.numerator.toString(), getWidth()/2, getHeight()/3);
            g.drawChars(value.numerator.toString().toCharArray(), 0, value.numerator.toString().toCharArray().length, getWidth()/3, getHeight()/3);
            g.drawLine((getWidth() / 4), getHeight()/2, (getWidth() / 4)*3, getHeight()/2);
            g.drawChars(value.denominator.toString().toCharArray(), 0, value.denominator.toString().toCharArray().length, getWidth()/3, 2*getHeight()/3);
            g.setColor(Color.black);
        }
        g.drawRect(0,0,getWidth(),getHeight());


    }

    PlayGroundPanel(Fraction fraction) {
        value = fraction;
    }
}