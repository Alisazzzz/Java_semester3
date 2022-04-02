package someClasses;

public class IntroTaskSameDigits {
    public static void main(String[] args) {
        System.out.println(introTaskSameDigits(133));
        System.out.println(introTaskSameDigits(156));
        System.out.println(introTaskSameDigits(6677854));
        System.out.println(introTaskSameDigits(1));
    }

    private static boolean introTaskSameDigits (int x) {
        int z = x % 10;
        int y = (x % 100) / 10;
        return z == y;
    }
}
