package cz.educanet;

import java.util.ArrayList;

public class MathUtils {

    /**
     * Calculates the greatest common divisor.
     * https://www.bbc.co.uk/bitesize/guides/z9hb97h/revision/5
     * ie. for 8 and 12 => 4.
     * ie. for 10 and 5 => 5.
     * ect.
     * @param a first number
     * @param b second number
     * @return GCD
     */
    public static int findGreatestCommonDenominator(int a, int b) {
        ArrayList<Integer> aDenominators = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if( (float) a / i == Math.floor((float) a / i)) aDenominators.add(i);
        }
        for (int i = b; i  != 0; i--) {
            if( ((float) b / i == Math.floor((float) b / i)) && aDenominators.contains(i) ) return i;
        }
        return -1;
    }

    /**
     * Calculates the lowest common multiple.
     * https://www.bbc.co.uk/bitesize/guides/z9hb97h/revision/5
     * ie. for 5 and 6 => 30.
     * multiples for 5: 5, 10, 15, 20, 25, *30*, 35...
     * multiples for 6: 6, 12, 18, 24, *30*...
     * @param a first number
     * @param b second number
     * @return GCD
     */
    public static int findLowestCommonMultiple(int a, int b) {
        ArrayList<Integer> aMultiples = new ArrayList<>();
        int a1, b1;
        for (int i = 1; i <= b; i++) {
            a1 = a*i;
            aMultiples.add(a1);
        }

        for (int i = 1; i < a; i++) {
            b1 = b*i;
            if(aMultiples.contains(b1)) return b1;
        }

        return -1;
    }

}
