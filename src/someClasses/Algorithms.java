package someClasses;

import java.util.Arrays;

public class Algorithms {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sieveOfEratosthenes(16)));

        System.out.println(Arrays.toString(primes(16)));

        System.out.println(Arrays.toString(primeFactors(16)));
        System.out.println(Arrays.toString(primeFactors(153)));
        System.out.println(Arrays.toString(primeFactors(197)));

        int[] sortedArray = new int[]{1, 5, 7, 13, 14, 78, 90, 124};
        System.out.println(binarySearch(sortedArray, 13));
        System.out.println(binarySearch(sortedArray, 15));

    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        for (int p = 2; p < n; p++) {
            for (int i = 0; i < n + 1; i++) {
                if (i != p && i % p == 0)
                    prime[i] = false;
            }
        }
        return prime;
    }

    private static int[] primes(int n) {
        boolean[] prime = sieveOfEratosthenes(n);
        int[] preresult = new int[n];
        int p = 0;
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                preresult[p] = i;
                p = p + 1;
            }
        }
        int c = 0;
        for (int number: preresult) {
            if (number != 0)
                c += 1;
        }
        int[] result = new int[c];
        for (int i = 0; i < c; i++)
            result[i] = preresult[i];
        return result;
    }

    private static int[] primeFactors(int n) {
        int[] factors = primes(n);
        int[] preresult = new int[n/2 + 1];
        int p = 1;
        int q = 0;
        while (n > 1) {
            if (n % factors[p] == 0) {
                preresult[q] = factors[p];
                q = q + 1;
                n = n/factors[p];
            } else {
                p = p + 1;
            }
        }
        int c = 0;
        for (int number: preresult) {
            if (number != 0)
                c += 1;
        }
        int[] result = new int[c];
        for (int i = 0; i < c; i++)
            result[i] = preresult[i];
        return result;
    }

    private static int binarySearch(int[] a, int x) {
        int p = 0;
        int r = a.length;
        while (p <= r) {
            int q = (p + r) / 2;
            if (a[q] == x)
                return q;
            else {
                if (a[q] < x)
                    p = q + 1;
                else
                    r = q - 1;
            }
        }
        return -1;
    }

}
