package someClasses;

public class PrimalityTest {

    public static void main(String[] args) {
        System.out.println(primalityTest(2020));
        System.out.println(primalityTest(121));
        System.out.println(primalityTest(113));
        System.out.println(primalityTest(67));
        System.out.println(primalityTest(2));

        System.out.println(primalityTestOptimized(2020));
        System.out.println(primalityTestOptimized(121));
        System.out.println(primalityTestOptimized(113));
        System.out.println(primalityTestOptimized(67));
        System.out.println(primalityTestOptimized(2));

    }

    private static boolean primalityTest(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean primalityTestOptimized(int n) {
        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if (n % i == 0 && n != i) {
                return false;
            }
        }
        return true;
    }
}
