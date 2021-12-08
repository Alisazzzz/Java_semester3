package MatrixPackage;

import java.util.Arrays;

public class Matrix22Test {

    public static void main(String[] args) {

        Matrix22 mat1 = new Matrix22(1, 2, 3, 4);
        Matrix22 mat2 = new Matrix22(new int[][]{{5, 6}, {7, 8}});

        System.out.println("Матрица 1");
        for (int[] str: mat1.getArray())
            System.out.println(Arrays.toString(str));
        System.out.println(mat1.spurAndDiscriminant());
        System.out.println(mat1.toString());

        System.out.println("Матрицы");
        mat1.print();
        mat2.print();

        System.out.println("Сложение");
        Matrix22 mat3 = mat1.add(mat2);
        mat3.print();

        System.out.println("Матрицы не изменились");
        mat1.print();
        mat2.print();

        System.out.println("Умножение");
        Matrix22 mat4 = mat1.mul(mat2);
        mat4.print();

        System.out.println("Возведение в степень");
        Matrix22 mat5 = mat1.pow(4);
        mat5.print();

        System.out.println("Матрица не изменилась");
        mat1.print();

        System.out.println("Фибоначчи");
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(10));

        System.out.println("Угол");
        Rotation mat6 = new Rotation(3);
        System.out.println(mat6.toString(true));
        System.out.println(mat6.getAngle());

    }

    private static int Fibonacci(int n) {
        Matrix22 P = new Matrix22(1, 1, 1, 0);
        return P.pow(n).getArray()[0][1];
    }
}
