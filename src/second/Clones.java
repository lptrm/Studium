package second;
/**
 * @version 42, 31.03.2023
 * @author Jan Obernberger
 **/

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
            this.addWindowListener(new WindowQuitter());
            this.setSize(400, 300);
            this.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cycle")) {
            setBackground(colors[(++iColor % (colors.length - 1))]);
        } else if (e.getActionCommand().equals("clone")) {
            new Clones() {
            }.setBackground(colors[(iColor % (colors.length - 1))]);
        }
    }

    public static void main(String[] args) {
        new Clones();
    }
}
