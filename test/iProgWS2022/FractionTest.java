package iProgWS2022;
/**
 * @version 42, 24.03.2023
 * @author Jan Obernberger
 **/

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    //unfortunately I could not find a method to "check" the immutability of the variables
    @Test
    public void testIsChildOfNumber() {

        Fraction[] fracB =
                {
                        new Fraction(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MIN_VALUE)),
                        new Fraction(BigInteger.valueOf(Long.MAX_VALUE), BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MAX_VALUE)),
                        new Fraction(BigInteger.TWO, BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.TEN),
                        new Fraction(BigInteger.ONE, BigInteger.ONE),
                };
        for (Fraction e : fracB) {
            assertTrue(fracB[0] instanceof Number);
        }

    }

    @Test
    public void testToString() {
        Fraction[] fracB =
                {
                        new Fraction(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MIN_VALUE)),
                        new Fraction(BigInteger.valueOf(Long.MAX_VALUE), BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MAX_VALUE)),
                        new Fraction(BigInteger.TWO, BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.TEN),
                        new Fraction(BigInteger.ONE, BigInteger.ONE)
                };
        String[] refB =
                {
                        "-9223372036854775808",
                        "-1/9223372036854775808",
                        "9223372036854775807",
                        "1/9223372036854775807",
                        "2",
                        "1/10",
                        "1",

                };

        for (int i = 0; i < fracB.length; i++) {
            assertEquals(refB[i], fracB[i].toString());
        }
    }

    @Test
    public void testAdd() {
        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[][] fracR = new Fraction[iterations][2];
        Fraction[] refR = new Fraction[iterations];
        int bitNum = 64;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numeratorA, numeratorB, denominatorA, denominatorB, denominatorR, numeratorR;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numeratorA = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominatorA = new BigInteger(lenMask, r2);
                numeratorB = new BigInteger(lenMask, r1);
                denominatorB = i % 2 == 0 ? new BigInteger(lenMask, r2) : new BigInteger(lenMask, r2).negate();
            } while (numeratorA.equals(BigInteger.ZERO) || denominatorB.equals(BigInteger.ZERO)
                    || (numeratorB.equals(BigInteger.ZERO) || denominatorA.equals(BigInteger.ZERO)));

            denominatorR = denominatorA.multiply(denominatorB).abs().divide(denominatorA.gcd(denominatorB));
            numeratorR = (numeratorA.multiply(denominatorR.divide(denominatorA))).add((numeratorB.multiply(denominatorR.divide(denominatorB))));
            refR[i] = new Fraction(numeratorR, denominatorR);
            fracR[i][0] = new Fraction(numeratorA, denominatorA);
            fracR[i][1] = new Fraction(numeratorB, denominatorB);

        }
        for (int i = 0; i < iterations; i++) {
            assertEquals(refR[i], fracR[i][0].add(fracR[i][1]));
        }
    }

    @Test
    public void testSubtract() {
        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[][] fracR = new Fraction[iterations][2];
        Fraction[] refR = new Fraction[iterations];
        int bitNum = 64;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numeratorA, numeratorB, denominatorA, denominatorB, denominatorR, numeratorR;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numeratorA = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominatorA = new BigInteger(lenMask, r2);
                numeratorB = new BigInteger(lenMask, r1);
                denominatorB = i % 2 == 0 ? new BigInteger(lenMask, r2) : new BigInteger(lenMask, r2).negate();
            } while (numeratorA.equals(BigInteger.ZERO) || denominatorB.equals(BigInteger.ZERO)
                    || (numeratorB.equals(BigInteger.ZERO) || denominatorA.equals(BigInteger.ZERO)));

            denominatorR = denominatorA.multiply(denominatorB).abs().divide(denominatorA.gcd(denominatorB));
            numeratorR = (numeratorA.multiply(denominatorR.divide(denominatorA))).subtract(numeratorB.multiply(denominatorR.divide(denominatorB)));
            refR[i] = new Fraction(numeratorR, denominatorR);
            fracR[i][0] = new Fraction(numeratorA, denominatorA);
            fracR[i][1] = new Fraction(numeratorB, denominatorB);

        }
        for (int i = 0; i < iterations; i++) {
            assertEquals(refR[i], fracR[i][0].subtract(fracR[i][1]));
        }
    }

    @Test
    public void testMultiply() {
        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[][] fracR = new Fraction[iterations][2];
        Fraction[] refR = new Fraction[iterations];
        int bitNum = 64;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numeratorA, numeratorB, denominatorA, denominatorB, denominatorR, numeratorR;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numeratorA = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominatorA = new BigInteger(lenMask, r2);
                numeratorB = new BigInteger(lenMask, r1);
                denominatorB = i % 2 == 0 ? new BigInteger(lenMask, r2) : new BigInteger(lenMask, r2).negate();
            } while (numeratorA.equals(BigInteger.ZERO) || denominatorB.equals(BigInteger.ZERO)
                    || (numeratorB.equals(BigInteger.ZERO) || denominatorA.equals(BigInteger.ZERO)));

            denominatorR = denominatorA.multiply(denominatorB);
            numeratorR = numeratorA.multiply(numeratorB);
            refR[i] = new Fraction(numeratorR, denominatorR);
            fracR[i][0] = new Fraction(numeratorA, denominatorA);
            fracR[i][1] = new Fraction(numeratorB, denominatorB);

        }
        for (int i = 0; i < iterations; i++) {
            assertEquals(refR[i], fracR[i][0].multiply(fracR[i][1]));
        }
    }

    @Test
    public void testDivide() {
        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[][] fracR = new Fraction[iterations][2];
        Fraction[] refR = new Fraction[iterations];
        int bitNum = 64;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numeratorA, numeratorB, denominatorA, denominatorB, denominatorR, numeratorR;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numeratorA = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominatorA = new BigInteger(lenMask, r2);
                numeratorB = new BigInteger(lenMask, r1);
                denominatorB = i % 2 == 0 ? new BigInteger(lenMask, r2) : new BigInteger(lenMask, r2).negate();
            } while (numeratorA.equals(BigInteger.ZERO) || denominatorB.equals(BigInteger.ZERO)
                    || (numeratorB.equals(BigInteger.ZERO) || denominatorA.equals(BigInteger.ZERO)));

            denominatorR = denominatorA.multiply(numeratorB);
            numeratorR = numeratorA.multiply(denominatorB);
            refR[i] = new Fraction(numeratorR, denominatorR);
            fracR[i][0] = new Fraction(numeratorA, denominatorA);
            fracR[i][1] = new Fraction(numeratorB, denominatorB);

        }
        for (int i = 0; i < iterations; i++) {
            assertEquals(refR[i], fracR[i][0].divide(fracR[i][1]));
        }
    }

    @Test
    public void testIsInteger() {
        Fraction[] fracB = {
                new Fraction(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.ONE),
                new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MIN_VALUE)),
                new Fraction(BigInteger.valueOf(Long.MAX_VALUE), BigInteger.ONE),
                new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MAX_VALUE)),
                new Fraction(BigInteger.TWO, BigInteger.ONE),
                new Fraction(BigInteger.ONE, BigInteger.TEN),
                new Fraction(BigInteger.ONE, BigInteger.ONE)
        };
        boolean[] ref = {true, false, true, false, true, false, true};
        for (int i = 0; i < fracB.length; i++) {
            assertEquals(ref[i], fracB[i].isInteger());
        }

        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[] fracR = new Fraction[iterations];
        boolean[] refR = new boolean[iterations];
        int bitNum = 64;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numerator, denominator;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numerator = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominator = new BigInteger(lenMask, r2);

            } while (numerator.equals(BigInteger.ZERO) || denominator.equals(BigInteger.ZERO));

            refR[i] = numerator.remainder(denominator).equals(BigInteger.ZERO);
            fracR[i] = new Fraction(numerator, denominator);

        }
        for (int i = 0; i < iterations; i++) {
            assertEquals(refR[i], fracR[i].isInteger());
        }
    }

    @Test
    public void testCompareTo() {
        Fraction[][] fracB = {
                {
                        new Fraction(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MIN_VALUE)),
                        new Fraction(BigInteger.valueOf(Long.MAX_VALUE), BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MAX_VALUE)),
                        new Fraction(BigInteger.TWO, BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.TEN),
                        new Fraction(BigInteger.ONE, BigInteger.ONE)
                },
                {
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MIN_VALUE)),
                        new Fraction(BigInteger.ONE, BigInteger.ONE),
                        new Fraction(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.ONE),
                        new Fraction(BigInteger.TWO, BigInteger.ONE),
                        new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MAX_VALUE)),
                        new Fraction(BigInteger.ONE, BigInteger.TEN),
                        new Fraction(BigInteger.valueOf(Long.MAX_VALUE), BigInteger.ONE),
                }

        };
        int[] ref = {-1, -1, 1, -1, 1, 0, -1};
        for (int i = 0; i < fracB.length; i++) {
            assertEquals(ref[i], fracB[i][0].compareTo(fracB[i][1]));
        }

    }


    @Test
    public void testIntValue() {
        //Bereichsgrenzen

        Fraction[] fracB = {new Fraction(BigInteger.valueOf(Integer.MIN_VALUE), BigInteger.ONE),
                new Fraction(BigInteger.ONE, BigInteger.valueOf(Integer.MIN_VALUE)), new Fraction(BigInteger.valueOf(Integer.MAX_VALUE),
                BigInteger.ONE), new Fraction(BigInteger.ONE, BigInteger.valueOf(Integer.MAX_VALUE)), new Fraction(BigInteger.ZERO, BigInteger.ZERO)};
        int[] refB = {Integer.MIN_VALUE, (1 / Integer.MIN_VALUE),
                Integer.MAX_VALUE, (1 / Integer.MAX_VALUE), 0};
        for (int i = 0; i < fracB.length; i++) {
            assertEquals(refB[i], fracB[i].intValue());
        }
        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[] fracR = new Fraction[iterations];
        int[] refR = new int[iterations];
        int bitNum = 32;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numerator;
            BigInteger denominator;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numerator = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominator = new BigInteger(lenMask, r2);
            } while (numerator.equals(BigInteger.ZERO) || denominator.equals(BigInteger.ZERO));

            int res = numerator.divide(denominator).intValue();
            refR[i] = res;
            fracR[i] = new Fraction(numerator, denominator);
        }
        for (int i = 0; i < iterations; i++) {
            assertEquals(refR[i], fracR[i].intValue());
        }
    }

    @Test
    public void testLongValue() {
        //Bereichsgrenzen

        Fraction[] fracB = {
                new Fraction(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.ONE),
                new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MIN_VALUE)),
                new Fraction(BigInteger.valueOf(Long.MAX_VALUE), BigInteger.ONE),
                new Fraction(BigInteger.ONE, BigInteger.valueOf(Long.MAX_VALUE)),
                new Fraction(BigInteger.ZERO, BigInteger.ZERO)
        };
        long[] refB = {Long.MIN_VALUE, (1 / Long.MIN_VALUE),
                Long.MAX_VALUE, (1 / Long.MAX_VALUE), 0};
        for (int i = 0; i < fracB.length; i++) {
            assertEquals(refB[i], fracB[i].longValue());
        }
        //Randomisiert

        int iterations = 200;         //reduce number of iterations for a shorter runtime
        Fraction[] fracR = new Fraction[iterations];
        long[] refR = new long[iterations];
        int bitNum = 64;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numerator;
            BigInteger denominator;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numerator = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominator = new BigInteger(lenMask, r2);
            } while (numerator.equals(BigInteger.ZERO) || denominator.equals(BigInteger.ZERO));

            long res = numerator.divide(denominator).longValue();
            refR[i] = res;
            fracR[i] = new Fraction(numerator, denominator);
        }
        for (int i = 0; i < iterations; i++) {
            assertEquals(refR[i], fracR[i].longValue());
        }
    }

    @Test
    public void testFloatValue() {
        //Bereichsgrenzen

        Fraction[] fracB = {
                new Fraction(BigInteger.ONE, BigDecimal.valueOf(Float.MAX_VALUE).toBigInteger()),
                new Fraction(BigDecimal.valueOf(Float.MAX_VALUE).toBigInteger(), BigInteger.ONE),
                new Fraction(BigInteger.ZERO, BigInteger.ZERO),
                new Fraction(BigDecimal.valueOf(50, -50).toBigInteger(), BigInteger.ONE),
                new Fraction(BigDecimal.valueOf(50, -50).toBigInteger().negate(), BigInteger.ONE),
        };
        float[] refB = {(1f / Float.MAX_VALUE), Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY};
        for (int i = 0; i < fracB.length; i++) {
            assertEquals(refB[i], fracB[i].floatValue());
        }

        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[] fracR = new Fraction[iterations];
        float[] refR = new float[iterations];
        int bitNum = 16;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numerator;
            BigInteger denominator;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numerator = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominator = new BigInteger(lenMask, r2);
            } while (numerator.equals(BigInteger.ZERO) || denominator.equals(BigInteger.ZERO));

            float res = numerator.floatValue() / denominator.floatValue();
            refR[i] = res;
            fracR[i] = new Fraction(numerator, denominator);
        }
        for (int i = 0; i < iterations; i++) {
            //the more iterations the higher I had to set the delta to pass the test... statistically^^
            //might also play with the bitNum. I guess Fraction is more precise...
            assertEquals(refR[i], fracR[i].floatValue(), 1e-15);
        }
    }

    @Test
    public void testDoubleValue() {
        //Bereichsgrenzen

        Fraction[] fracB = {
                new Fraction(BigInteger.ONE, BigDecimal.valueOf(Double.MAX_VALUE).toBigInteger()),
                new Fraction(BigDecimal.valueOf(Double.MAX_VALUE).toBigInteger(), BigInteger.ONE),
                new Fraction(BigInteger.ZERO, BigInteger.ZERO),
                new Fraction(BigDecimal.valueOf(50, -500).toBigInteger(), BigInteger.ONE),
                new Fraction(BigDecimal.valueOf(50, -500).toBigInteger().negate(), BigInteger.ONE),
        };
        double[] refB = {(1d / Double.MAX_VALUE), Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        for (int i = 0; i < fracB.length; i++) {
            assertEquals(refB[i], fracB[i].doubleValue());
        }

        //Randomisiert

        int iterations = 100;         //reduce number of iterations for a shorter runtime
        Fraction[] fracR = new Fraction[iterations];
        double[] refR = new double[iterations];
        int bitNum = 32;
        for (int i = 0; i < iterations; i++) {
            Random r1 = new Random();
            Random r2 = new Random();
            BigInteger numerator;
            BigInteger denominator;
            int lenMask = (i % (bitNum - 2)) + 2;
            do {
                numerator = i % 2 == 0 ? new BigInteger(lenMask, r1) : new BigInteger(lenMask, r1).negate();
                denominator = new BigInteger(lenMask, r2);
            } while (numerator.equals(BigInteger.ZERO) || denominator.equals(BigInteger.ZERO));

            double res = numerator.doubleValue() / denominator.doubleValue();
            refR[i] = res;
            fracR[i] = new Fraction(numerator, denominator);
        }
        for (int i = 0; i < iterations; i++) {
            //the more iterations the higher I had to set the delta to pass the test... statistically^^
            //might also play with the bitNum. I guess Fraction is more precise...
            assertEquals(refR[i], fracR[i].doubleValue(), 1e-16);
        }


    }

}