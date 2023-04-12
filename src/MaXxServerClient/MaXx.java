package MaXxServerClient;

import java.io.IOException;

/**
 * @author Jan Obernberger, Kevin Goldmann, Lau Kailany, Florijan Deljija, Benno Dinsch
 * @version X, 11.01.2023
 **/
public class MaXx {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Spielfigur[] p = {new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
        Spielfeld spielfeld = new Spielfeld(p);
        Visualisierung visualisierung = new Visualisierung();
        Controller controller = new Controller(spielfeld, visualisierung);
        while (!controller.isEnd()) {
            controller.zug();
        }
        controller.setEnd();

    }
}
