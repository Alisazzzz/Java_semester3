package ru.spbu.arts.java.oop.ascigraphics;

public class ImmutableDrawing {
    char[][] picture;

    ImmutableDrawing(int rows, int columns, char symbol) {
        this.picture = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.picture[i][j] = symbol;
            }
        }
    }

    public void print() {
        for (char[] i: picture) {
            StringBuilder forPrint = new StringBuilder();
            for (char j: i)
                forPrint.append(j);
            System.out.println(forPrint);
        }
    }

    public ImmutableDrawing setPoint(int x, int y, char symbol) {
        ImmutableDrawing newPicture = new ImmutableDrawing(picture.length, picture[0].length, picture[0][0]);
        newPicture.picture[y][x] = symbol;
        return newPicture;
    }

    public ImmutableDrawing drawVerticalLine(int x, int y1, int y2, char symbol) {
        ImmutableDrawing newPicture = new ImmutableDrawing(picture.length, picture[0].length, picture[0][0]);
        for (int i = y1; i <= y2; i++) {
            newPicture.picture[i][x] = symbol;
        }
        return newPicture;
    }

    public ImmutableDrawing drawHorizontalLine(int x1, int x2, int y, char symbol) {
        ImmutableDrawing newPicture = new ImmutableDrawing(picture.length, picture[0].length, picture[0][0]);
        for (int i = x1; i <= x2; i++) {
            newPicture.picture[y][i] = symbol;
        }
        return newPicture;
    }

    public ImmutableDrawing drawLine(int x1, int y1, int x2, int y2, char symbol) {
        ImmutableDrawing newPicture = new ImmutableDrawing(picture.length, picture[0].length, picture[0][0]);
        float s = Math.abs(((float)y2 - (float)y1)/((float)x2 - (float)x1));
        int t;
        if (y2 - y1 > 0)
            t = 1;
        else
            t = -1;
        int y = y1;
        newPicture.picture[x1][y] = symbol;
        for (int x = x1+1; x < x2; x++) {
            float err = Math.abs(y - (s*x + y1));
            if (err >= 1) {
                y = y + t;
            }
            newPicture.picture[x][y] = symbol;
        }
        return newPicture;
    }

    public ImmutableDrawing drawRectangle(int x1, int y1, int x2, int y2, char symbol) {
        ImmutableDrawing newPicture = new ImmutableDrawing(picture.length, picture[0].length, picture[0][0]);
        for (int i = y1; i <= y2; i++) {
            newPicture.picture[i][x1] = symbol;
        }
        for (int i = x1; i <= x2; i++) {
            newPicture.picture[y2][i] = symbol;
        }
        for (int i = y1; i <= y2; i++) {
            newPicture.picture[i][x2] = symbol;
        }
        for (int i = x1; i <= x2; i++) {
            newPicture.picture[y1][i] = symbol;
        }
        return newPicture;
    }

    public ImmutableDrawing drawCircle(int x, int y, int r, char symbol) {
        ImmutableDrawing newPicture = new ImmutableDrawing(picture.length, picture[0].length, picture[0][0]);
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if ( Math.pow(i - x, 2) + Math.pow(j - y, 2) <= Math.pow(r, 2) )
                    newPicture.picture[i][j] = symbol;
            }
        }
        return newPicture;
    }

    public ImmutableDrawing drawing(int x, int y, ImmutableDrawing original) {
        ImmutableDrawing newPicture = new ImmutableDrawing(picture.length, picture[0].length, picture[0][0]);
        for (int i = y; i < picture.length; i++) {
            for (int j = x; j <picture[i].length; j++) {
                newPicture.picture[j][i] = original.picture[i-y][j-x];
            }
        }
        return newPicture;
    }
}
