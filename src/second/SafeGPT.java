package second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeGPT extends JFrame implements ActionListener {
    private static final String CORRECT_COMBO = "31032023"; // Die richtige Kombination
    private JPanel panel;
    private JButton[] buttons;
    private StringBuilder currentCombo;

    public SafeGPT() {
        setTitle("Safe");
        panel = new JPanel();
        buttons = new JButton[10];
        currentCombo = new StringBuilder();

        // GUI-Komponenten erstellen und konfigurieren
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(Integer.toString(i));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(panel);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String buttonLabel = sourceButton.getText();
        currentCombo.append(buttonLabel); // Aktuellen Knopf zur Kombination hinzufügen

        // Überprüfen, ob die aktuelle Kombination der richtigen Kombination entspricht
        if (currentCombo.toString().equals(CORRECT_COMBO)) {
            JOptionPane.showMessageDialog(this, "Richtige Kombination eingegeben! Das Programm wird beendet.");
            System.exit(0);
        } else {
            // Hintergrundfarbe je nach Kombinationseingabe aktualisieren
            panel.setBackground(Color.RED);
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setBackground(null); // Hintergrundfarbe zurücksetzen
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SafeGPT();
            }
        });
    }
}