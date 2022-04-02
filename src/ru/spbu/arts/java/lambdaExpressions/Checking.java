package ru.spbu.arts.java.lambdaExpressions;

public class Checking {

    public static void main(String[] args) {

        DrawingWithLambda picture1 = new DrawingWithLambda(20, 20, '.');
        picture1.print();

        picture1.drawVerticalLine(6, 9, 14, '|');
        picture1.drawVerticalLine(12, 9, 14, '|');
        picture1.drawHorizontalLine(6, 12, 9, '#');
        picture1.drawHorizontalLine(6, 12, 14, '#');
        picture1.drawLine(6, 8, 9, 5, '/');
        picture1.drawLine(9, 5, 12, 8, '\\');
        picture1.setPoint(9, 5, '#');
        picture1.print();
        System.out.println();

        DrawingWithLambda picture2 = new DrawingWithLambda(20, 20, '.');
        picture2.drawCircle(19, 0, 5, '*');
        picture2.drawing(0, 5, picture1);
        picture2.print();
        System.out.println();

        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print();

        PrintableString ps = new PrintableString("asdf");
        ps.print();

        Printable Anonymous = new Printable() {
            @Override
            public void print() {
                System.out.println("Anonymous");
            }
        };

        Printable lambda = () -> System.out.println("Lambda!");

        Printable[] array = new Printable[]{picture1, pl, ps, Anonymous, lambda};
        for (Printable i: array) {
            i.print();
        }

    }
}
