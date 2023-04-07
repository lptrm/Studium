package second;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GUI-Programm basierend auf dem Gerüst aus der Vorlesung, um das Idealgewicht zu berechnen. Hierbei wird Geschlecht
 * und Größe über sog. Radio-Buttons ausgewählt. Anhand dieser Daten wird ein Ausgabetext mit dem Idealgewicht des Users
 * generiert.
 *
 * @author Jan Obernberger
 * @version 42, 07.04.2023
 */
public class IdealWeight extends JFrame implements ActionListener {
    JRadioButton[] gender = {new JRadioButton("Male", true), new JRadioButton("Female", false)};
    JRadioButton[] height = {
            new JRadioButton("60 to 64 inches", true),
            new JRadioButton("64 to 68 inches", false),
            new JRadioButton("68 to 72 inches", false),
            new JRadioButton("72 to 76 inches", false),
            new JRadioButton("76 to 80 inches", false)};
    ButtonGroup genderGroup;
    JPanel genderPanel;
    ButtonGroup heightGroup;
    JPanel heightPanel;
    JTextField resultText;
    JLabel resultLabel;
    JPanel resultPanel;

    public IdealWeight() {
        //Gender Panel erstellen
        genderGroup = new ButtonGroup();
        genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.Y_AXIS));
        genderPanel.add(new JLabel("Your Gender"));
        for (var e : gender) {
            genderGroup.add(e);
            genderPanel.add(e);
            e.addActionListener(this);
        }
        //Height Panel erstellen
        heightGroup = new ButtonGroup();
        heightPanel = new JPanel();
        heightPanel.setLayout(
                new BoxLayout(heightPanel, BoxLayout.Y_AXIS));
        heightPanel.add(new JLabel("Your Height"));
        for (var e : height) {
            heightPanel.add(e);
            heightGroup.add(e);
            e.addActionListener(this);
        }
        //Ausgabetextfeld erstellen
        resultText = new JTextField(10);
        resultText.setEditable(false);
        resultLabel = new JLabel("Ideal Weight");
        resultPanel = new JPanel();
        resultPanel.add(resultLabel);
        resultPanel.add(resultText);
        //Layout-Manager
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(genderPanel, BorderLayout.WEST);
        getContentPane().add(heightPanel, BorderLayout.EAST);
        getContentPane().add(resultPanel, BorderLayout.SOUTH);
        //Fensterkonfiguration
        setTitle("Your Ideal Weight");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 225);
        setVisible(true);
    }

    /**
     * Implementierung von ActionListener-Interface
     * fragt ab, welche Radio Buttons ausgewählt sind und setzt entsprechend die Variablen der Formel aus der Vorgabe
     * W = H² / 30(M)||28(W). Anschließend wird der Ausgabetext mit den Ergebnissen manipuliert.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int denominator = gender[0].isSelected() ? 30 : 28, minHeight = 0, maxHeight = 0, minIdealWeight, maxIdealWeight;
        for (var v : height) {
            if (v.isSelected()) {
                minHeight = Integer.parseInt(v.getActionCommand().substring(0, 2));
                maxHeight = Integer.parseInt(v.getActionCommand().substring(6, 8));
            }
        }
        minIdealWeight = minHeight * minHeight / denominator;
        maxIdealWeight = maxHeight * maxHeight / denominator;
        resultText.setText(minIdealWeight + "-" + maxIdealWeight + " Pounds");
    }

    /**
     * Main Methode zum Testen des Programms
     */
    public static void main(String[] args) {
        IdealWeight weightApp = new IdealWeight();
    }

}
