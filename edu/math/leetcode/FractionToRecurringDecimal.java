package edu.math.leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(fractionToDecimal(n, d));
        sc.close();
    }

    static String fractionToDecimal(int n, int d) {
        if (d == 0) {
            return "NaN";
        }
        if (n == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        if ((n < 0 && d > 0) || (n > 0 && d < 0)) {
            result.append("-");
        }

        long nL = n;
        long dL = d;

        if (nL < 0) {
            nL *= -1;
        }

        if (dL < 0) {
            dL *= -1;
        }

        result.append(n / d);

        long rem = nL % dL;

        if (rem == 0) {
            return result.toString();
        }

        result.append(".");
        // rem *= 10;

        HashMap<Long, Integer> remainderMap = new HashMap<>();

        while (!remainderMap.containsKey(rem)) {
            remainderMap.put(rem, result.length());
            rem *= 10;
            result.append(rem / dL);
            rem = rem % dL;
        }

        result.insert(remainderMap.get(rem), "(");
        result.append(")");

        return result.toString().replace("(0)", "");
    }
}
