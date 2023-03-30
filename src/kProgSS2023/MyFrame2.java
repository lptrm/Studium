package kProgSS2023;

import java.awt.*;
import java.awt.event.*;
class MyFrame extends Frame // Hauptklasse
{
    public void paint ( Graphics g )
    {
        g.drawString ("Bitte Schliessknopf klicken", 10, 50 );
    }
    public static void main ( String[] args ) // statische Methode von MyFrame
    {
        MyFrame frm = new MyFrame();
        WindowQuitter wquit = new WindowQuitter();
        frm.addWindowListener( wquit );
        frm.setSize( 200, 100 );
        frm.setVisible( true );
    }
}
class WindowQuitter extends WindowAdapter
{
    public void windowClosing ( WindowEvent e )
    {
        System.exit( 0 ); // Programm beenden
    }
}