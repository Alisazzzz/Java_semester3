public class IntroTaskLast5 {
    public static void main(String[] args) {
        System.out.println(introTaskLast5(255));
        System.out.println(introTaskLast5(254));
        System.out.println(introTaskLast5(25));
        System.out.println(introTaskLast5(255690));
    }

    private static boolean introTaskLast5 (int x) {
        return x % 5 == 0 && x % 10 != 0;
    }
}
