package second;

import java.awt.*;
import java.awt.event.*;
public class Safe25 extends Frame implements ActionListener {
    Safe25() { // Konstruktor
        setTitle("Safe25 "); // ...
        setLayout(new GridLayout(2, 5)); // Layout Manager
        for (int i = 0; i < 10; i++) { // 10 Knöpfe registrieren
            Button b = new Button("" + i); // und einfügen
            b.setFont(new Font("Courier", Font.BOLD, 34));
            b.addActionListener(this);
            add(b);
        }
        setSize(300, 200);
        setLocation(300, 300);
        setVisible(true);
    }

    int s = 0; // Status, zählt korrekte Zeichen

    public void actionPerformed(ActionEvent evt) {
// 3-1-0-3-2-0-2-3 ist richtige Kombination
// 0 1 2 3 4 5 6 7 8 Zustände ...
        switch (Integer.parseInt(evt.getActionCommand())) {
            case 0 -> s = (s == 2 || s == 5) ? s + 1 : 0;
            case 1 -> s = (s == 1) ? s + 1 : 0;
            case 2 -> s = (s == 4 || s == 6) ? s + 1 : 0;
            case 3 -> s = (s == 3 || s == 7) ? s + 1 : 1;
            default -> s = 0;
        }
        Color col;
        if (s == 0) { // Keine Taste
            col = Color.red;
        } else { // richtiger Weg
            col = Color.green;
        }
        if (s == 8) { // Kombination geraten
            System.exit(0);
        }
        for (Component c : getComponents()) c.setBackground(col);
        repaint();
    }

    public static void main(String[] args) {
        Safe25 safe25 = new Safe25();
    }
}
