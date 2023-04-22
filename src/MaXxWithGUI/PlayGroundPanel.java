package MaXxWithGUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class PlayGroundPanel extends JPanel implements IDesignConstants {
    public String text = "";
    public boolean occupied = false;
    public Fraction value;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //neu rendern
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(GUIManager.HIGHLIGHT_COLOR);
        g.setFont(PLAYGROUND_FONT);
        FontMetrics fm = g.getFontMetrics();
        int x, y;
        String text;
        if (occupied) {

            text = this.text;
            x = (getWidth() - fm.stringWidth(text)) / 2;
            y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g.drawString(text, x, y);

        } else if (value.equals(Fraction.NaN)) {
            g.setColor(BACKGROUND_COLOR);
            g.drawRect(0,0,getWidth(),getHeight());
            g.setColor(HIGHLIGHT_COLOR);

        } else {
            text = this.value.numerator.toString();
            x = (getWidth() - fm.stringWidth(text)) / 2;
            y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent() - getHeight() / 4;
            g.drawString(text, x, y);
            text = "\u2500\u2500\u2500";
            x = (getWidth() - fm.stringWidth(text)) / 2;
            y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g.drawString(text, x, y);
            text = this.value.denominator.toString();
            x = (getWidth() - fm.stringWidth(text)) / 2;
            y = (getHeight() - fm.getHeight() / 2) + fm.getAscent() - getHeight() / 4;
            g.drawString(text, x, y);
        }
        g.drawRect(0, 0, getWidth(), getHeight());


    }

    PlayGroundPanel(Fraction fraction) {
        value = fraction;
    }
}