package MaXxWithGUI;


import java.math.BigInteger;
import java.util.Random;

/**
 * @author Timo Kerber, Marcel Illenseer, Jan Obernberger
 * @version 4.20, 19.04.2023
 **/
public class Spielfeld {
    private final Fraction[][] fields = new Fraction[8][8];
    private final Spielfigur[] figures;

    public Spielfeld(Spielfigur[] arr) {
        this.figures = arr;
        Random r1 = new Random();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                do {
                    this.fields[i][j] = new Fraction(new BigInteger(10, r1), new BigInteger(10, r1));
                } while (
                        this.fields[i][j] == null
                        || this.fields[i][j].getNumerator().compareTo(this.fields[i][j].getDenominator()) <= 0
                        || this.fields[i][j].getDenominator().compareTo(BigInteger.valueOf(10L)) < 0
                        || this.fields[i][j].getNumerator().compareTo(BigInteger.valueOf(10L)) < 0
                        || this.fields[i][j].getDenominator().compareTo(BigInteger.valueOf(999L)) > 0
                        || this.fields[i][j].getNumerator().compareTo(BigInteger.valueOf(999L)) > 0);
            }
        }
        for (Spielfigur figur : figures) {
            setValue(figur.getRow(), figur.getColumn());
        }

    }

    public Fraction[][] getFields() {
        return fields;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iRow = 0, iColumn = 0;
        for (var row: fields) {
            sb.append("[ ");
            for (var column: row) {
                StringBuilder content = new StringBuilder();
                if(!column.equals(Fraction.NaN)){
                    content.append(column);
                }
                for(var figure : figures){
                    if(figure.getRow()==iRow && figure.getColumn()==iColumn) content.append(figure).append("  ");
                }
                sb.append(String.format("%1$8s", content));
                iColumn = ++iColumn % 8;
            }
            sb.append(" ]\n");
            iRow ++;
        }
        return sb.toString();
    }

    public void setValue(int x, int y) {
        this.fields[x][y] = new Fraction(0, 0);
    }

    public Fraction getFields(int x, int y) {
        return this.fields[x][y];
    }

    public Spielfigur[] getFigures() {
        return figures;
    }

}