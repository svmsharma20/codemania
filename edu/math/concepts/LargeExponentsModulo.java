package edu.math.concepts;

import java.util.Scanner;

public class LargeExponentsModulo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(findModulo(x,n,m));

        sc.close();
    }

    static int findModulo(int x, int n, int m){
        int result = 1;
        int mod = x % m;
        while(n>0){
            if((n & 1) > 0){
                result = (result * mod) % m;
            }
            mod =( mod * mod ) % m;
            n >>= 1;
        }
        return result;
    }
}
