/*
*   https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1120
*/

package edu.interviewBit.math;

import java.util.Scanner;

public class IrreducableBasicFractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(getCountOfIBF(n));

        sc.close();
    }

    static int getCountOfIBF(int n) {
        int phi = n;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                phi = phi - (phi / i);
            }
        }

        if (n > 1) {
            phi = phi - (phi / n);
        }
        return phi;
    }
}
