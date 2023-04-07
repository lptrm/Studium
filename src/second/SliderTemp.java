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
    JSlider sliderA, sliderB;
    JTextField textA, textB;

    boolean tempIsAdjusting;
    int celsius = 0;
    int fahrenheit = 32;


    public SliderTemp() {
        //Fensterkonfiguration
        setTitle("Temperatur-Rechner");
        setSize(600, 200);
        setResizable(false); // ... fixieren
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Sliderkonfiguration
        sliderA = new JSlider(SwingConstants.HORIZONTAL, -300, 1000, 0);
        sliderA.setBorder(new TitledBorder("Celsius")); // Rahmen mit Titel
        sliderA.setMajorTickSpacing(100);
        sliderA.setMinorTickSpacing(50);
        sliderA.setPaintTicks(true);
        sliderA.setPaintLabels(true);
        sliderA.setPreferredSize(new Dimension(500, 70));
        sliderA.addChangeListener(this);
        sliderA.setName("sliderA");
        sliderA.setToolTipText("Temperatur in Celsius einstellen");
        sliderB = new JSlider(SwingConstants.HORIZONTAL, -500, 1000, 0);
        sliderB.setBorder(new TitledBorder("Fahrenheit"));// Rahmen mit Titel
        sliderB.setMajorTickSpacing(100);
        sliderB.setMinorTickSpacing(50);
        sliderB.setPaintTicks(true);
        sliderB.setPaintLabels(true);
        sliderB.setPreferredSize(new Dimension(500, 70));
        sliderB.addChangeListener(this);
        sliderB.setName("sliderB");
        sliderB.setToolTipText("Temperatur in Fahrenheit einstellen");
        //Textfeldkonfiguration
        textA = new JTextField(4);
        textA.setToolTipText("Celsius-Temperatur");
        textA.setEditable(false);
        textB = new JTextField(4);
        textB.setToolTipText("Fahrenheit-Temperatur");
        textB.setEditable(false);
        //Container für Elemente
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(textA);
        cp.add(sliderA);
        cp.add(textB);
        cp.add(sliderB);
        //Temperatur initialisieren und anzeigen
        displayTemp();
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
        textA.setText("" + celsius);
        sliderA.setValue(celsius);
        textB.setText("" + fahrenheit);
        sliderB.setValue(fahrenheit);
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
     * Programm SliderTemp starten
     */
    public static void main(String[] args) {
        new SliderTemp();
    }
}
