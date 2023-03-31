package second;
/**
 * @version 42, 31.03.2023
 * @author Jan Obernberger
 **/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevenColors extends Frame implements ActionListener {
    Button[] buttons = {new Button("black"), new Button("blue"), new Button("cyan"), new Button("gray"),
            new Button("green"), new Button("magenta"), new Button("orange"), new Button("pink"),
            new Button("red"), new Button("white"), new Button("yellow")};

    ElevenColors() {
        setLayout(new FlowLayout());
        for (Button e : this.buttons) {
            e.addActionListener(this);
            this.add(e);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "black" -> setBackground(Color.black);
            case "blue" -> setBackground(Color.blue);
            case "cyan" -> setBackground(Color.cyan);
            case "gray" -> setBackground(Color.gray);
            case "green" -> setBackground(Color.green);
            case "magenta" -> setBackground(Color.magenta);
            case "orange" -> setBackground(Color.orange);
            case "pink" -> setBackground(Color.pink);
            case "red" -> setBackground(Color.red);
            case "white" -> setBackground(Color.white);
            case "yellow" -> setBackground(Color.yellow);
            default -> {
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        ElevenColors demo = new ElevenColors();
        demo.addWindowListener(new WindowQuitter());
        demo.setSize(800, 600);
        demo.setVisible(true);
    }

}
