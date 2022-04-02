package someClasses;

public class IntroTask3Digits {
    public static void main(String[] args) {
        System.out.println(introTask3Digits(34536));
        System.out.println(introTask3Digits(97));
        System.out.println(introTask3Digits(827));
    }

    private static boolean introTask3Digits(int x) {
        return x > 99 && x < 1000;
    }
}
