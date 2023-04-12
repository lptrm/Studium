package MaXxWithGUI;

/**
 * @author Jan Obernberger
 * @version X, 11.01.2023
 **/
public enum Richtung {
    Nord("N", -1, 0), Ost("O", 0, 1), Sued("S", 1, 0),
    West("W", 0, -1), Nordost("NO", -1, 1), Suedwest("SW", 1, -1);

    private final String shrt; //evtl weglassen?
    private final int zeile, spalte;

    Richtung(String shrt, int zeile, int spalte) {
        this.shrt = shrt;
        this.zeile = zeile;
        this.spalte = spalte;
    }

    public String getShrt() {
        return this.shrt;
    }

    public int getSpalte() {
        return spalte;
    }

    public int getZeile() {
        return zeile;
    }
}