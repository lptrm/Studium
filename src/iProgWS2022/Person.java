package iProgWS2022;
/**
 * @version 0.66, 08.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/


import java.util.Calendar;
import java.util.GregorianCalendar;


public class Person implements Comparable<Person>, Cloneable, SimpleTreeNode{
    public static void main(String[] args) {
        System.out.println("Lass uns die Klasse Testen.");
        System.out.println("Hierzu werde ich ein paar Objekte erzeugen.");
        Person[] personen = {
                new Person("Alex", "Lustig", "Instandhalter", "Heilbronn", 2000, 1.80),
                new Person("Sven", "Lustig", "Verkäufer", "Köln", 1992, 1.81),
                new Person("Dagmar", "Lustig", "Goldschmied", "Heilbronn", 1960, 1.65),
                new Person("Susanne", "Böse", "Consultant", "Heilbronn", 1976, 1.54),
                new Person("Friedrich", "Böse", "Influencer", "Heilbronn", 2002, 1.83),
                new Person("Vitali", "Böse", "Profiboxer", "Moskau", 1984, 1.85),
                new Person("Yusuf", "Böse", "Kamelzüchter", "Istanbul", 1999, 1.73)};

        for (Person person : personen) {
            System.out.println(person);
        }
        System.out.println("Lass mich jetzt Verwandtschaftbeziehungen erstellen");
        personen[2].addChild(personen[1]);
        System.out.println("Jetzt ist " + personen[1].vorname + " Ein Kind von " + personen[2].vorname);
        personen[2].addChild(personen[3]);
        System.out.println("Jetzt ist " + personen[3].vorname + " Ein Kind von " + personen[2].vorname);
        personen[3].addChild(personen[0]);
        System.out.println("Jetzt ist " + personen[0].vorname + " Ein Kind von " + personen[3].vorname);
        personen[5].addChild(personen[0]);
        System.out.println("Jetzt ist " + personen[0].vorname + " Ein Kind von " + personen[5].vorname);
        personen[5].addChild(personen[6]);
        System.out.println("Jetzt ist " + personen[6].vorname + " Ein Kind von " + personen[1].vorname);
        personen[5].addChild(personen[4]);
        System.out.println("Jetzt ist " + personen[4].vorname + " Ein Kind von " + personen[5].vorname);
        System.out.println("Lass mich nun eine Person klonen...");
        Person p = personen[2].clone();
        System.out.println("Sehr schön, nun lass uns überprüfen, ob das geklappt hat? ");
        System.out.println("Die geklonte Person ist\n" + p);
        System.out.println(" ihre kinder sind ");
        for(int i = 0; i < p.getChildCnt(); i++){
            System.out.println(p.getChild(i));
        }
    }

    private final String vorname;
    private final String name;
    private final String beruf;
    private final String geburtsort;
    private final int geburtsjahr;
    private final double hoehe;
    //Hier wird über DefaultTreeNode delegiert, womit die Methoden hieraus nutzbar sind
    private DefaultTreeNode node;

    public Person(String vorname, String name, String beruf, String geburtsort, int geburtsjahr, double hoehe) {
        this.vorname = vorname;
        this.name = name;
        this.beruf = beruf;
        this.geburtsort = geburtsort;
        this.geburtsjahr = geburtsjahr;
        this.hoehe = hoehe;
        this.node = new DefaultTreeNode(name);
    }

    public Person() {
        MyIO.writeln("Trage in den folgenden Zelen die Daten der Person ein");
        this.vorname = MyIO.promptAndRead("Gib mir den Vornamen der Person: ");
        this.name = MyIO.promptAndRead("Gib mir den Nachnahmen der Person: ");
        this.beruf = MyIO.promptAndRead("Gib mir den Beruf der Person: ");
        this.geburtsort = MyIO.promptAndRead("Gib mir den Geburtsort der Person: ");
        this.geburtsjahr = MyIO.readInt("Gib mir das Geburtsjahr der Person: ");
        this.hoehe = MyIO.readFlt("Gib mir die Körpergröße der Person:");
    }



    public String toString() {

        int age = new GregorianCalendar().get(Calendar.YEAR) - geburtsjahr;
        String s;
        if (hoehe <= 1.48) {
            s = "klein";
        } else if (hoehe <= 1.82) {
            s = "mittel";
        } else {
            s = "groß";
        }
        return "[" + vorname + ", " + name + ", " + beruf + ", " + geburtsort + ", " + geburtsjahr + "(" + age + "j), "
                + hoehe + "m(" + s + ")]";

    }

    public void compareWith(Person a) {
        if (this.hoehe == a.hoehe) {
            MyIO.writeln("Beide sind gleich groß: " + this.hoehe);
        } else if (this.hoehe <= a.hoehe) {
            MyIO.writeln(a.name + " ist " + (a.hoehe - this.hoehe) + " größer als " + this.name);
        } else {
            MyIO.writeln(this.name + " ist " + (this.hoehe - a.hoehe) + " größer als " + a.name);
        }
        if (this.geburtsjahr == a.geburtsjahr) {
            MyIO.writeln("Beide sind gleich alt: " + (new GregorianCalendar().get(Calendar.YEAR) - geburtsjahr));
        } else if (this.geburtsjahr <= a.geburtsjahr) {
            MyIO.writeln(this.name + " ist " + (a.geburtsjahr - this.geburtsjahr) + " älter als " + a.name);
        } else {
            MyIO.writeln(a.name + " ist " + (this.geburtsjahr - a.geburtsjahr) + " älter als " + this.name);
        }
    }

    @Override
    public void addChild(SimpleTreeNode child) {
        node.addChild(child);
    }

    @Override
    public int getChildCnt() {
        return this.node.getChildCnt();
    }

    @Override
    public SimpleTreeNode getChild(int pos) {
        return this.node.getChild(pos);
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public Person clone() {
        try {
            Person clone = (Person) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
