package iProgWS2022;

import org.junit.jupiter.api.Test;
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
        var frac = new Fraction(1,2);
        assertEquals(0, frac.intValue());

        frac = new Fraction(1, 1);
        assertEquals(1, frac.intValue());
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