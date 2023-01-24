package iProgWS2022;

public class Table {
    public static void main(String[] args) {
    /*
        int[] arr = {0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1};
        int[] arr2 = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        int[] arr3 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0};
         */
        int[] arr = {0, 0, 0, 1};
        Table taple = new Table(2, arr);
        System.out.println(taple.toString());
        System.out.println(taple.dnf());
    }

    //Instanzvariablen
    private final int eingaenge, ausgaenge;
    private int zeilen, spalten;
    private boolean[][] feld;
    //Konstruktor
    Table(int eingaenge, int[] ... ausgaenge) {
        this.eingaenge = eingaenge;
        this.ausgaenge = ausgaenge.length;
        zeilen = 1 << eingaenge;
        spalten = eingaenge + ausgaenge.length;
        feld = new boolean[zeilen][spalten];
        //Schleife für Spalten
        for(int i = 0; i <= eingaenge -1; i++) {
            //Schleife für Zeilen
            for (int l = 0; l < zeilen; l += (1<<i)){
                if (l % (1<<i+1) == (1<<i)) {
                    //Schleife für die jeweilige Anzahl an 1en
                    for (int m = 0; m < (1 << i); m++) {
                        feld[m + l][eingaenge-1-i] = true;
                    }
                }
            }
        }
        for(int i = 0; i < ausgaenge.length; i++){
            for (int l = 0; l < zeilen; l++){
                if (ausgaenge[i][l] >= 1){
                    feld[l][eingaenge+i] = true;
                } else{
                    feld[l][eingaenge+i] = false;
                }
            }
        }
    }
    public String dnf() {
        String res = "";
        int[][] arr = new int[ausgaenge][zeilen];
        for (int i = 0; i < this.ausgaenge; i++){
            for (int j = 0; j < this.zeilen; j++){
                if (this.feld[j][eingaenge+i]) {
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = 0;
                }
            }
        }
        Table[] res2 = new Table[this.ausgaenge];
        for (int i = 0; i < this.ausgaenge; i++) {
            res2[i] = new Table(this.eingaenge, arr[i]);
        }
        int c = 1;
        for (Table t : res2) {
            String or = " || ";
            res = res.concat("Die DNF von Ausgang " + c++ + " ist : ");
            for (boolean[] b : t.feld) {

                if (b[b.length-1]) {
                    for (int i = 0; i < b.length-1; i++) {
                        if (i < b.length -2){
                            if (b[i]) res = res.concat((i+1) + " && ");
                            else res = res.concat("!" + (i+1) + " && ");
                        } else {
                            if (b[i]) res = res.concat((i+1) + "");
                            else res = res.concat("!" + (i + 1) + "");
                        }
                    }
                    res = res.concat(or);
                }

            }
            res = res.substring(0, res.length()-or.length());
            res = res.concat("\n");
        }
        return res;
    }
    public Table addOut(int ... arr){
        return new Table(this.eingaenge, arr);
    }
    public String toString(){
        String res = "";
        //Schleife für durchlauf durch das äußere Array
        for (boolean[] b : this.feld) {
            //An resultierenden String wird "[" angefügt
            res = res.concat("[ ");
            //Schleife für Durchlauf durch das innere Array
            for (int i = 0; i <= b.length -1; i++)  {
                if (b[i]) {
                    res = res.concat("1");
                } else {
                    res = res.concat("0");
                }
                if (i == eingaenge-1 ) res = res.concat(" |");

                res = res.concat(" ");
            }
            res = res.concat("]\n");
        }
        return res;
    }
    public void setValue(int i, int j, boolean x) {
        this.feld[i][j] = x;
    }
    public boolean getValue(int i, int j) {
        return this.feld[i][j];
    }
}

