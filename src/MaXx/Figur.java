package MaXx;

/**
 * @author Jan Obernberger, Kevin Goldmann, Lau Kailany, Florijan Deljija, Benno Dinsch
 * @version X, 11.01.2023
 **/
public enum Figur {
    Schwarz("B"), Weiss("W");
    private final String sign;
    private Richtung[] dir;

    Figur(String sign) {
        this.sign = sign;
        if (this.sign.equals("B")) {
            this.dir = new Richtung[]{Richtung.Nord, Richtung.Ost, Richtung.Sued, Richtung.West, Richtung.Suedwest};
        }
        if (this.sign.equals("W")) {
            this.dir = new Richtung[]{Richtung.Nord, Richtung.Ost, Richtung.Sued, Richtung.West, Richtung.Nordost};
        }
    }

    public String getSign() {
        return this.sign;
    }

    public Richtung[] getDir() {
        return dir;
    }
}
