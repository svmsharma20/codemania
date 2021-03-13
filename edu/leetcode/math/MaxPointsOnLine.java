package edu.leetcode.math;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MaxPointsOnLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int points[][] = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        // };
        // int points[][] = { { 1, 1 }, { 0, 0 }, { 1, -1 } };
        // int points[][] = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
        // int points[][] = { { 1, 1 }, { 1, 1 }, { 0, 0 }, { 3, 4 }, { 4, 5 }, { 5, 6
        // }, { 7, 8 }, { 8, 9 } }; [[0,0],[94911151,94911150],[94911152,94911151]]
        // int points[][] = { { 0, 0 }, { 94911151, 94911150 }, { 94911152, 94911151 }
        // };
        System.out.println(maxPointsUsingGCD(points));
        sc.close();
    }

    static public int maxPoints(int[][] points) {

        if (points == null)
            return 0;

        if (points.length <= 2)
            return points.length;

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            if (x >= y) {
                points[i][0] -= y;
                points[i][1] -= y;
            } else {
                points[i][0] -= x;
                points[i][1] -= x;
            }
        }

        int max = 0;

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int samePoints = 1;
            int localMax = 0;
            HashMap<Double, Integer> slopeWithCount = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {

                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 == x2 && y2 == y1) {
                    samePoints++;
                    continue;
                }

                double m = Double.POSITIVE_INFINITY;
                int den = (x2 - x1);
                if (den != 0) {
                    double num = (y2 - y1);
                    m = num / den;
                    if (m == -0.0) {
                        m = 0.0;
                    }
                }

                if (slopeWithCount.containsKey(m)) {
                    int pastCount = slopeWithCount.get(m);
                    pastCount++;
                    slopeWithCount.put(m, pastCount);
                } else {
                    slopeWithCount.put(m, 1);
                }

            }
            for (Double d : slopeWithCount.keySet()) {
                int val = slopeWithCount.get(d);
                if (val > localMax) {
                    localMax = val;
                }
            }
            localMax += samePoints;
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }

    // Method 2
    static public int maxPointsUsingGCD(int[][] points) {
        if (points == null)
            return 0;

        int solution = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                if (deltaX == 0 && deltaY == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(deltaX, deltaY);
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;

                map.put(dX + "," + dY, map.getOrDefault(dX + "," + dY, 0) + 1);
                max = Math.max(max, map.get(dX + "," + dY));
            }

            solution = Math.max(solution, max + duplicate + 1);
        }

        return solution;
    }

    static public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
