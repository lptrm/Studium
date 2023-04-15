package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyPaint extends JFrame {
    Color[] colors = {Color.red, Color.blue, Color.green, Color.white, Color.pink, Color.magenta};
    Color repCol = Color.red;
    JPanel scope = new CircularPanel();
    ArrayList<JPanel> pixels = new ArrayList<>();
    Boolean paint = false;
    Boolean erease = false;
    int i = 0;


    MyPaint() {
        setTitle("MyPaint");
        setSize(1000, 1000);
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
        JLabel label = new JLabel();
        label.setText("selected color");
        cp.add(label);
        label.setAlignmentX(0);
        label.setAlignmentY(0);

        scope.setPreferredSize(new Dimension(300,300));
        scope.setMaximumSize(new Dimension(300,300));
        cp.add(scope);
        scope.setAlignmentY(300);
        scope.setAlignmentX(0);

        JPanel canvas = new JPanel();
        canvas.setLayout(new GridLayout(100,100));
        //canvas.setSize(500,500);
        canvas.setMaximumSize(new Dimension(500,500));
        canvas.setPreferredSize(new Dimension(500,500));
        cp.add(canvas);
        canvas.setAlignmentY(0);
        canvas.setAlignmentX(400);
        System.out.println(canvas.getX() + " " + canvas.getY());

        for (int i = 0; i < 10000; i++) {
            pixels.add(new JPanel());
        }
        cp.addMouseWheelListener(e -> {
            i = ++i % colors.length;
            repCol = colors[i];
            scope.repaint();
        });
        cp.addMouseListener(new MouseAdapter() {
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
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
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
        pixels.forEach(canvas::add);
        pixels.forEach(el -> {
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

                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 */
                @Override
                public void mousePressed(MouseEvent e) {
                    if(e.getButton()==MouseEvent.BUTTON1) {
                        System.out.println("test");
                        paint = true;
                    }
                    if(e.getButton()==MouseEvent.BUTTON3) {
                        System.out.println("etts");
                        erease = true;
                    }
                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 */
                @Override
                public void mouseReleased(MouseEvent e) {
                    if(e.getButton()==MouseEvent.BUTTON1) paint = false;
                    if(e.getButton()==MouseEvent.BUTTON3) erease = false;
                }

                /**
                 * {@inheritDoc}
                 *
                 * @param e
                 */
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (paint) el.setBackground(colors[i]);
                    if (erease) el.setBackground(Color.white);
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



        setVisible(true);
    }
    class CircularPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.drawOval(0, 0,200 ,200);
            g.setColor(repCol);
            g.fillOval(0,0,200,200);


        }

    }

    public static void main(String[] args) {
        new MyPaint();
    }
}
