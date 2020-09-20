/*
*   Question: https://leetcode.com/problems/perfect-squares/submissions/
*   Time complexity: sqrt(N)
*/

package edu.math.leetcode;

import java.util.Scanner;

public class PerfectSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(getMinimumNumberOfDigits(n));
        sc.close();
    }

    static boolean isPerfectSquare(int n) {
        int base = (int) Math.sqrt(n);
        return (base * base == n);
    }

    static int getMinimumNumberOfDigits(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }

        /*
         * The result is 4 if and only if n can be written in the form of 4^a*(8*b + 7).
         * As per the Legendre's three-square theorem.
         */
        int temp = n;
        while (temp % 4 == 0) {
            temp /= 4;
        }
        if (temp % 8 == 7) {
            return 4;
        }

        for (int i = 1; i * i < n; i++) {
            if (isPerfectSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }
}
