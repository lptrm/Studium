package second;

import java.awt.*;
import java.awt.event.*;

public class Safe00 extends Frame implements ActionListener {
    Button[] buttons; // Array fuer Knöpfe
    Safe00() { // Konstruktor
        setSize( 250, 300 ); // Fenstergroesse
        setLocation(300, 300);
        setTitle ("Safe00"); // Titel setzen
        buttons = new Button [10]; // Array anlegen und dimensionieren
        for (int i=0; i < 10; i++){ // 10 Knöpfe im Array
            buttons[i] = new Button (""+i); // erzeugen
            buttons[i].setFont(new Font("Courier", Font.BOLD, 34));
            buttons[i].addActionListener( this ); // ... und registrieren
        }
        Panel panel0 = new Panel (); // Panel fuer 0-Knopf
        panel0.setLayout( new GridLayout(1,1) ); // ... mit 1x1 Gitter
        panel0.add (buttons[0]); // ... Knopf einfuegen
        Panel panelRest = new Panel (); // Panel fuer restliche Knoepfe
        panelRest.setLayout( new GridLayout(3,3) ); // ... mit 3x3 Gitter
        setLayout( new GridLayout(2,1) ); // 2x1 Layout fuer Fenster
        for (int i=1; i < 10; i++){ // 9 Knoepfe
            panelRest.add (buttons[i]); // ... in restliches Panel einfuegen
        }
        add (panel0); // Panel mit 0-Knopf
        add (panelRest); // Panel mit restlichen Knöpfen
        addWindowListener( new WindowQuitter() );
        setVisible( true );
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
        for (Button b : buttons) b.setBackground(col);
    }

    public static void main(String[] args) {
        Safe00 safe00 = new Safe00();
    }
}
