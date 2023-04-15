package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * A simple Java GUI painting program. It holds a canvas of 100 x 100 "pixels" using javax.swing's JPanels and attached
 * mouse listeners to track the user's mouse movements. If right-pressed the user paints the pixels of the canvas with a
 * chosen color (black by default). If left-pressed the user erases the pixels of the canvas. The color can be changed
 * by rotating the mouse wheel. The chosen color will be shown in a colored circe on the left-side of the frame besides
 * some information on how to use the program and a clearing button which will set all pixels white when pressed.
 * task of CS course "Komplexe Programme" (13.04.2023)
 * @author Jan Obernberger
 * @verion 42, 15.04.2023
 */
public class MyPaint extends JFrame {
    Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray,
    Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
    // used to generate the preview of the color to be drawn
    Color repCol = Color.black;
    ArrayList<JPanel> pixels = new ArrayList<>();
    // flags
    Boolean paint = false;
    Boolean erase = false;
    // index to select the color to be drawn
    int i = 0;
    JPanel preview = new JPanel(){
        /**
         * displays a circle with 150p diameter in the color the user choose to draw
         * @param g the <code>Graphics</code> object to protect
         */
        @Override
        public void paintComponent(Graphics g) {
            this.setBackground(new Color(238, 238, 238));
            super.paintComponent(g);
            g.setColor(repCol);
            g.fillOval(0, 0, 150, 150);


        }
    };

    /**
     * default constructor
     */
    MyPaint() {
        //frame configuration
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
        setResizable(false);
        //panel configuration
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 400));
        panel.setMaximumSize(new Dimension(150, 500));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //label and info text configuration
        JLabel label = new JLabel();
        JLabel info1 = new JLabel();
        JLabel info2 = new JLabel();
        JLabel info3 = new JLabel();
        JLabel info4 = new JLabel();
        label.setText("  selected color");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        info1.setText("To paint hold left.");
        info2.setText("To change the color just");
        info3.setText("spin your mouse wheel.");
        info4.setText("To erase, hold right.");
        //clearing button configuration
        JButton button = new JButton("Clear Canvas");
        button.addActionListener(e -> pixels.forEach(el -> el.setBackground(Color.white)));
        //setting scope's size
        preview.setPreferredSize(new Dimension(150, 150));
        //canvas configuration
        JPanel canvas = new JPanel();
        canvas.setLayout(new GridLayout(100, 100));
        canvas.setPreferredSize(new Dimension(500, 500));
        //build up of the panel
        panel.add(label);
        panel.add(preview);
        panel.add(button);
        panel.add(info1);
        panel.add(info2);
        panel.add(info3);
        //build up of the frame
        cp.add(panel);
        cp.add(canvas);
        //build up of the canvas
        for (int i = 0; i < 10000; i++) {
            pixels.add(new JPanel());
        }
        //adding a mouse wheel listener to the frame
        cp.addMouseWheelListener(e -> {
            i = ++i % colors.length;
            repCol = colors[i];
            preview.setBackground(Color.WHITE);
            preview.repaint();
        });
        //adding each pixel to the canvs and adding a mouse listener to each pixel
        pixels.forEach(el -> {
            canvas.add(el);
            el.setOpaque(true);
            el.setBackground(Color.white);
            el.addMouseListener(new MouseAdapter() {
                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 */
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                }

                /**
                 * sets the painting flag if right-pressed and the erase flag if left-pressed
                 * @param e : mouse event will be evaluated by button
                 */
                @Override
                public void mousePressed(MouseEvent e) {
                    paint = e.getButton() == MouseEvent.BUTTON1;
                    erase = e.getButton() == MouseEvent.BUTTON3;
                }

                /**
                 * resets the painting flag if right-released and the erase flag if left-released
                 * @param e : mouse event will be evaluated by button
                 */
                @Override
                public void mouseReleased(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON1) paint = false;
                    if(e.getButton() == MouseEvent.BUTTON3) erase = false;
                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 */
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (paint) el.setBackground(colors[i]);
                    if (erase) el.setBackground(Color.white);
                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 */
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 * @since 1.6
                 */
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    super.mouseWheelMoved(e);
                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 * @since 1.6
                 */
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 * @since 1.6
                 */
                @Override
                public void mouseMoved(MouseEvent e) {
                    super.mouseMoved(e);
                }
            });

        });
    }

    /**
     * test MyPaint by using the Konsole program given by prof. Heinz
     * @param args : none expected
     */

    public static void main(String[] args) {
        Konsole.run(new MyPaint(), 750, 600);
    }
}
