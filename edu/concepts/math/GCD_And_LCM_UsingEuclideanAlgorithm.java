/*
*   Proof of theorem: https://www.youtube.com/watch?v=H_2_nqKAZ5w
*/


package edu.concepts.math;

import java.util.Scanner;

public class GCD_And_LCM_UsingEuclideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(String.format("GCD of (%s,%s) : %s",a,b,gcd(a,b)));
        System.out.println(String.format("GCD using recurssion (%s,%s) : %s",a,b,gcdRecursive(a,b)));
        System.out.println(String.format("LCM of (%s,%s) : %s",a,b,lcm(a,b)));
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

    static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }

    static int gcdRecursive(int a, int b){
        if(b == 0)
            return a;

        return gcdRecursive(b, a%b);    
    }
}
