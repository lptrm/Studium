package iProgWS2022;
/**
 * @version 1, 15.11.2022
 * @author Jan Obernberger
 **/
enum Monat {
    //Die Klammer bedeutet, dass der Konstruktor mit diesen Attributen aufgerufen wird
    Januar (1), Februar (2), Maerz (3), April (4), Mai (5), Juni (6),
    Juli(7), August(8), September(9), Oktober(10), November(11),
    Dezember(12);
    //Instanzvariable
    private final int number;
    //Konstruktor
    Monat(int number){
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public static void main(String[] args) {
        for (Monat m : Monat.values()) {
            if (m.toString().toLowerCase().contains("m") && (m.getNumber() % 2) == 1) {
                System.out.println(m);
            }
        }
        for (Monat m : Monat.values()) {
            if (m.toString().toLowerCase().contains("b") && (m.getNumber() % 2) == 0) {
                System.out.println(m);
            }
        }
    }
}


/*
     switch (number) {
            case Januar : this.number = 1; break;
            case Februar : this.number = 1; break;
            case Maerz : this.number = 1; break;
            case April : this.number = 1; break;
            case Mai : this.number = 1; break;
            case Juni : this.number = 1; break;
            case Juli : this.number = 1; break;
            case August : this.number = 1; break;
            case September : this.number = 1; break;
            case Oktober : this.number = 1; break;
            case November : this.number = 1; break;
            case Dezember : this.number = 1; break;

        }
 */