package someClasses;

public class IntroTaskLeap {
    public static void main(String[] args) {
        System.out.println(introTaskLeap(2020));
        System.out.println(introTaskLeap(1600));
        System.out.println(introTaskLeap(1500));
        System.out.println(introTaskLeap(1345));
    }

    private static boolean introTaskLeap (int x) {
        if (x % 4 == 0 && x % 100 != 0)
            return true;
        else return x % 400 == 0;
    }
}
