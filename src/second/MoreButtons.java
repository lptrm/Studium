package second;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.basic.*; // fuer BasicArrowButton
import javax.swing.border.*; // fuer TitledBorder
public class MoreButtons extends JFrame implements ActionListener {
    JButton jb = new JButton("JButton");
    JToggleButton jtb = new JToggleButton("JToggleButton"); // koennen gesetzt oder
    JCheckBox jcb = new JCheckBox("JCheckBox"); // ... frei sein
    JRadioButton jrb = new JRadioButton("JRadioButton"); // ...
    BasicArrowButton // Pfeil-Knöpfe
            up = new BasicArrowButton (BasicArrowButton.NORTH),
            down = new BasicArrowButton (BasicArrowButton.SOUTH),
            right = new BasicArrowButton (BasicArrowButton.EAST),
            left = new BasicArrowButton (BasicArrowButton.WEST);
    JTextField txt = new JTextField (13); // Ausgabefeld
    public MoreButtons () { // Konstruktor
        Container cp = getContentPane(); // Fenster-Container
        cp.setLayout(new FlowLayout()); // FlowLayout
        cp.add(jb); // Knoepfe addieren und
        jb.addActionListener (this); // ... registrieren
        cp.add(jtb); // ...
        jtb.addActionListener (this); // ...
        cp.add(jcb); // ...
        jcb.addActionListener (this); // ...
        cp.add(jrb); // ...
        jrb.addActionListener (this); // ...
        JPanel jp = new JPanel(); // ...
        jp.setBorder(new TitledBorder("Richtungen")); // JPanel mit Rahmen
        jp.add(up); // Richtungsknoepfe addieren
        up.setActionCommand ("Rauf"); // ... und hinzufuegen
        up.addActionListener (this); // ...
        jp.add(down); // ...
        down.setActionCommand ("Runter"); // ...
        down.addActionListener (this); // ...
        jp.add(left); // ...
        left.setActionCommand ("Links"); // ...
        left.addActionListener (this); // ...
        jp.add(right); // ...
        right.setActionCommand ("Rechts"); // ...
        right.addActionListener (this); // ...
        cp.add(jp); // JPanel hinzufuegen
        cp.add(txt); // Ergebnisfeld hinzufuegen
        txt.setEditable (false);
    }
    public void actionPerformed( ActionEvent evt) { // ActionEvents bearbeiten
        AbstractButton ab = (AbstractButton)evt.getSource(); // Knopf bestimmen
        if (ab instanceof JToggleButton || // Nach Knopf-Art unterscheiden
                ab instanceof JCheckBox || // ...
                ab instanceof JRadioButton ) { // ...
            txt.setText (ab.getActionCommand()+" "+ // Kommando und
                    ((ab.isSelected())?" gesetzt":" frei")); // ... Select-Status ausgeben
        } else txt.setText (ab.getActionCommand()); // Kommando ausgeben
    }
    public static void main(String[] args) {
        Konsole.run (new MoreButtons(), 350, 150); // Konsolenstart
    }
}