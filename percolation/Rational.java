import edu.princeton.cs.algs4.StdOut;

public class Rational implements Comparable<Rational> {

    private long num;
    private long den;

    public Rational(long numerator, long denominator){
        if (denominator == 0) {
            throw new ArithmeticException("denominator is zero");
        }
        long g = gcd(numerator, denominator);
        num = numerator   / g;
        den = denominator / g;
        if (den < 0) {
            den = -den;
            num = -num;
        }
    }

    public double toDouble() {
        return (double) num/den;
     }

    public Rational plus(Rational that){
       long n = this.num * that.den + this.den * that.num;
       long d = this.den * that.den;
       long f = gcd(n, d);
       return new Rational(n/f,d/f);
    }

    public Rational negate() {
        return new Rational(-num, den);
    }

    public Rational minus(Rational that){
        return this.plus(that.negate());
    }

    public Rational times(Rational that){
        return new Rational(this.num*that.num, this.den*that.den);
    }

    public Rational reciprocal(){
        return new Rational(den,num);
    }
    public Rational divides(Rational that){
        return this.times(that.reciprocal());
    }

    public int compareTo(Rational that){
        if (this.toDouble() < that.toDouble()) { return -1; }
        if (this.toDouble() > that.toDouble()) { return  1; }
        return 0;
    }

    public boolean equals(Object other){
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        return this.compareTo((Rational) other) == 0;
    }

    private static long gcd(long m, long n){
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }

    public String toString(){
        return num + "/" + den;
    }

    public static void main(String[] args) {
        Rational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 - 1/9 = 7/9
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.minus(y);
        StdOut.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new Rational(1, 200000000);
        y = new Rational(1, 300000000);
        z = x.plus(y);
        StdOut.println(z);

        // 1073741789/20 - 1073741789/30 = 1073741789/60
        x = new Rational(1073741789, 20);
        y = new Rational(1073741789, 30);
        z = x.minus(y);
        StdOut.println(z);

        //  4/17 / 17/4 = 16/289
        x = new Rational(4, 17);
        y = new Rational(17, 4);
        z = x.divides(y);
        StdOut.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961
        x = new Rational(3037141, 3247033);
        y = new Rational(3037547, 3246599);
        z = x.times(y);
        StdOut.println(z);

        // 1/6 - -4/-8 = -1/3
        x = new Rational(1, 6);
        y = new Rational(-4, -8);
        z = x.minus(y);
        StdOut.println(z);
    }
}
