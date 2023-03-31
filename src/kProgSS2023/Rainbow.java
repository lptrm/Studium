package kProgSS2023;
import java.awt.*;
import java.awt.event.*;

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
            new Thread(){
                @Override
                public void run() {
                    super.run();
                }
                Frame frame = new Frame(){
                    Color[] colors = {Color.black, Color.blue, Color.cyan, Color.gray, Color.green, Color.magenta, Color.pink,
                            Color.red, Color.white, Color.yellow};
                    int iColor = 0;

                };
            };
        }
    }
}
