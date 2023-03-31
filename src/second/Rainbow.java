package second;
/**
 * @version 42, 31.03.2023
 * @author Jan Obernberger
 **/

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Rainbow extends Frame implements ActionListener {
    static Color[] colors = {Color.black, Color.blue, Color.cyan, Color.gray, Color.green, Color.magenta, Color.pink,
            Color.red, Color.white, Color.yellow};
    Button button = new Button("epilepsy");

    Rainbow() {
        setLayout(new FlowLayout());
        button.addActionListener(this);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("epilepsy")) {
            new Frame() {
                int iColor = 1;

                void strobe() {
                    Timer timer = new Timer();
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            setBackground(colors[(iColor++ % (colors.length - 1))]);
                        }
                    }, 100, 100);
                    setSize(400, 150);
                    setVisible(true);
                }

            }.strobe();


        }
    }

    public static void main(String[] args) {
        Rainbow rainbow = new Rainbow();
        rainbow.addWindowListener(new WindowQuitter());
        rainbow.setSize(400, 150);
        rainbow.setVisible(true);
    }
}
