package MaXxWithGUI;
/**
 * @version X, 11.01.2023
 * @author Jan Obernberger
 **/

import java.math.BigInteger;
import java.util.Random;

public class Spielfeld {
    private final int zeilen = 8;
    private final int spalten = 8;
    private final Fraction[][] feld;
    private final Spielfigur[] f;

    public Spielfeld(Spielfigur[] arr) {
        this.feld = new Fraction[this.zeilen][this.spalten];
        this.f = arr;

        for (int i = 0; i < this.zeilen; i++) {
            for (int j = 0; j < this.spalten; j++) {
                Random r1 = new Random();
                Random r2 = new Random();

                do {
                    this.feld[i][j] = new Fraction(new BigInteger(10, r1), new BigInteger(10, r2));
                } while (this.feld[i][j] == null || this.feld[i][j].getNumerator().compareTo(this.feld[i][j].getDenominator()) <= 0 || this.feld[i][j].getDenominator().compareTo(BigInteger.valueOf(10L)) < 0 || this.feld[i][j].getNumerator().compareTo(BigInteger.valueOf(10L)) < 0 || this.feld[i][j].getDenominator().compareTo(BigInteger.valueOf(999L)) > 0 || this.feld[i][j].getNumerator().compareTo(BigInteger.valueOf(999L)) > 0);

            }
        }
        for (Spielfigur ff : f) {
            setValue(ff.getZeile(), ff.getSpalte());
        }

    }

    public Fraction[][] getFeld() {
        return feld;
    }

    public String toString() {
        int b = 0;
        for (Fraction[] ff : this.feld) {
            for (Fraction f : ff) {
                if (b < f.toString().length() - 1) {
                    b = f.toString().length() - 1;
                }
            }
        }

        String res = "";
        for (int i = 0; i < zeilen; i++) {
            res = res.concat("[ ");
            for (int j = 0; j < spalten; j++) {
                for (int a = this.feld[i][j].toString().length() - 1; a < b; ++a) {
                    res = res.concat(" ");
                }
                if (this.feld[i][j].getNumerator().equals(BigInteger.ZERO) && this.feld[i][j].getDenominator().equals(BigInteger.ZERO)) {
                    int k = 0;
                    for (Spielfigur ff : f) {
                        if (ff.getZeile() == i && ff.getSpalte() == j) {
                            res = res.concat(ff.getSign());
                            k++;
                        }
                    }
                    while (k <= this.feld[i][j].toString().length()) {
                        res = res.concat(" ");
                        k++;
                    }
                } else {
                    res = res.concat("" + this.feld[i][j] + " ");
                }
            }

            res = res.concat(" ]\n");
        }

        return res;
    }

    public void setValue(int x, int y) {
        this.feld[x][y] = new Fraction(0, 0);
    }

    public Fraction getValue(int x, int y) {
        return this.feld[x][y];
    }

    public Spielfigur[] getF() {
        return f;
    }

    public Spielfigur getF(int i) {
        return f[i];
    }

}