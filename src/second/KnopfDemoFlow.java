package second;

import java.awt.*;

public class KnopfDemoFlow extends Frame {
    Button bChange = new Button("Klick mich!");
    KnopfDemoFlow() { // Konstruktor für KnopfDemoFlow
        setLayout (new FlowLayout()); // setze FlowLayout
        add( bChange ); // füge Knopf hinzu
    }
    public static void main ( String[] args ) {
        KnopfDemoFlow frm = new KnopfDemoFlow();
        WindowQuitter wquit = new WindowQuitter();
        frm.addWindowListener( wquit );
        frm.setSize( 200, 150 );
        frm.setVisible( true );
    }
}
