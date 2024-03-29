package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Ein GUI-Programm auf Grundlage des Programmes DrehSafe. Hierbei muss über die Eingabe durch Buttons die richtige Zahlen-
 * kombination erraten werden, um das Programm erfolgreich (Exit Code 0) zu beenden. Wobei die Farbe des Hintergrunds
 * bzw. der Buttons grün ist, solange der User sich auf dem richtigen Pfad befindet und rot wird, wenn der User eine
 * Fehleingabe tätigt. (Vgl. Zustandsautomaten). Außerdem sind die Zahlen im Kreis angeordnet und rotieren im Uhrzeigersinn
 * im Sekundentakt. Solange sich der User auf dem richtigen Pfad befindet, sind die JButtons grün, bei einer Fehleingabe
 * werden sie rot und zusätzlich ändert sich die Drehrichtung.
 * In dieser Version öffnet sich zudem bei jeder Falscheingabe ein weiterer Safe und die Geschwindigkeit des betref-
 * fenden Safes wird um 33% erhöht.
 *
 * @author Jan Obernberger
 * @version ++42, 15.04.23
 */
public class ToggleSafe extends JFrame implements ActionListener {
    private int state = 0;
    private boolean direction = true;
    private final JButton[] buttons = new JButton[10];
    private long sleeptime = 1000;
    private Timer timer = null;
    static final ArrayList<ToggleSafe> TOGGLE_SAFES = new ArrayList<>();

    ToggleSafe() { // Konstruktor
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
        generateTimerTask(1000);
        //Parameter Delay setzt Verzögerung, mit der die Rotation beginnt. in ms
        Konsole.run(this, 500, 500);
    }

    private void generateTimerTask(int delay) {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int k = direction ? 1 : 9;
                for (int i = 0; i < 10; i++) {
                    buttons[i].setText(((Integer.parseInt(buttons[i].getText()) + k) % 10) + "");
                }
            }
        }, delay, sleeptime >= 1 ? sleeptime : 1);
    }


    /**
     * Implementierung des ActionListener-Interface
     * Zustandsautomat zur Zahlenfolge 8-5-2-9-6-3-0-7-4-1 realisiert mit Switch-Case Anweisung.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (Integer.parseInt(evt.getActionCommand())) {
            case 0 -> state = (state == 6) ? state + 1 : 0;
            case 1 -> state = (state == 9) ? state + 1 : 0;
            case 2 -> state = (state == 2) ? state + 1 : 0;
            case 3 -> state = (state == 5) ? state + 1 : 0;
            case 4 -> state = (state == 8) ? state + 1 : 0;
            case 5 -> state = (state == 1) ? state + 1 : 0;
            case 6 -> state = (state == 4) ? state + 1 : 0;
            case 7 -> state = (state == 7) ? state + 1 : 0;
            case 8 -> state = 1;
            case 9 -> state = (state == 3) ? state + 1 : 0;
            default -> state = 0;
        }
        Color col;
        if (state == 0) {
            col = Color.red;
            direction = !direction;
            sleeptime *= 2.0 / 3;
            TOGGLE_SAFES.add(new ToggleSafe());
            generateTimerTask(0);
        } else {
            col = Color.green;

        }
        if (state == 1) {
            if (TOGGLE_SAFES.size() == 1) {
                System.exit(0);
            }
            dispose();
        }
        for (JButton b : buttons) b.setBackground(col);
    }

    /**
     * Main Methode zum Testen des Programms
     */
    public static void main(String[] args) {
        new ToggleSafe();
    }
}
