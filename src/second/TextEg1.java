package second;

import javax.swing.*;
import java.awt.*;
public class TextEg1 extends JFrame {
    JTextField text;
    public TextEg1() { // Konstruktor
        super ("Namenseingabe"); // Aufruf Konstruktor der Superklasse
        text = new JTextField( 15 ); // Swing-Textfeld der Laenge 15
        text.setToolTipText("Bitte Namen eingeben"); // Hilfetext zum Textfeld
        getContentPane().setLayout( new FlowLayout() ); // Layout Manager
        getContentPane().add( text ); // Feld hinzufuegen
    }
    public static void main ( String[] args ) {
        TextEg1 teg = new TextEg1() ;
        teg.addWindowListener( new WindowQuitter() );
        teg.setSize ( 300, 100 );
        teg.setVisible( true );
    }
}
