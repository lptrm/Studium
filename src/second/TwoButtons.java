package second;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons extends Frame implements ActionListener {
    Button redButton = new Button("Rot");
    Button grnButton = new Button("Grün");
    TwoButtons() {
        setLayout( new FlowLayout() );
        redButton.addActionListener( this );
        grnButton.addActionListener( this );
        redButton.setActionCommand( "red" ); // Kommando für roten Knopf
        grnButton.setActionCommand( "green" ); // Kommando für grünen Knopf
        add( redButton );
        add( grnButton );
    }
    public void actionPerformed( ActionEvent evt) {
        if ( evt.getActionCommand().equals( "red" ) ) // Kommando abfragen
            setBackground( Color.red ); // rote Farbe setzen
        else
            setBackground( Color.green ); // grüne Farbe setzen
        repaint(); // neu zeichnen
    }
    public static void main ( String[] args ){
        TwoButtons demo = new TwoButtons();
        demo.setSize( 200, 150 );
        demo.setVisible( true );
    }
}