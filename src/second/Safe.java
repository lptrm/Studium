package second;
/**
 * @version 42, 31.03.2023
 * @author Jan Obernberger
 **/

//Deterministischer Endlicher Automtat / Zustandstransitionsmaschine

import java.awt.event.*;
import java.awt.*;

public class Safe extends Frame implements ActionListener {
    Button[] buttons = {new Button("0"), new Button("1"), new Button("2"), new Button("3"),
            new Button("4"), new Button("5"), new Button("6"), new Button("7"),
            new Button("8"), new Button("9"),};
    static int s = 0;

    Safe() {
        setLayout(new FlowLayout());
        for (Button b : buttons) {
            b.addActionListener(this);
            this.add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 3-1-0-3-2-0-2-3 ist richtige Kombination
        // 0 1 2 3 4 5 6 7 8 Zustände ...
        switch (Integer.parseInt(e.getActionCommand())) {
            case 0 -> s = (s == 2 || s == 5) ? s + 1 : 0;
            case 1 -> s = (s == 1 || s == 3) ? s + 1 : 0;
            case 2 -> s = (s == 4 || s == 6) ? s + 1 : 0;
            case 3 -> s = (s == 3 || s == 7) ? s + 1 : 1;
            default -> s = 0;
        }
        if (s == 0) { // Keine Taste
            setBackground(Color.red);
        } else { // richtiger Weg
            setBackground(Color.green);
        }
        if (s == 8) { // Kombination geraten
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Safe safe = new Safe();
        safe.addWindowListener(new WindowQuitter());
        safe.setSize(400, 500);
        safe.setVisible(true);
    }
}
