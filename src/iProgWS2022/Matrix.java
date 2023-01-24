package iProgWS2022;
/**
 * @version 1, 15.11.2022
 * @author Jan Obernberger
 **/
public class Matrix implements SimpleTreeNode {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        Matrix matrix1 = new Matrix(m, n);
        matrix1.setValue(1, 2, 1);
        matrix1.setValue(2, 3, 1);
        matrix1.setValue(3, 4, 1);
        matrix1.setValue(4, 5, 1);
        matrix1.setValue(5, 6, 1);
        matrix1.setValue(6, 6, 1);
        matrix1.setValue(6, 6, 2);
        matrix1.setValue(6, 3, -1);
        matrix1.setValue(4, 1, 1);
        matrix1.print("Die Matrix ist: ");
        Matrix[] matrix = new Matrix[19];
        matrix[0] = matrix1.multiply(matrix1);
        matrix[0].print("Die 1. Matrixpotenz ist: ");
        for (int i = 0; i < 18; i++) {
            matrix[i + 1] = matrix[i].multiply(matrix1);
            matrix[i + 1].print("Die " + (i + 2) + ". Matrixpotenz M^" + (i + 3) + " ist: ");
        }
        System.out.println("...\n" +
                "Das war die multiply Methode.\n" +
                "Lass uns nun nochmal die Klasse testen\n" +
                "Hierzu werde ich eine Matrix mit 6 Zeilen und 6 Spalten\n" +
                "mit ihren Defaultwerten (0.0) initialisieren.");
        Matrix matrix2 = new Matrix(6, 6);
        System.out.println("...\n" +
                "Das hat geklappt, sehr schön.\n" +
                "Lass mich nun das erste Element der Matrix\n" +
                "mit der setValue Methode auf den Wert 1.0 setzen.");
        matrix2.setValue(1, 1, 1.0);
        System.out.println("...\n" +
                "Das hat geklappt, sehr schön.\n" +
                "Lass mich nun das erste Element der Matrix\n" +
                "mit der getValue Methode abfragen.");
        System.out.println(matrix2.getValue(1, 1));
        System.out.println("...\n" +
                "Das hat geklappt, sehr schön.\n" +
                "Lass mich nun die eben erstellte Matrix\n" +
                "zu unserer allerersten Matrix addieren.");
        Matrix matrix3 = matrix1.add(matrix2);
        System.out.println("...\n" +
                "Das hat geklappt, sehr schön.\n" +
                "Lass mich nun die eben erstellte Matrix\n" +
                "mit der toString Methode in einen String\n" +
                "überführen und dann ausgeben.");
        System.out.printf(matrix3.toString());
        System.out.printf("...\n" +
                "Das hat geklappt, sehr schön.\n" +
                "Der erste Wert der ersten Matrix war " +
                matrix1.getValue(1, 1) +
                "\n" +
                "Der erste Wert der zweiten Matrix war " +
                matrix2.getValue(1, 1) +
                "\n" +
                "Der erste Wert der dritten Matrix ist " +
                matrix3.getValue(1, 1));
    }

    //Instanzvariablen
    final int zeilen;
    final int spalten;
    private final double[][] feld;

    //Konstruktor
    Matrix(int m, int n) {
        zeilen = m;
        spalten = n;
        feld = new double[zeilen][spalten];
    }

    public void print(String s) {
        System.out.println(s);
        System.out.println(this);
    }

    public String toString() {
        //Buffervariable b wird mit Wert 0 initialisiert
        int b = 0;
        //Schleife zum finden des größten Elementes für den Buffer
        for (double[] d : this.feld) {
            for (double dd : d) {
                //Variable a wird der länge des String der die Doublezahl repräsentiert zugewiesen
                int a = Double.toString(dd).length();
                //Wenn aktuelles Element größer als Buffer entspricht der Buffer dem aktuellen Element
                if (b < a) b = a;
            }
        }
        //Initialisierung des resultierenden Strings
        String res = "";
        //Schleife für durchlauf durch das äußere Array
        for (double[] d : this.feld) {
            //An resultierenden String wird "[" angefügt
            res = res.concat("[");
            //Schleife für Durchlauf durch das innere Array
            for (double dd : d) {
                //Variable a mit dem Wert der Länge der String-Repräsentation des aktuellen Elementes
                int a = Double.toString(dd).length();
                //Schleife für Anfügen von Leerzeichen vor dem Element
                while (a < b) {
                    res = res.concat(" ");
                    a++;
                }
                //Hinzufügen des aktuellen Array-Elemntes zum resultierenden String
                res = res.concat(Double.toString(dd));
                res = res.concat(" ");
            }
            res = res.concat("]\n");
        }
        return res;
    }

    public void setValue(int i, int j, double x) {
        this.feld[i-1][j-1] = x;
    }

    public double getValue(int i, int j) {
        return this.feld[i-1][j-1];
    }

    public Matrix add(Matrix other) {
        if (this.zeilen == other.zeilen && this.spalten == other.spalten) {
            Matrix res = new Matrix(other.zeilen, other.spalten);
            for (int i = 0; i < res.zeilen; i++) {
                for (int j = 0; j < res.spalten; j++) {
                    res.setValue(i, j, this.getValue(i, j) + other.getValue(i, j));
                }
            }
            return res;
        } else {
            return null;
        }
    }

    public Matrix multiply(Matrix m) {
        Matrix res = null;
        if (this.zeilen == m.spalten) {
            //Resultierende Matrix
            res = new Matrix(this.zeilen, m.spalten);
            //Iterator für resultierende Zeile
            for (int i = 0; i < res.zeilen; i++) {
                //Iterator für resultierende Spalte
                for (int j = 0; j < res.spalten; j++) {
                    //Iterator für Berechnung der resultierenden Zelle
                    for (int k = 0; k < this.spalten; k++) {
                        //https://de.wikipedia.org/wiki/Matrizenmultiplikation
                        //Da wir innerhalt der Klasse sind, können wir die privaten Variablen so verändern
                        //Von außerhalb der Klasse gäbe es lediglich getter und setter als Schnittstelle
                        res.feld[i][j] += this.feld[i][k] * m.feld[k][j];
                    }

                }

            }
        }
        return res;
    }

    @Override
    public void addChild(SimpleTreeNode child) {

    }

    @Override
    public int getChildCnt() {
        return 0;
    }

    @Override
    public SimpleTreeNode getChild(int pos) {
        return null;
    }
}
