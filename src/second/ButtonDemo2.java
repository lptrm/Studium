package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonDemo2 extends JFrame implements ActionListener {
    JButton bChange;

    public ButtonDemo2() {
        setTitle("ButtonDemo2");
        getContentPane().
                setLayout(new FlowLayout()); // Layout Manager
        bChange = new JButton("Klick mich!");// construct a Button
        bChange.setFont(new Font("Courier", Font.BOLD, 16));
        bChange.setToolTipText("zum Wechseln der Farbe");
        bChange.addActionListener(this); // register the ButtonDemo2 object
        getContentPane().add(bChange); // add the button to the container
    }

    Color[] colors = {Color.red, Color.blue};
    int col = 0;
    int clicks = 0;

    public void actionPerformed(ActionEvent evt) {
        getContentPane().setBackground(colors[col]);
        col = (col + 1) % colors.length;
        bChange.setText("Klick mich! (" + (++clicks) + ")");
        repaint(); // ask the system to paint the screen.
    }

    public static void main(String[] args) {
        ButtonDemo2 buttonDemo2 = new ButtonDemo2();
        buttonDemo2.addWindowListener(new WindowQuitter());
        buttonDemo2.setSize(300,100);
        buttonDemo2.setVisible(true);
    }
}