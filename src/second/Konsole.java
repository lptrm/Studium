package second;
import java.awt.event.*;
import javax.swing.*;
public class Konsole {
    public static String title(Object o) { // Liefert den Klassennamen
        String t = o.getClass().toString(); // eines Objektes für Titel
        if (t.indexOf("class") != -1) t = t.substring(6);
        System.out.println ("Konsole: running "+t);
        return t;
    }
    public static void setupClosing(JFrame frame) { // setzt Schliessoperation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void run (JPanel panel, int width, int height) { // packt JPanel
        JFrame frame = new JFrame(title(panel)); // in JFrame
        setupClosing (frame); // setzt Parameter
        frame.getContentPane().add(panel); // macht sichtbar
        frame.setSize (width, height);
        frame.setVisible (true);
    }
    public static void run (JFrame frame, int width, int height) { // das Gleiche
        setupClosing (frame); // fuer JFrame
        frame.setTitle(title(frame));
        frame.setSize (width, height);
        frame.setVisible (true);
    }

    public static void main(String[] args) {

    }
}