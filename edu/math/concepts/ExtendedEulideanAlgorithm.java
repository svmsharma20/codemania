 /*
*   Ref: https://cp-algorithms.com/algebra/extended-euclid-algorithm.html
*/

package edu.math.concepts;

import java.util.Scanner;

public class ExtendedEulideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] gcd = gcdWithCoefficient(a, b);

        System.out.println(String.format("GCD of (%s,%s): %s",a,b,gcd[0]));
        System.out.println(String.format("X: %s",gcd[1]));
        System.out.println(String.format("Y: %s",gcd[2]));
        System.out.println(String.format("Equation-> %s.(%s) + %s.(%s) = %s",a,gcd[1], b,gcd[2],gcd[0]));

        sc.close(); 
    }

    /*
    *   0th index represents gcd of a abd b
    *   1st index represents x coefficient that is coefficient of a
    *   2nd index represents y coefficient that is coefficient of b
    */
    static int[] gcdWithCoefficient(int a, int b){
        if(b==0){
            int[] gcd = new int[3];
            gcd[0] = a;
            gcd[1] = 1;
            gcd[2] = 0;
            return gcd;
        }

        int[] arr = gcdWithCoefficient(b, a%b);
        int[] nextArr = new int[3];
        nextArr[0] = arr[0];
        nextArr[1] = arr[2];
        nextArr[2] = arr[1]-(a/b)*arr[2];

        return nextArr;
    }
}
