package second;

import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
public class LinksMitteRechts extends JFrame  {
    JLabel lData1 = new JLabel("Datenfeld 1"); // Label fuer Datum Nr.1
    JTextField txData1 = new JTextField(7); // dazu ein Textfeld
    JPanel Panel1 = new JPanel(); // dazu ein Panel
    // ... ebenso fuer andere Daten
    JLabel lData2 = new JLabel("Datenfeld 2"); // Label fuer Datum Nr.2
    JTextField txData2 = new JTextField(7); // dazu ein Textfeld
    JPanel Panel2 = new JPanel(); // dazu ein Panel
    // ... ebenso fuer andere Daten
    JLabel lData3 = new JLabel("Datenfeld 3"); // Label fuer Datum Nr.3
    JTextField txData3 = new JTextField(7); // dazu ein Textfeld
    JPanel Panel3 = new JPanel(); // dazu ein Panel
    // ... ebenso fuer andere Daten
    JLabel lData4 = new JLabel("Datenfeld 4"); // Label fuer Datum Nr.4
    JTextField txData4 = new JTextField(7); // dazu ein Textfeld
    JPanel Panel4 = new JPanel(); // dazu ein Panel
    // ... ebenso fuer andere Daten
    JLabel lData5 = new JLabel("Datenfeld 5"); // Label fuer Datum Nr.5
    JTextField txData5 = new JTextField(7); // dazu ein Textfeld
    JPanel Panel5 = new JPanel(); // dazu ein Panel
    // ... ebenso fuer andere Daten
    JLabel lData6 = new JLabel("Datenfeld 6"); // Label fuer Datum Nr.6
    JTextField txData6 = new JTextField(7); // dazu ein Textfeld
    JPanel Panel6 = new JPanel(); // dazu ein Panel
    // ... ebenso fuer andere Daten
    JPanel dataPan = new JPanel(); // Panel fuer alle Daten
    JButton butLinks = new JButton("Links"); // Knopf fuer Links
    JButton butMitte = new JButton("Mitte"); // ... Mitte
    JButton butRechts = new JButton("Rechts"); // ... Rechts
    JPanel leftPanel = new JPanel(); // linkes Panel fuer Daten Nr.1-3
    JPanel rightPanel = new JPanel(); // rechtes ... Nr.4-6
    JPanel butPan = new JPanel(); // unteres ... fuer Knoepfe

    public LinksMitteRechts() { // Konstruktor
        setTitle("Links Mitte Rechts"); // Fenstertitel
        Panel1.add(lData1);
        Panel1.add(txData1);
        Panel2.add(lData2);
        Panel2.add(txData2);
        Panel3.add(lData3);
        Panel3.add(txData3);
        Panel4.add(lData4);
        Panel4.add(txData4);
        Panel5.add(lData5);
        Panel5.add(txData5);
        Panel6.add(lData6);
        Panel6.add(txData6);
        butPan.setLayout( // Layout Knopfpanel
                new BoxLayout(butPan, BoxLayout.X_AXIS)); // ... horizontal
        butPan.add(butLinks); // Knoepfe einfuegen
        butPan.add(butMitte); // ...
        butPan.add(butRechts); // ...
        leftPanel.setLayout( // Layout linkes Panel
                new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // ... vertikal
        leftPanel.add(Panel1); // Daten-Panels einfuegen
        leftPanel.add(Panel2); // ...
        leftPanel.add(Panel3); // ...
        rightPanel.setLayout( // Layout rechtes Panel
                new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // ... vertikal
        rightPanel.add(Panel4); // Daten-Panels einfuegen
        rightPanel.add(Panel5); // ...
        rightPanel.add(Panel6); // ...
        dataPan.setLayout( // Layout Daten-Panel
                new BoxLayout(dataPan, BoxLayout.X_AXIS)); // ... horizontal
        dataPan.add(leftPanel); // linkes Panel einfuegen
        dataPan.add(rightPanel); // rechtes ...
        getContentPane().setLayout( // Layout Gesamt-Fenster
                new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // ... vertikal
        getContentPane().add(dataPan); // Daten-Panel einfuegen
        getContentPane().add(butPan); // Knopf-Panel ...
    } // end Konstruktor ...

    public static void main(String[] args) {
        LinksMitteRechts linksMitteRechts = new LinksMitteRechts();
        linksMitteRechts.addWindowListener(new WindowQuitter());
        linksMitteRechts.setSize(500, 400);
        linksMitteRechts.setVisible(true);
    }
}
