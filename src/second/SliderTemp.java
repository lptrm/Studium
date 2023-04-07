package second;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Ein GUI-Programm zu Umrechnungen zwischen den Temperatureinheiten Celsius und Fahrenheit. Das Programm benutzt
 * hierfür ausschließlich Integer-Werte und rundet gemäß den in Java bekannten Mechanismen. Die Temperaturskala ist von
 * -273°C (-459°F), wobei die Skalen bis zum nächstgrößeren vielfachen von 100 gehen.
 *
 * @author Jan Obernberger
 * @version 42, 07.04.23
 */
public class SliderTemp extends JFrame implements ChangeListener {
    private final JSlider[] sliders = {
            new JSlider(SwingConstants.HORIZONTAL, -300, 1000, 0),
            new JSlider(SwingConstants.HORIZONTAL, -500, 1000, 0)};
    private final JTextField[] textFields = {new JTextField(4), new JTextField(4)};

    private boolean tempIsAdjusting;
    private int celsius = 0;
    private int fahrenheit = 32;


    public SliderTemp() {
        //Sliderkonfiguration
        for(var e : sliders){
            e.setMajorTickSpacing(100);
            e.setMinorTickSpacing(50);
            e.setPaintTicks(true);
            e.setPaintLabels(true);
            e.setPreferredSize(new Dimension(500, 70));
            e.addChangeListener(this);
        }
        sliders[0].setBorder(new TitledBorder("Celsius"));
        sliders[0].setName("sliderA");
        sliders[0].setToolTipText("Temperatur in Celsius einstellen");
        sliders[1].setBorder(new TitledBorder("Fahrenheit"));
        sliders[1].setName("sliderB");
        sliders[1].setToolTipText("Temperatur in Fahrenheit einstellen");
        //Textfeldkonfiguration
        textFields[0].setToolTipText("Celsius-Temperatur");
        textFields[0].setEditable(false);
        textFields[1].setToolTipText("Fahrenheit-Temperatur");
        textFields[1].setEditable(false);
        //Container für Elemente
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(textFields[0]);
        cp.add(sliders[0]);
        cp.add(textFields[1]);
        cp.add(sliders[1]);
        //Temperatur initialisieren
        displayTemp();
        //Fensterkonfiguration
        setTitle("Temperatur-Rechner");
        setSize(600, 200);
        setResizable(false); // ... fixieren
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Setzt die Temperaturen auf Grundlagen der Eingabe in Celsius
     *
     * @param c : Wert des Celsius-Sliders nach Änderung
     */
    void setCelsius(int c) {
        celsius = Math.max(-273, c);
        fahrenheit = ((celsius * 9) / 5) + 32;
    }

    /**
     * Setzt die Temperaturen auf Grundlagen der Eingabe in Fahrenheit über Aufruf von setCelsius()
     *
     * @param f : Wert des Fahrenheit-Sliders nach Änderung
     */
    void setFahrenheit(int f) {
        setCelsius(((f - 32) * 5) / 9);
    }

    /**
     * Setzt die Texte sowie die Slider, sodass eine kontinuierliche Ein- und Ausgabe in beide Seiten möglich ist.
     */
    void displayTemp() {
        tempIsAdjusting = true;
        textFields[0].setText("" + celsius);
        sliders[0].setValue(celsius);
        textFields[1].setText("" + fahrenheit);
        sliders[1].setValue(fahrenheit);
        tempIsAdjusting = false;
    }

    /**
     * Implementierung des ChangeListener-Interface
     * so lange keine Neuanzeige erfolgt, wird bei einer Änderung der geänderte Schieber identifiziert, und die
     * entsprechende Funktion zur korrekten Verarbeitung der Eingabe aufgerufen.
     */
    @Override
    public void stateChanged(ChangeEvent evt) {
        if (!tempIsAdjusting) {
            JSlider source = (JSlider) evt.getSource();
            if (source.getName().equals("sliderA")) {
                setCelsius(source.getValue());
            }
            if (source.getName().equals("sliderB")) {
                setFahrenheit(source.getValue());
            }
            displayTemp();
        }
    }

    /**
     * Main Methode um Programm SliderTemp zu testen
     */
    public static void main(String[] args) {
        new SliderTemp();
    }
}
