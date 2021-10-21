public class PrimalityTest {

    public static void main(String[] args) {
        System.out.println(PrimalityTest(2020));
        System.out.println(PrimalityTest(121));
        System.out.println(PrimalityTest(113));
        System.out.println(PrimalityTest(67));

        System.out.println(PrimalityTestOptimized(2020));
        System.out.println(PrimalityTestOptimized(121));
        System.out.println(PrimalityTestOptimized(113));
        System.out.println(PrimalityTestOptimized(67));

    }

    private static boolean PrimalityTest(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean PrimalityTestOptimized(int n) {
        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
