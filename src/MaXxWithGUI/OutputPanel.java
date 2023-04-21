package MaXxWithGUI;

import javax.swing.*;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class OutputPanel extends JPanel {
    private final JButton[] buttons = {new JButton("N"), new JButton("O"), new JButton("S"), new JButton("W"),
            new JButton("NO"), new JButton("SW"), new JButton("Menü"), new JButton("Exit")};

    OutputPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public JButton[] getButtons() {
        return buttons;
    }
}
