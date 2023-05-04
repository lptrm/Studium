package second;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menus extends JFrame {
    String[] flavors = { "Chocolate", "Strawberry", // Array mit Geschmacks-Namen:
            "Vanilla Fudge Swirl", "Mint Chip", // ... flavors
            "Mocha Almond Fudge", "Rum Raisin", // ...
            "Praline Cream", "Mud Pie" }; // ...
    JTextField t = new JTextField ("No flavor", 30); // Textfeld mit Anfangswert
    JMenuBar mb1 = new JMenuBar(); // Menue-Leiste 1
    JMenu // Verschiedene Menues
            f = new JMenu ("File"), // ...
            m = new JMenu ("Flavors"), // ...
            s = new JMenu ("Safety"); // ... Untermenue
    JCheckBoxMenuItem[] safety = { // Array mit ankreuzbaren
            new JCheckBoxMenuItem ("Guard"), // Menue-Eintraegen
            new JCheckBoxMenuItem ("Hide") // safety
    };
    JMenuItem[] file = {
            new JMenuItem ("Open"), // normaler Menue-Eintrag
    };
    JMenuBar mb2 = new JMenuBar(); // Menue-Leiste 2 (wechselbar)
    JMenu fooBar = new JMenu ("fooBar");
    JMenuItem[] other = { // restliche Menue-Eintraege
            new JMenuItem("Foo", KeyEvent.VK_F), // Kuerzel nur bei JMenuItems
            new JMenuItem("Bar", KeyEvent.VK_A), // ... mit KeyEvent-Konstanten
            new JMenuItem("Baz"), // hier kein Kuerzel
    };
    JButton b = new JButton("Swap Menus"); // Knopf zum Umschalten
    class BL implements ActionListener { // AL zum Umschalt-Knopf
        public void actionPerformed(ActionEvent e) {
            JMenuBar m = getJMenuBar(); // m ist aktuelle Menue-Leiste
            setJMenuBar (m == mb1 ? mb2 : mb1); // vertauschen
            validate(); // Fenster neu Layouten
        }
    }
    class FL implements ActionListener { // AL fuer Flavors
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem)e.getSource();
            t.setText (target.getText()); // Ausgabe nach t
        }
    }
    class FooL implements ActionListener { // AL fuer Foo M.-Eintrag
        public void actionPerformed(ActionEvent e) {
            t.setText ("Foo selected"); // Ausgabe nach t
        }
    }
    class BarL implements ActionListener { // AL fuer Bar M.-Eintrag
        public void actionPerformed(ActionEvent e) {
            t.setText ("Bar selected"); // Ausgabe nach t
        }
    }
    class BazL implements ActionListener { // AL fuer Baz M.-Eintrag
        public void actionPerformed(ActionEvent e) {
            t.setText ("Baz selected"); // Ausgabe nach t
        }
    }
    class CMIL implements ItemListener { // IL fuer Guard und Hide
        public void itemStateChanged(ItemEvent e) {
            JCheckBoxMenuItem target =
                    (JCheckBoxMenuItem)e.getSource(); // Quelle des Events
            String actionCommand =
                    target.getActionCommand(); // Command
            if (actionCommand.equals("Guard"))
                t.setText ("Guarding is " + target.getState()); // Ausgabe mit Status
            else if (actionCommand.equals("Hide"))
                t.setText ("Hiding is " + target.getState()); // Ausgabe mit Status
        }
    }
    public Menus() {
        CMIL cmil = new CMIL(); // neuer Listener
        safety[0].setActionCommand("Guard"); // Command in JCheckBoxMenuItem und
        safety[0].setMnemonic (KeyEvent.VK_G); // ... Key-Kuerzel
        safety[0].addItemListener (cmil); // ... Listener setzen
        safety[1].setActionCommand ("Hide"); // ...
        safety[1].setMnemonic (KeyEvent.VK_H); // ...
        safety[1].addItemListener (cmil); // ...
        other[0].addActionListener (new FooL()); // spezielle AL registrieren
        other[1].addActionListener (new BarL()); // ..
        other[2].addActionListener (new BazL()); // ..
        FL fl = new FL(); // Flavor-Listener
        for (int i = 0; i < flavors.length; i++) { // fuer jeden Flavor:
            JMenuItem mi = new JMenuItem (flavors[i]); // neues Menue-Item generieren
            mi.addActionListener(fl); // AL registrieren
            m.add(mi); // zum Flavors-Menue hinzufuegen
            if ((i+1) % 3 == 0) m.addSeparator(); // nach jedem 3. Item Separator
        }
        for (int i = 0; i < safety.length; i++) // fuer alle Eintraege in safety:
            s.add (safety[i]); // zum Menue Safety
        s.setMnemonic (KeyEvent.VK_A); // safety Key-Kuerzel
        f.add (s); // safety zu File-Menue hinzufuegen
        f.setMnemonic (KeyEvent.VK_F); // file Key-Kuerzel
        for (int i = 0; i < file.length; i++) {
            file[i].addActionListener(fl);
            f.add (file[i]);
        }
        mb1.add (f); // File zu Menue-Leiste 1
        mb1.add (m); // Flavors zu Menue-Leiste 1
        setJMenuBar (mb1); // aktiv: Menue-Leiste 1
        t.setEditable (false); // t nicht editierbar
        Container cp = getContentPane(); // Fenster-Container
        cp.add (t, BorderLayout.CENTER); // Textfeld ins Zentrum
        b.addActionListener (new BL()); // BL bei Swapbutton registrieren
        b.setMnemonic (KeyEvent.VK_S); // Key-Kuerzel setzen
        cp.add (b, BorderLayout.NORTH); // Button nach oben
        for (int i = 0; i < other.length; i++) // fuer alle anderen Menue-Eintraege:
            fooBar.add (other[i]); // in FooBar einfuegen
        fooBar.setMnemonic (KeyEvent.VK_B); // Key-Kuerzel setzen
        mb2.add (fooBar); // Foo zu Menue-Leiste 2
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocation(250, 340);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Menus();
    }
}
