package ru.spbu.arts.java.oop.rational;

public class RationalChecking {

    public static void main(String[] args) {

        Rational x = new Rational(5, 6);
        System.out.println(x.toString());
        System.out.println(x.toDouble());
        System.out.println("----");

        Rational y = new Rational(2, 12);
        System.out.println(y.toString());
        System.out.println(y.toDouble());
        System.out.println("----");

        Rational z = x.add(y);
        System.out.println(z.toString());
        System.out.println(y.toString());
        System.out.println(x.toString());
        System.out.println("----");

        Rational w = x.div(y);
        System.out.println(w.toString());
        System.out.println(y.toString());
        System.out.println(x.toString());
        System.out.println("----");

        Rational u = x.mul(y);
        System.out.println(u.toString());
        System.out.println(y.toString());
        System.out.println(x.toString());
        System.out.println("----");

        Rational h = y.sub(x);
        System.out.println(h.toString());
        System.out.println(y.toString());
        System.out.println(x.toString());
        System.out.println("----");

        /*
        x.subInPlace(h);
        System.out.println(x.toString());
        System.out.println("----");
        */

        System.out.println(f(1).toString());
        System.out.println(f(2).toDouble());
        System.out.println(f(3).toDouble());
        System.out.println(f(20).toDouble()); // равно 0.8302753773574207
        // думаю, так получилось, потому что числа получаются слишком большими для int
        // поэтому я не стала мелочиться и исправила все int в классе Rational на long
        System.out.println("----");

        System.out.println(Rational.add(x, y).toString());
        System.out.println(Rational.ONE.toString());
        System.out.println(Rational.ZERO.toDouble());


    }

    public static Rational f(int n) {
        Rational x = new Rational(0);
        for (int i = 1; i <= n; i++) {
            x = x.add(new Rational(1, i));
        }
        return x;
    }

}
