package edu.math.leetcode;

import java.util.Scanner;

public class FloorOfSqrtUsingBinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findSqur(n));
        sc.close();
    }

    public static int findSqur(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int start = 1;
        int end = n;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int squr = mid * mid;

            if (squr == n) {
                return mid;
            } else if (squr < n) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
