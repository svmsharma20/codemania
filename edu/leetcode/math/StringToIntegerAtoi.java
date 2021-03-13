package edu.leetcode.math;

import java.util.Scanner;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(myAtoi(str));
        sc.close();
    }

    static public int myAtoi(String str) {
        String trimmedStr = str.trim();

        int sign = 1;
        int i = 0;

        if (trimmedStr.length() == 0) {
            return 0;
        }

        char firstChar = trimmedStr.charAt(i);

        if (firstChar == '+' || firstChar == '-') {
            if (firstChar == '-') {
                sign = -1;
            }
            i++;
        }

        if (i < trimmedStr.length() && (trimmedStr.charAt(i) < 48 || trimmedStr.charAt(i) > 57)) {
            return 0;
        }

        int prev = 0;
        int num = Integer.parseInt("" + trimmedStr.charAt(i));
        i++;

        if (i < trimmedStr.length()) {
            char ch = trimmedStr.charAt(i);
            while ((ch >= 48 && ch <= 57) && i < trimmedStr.length()) {

                if (num / 10 != prev) {
                    if (sign < 0) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }

                prev = num;
                num = num * 10 + Integer.parseInt("" + ch);

                i++;

                ch = trimmedStr.charAt(i);
            }
        }

        if (num / 10 != prev) {
            if (sign < 0) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        return num * sign;

    }
}
