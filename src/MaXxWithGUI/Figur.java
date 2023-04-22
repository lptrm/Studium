package MaXxWithGUI;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public enum Figur {
    BLACK("B"), WHITE("W");
    private final String sign;
    private Richtung[] direction;

    Figur(String sign) {
        this.sign = sign;
        if (this.sign.equals("B")) {
            this.direction = new Richtung[]{Richtung.NORTH, Richtung.EAST, Richtung.SOUTH, Richtung.WEST, Richtung.SOUTH_WEST};
        }
        if (this.sign.equals("W")) {
            this.direction = new Richtung[]{Richtung.NORTH, Richtung.EAST, Richtung.SOUTH, Richtung.WEST, Richtung.NORTH_EAST};
        }
    }
    public String getSign() {
        return this.sign;
    }

    public Richtung[] getDirection() {
        return direction;
    }
}