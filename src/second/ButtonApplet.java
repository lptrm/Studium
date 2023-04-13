package second;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ButtonApplet extends JFrame { // JFrame ableiten
    JButton // Knöpfe definieren
            b1 = new JButton("Button 1"), // ...
            b2 = new JButton("Button 2"); // ...
    JTextField txt = new JTextField(10); // Textfeld ...
    class BL implements ActionListener { // ActionListener als
        public void actionPerformed(ActionEvent e){ // innere Klasse def.
            String name = //
                    ((JButton)e.getSource()).getText(); // aus Event Source und
            txt.setText(name); // dann Text extrahieren
        }
    } // end class BL
    /*
        Als anonyme Klasse

        ActionListener al = new ActionListener() { // ActionListener
            public void actionPerformed(ActionEvent e){ // durch anonyme
                String name = ((JButton)e.getSource()).getText(); // Klasse def.
                txt.setText(name); // ...
            } // ...
        };

        Als Lamda-Ausdruck

         ActionListener al = e-> txt.setText(((JButton)e.getSource()).getText()); //Durch das Interface hat ActionListener in jedem Fall ein ActionEvent, welches nicht explizit als solches benannt werden muss

     */
    BL al = new BL(); // einen Listener erzeugen
    public ButtonApplet () { // Konstruktor ...
        b1.addActionListener(al); // Listener registrieren
        b2.addActionListener(al); // ...
        Container cp = getContentPane(); // Container fuer Fenster
        cp.setLayout(new FlowLayout()); // Layout
        cp.add(b1); // Komponenten hinzufuegen
        cp.add(b2); // ...
        cp.add(txt); // ...
    }
    public static void main(String[] args) { // zum Starten von Konsole
        Konsole.run (new ButtonApplet(), 300, 150);
    }
}
