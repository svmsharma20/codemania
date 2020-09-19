/*  
*    Time complexity = O(sqrt(n)) 
*   Ref: https://cp-algorithms.com/algebra/phi-function.html
*/

package edu.math.concepts;

import java.util.Scanner;

public class EulerTotientFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(phi(n));

        sc.close();
    }

    public static int phi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }
}
