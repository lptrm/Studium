package MaXxWithGUI;

import javax.swing.*;

public class Feld extends JLabel {
    private int xPos, yPos;
    private Fraction points;
    private boolean occupied;
    Feld(int xPos, int yPos, Fraction points){
        super();
        this.xPos = xPos;
        this.yPos = yPos;
        this.points = points;
        this.occupied = false;
    }


    /**
     * Defines the single line of text this component will display.  If
     * the value of text is null or empty string, nothing is displayed.
     * <p>
     * The default value of this property is null.
     * <p>
     * This is a JavaBeans bound property.
     *
     * @param text the single line of text this component will display
     * @see #setVerticalTextPosition
     * @see #setHorizontalTextPosition
     * @see #setIcon
     */
    @Override
    public void setText(String text) {
        super.setText(text);
    }

}