package MaXxWithGUI;

/**
 * @author Jan Obernberger
 * @version X, 11.01.2023
 **/
public class MaXx {
    public static void main(String[] args) {
        Spielfigur[] p = {new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
        Spielfeld spielfeld = new Spielfeld(p);
        Visualisierung visualisierung = new Visualisierung();
        Controller controller = new Controller(spielfeld, visualisierung);

    }
}