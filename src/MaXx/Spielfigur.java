package MaXx;

/**
 * @author Jan Obernberger, Kevin Goldmann, Lau Kailany, Florijan Deljija, Benno Dinsch
 * @version X, 11.01.2023
 **/

public class Spielfigur {
    private final Figur figur;
    private int zeile;
    private int spalte;
    private Fraction punkte;



    public Spielfigur(Figur figur) {
        this.figur = figur;
        this.punkte = new Fraction(0, 0);
        if (this.figur.getSign().equals("W")) {
            this.zeile = 2;
            this.spalte = 3;
        } else if (this.figur.getSign().equals("B")) {
            this.zeile = 5;
            this.spalte = 4;
        }
    }

    public Fraction getPunkte() {
        return punkte;
    }

    public void setPunkte(Fraction f) {
        this.punkte = this.punkte.add(f);
    }

    public int getZeile() {
        return zeile;
    }

    public void setZeile(int zeile) {
        this.zeile = zeile;
    }

    public int getSpalte() {
        return spalte;
    }

    public void setSpalte(int spalte) {
        this.spalte = spalte;
    }

    public Richtung[] getDir() {
        return this.figur.getDir();
    }

    public String getSign() {
        return this.figur.getSign();
    }
}
