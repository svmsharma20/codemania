/*
*   Time complexity = O(log(n))
*/

package edu.math.leetcode;

import java.util.Scanner;

public class powerOf_x_to_n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(myPowUsingSimpleIterative(x, n));

        sc.close();
    }

    /*
     * Same as below just the operations are bit operations
     */
    static double myPow(double x, int n) {

        double ans = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1)
                ans *= x;

            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }

    /*
     * https://www.youtube.com/watch?v=L-Wzglnm4dM
     */
    static double myPowUsingSimpleIterative(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if (absN % 2 == 1) {
                ans *= x;
            }
            x *= x;
            absN /= 2;
        }

        return n < 0 ? 1 / ans : ans;
    }
}
