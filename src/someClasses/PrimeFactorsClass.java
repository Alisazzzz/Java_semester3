package someClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorsClass {

    public static void main(String[] args) {

        for (ArrayList<Integer> factor: (primeFactors(16))) {
            System.out.println(Arrays.toString(factor.toArray()));
        }
        for (ArrayList<Integer> factor: (primeFactors(153))) {
            System.out.println(Arrays.toString(factor.toArray()));
        }
        for (ArrayList<Integer> factor: (primeFactors(197))) {
            System.out.println(Arrays.toString(factor.toArray()));
        }

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

    private static ArrayList<ArrayList<Integer>> primeFactors(int n) {
        int[] factors = primes(n);
        ArrayList<ArrayList<Integer>>result = new ArrayList<>();
        int d = factors[1];
        int q = 1; //индекс для factors
        int p = -1; //индекс для result

        while (n > 1) { //почему-то вариант с квадратом осанавливался слишком рано и давал неверный ответ
            if (n % d == 0) {
                if (p >= 0 && result.get(p).get(0) == d) {
                    int lastQuantity = result.get(p).get(1);
                    result.get(p).set(1, lastQuantity + 1);
                } else {
                    p = p + 1;
                    result.add(new ArrayList<>());
                    result.get(p).add(0, d);
                    result.get(p).add(1, 1);
                }
                n = n/d;
            } else {
                q = q + 1;
                d = factors[q];
            }
        }
        if (n != 1) {
            if (p >= 0 && result.get(p).get(0) == d) {
                int lastQuantity = result.get(p).get(1);
                result.get(p).set(1, lastQuantity + 1);
            } else {
                p = p + 1;
                result.add(new ArrayList<>());
                result.get(p).add(0, d);
                result.get(p).add(1, 1);
            }
        }

        return result;
    }
}
