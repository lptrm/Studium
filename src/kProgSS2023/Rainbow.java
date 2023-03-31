package kProgSS2023;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Rainbow extends Frame implements ActionListener{
    static Color[] colors = {Color.black, Color.blue, Color.cyan, Color.gray, Color.green, Color.magenta, Color.pink,
            Color.red, Color.white, Color.yellow};
    Button button = new Button("epilepsy");
    Rainbow(){
        setLayout(new FlowLayout());
        button.addActionListener(this);
        this.add(button);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("epilepsy")){
            new Frame() {
                Timer timer = new Timer();
                int iColor = 0;

                void strobe() {
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            setBackground(colors[((++iColor%colors.length-1))]);
                            repaint();
                        }
                    }, 1000, 1000);
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
