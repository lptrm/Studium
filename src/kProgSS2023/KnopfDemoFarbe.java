package kProgSS2023;

import java.awt.*;
import java.awt.event.*;
public class KnopfDemoFarbe extends Frame implements ActionListener {
    Button bChange = new Button("Klick mich!");
    KnopfDemoFarbe() { // Konstruktor
        setLayout( new FlowLayout() ); // Layout setzen
        bChange.addActionListener( this ); // Listener registrieren
        add( bChange );
    }
    Color[] colors = { Color.blue, Color.red }; // Farbpalette
    int col = 0;
    public void actionPerformed( ActionEvent evt) { // Farbe ändern
        setBackground( colors[col] );
        col = (col+1) % colors.length;
        repaint();
    }
    public static void main ( String[] args )
    {
        KnopfDemoFarbe kdf = new KnopfDemoFarbe();
        WindowQuitter wquit = new WindowQuitter();
        kdf.addWindowListener(wquit);
        kdf.setSize(400, 300);
        kdf.setVisible(true);
    }
}

