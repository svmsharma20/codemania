package edu.math.leetcode;

import java.util.Scanner;

public class DivideTwoInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dd = sc.nextInt();
        int dv = sc.nextInt();
        System.out.println(divideLogComplexity(dd, dv));
        sc.close();
    }

    static public int divide(int A, int B) {
        if (A == Integer.MIN_VALUE && B == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(A), b = Math.abs(B), res = 0;

        for (int x = 31; x >= 0; x--) {
            int t = (a >>> x) - b;
            if (t >= 0) {
                int p = 1 << x;
                res += p;
                int q = b << x;
                a -= q;
            }
        }
        return (A > 0) == (B > 0) ? res : -res;
    }

    static public int divideLogComplexity(int A, int B) {
        if (A == Integer.MIN_VALUE && B == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(A), b = Math.abs(B), res = 0;

        while ((a - b) >= 0) {
            int pow = 0;
            /*
             * n<<k  = n*(2^k) and, n>>k  = n/(2^k)
             */
            while (a > (b << 1 << pow)) {
                pow++;
            }
            res += 1 << pow;
            a -= b << pow;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
