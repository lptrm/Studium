package MaXxWithGUI;
/**
 * @author Jan Obernberger
 * @version X, 11.01.2023
 **/

public class Visualisierung {

    private static final int zeilenAussen = 8;
    private static final int spaltenAussen = 8;
    private static final int zeilenInnen = 3;
    private static final int spaltenInnen = 7;

    private static final char horizontalChar = '\u2500';
    private static final char verticalChar = '\u2502';
    private static final char verticalLeft = '\u251C';
    private static final char verticalRight = '\u2524';
    private static final char horizontalTop = '\u252C';
    private static final char horizontalBottom = '\u2534';
    private static final char cornerTopRight = '\u2510';
    private static final char cornerTopLeft = '\u250C';
    private static final char cornerBottomRight = '\u2518';
    private static final char cornerBottomLeft = '\u2514';
    private static final char node = '\u253c';
    private static final char[] emptyLine = {' ', ' ', ' ', ' ', ' ', ' ', ' '};
    public static final char[][] emptyField = {emptyLine, emptyLine, emptyLine};
    private static final char[] divisionLine = {' ', ' ', horizontalChar, horizontalChar, horizontalChar, ' ', ' '};
    private static final char[] playerLineWhite = {' ', ' ', ' ', 'W', ' ', ' ', ' '};
    private static final char[] playerLineBlack = {' ', ' ', ' ', 'B', ' ', ' ', ' '};
    private static final char[] playerLineBoth = {' ', ' ', 'W', ' ', 'B', ' ', ' '};
    private final int visuZeilen, visuSpalten;
    private final char[][][][] feld;
    private final char[][] visu;
    private Fraction[][] playground;
    private int[] posZeile, posSpalte;


    public Visualisierung() {

        this.feld = new char[zeilenAussen][spaltenAussen][zeilenInnen][spaltenInnen];
        this.visu = new char[zeilenAussen * zeilenInnen + zeilenAussen + 1][spaltenAussen * spaltenInnen + spaltenAussen + 1];
        this.visuZeilen = zeilenAussen * zeilenInnen + zeilenAussen;
        this.visuSpalten = spaltenAussen * spaltenInnen + spaltenAussen;

    }

    public void init(Spielfeld spielfeld) {
        playground = spielfeld.getFeld();
        posZeile = new int[]{spielfeld.getF(0).getZeile(), spielfeld.getF(1).getZeile()};
        posSpalte = new int[]{spielfeld.getF(0).getSpalte(), spielfeld.getF(1).getSpalte()};
        createFields();
        fillVisu();
    }

    public void update(Spielfeld spielfeld) {
        int[] posZeileOld = this.posZeile;
        int[] posSpalteOld = this.posSpalte;
        int[] posZeile = new int[]{spielfeld.getF(0).getZeile(), spielfeld.getF(1).getZeile()};
        int[] posSpalte = new int[]{spielfeld.getF(0).getSpalte(), spielfeld.getF(1).getSpalte()};
        this.posZeile = posZeile;
        this.posSpalte = posSpalte;
        int[][] changes = new int[][]{{posZeileOld[0] - posZeile[0], posSpalteOld[0] - posSpalte[0]},
                {posZeileOld[1] - posZeile[1], posSpalteOld[1] - posSpalte[1]}};

        for (int i = 0; i < changes.length; i++) {
            int[] arr = changes[i];

            if (arr[0] == 1 && arr[1] == 0) {
                //Nord
                switchFields(i, posZeileOld, posSpalteOld, posZeile, posSpalte, arr);
            } else if (arr[0] == 0 && arr[1] == -1) {
                //Ost
                switchFields(i, posZeileOld, posSpalteOld, posZeile, posSpalte, arr);
            } else if (arr[0] == -1 && arr[1] == 0) {
                //Süd
                switchFields(i, posZeileOld, posSpalteOld, posZeile, posSpalte, arr);
            } else if (arr[0] == 0 && arr[1] == 1) {
                //West
                switchFields(i, posZeileOld, posSpalteOld, posZeile, posSpalte, arr);
            } else if (arr[0] == -1 && arr[1] == 1) {
                //Südwest
                switchFields(i, posZeileOld, posSpalteOld, posZeile, posSpalte, arr);
            } else if (arr[0] == 1 && arr[1] == -1) {
                //Nordost
                switchFields(i, posZeileOld, posSpalteOld, posZeile, posSpalte, arr);

            }
        }

    }

    void switchFields(int i, int[] posZeileOld, int[] posSpalteOld, int[] posZeile, int[] posSpalte, int[] arr) {
        char[][] temp = createField(posZeile[i], posSpalte[i]);//Kreiert das neue Feld
        this.feld[posZeileOld[i] - arr[0]][posSpalteOld[i] - arr[1]] = temp;    //Beide Matrix-Inices Betrag und Subtraktion, ansonsten Out Of Bounds, wobei + Osten und Süden und nicht Betrag Norden und Westen
        if (posZeileOld[0] == posZeileOld[1] && posSpalteOld[0] == posSpalteOld[1]) {
            this.feld[posZeileOld[i]][posSpalteOld[i]] = createField(posZeileOld[i], posSpalteOld[i]);
        } else {
            this.feld[posZeileOld[i]][posSpalteOld[i]] = emptyField;
        }

        {
            for (int j = 0; j < zeilenInnen; j++) {
                for (int k = 0; k < spaltenInnen; k++) {

                    this.visu[posZeileOld[i] * (zeilenInnen + 1) + 1 + j][posSpalteOld[i] * (spaltenInnen + 1) + 1 + k] = ' ';
                    this.visu[posZeile[i] * (zeilenInnen + 1) + 1 + j][posSpalte[i] * (spaltenInnen + 1) + 1 + k] = temp[j][k];
                }


            }
            if (posZeileOld[0] == posZeileOld[1] && posSpalteOld[0] == posSpalteOld[1]) {
                System.arraycopy(getPlayerLine(posZeileOld[0], posSpalteOld[0]), 0, this.visu[posZeileOld[i] * (zeilenInnen + 1) + 2], posSpalteOld[i] * (spaltenInnen + 1) + 1, spaltenInnen);
            }
        }
    }

    void createFields() {
        for (int zeileAussenIterator = 0; zeileAussenIterator < zeilenAussen; zeileAussenIterator++) {               //Schleife für Zeilen der äußeren Matrix
            char[][][] zeileAussen = this.feld[zeileAussenIterator];                                               //Aktuelle Zeile der 8x8 Matrix aus 5x5 Matritzen
            for (int spalteAussenIterator = 0; spalteAussenIterator < spaltenAussen; spalteAussenIterator++) {      //Schleife für die Spalten der äußeren Matrix
                zeileAussen[spalteAussenIterator] = createField(zeileAussenIterator, spalteAussenIterator);                 //Spaltenelement der 8x8 Matrix = 5x5 Matrix, für einen Bruch

            }
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : this.visu) {
            sb.append(row);
            sb.append("\n");
        }
        return sb.toString();
    }

    void fillVisu() {
        int[] matrixVector = {0, 0};
        int matrixSpalteH = 0;
        int feldZeile = 0;
        boolean zeilenSprung = true;
        for (int i = 0; i < this.visu.length; i++) {
            char[] row = this.visu[i];
            for (int j = 0; j < row.length; j++) {
                if (i % (zeilenInnen + 1) == 0 && j % (spaltenInnen + 1) == 0) {
                    if (i == 0 && j == 0) {
                        row[j] = cornerTopLeft;
                    } else if (i == 0 && j == visuSpalten) {
                        row[j] = cornerTopRight;
                    } else if (i == visuZeilen && j == 0) {
                        row[j] = cornerBottomLeft;
                    } else if (i == visuZeilen && j == visuSpalten) {
                        row[j] = cornerBottomRight;
                    } else if (i == 0) {
                        row[j] = horizontalTop;
                    } else if (i == visuZeilen) {
                        row[j] = horizontalBottom;
                    } else if (j == 0) {
                        row[j] = verticalLeft;
                    } else if (j == visuSpalten) {
                        row[j] = verticalRight;
                    } else
                        row[j] = node;
                } else if (i % (zeilenInnen + 1) == 0) {
                    row[j] = horizontalChar;
                } else if (j % (spaltenInnen + 1) == 0) {
                    row[j] = verticalChar;
                } else {
                    System.arraycopy(this.feld[matrixVector[0]][matrixVector[1]][feldZeile], 0, this.visu[i], j, spaltenInnen);
                    if (matrixVector[1] >= 7) {
                        matrixVector[1] = 0;
                        matrixSpalteH++;
                        feldZeile++;
                        zeilenSprung = false;
                    }
                    if (matrixSpalteH == zeilenInnen) {
                        matrixSpalteH = 0;
                        matrixVector[0]++;
                    }
                    if (feldZeile == zeilenInnen) {
                        feldZeile = 0;
                    }
                    if (zeilenSprung) {
                        matrixVector[1]++;
                    } else {
                        zeilenSprung = true;
                    }
                    j += spaltenInnen - 1;

                }
            }
        }
    }


    char[][] createField(int zeile, int spalte) {
        char[][] field = new char[zeilenInnen][spaltenInnen];
        boolean hasPlayer = this.posZeile[0] == zeile && this.posSpalte[0] == spalte || this.posZeile[1] == zeile && this.posSpalte[1] == spalte;
        for (int zeilenIterator = 0; zeilenIterator < zeilenInnen; zeilenIterator++) {
            if (!hasPlayer) {
                field[zeilenIterator] = switch (zeilenIterator) {
                    case 0 -> getFractionValue(zeile, spalte, 0);
                    case 1 -> divisionLine;
                    case 2 -> getFractionValue(zeile, spalte, 1);
                    default -> throw new IllegalStateException("Unexpected value: " + zeilenIterator);
                };
            } else {
                field[zeilenIterator] = switch (zeilenIterator) {
                    case 0, 2 -> emptyLine;
                    case 1 -> getPlayerLine(zeile, spalte);
                    default -> throw new IllegalStateException("Unexpected value: " + zeilenIterator);
                };
            }

        }
        return field;
    }

    char[] getPlayerLine(int zeile, int spalte) {
        if (this.posZeile[0] == this.posZeile[1] && this.posSpalte[0] == this.posSpalte[1]) {
            return playerLineBoth;
        } else if (this.posZeile[0] == zeile && this.posSpalte[0] == spalte) {
            return playerLineWhite;
        } else if (this.posZeile[1] == zeile && this.posSpalte[1] == spalte) {
            return playerLineBlack;
        } else {
            throw new IllegalStateException("Unexpected value: " + zeile + " " + spalte);
        }
    }

    char[] getFractionValue(int zeile, int spalte, int layer) {
        Fraction fraction = playground[zeile][spalte];
        String[] arr = fraction.toString().equals("NaN") ? new String[]{"0", "0"} : fraction.toString().split("/");
        String res = "  ";
        for (int i = arr[layer].length(); i < 3; i++) {
            res = res.concat(" ");

        }
        res = res.concat(arr[layer]);
        res = res.concat("  ");
        return res.toCharArray();

    }

}