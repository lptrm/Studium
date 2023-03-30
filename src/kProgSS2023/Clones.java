package kProgSS2023;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Clones extends Frame implements ActionListener {
    ArrayList<ActionListener> clones = new ArrayList<>();

    Button[] buttons = {new Button("cycle"), new Button("clone")};
    Color[] colors = {Color.black, Color.blue, Color.cyan, Color.gray, Color.green, Color.magenta, Color.pink,
            Color.red, Color.white, Color.yellow};
    int iColor = 0;

    Clones() {
        setLayout(new FlowLayout());
        for (Button e : buttons) {
            e.addActionListener(this);
            this.add(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cycle")) {
            setBackground(colors[(iColor++ % (colors.length - 1))]);
            repaint();
        } else if (e.getActionCommand().equals("clone")) {
            Clones tmp = new Clones();
            tmp.setBackground(colors[(iColor - 1 % (colors.length - 1))]);
            tmp.addWindowListener(new WindowQuitter());
            tmp.setSize(400, 300);
            tmp.setVisible(true);
            clones.add(tmp);
        }
        ;
    }

    public static void main(String[] args) {
        Clones clones = new Clones();
        clones.addWindowListener(new WindowQuitter());
        clones.setSize(400, 300);
        clones.setVisible(true);
    }
}
