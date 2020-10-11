/*
*   Proof of theorem: https://www.youtube.com/watch?v=H_2_nqKAZ5w
*/


package edu.math.concepts;

import java.util.Scanner;

public class GCDUsingEuclideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a,b));

        sc.close();
    }

    static int gcd(int a, int b){
        while(b>0){
            a = a % b;
            
            // swap
            a += b;
            b = a - b;
            a = a - b;
        }
        return a;
    }   
}
