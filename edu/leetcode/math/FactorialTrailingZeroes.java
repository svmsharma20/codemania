package edu.leetcode.math;

import java.util.Scanner;

public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {

        int count = 0;

        while (n > 1) {
            count += (n / 5);
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(trailingZeroes(n));
        sc.close();
    }
}
