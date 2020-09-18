package edu.math.leetcode;

import java.util.Scanner;

/*   
*   Ref:  https://www.geeksforgeeks.org/program-for-newton-raphson-method/
*         https://www.math.ubc.ca/~anstee/math104/104newton-solution.pdf
*   
*   Complexity: https://en.citizendium.org/wiki/Newton's_method#Computational_complexity
*/

public class SqrtUsingNewtonRaphsonMethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double l = sc.nextDouble();

        System.out.println(sqrt(n, l));
        sc.close();
    }

    public static double sqrt(int n, double l) {
        double xi = n;
        double next_xi = 0;

        while (true) {

            /*
             * equation of square root function is (n)^0.5 = x
             * 
             * Squaring both the side => n = x^2 making equation equates to zero => x^2 - n
             * = 0 So, f(x) = x^2 - n where n will be a constant number like 4, 10, etc. =>
             * f'(x) = 2x, Since n will be a constant its derivative is zero.
             * 
             * As per the Newton-Raphson Method
             * 
             * X of (i+1) = (X of i) - (f(x) / f'(x))
             * 
             */
            next_xi = (0.5 * (xi + (n / xi)));

            if (Math.abs(next_xi - xi) < l) {
                break;
            }
            xi = next_xi;
        }

        return next_xi;
    }
}
