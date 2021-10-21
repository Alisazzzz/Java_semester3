import java.io.PrintStream;
import java.util.Arrays;

public class MultidimentionalArrays {
    public static void main(String[] args) {
        printTable(new int[][] {{23, 45, 12}, {333, 1}, {1, 2, 3, 4, 5}});
        printTableAligned(new int[][] {{23, 45, 12}, {333, 1}, {1, 2, 3, 4, 5}});

    }

    private static void printTable(int[][] a) {
        for (int[] string: a) {
            String res = "";
            for (int number: string)
                res = res + number + ' ';
            System.out.println(res);
        }
    }

    private static void printTableAligned(int[][] a) {
        int numberOfColumns = 0;
        for (int[] array: a) {
            if (array.length > numberOfColumns)
                numberOfColumns = array.length;
        }
        int[] lengthOfColumns = new int[numberOfColumns];
        for (int[] array: a) {
            for (int i = 0; i < array.length; i++) {
                if (Integer.toString(array[i]).length() > lengthOfColumns[i])
                    lengthOfColumns[i] = Integer.toString(array[i]).length();
            }
        }
        for (int[] string: a) {
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
