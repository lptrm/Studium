package kProgSS2023;
import java.awt.*;
import java.awt.event.*;
public class Repeatersep extends Frame implements ActionListener {
    Label inLabel = new Label("Bitte Namen eingeben: ");
    TextField inText = new TextField(15);
    Label outLabel = new Label("Dein Name ist :");
    TextField outText = new TextField(15);

    Repeatersep() {
        setTitle("Repeatersep");
        setLayout(new FlowLayout());
        add(inLabel);
        add(inText);
        add(outLabel);
        add(outText);
        inText.addActionListener(this);
        outText.setEditable(false); // verhindert Editierung des Textfeldes
    }

    public void copyText() {
        String name = inText.getText();
        outText.setText(name);
    }

    public void actionPerformed(ActionEvent evt) {
        copyText(); // Anwendungsmethode aufrufen
        repaint();
    }

    public static void main(String[] args) {
        Repeatersep repsep = new Repeatersep();
        WindowQuitter wquit = new WindowQuitter();
        repsep.addWindowListener(wquit);
        repsep.setSize(400, 300);
        repsep.setVisible(true);
    }
}

