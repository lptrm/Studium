package iProgWS2022;
/**
 * @version 1, 14.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

//ToDo: Methoden kommentieren
//Da immutable, keine Setter-Methoden
public class Fraction extends Number implements Comparable<Fraction> {
    public static final Fraction NaN = new Fraction(0, 0);
    protected BigInteger numerator;
    protected BigInteger denominator;


    public Fraction(BigInteger n, BigInteger d){
        numerator = n;
        denominator = d;
        switch (denominator.signum()) {
            case 0 : numerator = BigInteger.ZERO; break;
            case -1 :
                numerator = numerator.negate();
                denominator = denominator.negate();

            case 1 :
                BigInteger temp = numerator.gcd(denominator);
                numerator = numerator.divide(temp);
                denominator = denominator.divide(temp);
                break;
        }
    }
    public Fraction(long zaehler, long nenner){
        this(BigInteger.valueOf(zaehler), BigInteger.valueOf(nenner));
    }
    public Fraction(String zaehler, String nenner){
                  this(Fraction.stringTest(zaehler), Fraction.stringTest(nenner));
    }
    public static Long stringTest(String s){
        long res;
        try {
            res = Long.parseLong(s);
        } catch (Exception e){
            System.out.println(e + " Fehler beim konvertieren von String zu Long\n" +
                    "Wert auf 0 gesetzt");
            res = 0;
        }
        return res;
    }
    public String toString(){
        String res = "";
        if (this.equals(NaN)){
            //Double und Float haben eine interne codierung für NaN
            //Anschauen
            res += "NaN";
        } else if (this.denominator.equals(BigInteger.ONE)){
            res += this.numerator;
        } else {
            res += this.numerator + "/" + this.denominator;
        }
        return res;
    }
    public BigInteger getNumerator(){
        return numerator;
    }    public BigInteger getDenominator(){
        return denominator;
    }
    public Fraction add(Fraction r){
        if (this.equals(NaN) && !r.equals(NaN)){
            return r;
        }
        if (!this.equals(NaN) && r.equals(NaN)){
            return this;
        }
        if (this.equals(NaN) && r.equals(NaN)){
            return NaN;
        }
        BigInteger kgV = this.denominator.multiply(r.denominator).divide(this.denominator.gcd(r.denominator));
        BigInteger tempA = this.numerator.multiply(kgV.divide(this.denominator));
        BigInteger tempB = r.numerator.multiply(kgV.divide(r.denominator));
        BigInteger tempZ = tempA.add(tempB);
        return new Fraction (tempZ, kgV);
    }    public Fraction subtract(Fraction r){
        if (this.equals(NaN) && !r.equals(NaN)){
            return r;
        }
        if (!this.equals(NaN) && r.equals(NaN)){
            return this;
        }
        if (this.equals(NaN) && r.equals(NaN)){
            return NaN;
        }
        BigInteger kgV = this.denominator.multiply(r.denominator).divide(this.denominator.gcd(r.denominator));
        BigInteger tempA = this.numerator.multiply(kgV.divide(this.denominator));
        BigInteger tempB = r.numerator.multiply(kgV.divide(r.denominator));
        BigInteger tempZ = tempA.subtract(tempB);
        return new Fraction (tempZ, kgV);
    }
    public Fraction multiply(Fraction r){
        return new Fraction(this.numerator.multiply(r.numerator),this.denominator.multiply(r.denominator));
    }
    public Fraction divide(Fraction r){
        return new Fraction(this.numerator.multiply(r.denominator), this.denominator.multiply(r.numerator));
    }
    public boolean isInteger(){
        if (this.equals(NaN))
            return false;
        BigInteger res = this.numerator.remainder(this.denominator);
        return res.equals(BigInteger.ZERO);
    }

    @Override
    public int compareTo(Fraction other) {
        if (this.equals(NaN) && other.equals(NaN)){
            return 0;
        } else if (this.equals(NaN)) {
            return 1;
        } else if (other.equals(NaN)) {
            return -1;
        }
        return this.numerator.multiply(other.denominator).compareTo(other.numerator.multiply(this.denominator));
    }

    @Override
    public int intValue() {
        return Double.valueOf(doubleValue()).intValue();
    }

    @Override
    public long longValue() {
        return Double.valueOf(doubleValue()).longValue();
    }

    @Override
    public float floatValue() {
        return Double.valueOf(doubleValue()).floatValue();
    }

    @Override
    public double doubleValue() {
        return this.numerator.doubleValue() / this.denominator.doubleValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator.equals(fraction.numerator) && denominator.equals(fraction.denominator);
    }
}

