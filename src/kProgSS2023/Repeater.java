package kProgSS2023;

import java.awt.*;
import java.awt.event.*;

public class Repeater extends Frame implements ActionListener {
    Label inLabel = new Label("Bitte Namen eingeben: "); // Label Input
    TextField inText = new TextField(15); // Textfeld Input
    Label outLabel = new Label("Dein Name ist :"); // Label Output
    TextField outText = new TextField(15); // Textfeld Output

    Repeater() { // Konstruktor
        setTitle("Repeater"); // Fenstertitel
        setLayout(new FlowLayout()); // Layout Manager
        add(inLabel); // Komponenten hinzufügen
        add(inText); // ..
        add(outLabel); // ..
        add(outText); // ..
        inText.addActionListener(this); // Listener registrieren
    }

    public void actionPerformed(ActionEvent evt) { // Text kopieren
        String name = inText.getText();
        outText.setText(name);
        repaint();
    }

    public static void main(String[] args) {
        Repeater echo = new Repeater();
        WindowQuitter wquit = new WindowQuitter();
        echo.addWindowListener(wquit);
        echo.setSize(400, 300);
        echo.setVisible(true);
    }
}