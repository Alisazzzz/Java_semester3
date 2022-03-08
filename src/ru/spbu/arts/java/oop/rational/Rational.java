package ru.spbu.arts.java.oop.rational;

public class Rational {
    private long n;
    private long d;

    static Rational ONE = new Rational(1);
    static Rational ZERO = new Rational(0);

    private static long findGCD(long a, long b)  {
        long a1 = Math.abs(a);
        long b1 = b;
        while (a1 != b1) {
            if (a1 < b1)
                b1 = b1 - a1;
            else
                a1 = a1 - b1;
        }

        return a1;
    }

    Rational(long a, long b) {
        if (b < 0) {
            b = b * (-1);
            a = a * (-1);
        }
        if (b != 0) {
            long gcd = findGCD(a, b);
            a = a / gcd;
            b = b / gcd;
            this.n = a;
            this.d = b;
        }
    }

    Rational(int a) {
        this.n = a;
        this.d = 1;
    }

    public long getNumerator() {
        return this.n;
    }

    public long getDenominator() {
        return this.d;
    }

    public String toString() {
        if ((d == 1) || (n == 0))
            return "%d".formatted(n);
        else
            return "%d/%d".formatted(n, d);
    }

    public double toDouble() {
        return (double)n/(double)d;
    }

    public Rational add(Rational b) { return new Rational(this.n * b.d + this.d * b.n, b.d * this.d); }

    public Rational sub(Rational b) { return new Rational( this.n * b.d - this.d * b.n, b.d * this.d); }

    public Rational mul(Rational b) { return new Rational(this.n * b.n, this.d * b.d); }

    public Rational div(Rational b) { return new Rational(this.n * b.d, this.d * b.n); }

    public static Rational add(Rational a, Rational b) { return new Rational(a.n * b.d + a.d * b.n, b.d * a.d); }

    public static Rational sub(Rational a, Rational b) { return new Rational( a.n * b.d - a.d * b.n, b.d * a.d); }

    public static Rational mul(Rational a, Rational b) { return new Rational(a.n * b.n, a.d * b.d); }

    public static Rational div(Rational a, Rational b) { return new Rational(a.n * b.d, a.d * b.n); }

    /*
    public void addInPlace(Rational b) {
        this.n = (long) ((long)this.n * b.d + this.d * b.n);
        this.d = b.d * this.d;
        long gcd = findGCD(this.n, this.d);
        this.n = this.n / gcd;
        this.d = this.d / gcd;
    }

    public void subInPlace(Rational b) {
        this.n = this.n * b.d - this.d * b.n;
        this.d = b.d * this.d;
        long gcd = findGCD(this.n, this.d);
        this.n = this.n / gcd;
        this.d = this.d / gcd;
    }

    public void mulInPlace(Rational b) {
        this.n = this.n * b.n;
        this.d = b.d * this.d;
        long gcd = findGCD(this.n, this.d);
        this.n = this.n / gcd;
        this.d = this.d / gcd;
    }

    public void divInPlace(Rational b) {
        this.n = this.n * b.d;
        this.d = b.n * this.d;
        long gcd = findGCD(this.n, this.d);
        this.n = this.n / gcd;
        this.d = this.d / gcd;
    }
    */
}
