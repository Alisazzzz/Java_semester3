package ru.spbu.arts.java.lambdaExpressions;

public class DrawingWithLambda implements Printable {

    private char[][] picture;

    DrawingWithLambda(int rows, int columns, char symbol) {
        this.picture = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.picture[i][j] = symbol;
            }
        }
    }

    @Override
    public void print() {
        for (char[] i: picture) {
            StringBuilder forPrint = new StringBuilder();
            for (char j: i)
                forPrint.append(j);
            System.out.println(forPrint);
        }
    }

    public void setPoint(int x, int y, char symbol) {
        picture[y][x] = symbol;
    }

    public void drawVerticalLine(int x, int y1, int y2, char symbol) {
        for (int i = y1; i <= y2; i++) {
            setPoint(x, i, symbol);
        }
    }

    public void drawHorizontalLine(int x1, int x2, int y, char symbol) {
        for (int i = x1; i <= x2; i++) {
            setPoint(i, y, symbol);
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2, char symbol) {
        float s = Math.abs(((float)y2 - (float)y1)/((float)x2 - (float)x1));
        int t;
        if (y2 - y1 > 0)
            t = 1;
        else
            t = -1;
        int y = y1;
        setPoint(x1, y, symbol);
        for (int x = x1+1; x < x2; x++) {
            float err = Math.abs(y - (s*x + y1));
            if (err >= 1) {
                y = y + t;
            }
            setPoint(x, y, symbol);
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char symbol) {
        drawVerticalLine(x1, y1, y2, symbol);
        drawHorizontalLine(x1, x2, y2, symbol);
        drawVerticalLine(x2, y1, y2, symbol);
        drawHorizontalLine(x1, x2, y1, symbol);
    }

    public void drawCircle(int x, int y, int r, char symbol) {
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if ( Math.pow(i - x, 2) + Math.pow(j - y, 2) <= Math.pow(r, 2) )
                    setPoint(i, j, symbol);
            }
        }
    }

    public void drawing(int x, int y, DrawingWithLambda original) {
        for (int i = y; i < picture.length; i++) {
            for (int j = x; j <picture[i].length; j++) {
                setPoint(j, i, original.picture[i-y][j-x]);
            }
        }
    }
}
