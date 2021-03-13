package edu.leetcode.math;

import java.util.Scanner;

public class SqrtUsingLogFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double ans = Math.pow(Math.E, Math.log(n) * 0.5);
        System.out.println(Math.round(ans * 100.0) / 100.0);

        sc.close();
    }

}
