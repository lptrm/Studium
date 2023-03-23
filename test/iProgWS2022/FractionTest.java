package iProgWS2022;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
    //TODO: Ist Subklasse von Number? Ist Immutable? Hat BigIntegerInZählerUndNenner?
/*
    @Test
    public void testToString() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testSubtract() {
    }

    @Test
    public void testMultiply() {
    }

    @Test
    public void testDivide() {
    }

    @Test
    public void testIsInteger() {
    }

    @Test
    public void testCompareTo() {
    }

 */

    @Test
    public void testIntValue() {
        //Bereichsgrenzen
        Fraction[] fracB = { new Fraction(BigInteger.ONE,BigInteger.TWO), new Fraction(BigInteger.valueOf(Integer.MIN_VALUE),BigInteger.ONE),
        new Fraction(BigInteger.valueOf(Integer.MAX_VALUE), BigInteger.ONE), new Fraction(BigInteger.ZERO, BigInteger.ZERO)};
        //Randomisiert
        Fraction[] fracR = new Fraction[100];
        int[] refR = new int[100];
        int i = 0;
        do {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numerator = i % 2 == 0 ? new BigInteger(31, r1) : new BigInteger(31, r1).negate();
            BigInteger denominator = new BigInteger(31, r2);
            int res = numerator.divide(denominator).intValue();
            refR[i] = res;
            fracR[i++] = new Fraction(numerator, denominator);
        } while (i < 100);
        i = 0;
        do {
            assertEquals(refR[i], fracR[i++].intValue());
        } while (i < 100);
        //assertEquals(0, frac.intValue());

        //frac = new Fraction(1, 1);
        //assertEquals(1, frac.intValue());
    }
/*
    @Test
    public void testLongValue() {
    }

    @Test
    public void testFloatValue() {
    }

    @Test
    public void testDoubleValue() {
    }

 */
}