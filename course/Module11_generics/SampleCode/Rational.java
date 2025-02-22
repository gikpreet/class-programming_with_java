public class Rational extends Number implements Comparable<Rational> {
    private int num;   // the numerator
    private int den;   // the denominator

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Denominator is zero");
        }
        int g = gcd(numerator, denominator);
        num = numerator   / g;
        den = denominator / g;

    }

    @Override
    public String toString() {
        if (den == 1) return num + "";
        else          return num + "/" + den;
    }

    public Rational times(Rational b) {
        return new Rational(this.num * b.num, this.den * b.den);
    }

    public Rational plus(Rational b) {
        int numerator   = (this.num * b.den) + (this.den * b.num);
        int denominator = this.den * b.den;
        return new Rational(numerator, denominator);
    }

    public Rational reciprocal() { return new Rational(den, num);  }

    public Rational divides(Rational b) {
        return this.times(b.reciprocal());
    }

    private static int gcd(int m, int n) {
        if (0 == n) return m;
        else return gcd(n, m % n);
    }

    public double doubleValue() {
        return (double)num / (double)den;
    }

    public float floatValue() {
        return (float)num / (float)den;
    }

    public int intValue() {
        return num / den;
    }

    public long longValue() {
        return (long)num / (long)den;
    }

    @Override
    public int compareTo(Rational rational) {
        if (this.doubleValue() > rational.doubleValue()) {
            return 1;
        }
        else if (this.doubleValue() < rational.doubleValue()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}