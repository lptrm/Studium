package second;
import java.awt.*;
import java.awt.event.*;
class MyFrame3 extends Frame
{
    public void paint ( Graphics g )
    {
        g.drawString ("Bitte Schliessknopf klicken", 10, 50 );
    }
    public static void main ( String[] args )
    {
        MyFrame3 frm = new MyFrame3();
        frm.addWindowListener(
                new WindowAdapter () {
                    public void windowClosing( WindowEvent e )
                    {
                        System.exit( 0 ); // Programm beenden
                    }
                }
        );
        frm.setSize ( 200, 100 );
        frm.setVisible( true );
    }
}
