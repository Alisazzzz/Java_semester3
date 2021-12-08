package MatrixPackage;

public class Matrix22 {
    int a;
    int b;
    int c;
    int d;

    //это для наследования и класса Rotation
    //получается, все методы нужно переписать ещё и для double? Ведь все массивы - из типов int...
    double ad;
    double bd;
    double cd;
    double dd;

    Matrix22(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    Matrix22(double a, double b, double c, double d) {
        this.ad = a;
        this.bd = b;
        this.cd = c;
        this.dd = d;
    }

    Matrix22(int[][] arr) {
        this.a = arr[0][0];
        this.b = arr[0][1];
        this.c = arr[1][0];
        this.d = arr[1][1];
    }

    public String spurAndDiscriminant() {
        return "%d, %d".formatted(a-d, a*d - b*c);
    }

    public int[][] getArray() {
        return new int[][]{{a, b}, {c, d}};
    }

    public String toString() {
        return "{ {%d, %d}, {%d, %d} }".formatted(a, b, c, d);
    }

    //это чтобы проверить правильность матрицы для Rotation,
    //остальные методы я не переписывала
    public String toString(boolean isDouble) {
        return "{ {%f, %f}, {%f, %f} }".formatted(ad, bd, cd, dd);
    }

    public void print() {
        int[][] arr = getArray();
        printTableAligned(arr);

    }

    public Matrix22 add(Matrix22 b) {
        int[][] arrA = getArray();
        int[][] arrB = b.getArray();
        int[][] arrC = new int[2][2];
        arrC[0][0] = arrA[0][0] + arrB[0][0];
        arrC[0][1] = arrA[0][1] + arrB[0][1];
        arrC[1][0] = arrA[1][0] + arrB[1][0];
        arrC[1][1] = arrA[1][1] + arrB[1][1];

        return new Matrix22(arrC);
    }

    public Matrix22 mul(Matrix22 b) {
        int[][] arrA = getArray();
        int[][] arrB = b.getArray();
        int[][] arrC = new int[2][2];
        arrC[0][0] = arrA[0][0]*arrB[0][0] + arrA[0][1]*arrB[1][0];
        arrC[0][1] = arrA[0][0]*arrB[0][1] + arrA[0][1]*arrB[1][1];
        arrC[1][0] = arrA[1][0]*arrB[0][0] + arrA[1][1]*arrB[1][0];
        arrC[1][1] = arrA[1][0]*arrB[0][1] + arrA[1][1]*arrB[1][1];

        return new Matrix22(arrC);
    }

    public Matrix22 pow(int n) {
        Matrix22 arrB = new Matrix22(getArray());
        for (int i = 1; i < n; i++)
            arrB = arrB.mul(new Matrix22(getArray()));

        return arrB;
    }

   //скопировано из многомерных массивов, потому что я не смогла разобраться
   // с использованием методов
    public static void printTableAligned(int[][] a) {
        int numberOfColumns = 0;
        for (int[] array : a) {
            if (array.length > numberOfColumns)
                numberOfColumns = array.length;
        }
        int[] lengthOfColumns = new int[numberOfColumns];
        for (int[] array : a) {
            for (int i = 0; i < array.length; i++) {
                if (Integer.toString(array[i]).length() > lengthOfColumns[i])
                    lengthOfColumns[i] = Integer.toString(array[i]).length();
            }
        }
        for (int[] string : a) {
            String res = "";
            int p = 0;
            for (int i = 0; i < string.length; i++) {
                p = lengthOfColumns[i] - Integer.toString(string[i]).length();
                String s = "";
                for (int j = 0; j < p; j++)
                    s = s + ' ';
                res = res + s + string[i] + "  ";
            }
            System.out.println(res);
        }
    }

}
