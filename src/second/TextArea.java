package second;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TextArea extends JFrame { // JFrame ableiten
    JButton // Drei Knoepfe
            a = new JButton ("Daten setzen"),
            b = new JButton ("Daten hinzufügen"),
            c = new JButton ("Alles löschen");
    JTextArea t = new JTextArea("Der Anfang\n", 15, 20); // Starttext, # Zeilen, Spalten
    int j=0;
    public TextArea() { // Konstruktor
        a.addActionListener(new ActionListener() { // Listener Knopf a
            public void actionPerformed(ActionEvent e){ // durch anonyme Klasse
                t.setText("Das ist der Anfang:\n");
            }
        });
        b.addActionListener(new ActionListener() { // Listener Knopf b
            public void actionPerformed(ActionEvent e){
                for(int i=0;i<10;i++){
                    t.append(""+j+" "+i+ " : xxxxx yyyyy zzzzz\n");
                }
                j++;
            }
        });
        c.addActionListener(new ActionListener() { // Listener Knopf c
            public void actionPerformed(ActionEvent e){
                t.setText("");
            }
        });
        Container cp = getContentPane(); // Fenster-Container
        cp.setLayout(new FlowLayout()); // Layout Manager
        cp.add(new JScrollPane(t)); // rollbare Pane mit JTextArea ...
        cp.add(a); // Knoepfe anfuegen ...
        cp.add(b); // ...
        cp.add(c); // ...
    }
    public static void main(String[] args) {
        Konsole.run(new TextArea(), 275, 375); // Konsolenstart ...
    }
}
