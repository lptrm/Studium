package second;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class TrackEvent extends JFrame {
    HashMap<String,JTextField> h = new HashMap<String,JTextField>();
    // Datenstruktur um Zuordnungen zu definieren
    String[] event = { // String-Array fuer Event-Namen
            "focusGained", "focusLost", "keyPressed",
            "keyReleased", "keyTyped", "mouseClicked",
            "mouseEntered", "mouseExited", "mousePressed",
            "mouseReleased", "mouseDragged", "mouseMoved"
    };
    MyButton // Zwei Knoepfe mit Farbe und Namen def.
            b1 = new MyButton (Color.blue, "Knopf A"), // ...
            b2 = new MyButton (Color.red, "Knopf B"); // ...
    class MyButton extends JButton { // Eigene Knopfklasse, innere Klasse v. TrackEvent
        void report (String field, AWTEvent e ) { // gibt Knopfnamen und Eventpar. aus
            h.get(field).setText(((MyButton)e.getSource()).getText()+": "+e.paramString());
// h ordnet Eventnamen JTextFields zu
        }
        FocusListener fl = new FocusListener() { // anonyme Klasse
            public void focusGained(FocusEvent e) {
                report ("focusGained", e); // schreibe in Feld fuer focusGained
            }
            public void focusLost(FocusEvent e) {
                report ("focusLost", e); // ... fuer FocusLost
            }
        }; // end fl
        KeyListener kl = new KeyListener() { // anonyme Klasse
            public void keyPressed (KeyEvent e) {
                report ("keyPressed", e); // schreibe in Feld fuer Tastendruck
            }
            public void keyReleased (KeyEvent e) {
                report ("keyReleased", e); // ... fuer Taste losgelassen
            }
            public void keyTyped (KeyEvent e) {
                report ("keyTyped", e); // ... fuer Taste getippt
            }
        }; // end kl
        MouseListener ml = new MouseListener() { // anonyme Klasse
            public void mouseClicked (MouseEvent e) {
                report ("mouseClicked", e); // schreibe in Feld fuer Mausklick
            }
            public void mouseEntered (MouseEvent e) {
                report ("mouseEntered", e); // ... fuer Maus-Eintritt
            }
            public void mouseExited (MouseEvent e) {
                report ("mouseExited", e); // ... fuer Maus-Austritt
            }
            public void mousePressed (MouseEvent e) {
                report ("mousePressed", e); // ... fuer Maus-Druck
            }
            public void mouseReleased (MouseEvent e) {
                report ("mouseReleased", e); // ... fuer Maus-Losgelassen
            }
        }; // end ml
        MouseMotionListener mml = new MouseMotionListener() { // anonyme Klasse
            public void mouseDragged (MouseEvent e) {
                report ("mouseDragged", e); // schreibe in Feld fuer Maus-Ziehen
            }
            public void mouseMoved (MouseEvent e) {
                report ("mouseMoved", e); // ... fuer Maus-Bewegung
            }
        };
        public MyButton (Color color, String label){ // Konstruktor
            super (label); // Knopf-Text
            setBackground (color); // Knopf-Farbe
            addFocusListener (fl); // registriere Listener fuer Focus
            addKeyListener (kl); // ... fuer Key
            addMouseListener (ml); // ... fuer Mouse
            addMouseMotionListener (mml); // ... fuer MouseMotion
        } // end Konstruktor
    }
    public TrackEvent () { // Initialisiere
        Container c = getContentPane(); // Besorge Container
        c.setLayout (new GridLayout (event.length+1,2)); // setze Layout Manager
        for (int i = 0; i < event.length; i++) { // fuer jeden Event-Typ:
            JTextField t = new JTextField(); // erzeuge Textfeld,
            t.setEditable (false); // nicht editierbar
            c.add (new JLabel(event[i], JLabel.RIGHT)); // addiere Label, rechts ausgerichtet
            c.add (t); // und Textfeld
            h.put (event[i], t); // ordne Event-String dem Feld zu
        }
        c.add(b1); // fuege beide Knoepfe hinzu
        c.add(b2); // ...
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1700, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TrackEvent();
    }
}