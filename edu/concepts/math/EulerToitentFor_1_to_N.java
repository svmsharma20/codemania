/*  
*   Time complexity = O(nloglogn) 
*/

package edu.concepts.math;

import java.util.Scanner;

public class EulerToitentFor_1_to_N {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] phi = printAllPhiFromOneToN(n);

        for (int i = 1; i < phi.length; i++) {
            System.out.println(i + " - " + phi[i] + " ");
        }

        sc.close();
    }

    static int[] printAllPhiFromOneToN(int n) {
        int[] phi = new int[n + 1];

        phi[0] = 0;
        phi[1] = 1;

        for (int i = 2; i < phi.length; i++) {
            phi[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= n; j += i) {
                    phi[j] = phi[j] - (phi[j] / i);
                }
            }
        }

        return phi;
    }
}
