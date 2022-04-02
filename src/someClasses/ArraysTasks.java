package someClasses;

import java.util.Arrays;

public class ArraysTasks {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(even(5)));
        System.out.println("---");

        int[] a1 = new int[]{1, 2, 3, 1};
        int[] a2 = new int[]{4, 4, 4, 4};
        int[] a3 = new int[]{1};
        System.out.println(allSimilar(a1));
        System.out.println(allSimilar(a2));
        System.out.println(allSimilar(a3));
        System.out.println("---");

        System.out.println(hasSimilar(a1));
        System.out.println(hasSimilar(a2));
        System.out.println(hasSimilar(a3));
        System.out.println("---");

        System.out.println(mean(a1));
        System.out.println(mean(a2));
        System.out.println(mean(a3));
        System.out.println("---");

        shift(a1);
        shift(new int[]{10, 20, 30, 40});
        System.out.println("---");

        System.out.println(Arrays.toString(copyShift(a1)));
        System.out.println(Arrays.toString(copyShift(new int[]{10, 20, 30, 40})));
    }

    private static int[] even(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = 2 * (i+1);
        return array;
    }

    private static boolean allSimilar(int[] a) {
        int p = a[0];
        for (int number:a) {
            if (number != p)
                return false;
        }
        return true;
    }

    private static boolean hasSimilar(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int p = a[i];
            for (int j = i+1; j < a.length; j++) {
                if (a[j] == p)
                    return true;
            }
        }
        return false;
    }

    private static double mean(int[] a) {
        double sum = 0;
        for (int number: a)
            sum = sum + number;
        double res = sum / a.length;
        return res;
    }

    private static void shift(int[] a) {
        System.out.println(a);
        int p = a[0];
        for (int i = 1; i < a.length+1; i++) {
            int q = a[i % a.length];
            a[i % a.length] = p;
            p = q;

        }
        System.out.println(Arrays.toString(a));
        System.out.println(a);
    }

    private static int[] copyShift(int[] a) {
        int[] b = new int[a.length];
        b[0] = a[a.length - 1];
        for (int i = 1; i < b.length; i++) {
            b[i] = a[i-1];
        }
        return b;
    }

}
