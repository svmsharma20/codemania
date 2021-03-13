/*  
*   Time complexity = O(nlogn) 
*/

package edu.concepts.math;

import java.util.Scanner;

public class EulerTotientUsingDivisorSumProperty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] phi = getAllPhis(n);

        for (int i = 1; i < phi.length; i++) {
            System.out.println(i + " : " + phi[i]);
        }

        sc.close();
    }

    static int[] getAllPhis(int n) {
        int[] phi = new int[n + 1];

        phi[0] = 0;
        phi[1] = 1;

        for (int i = 2; i < phi.length; i++) {
            phi[i] = i - 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                phi[j] -= phi[i];
            }
        }

        return phi;
    }
}
