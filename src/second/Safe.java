package second;
/**
 * @version 42, 31.03.2023
 * @author Jan Obernberger
 **/

import java.awt.event.*;
import java.awt.*;

public class Safe extends Frame implements ActionListener {
    Button[] buttons = {new Button("0"), new Button("1"), new Button("2"), new Button("3"),
            new Button("4"), new Button("5"), new Button("6"), new Button("7"),
            new Button("8"), new Button("9"),};
    static int step = 0;
    String[] t = {"3", "1", "0", "3", "2", "0", "2", "3"};

    Safe() {
        setLayout(new FlowLayout());
        for (Button b : buttons) {
            b.addActionListener(this);
            this.add(b);
        }
        step++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (step) {
            case 1:
                step = transition(e, t[0], ++step);
                break;
            case 2:
                step = transition(e, t[1], ++step);
                break;
            case 3:
                step = transition(e, t[2], ++step);
                break;
            case 4:
                step = transition(e, t[3], ++step);
                break;
            case 5:
                step = transition(e, t[4], ++step);
                break;
            case 6:
                step = transition(e, t[5], ++step);
                break;
            case 7:
                step = transition(e, t[6], ++step);
                break;
            case 8:
                step = transition(e, t[7], ++step);
            case 9:
                System.exit(0);
        }
    }

    int transition(ActionEvent e, String s, int step) {
        if (e.getActionCommand().equals(s)) {
            setBackground(Color.green);
            return step;
        } else {
            setBackground(Color.red);
            return 1;
        }
    }

    public static void main(String[] args) {
        Safe safe = new Safe();
        safe.addWindowListener(new WindowQuitter());
        safe.setSize(400, 500);
        safe.setVisible(true);
    }
}
