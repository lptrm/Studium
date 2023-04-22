package MaXxWithGUI;

/**
 * @author Jan Obernberger
 * @version X, 11.01.2023
 **/

public class Spielfigur {
    private final Figur figur;
    private int row;
    private int column;
    private Fraction points = new Fraction(0,0);


    public Spielfigur(Figur figur) {
        this.figur = figur;
        row = this.figur == Figur.WHITE ? 2 : 5;
        column = this.figur == Figur.WHITE ? 3 : 4;
    }
    @Override
    public String toString() {
        return figur.getSign();
    }

    public Fraction getPoints() {
        return points;
    }

    public void setPoints(Fraction f) {
        this.points = this.points.add(f);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getSign() {
        return this.figur.getSign();
    }
}