package kProgSS2023;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clones extends Frame implements ActionListener {

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
            tmp.setBackground(iColor == 0 ? Color.white : colors[(iColor % (colors.length - 1))-1]);
            tmp.iColor = this.iColor;
            tmp.addWindowListener(new WindowQuitter());
            tmp.setSize(400, 300);
            tmp.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Clones clones = new Clones();
        clones.addWindowListener(new WindowQuitter());
        clones.setSize(400, 300);
        clones.setVisible(true);
    }
}
