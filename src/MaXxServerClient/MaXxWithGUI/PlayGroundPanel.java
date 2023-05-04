package MaXxServerClient.MaXxWithGUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class PlayGroundPanel extends JPanel implements IDesignConstants {
    private String text = "";
    private boolean occupied = false;
    private boolean neighbor = false;

    private Fraction fraction;
    PlayGroundPanel(Fraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //neu rendern
        g.setColor(BACKGROUND_COLOR);
        if(neighbor) g.setColor(Color.green);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(GUIManager.HIGHLIGHT_COLOR);
        g.setFont(PLAYGROUND_FONT);
        if (occupied) {
            drawPlayersValue(g);

        } else if (fraction.equals(Fraction.NaN)) {
            
            g.setColor(BACKGROUND_COLOR);
            g.drawRect(0,0,getWidth(),getHeight());
            g.setColor(HIGHLIGHT_COLOR);

        } else {
            drawFractionValue(g);
        }
        g.drawRect(0, 0, getWidth(), getHeight());


    }

    private void drawPlayersValue(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x, y;
        String toBeDrawn;
        toBeDrawn = this.text;
        x = (getWidth() - fm.stringWidth(toBeDrawn)) / 2;
        y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(toBeDrawn, x, y);
    }

    private void drawFractionValue(Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x, y;
        String toBeDrawn;
        toBeDrawn = this.fraction.numerator.toString();
        x = (getWidth() - fm.stringWidth(toBeDrawn)) / 2;
        y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent() - getHeight() / 4;
        g.drawString(toBeDrawn, x, y);
        toBeDrawn = "\u2500\u2500\u2500";
        x = (getWidth() - fm.stringWidth(toBeDrawn)) / 2;
        y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(toBeDrawn, x, y);
        toBeDrawn = this.fraction.denominator.toString();
        x = (getWidth() - fm.stringWidth(toBeDrawn)) / 2;
        y = (getHeight() - fm.getHeight() / 2) + fm.getAscent() - getHeight() / 4;
        g.drawString(toBeDrawn, x, y);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isNeighbor() {
        return neighbor;
    }

    public void setNeighbor(boolean neighbor) {
        this.neighbor = neighbor;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }
}