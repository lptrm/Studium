package training;

import MaXx.*;

import java.io.IOException;
import java.util.ArrayList;

public class MaXxGraph {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Spielfigur[] p = {new Spielfigur(Figur.Weiss), new Spielfigur(Figur.Schwarz)};
        Spielfeld spielfeld = new Spielfeld(p);
        System.out.println(spielfeld);
        ArrayList<MaXxNodeWrapper> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (Fraction[] ff:
             spielfeld.getFeld()) {
            for (Fraction e:
                 ff) {
                list.add(new MaXxNodeWrapper(new Node(e.toString()), e));
                j++;
            }
            i++;
        }
        list.forEach(System.out::println);
    }
}
