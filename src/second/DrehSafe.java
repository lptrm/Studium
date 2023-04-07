package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Ein GUI-Programm auf Grundlage des Programmes Safe. Hierbei muss über die Eingabe durch Buttons die richtige Zahlen-
 * kombination erraten werden, um das Programm erfolgreich (Exit Code 0) zu beenden. Wobei die Farbe des Hintergrunds
 * bzw. der Buttons grün ist, solange der User sich auf dem richtigen Pfad befindet und rot wird, wenn der User eine
 * Fehleingabe tätigt. (Vgl. Zustandsautomaten).
 * In dieser Version sind die Zahlen im Kreis angeordnet und rotieren im Uhrzeigersinn im Sekundentakt. So lange sich
 * der User auf dem richtigen Pfad befindet, sind die JButtons grün, bei einer Fehleingabe werden sie rot und zusätzlich
 * ändert sich die Drehrichtung.
 *
 * @author Jan Obernberger
 * @version 42, 07.04.23
 */
public class DrehSafe extends JFrame implements ActionListener {
    int state = 0;
    boolean direction = true;
    JButton[] buttons = new JButton[10];
    Timer timer = new Timer();

    DrehSafe() { // Konstruktor
        setTitle("DrehSafe");
        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 3));
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton("" + i);
            buttons[i].setFont(new Font("Courier", Font.BOLD, 34));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
        c.add(buttons[0]);
        c.add(buttons[9]);
        c.add(buttons[8]);
        c.add(buttons[1]);
        c.add(new JPanel());
        c.add(buttons[7]);
        c.add(buttons[2]);
        c.add(new JPanel());
        c.add(buttons[6]);
        c.add(buttons[3]);
        c.add(buttons[4]);
        c.add(buttons[5]);
        setSize(300, 200);
        setLocation(300, 300);
        setVisible(true);
        //Parameter Delay setzt Verzögerung, mit der die Rotation beginnt in ms
        timer.scheduleAtFixedRate(task, 3000, 1000);
    }

    /**
     * TimerTask-Objekt, in welchem die run Methode implementiert wird, die den Wechsel der Labels der Buttons bewirkt.
     */
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            int k = direction ? 1 : 9;
            for (int i = 0; i < 10; i++) {
                buttons[i].setText(((Integer.parseInt(buttons[i].getText()) + k) % 10) + "");
            }
        }
    };

    /**
     * Implementierung des ActionListener-Interface
     * Zustandsautomat zur Zahlenfolge 8-2-2-4-7-2-5-3-0-1 realisiert mit Swicht-Case Anweisung. Bei falschem Raten wird
     * hier zusätzlich die Drehrichtung über einen Boolean geändert.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (Integer.parseInt(evt.getActionCommand())) {
            case 0 -> state = (state == 8) ? state + 1 : 0;
            case 1 -> state = (state == 9) ? state + 1 : 0;
            case 2 -> state = (state == 1 || state == 2 || state == 5) ? state + 1 : 0;
            case 3 -> state = (state == 7) ? state + 1 : 0;
            case 4 -> state = (state == 3) ? state + 1 : 0;
            case 5 -> state = (state == 6) ? state + 1 : 0;
            case 7 -> state = (state == 4) ? state + 1 : 0;
            case 8 -> state = (state == 0) ? state + 1 : 1;
            default -> state = 0;
        }
        Color col;
        if (state == 0) {
            col = Color.red;
            direction = !direction;
        } else {
            col = Color.green;
        }
        if (state == 10) {
            System.exit(0);
        }
        for (JButton b : buttons) b.setBackground(col);
    }

    /**
     * Main Methode zum Testen des Programms
     */
    public static void main(String[] args) {
        DrehSafe drehSafe = new DrehSafe();
    }
}
