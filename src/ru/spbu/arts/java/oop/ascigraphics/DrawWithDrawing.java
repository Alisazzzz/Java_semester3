package ru.spbu.arts.java.oop.ascigraphics;

public class DrawWithDrawing {

    public static void main(String[] args) {

        Drawing picture1 = new Drawing(20, 20, '.');
        picture1.print();
        System.out.println();

        picture1.drawVerticalLine(6, 9, 14, '|');
        picture1.drawVerticalLine(12, 9, 14, '|');
        picture1.drawHorizontalLine(6, 12, 9, '#');
        picture1.drawHorizontalLine(6, 12, 14, '#');
        picture1.drawLine(6, 8, 9, 5, '/');
        picture1.drawLine(9, 5, 12, 8, '\\');
        picture1.setPoint(9, 5, '#');
        picture1.print();
        System.out.println();

        Drawing picture2 = new Drawing(20, 20, '.');
        picture2.drawCircle(19, 0, 5, '*');
        picture2.drawing(0,5, picture1);
        picture2.print();
        System.out.println();

        ImmutableDrawing picture3 = new ImmutableDrawing(20, 20, '.');
        picture3.print();
        System.out.println();

        picture3.drawVerticalLine(6, 9, 14, '|').print();
        picture3.drawVerticalLine(12, 9, 14, '|').print();
        picture3.print();
        picture3.drawRectangle(5, 5, 15, 15, '+').print();
        picture3.drawing(10, 0, picture3.drawCircle(10, 10, 10, '*')).print();

    }
}
