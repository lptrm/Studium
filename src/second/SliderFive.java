package second;

import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.* ;
public class SliderFive extends JFrame
        implements ChangeListener {
    JSlider sliderA, sliderB;
    JTextField textA, textB;
    public SliderFive() {
        setTitle( "Change Listener" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        sliderA = new JSlider( SwingConstants.HORIZONTAL, 0, 1000, 400);
        sliderA.setMajorTickSpacing( 100 );
        sliderA.setMinorTickSpacing( 50);
        sliderA.setPaintTicks( true );
        sliderA.setPaintLabels( true );
        sliderA.setPreferredSize( new Dimension(300,50)) ;
        sliderA.addChangeListener( this );
        sliderA.setName("sliderA");
        sliderA.setToolTipText ("Schieber A einstellen");
        textA = new JTextField( 4 );
        textA.setText( sliderA.getValue() + " " );
        textA.setToolTipText ("Ergebnis A");
        sliderB = new JSlider( SwingConstants.HORIZONTAL, 0, 1000, 400);
        sliderB.setMajorTickSpacing( 100 );
        sliderB.setMinorTickSpacing( 50);
        sliderB.setPaintTicks( true );
        sliderB.setPaintLabels( true );
        sliderB.setPreferredSize( new Dimension(300,50)) ;
        sliderB.addChangeListener( this );
        sliderB.setName("sliderB");
        textB = new JTextField( 4 );
        textB.setText( sliderB.getValue() + " " );
// content pane
        getContentPane().setLayout( new FlowLayout() );
        getContentPane().add( textA );
        getContentPane().add( sliderA );
        getContentPane().add( textB );
        getContentPane().add( sliderB );
        textA.setEditable (false);
        textB.setEditable (false);
    }
    public void stateChanged( ChangeEvent evt ) {
        JSlider source;
        source = (JSlider)evt.getSource();
        if ( !source.getValueIsAdjusting() && source.getName().equals("sliderA") )
            textA.setText( source.getValue() + " " );
        if ( source.getName().equals("sliderB") )
            textB.setText( source.getValue() + " " );
    }
    public static void main ( String[] args ) {
        SliderFive weightApp = new SliderFive() ;
        weightApp.setSize( 400, 150 );
        weightApp.setVisible( true );
    }
}

