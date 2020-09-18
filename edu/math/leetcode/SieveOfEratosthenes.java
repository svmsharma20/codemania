package edu.math.leetcode;

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] primes = new int[n + 1];

        int sqrtOfN = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i <= sqrtOfN; i++) {
            if (primes[i] == 0) {
                for (int j = 2 * i; j <= n; j += i) {
                    primes[j] = 1;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}
