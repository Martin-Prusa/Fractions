package cz.educanet;

public class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //region: basic operations (+, -, *, /)
    /**
     * Adds the fraction to the other fraction. Returns a new fraction.
     * @param other
     * @return new fraction
     */
    public Fraction plus(Fraction other) {
        int nsn = MathUtils.findLowestCommonMultiple(denominator, other.getDenominator());
        int rozdilA = nsn/denominator;
        int rozdilB = nsn/other.getDenominator();

        return new Fraction(numerator*rozdilA + other.getNumerator()*rozdilB, nsn);
    }

    /**
     * Subtracts other from the fraction. Returns a new fraction.
     * @param other
     * @return new fraction
     */
    public Fraction minus(Fraction other) {
        int nsn = MathUtils.findLowestCommonMultiple(denominator, other.getDenominator());
        int rozdilA = nsn/denominator;
        int rozdilB = nsn/other.getDenominator();

        return new Fraction(numerator*rozdilA - other.getNumerator()*rozdilB, nsn);
    }

    /**
     * Multiplies the two fractions. Returns a new fraction.
     * @param other
     * @return new fraction
     */
    public Fraction times(Fraction other) {
        int dn = denominator * other.getDenominator();
        int nm = numerator * other.getNumerator();
        return new Fraction(nm, dn);
    }

    /**
     * Divides the two fractions (this / other). Returns a new fraction.
     * @param other
     * @return new fraction
     */
    public Fraction dividedBy(Fraction other) {
        int dn = denominator * other.getNumerator();
        int nm = numerator * other.getDenominator();
        return new Fraction(nm, dn);
    }
    //endregion

    //region: other operations
    /**
     * Gets the reciprocal (flipped) of the fraction. ie. reciprocal of 1/2 is 2/1
     * @return new fraction
     */
    public Fraction getReciprocal() {
        return new Fraction(denominator, numerator);
    }

    /**
     * Simplifies the fraction
     * @return new fraction
     */
    public Fraction simplify() {
        int nsd = MathUtils.findGreatestCommonDenominator(numerator, denominator);
        return new Fraction(numerator/nsd, denominator/nsd);
    }

    /**
     * Calculates the floating value of the fraction.
     * @return float
     */
    public float toFloat() {
        return (float) numerator/(float) denominator;
    }
    //endregion

    //region: getters
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    //endregion
}
