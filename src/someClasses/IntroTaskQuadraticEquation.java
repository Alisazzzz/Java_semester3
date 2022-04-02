package someClasses;

public class IntroTaskQuadraticEquation {
    public static void main(String[] args) {
        introTaskQuadraticEquation(3.,5.,6.);
        introTaskQuadraticEquation(3.,6.,3.);
        introTaskQuadraticEquation(0.,7.,9.);
        introTaskQuadraticEquation(0.,0.,9.);
        introTaskQuadraticEquation(0.,0.,0.);
    }

    private static void introTaskQuadraticEquation (double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Решений бесконечно много");
                } else {
                    System.out.println("Решений нет");
                }
            } else {
                System.out.println("Одно решение: х = " + String.format("%.2f", ((-c)/b)));
            }
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                System.out.println("Решений нет");
            }
            if (d == 0) {
                System.out.println("Одно решение: х = " + String.format("%.2f", ((-b) / (2 * a))));
            }
            if (d > 0) {
                double d2 = Math.sqrt(d);
                double x1 = ((-b) + d2) / (2 * a);
                double x2 = ((-b) - d2) / (2 * a);
                if (x1 < x2) {
                    System.out.println("Два решения: х1 = " + String.format("%.2f", x1) + "; x2 = " + String.format("%.2f", x2));
                } else {
                    System.out.println("Два решения: х1 = " + String.format("%.2f", x2) + "; x2 = " + String.format("%.2f", x1));
                }
            }
        }
    }
}
