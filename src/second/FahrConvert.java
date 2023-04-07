package second;

import java.awt.*;
import java.awt.event.*;

public class FahrConvert extends Frame implements ActionListener {
    Label title = new Label("Konvertiere Fahrenheit in Celsius");
    Label inLabel = new Label("Eingabe Fahrenheit");
    Label outLabel = new Label("Ausgabe Celsius ");
    TextField inFahr = new TextField(9);
    TextField outCel = new TextField(9);
    int fahrTemp;
    int celsTemp;

    FahrConvert() { // Konstruktor
        setTitle ("Konvertiere Fahrenheit in Celsius"); // Fenstertitel
        setLayout( new FlowLayout() ); // Layout Manager
        setSize( 280, 150 );
        setResizable(false); // fixiere Groesse
        inFahr.addActionListener( this );
        add( title );
        add( inLabel );
        add( outLabel );
        add( inFahr );
        add( outCel );
        outCel.setEditable( false );
        setVisible( true );
    }


    public void convert() { // Anwendungscode
        celsTemp = ((fahrTemp - 32) * 5) / 9;
    }

    public void actionPerformed(ActionEvent evt) {
        try { // Versuch ...
            inFahr.setBackground (Color.white); // Eingabefeld in weiss
            String userIn = inFahr.getText() ;
            fahrTemp = Integer.parseInt(userIn.trim()); // Fehlermoeglichkeiten ..
            convert() ;
            outCel.setText( celsTemp+"" );
        } catch (Exception e) { // Bei Fehler ...
            inFahr.setBackground (Color.red); // Eingabefeld rot setzen
            outCel.setText( "" ); // Ausgabefeld leeren
        }
    }

    public static void main(String[] args) {
        FahrConvert fahr = new FahrConvert();
        fahr.addWindowListener(new WindowQuitter());
        fahr.setSize(280, 150); // Groesse
        fahr.setVisible(true); // Sichtbarkeit setzen
    }
}
