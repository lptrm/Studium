package second;

import java.util.*;
public class TestBitSet2 {
    public static void main (String[] args) {
        int max = 2000000000;
        BitSet large = new BitSet();
        large.set (0);
        large.set (max);
        System.out.println ("large set: "+large);
    }
}

