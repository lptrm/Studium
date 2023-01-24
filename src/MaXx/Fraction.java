package MaXx; /**
 * @author Jan Obernberger, Kevin Goldmann, Lau Kailany, Florijan Deljija, Benno Dinsch
 * @version X, 11.01.2023
 **/

import java.math.BigInteger;
import java.util.Objects;

public class Fraction extends Number implements Comparable<Fraction> {
    protected BigInteger zaehler;
    protected BigInteger nenner;


    public Fraction(BigInteger n, BigInteger d) {
        zaehler = n;
        nenner = d;
        switch (nenner.signum()) {
            case 0:
                zaehler = BigInteger.ZERO;
                break;
            case -1:
                zaehler = zaehler.negate();
                nenner = nenner.negate();

            case 1:
                BigInteger temp = zaehler.gcd(nenner);
                zaehler = zaehler.divide(temp);
                nenner = nenner.divide(temp);
                break;
        }
    }

    public Fraction(long zaehler, long nenner) {
        this(BigInteger.valueOf(zaehler), BigInteger.valueOf(nenner));
    }

    public Fraction(String zaehler, String nenner) {
        this(Fraction.stringTest(zaehler), Fraction.stringTest(nenner));
    }

    public static Long stringTest(String s) {
        long res;
        try {
            res = Long.parseLong(s);
        } catch (Exception e) {
            System.out.println(e + " Fehler beim konvertieren von String zu Long\n" +
                    "Wert auf 0 gesetzt");
            res = 0;
        }
        return res;
    }

    public String toString() {
        String res = "";
        if (this.nenner.equals(BigInteger.ZERO)) {
            res += "NaN";
        } else if (this.nenner.equals(BigInteger.ONE)) {
            res += this.zaehler;
        } else {
            res += this.zaehler + "/" + this.nenner;
        }
        return res;
    }

    public BigInteger getNumerator() {
        return zaehler;
    }

    public BigInteger getDenominator() {
        return nenner;
    }

    public Fraction add(Fraction r) {
        if (this.zaehler.equals(BigInteger.ZERO) && !r.zaehler.equals(BigInteger.ZERO)) {
            return r;
        }
        if (!this.zaehler.equals(BigInteger.ZERO) && r.zaehler.equals(BigInteger.ZERO)) {
            return this;
        }
        if (this.zaehler.equals(BigInteger.ZERO) && r.zaehler.equals(BigInteger.ZERO)) {
            return null;
        }
        BigInteger kgV = this.nenner.multiply(r.nenner).divide(this.nenner.gcd(r.nenner));
        BigInteger tempA = this.zaehler.multiply(kgV.divide(this.nenner));
        BigInteger tempB = r.zaehler.multiply(kgV.divide(r.nenner));
        BigInteger tempZ = tempA.add(tempB);
        return new Fraction(tempZ, kgV);
    }

    public Fraction subtract(Fraction r) {
        BigInteger kgV = this.nenner.multiply(r.nenner).divide(this.nenner.gcd(r.nenner));
        BigInteger tempA = this.zaehler.multiply(kgV.divide(this.nenner));
        BigInteger tempB = r.zaehler.multiply(kgV.divide(r.nenner));
        BigInteger tempZ = tempA.subtract(tempB);
        return new Fraction(tempZ, kgV);
    }

    public Fraction multiply(Fraction r) {
        return new Fraction(this.zaehler.multiply(r.zaehler), this.nenner.multiply(r.nenner));
    }

    public Fraction divide(Fraction r) {
        return new Fraction(this.zaehler.multiply(r.nenner), this.nenner.multiply(r.zaehler));
    }

    public boolean isInteger() {
        if (this.zaehler.equals(BigInteger.ZERO) || this.nenner.equals(BigInteger.ZERO))
            return false;
        BigInteger res = this.zaehler.remainder(this.nenner);
        return res.equals(BigInteger.ZERO);
    }

    @Override
    public int compareTo(Fraction other) {
        if (this.zaehler.equals(BigInteger.ZERO) && other.zaehler.equals(BigInteger.ZERO)) {
            return 0;
        } else if (this.zaehler.equals(BigInteger.ZERO)) {
            return 1;
        } else if (other.zaehler.equals(BigInteger.ZERO)) {
            return -1;
        }
        return this.zaehler.multiply(other.nenner).compareTo(other.zaehler.multiply(this.nenner));
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
        return this.zaehler.doubleValue() / this.nenner.doubleValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(zaehler, nenner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return zaehler.equals(fraction.zaehler) && nenner.equals(fraction.nenner);
    }
}

