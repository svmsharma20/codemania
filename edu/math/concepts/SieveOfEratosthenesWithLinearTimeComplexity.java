/*
*   Time complexity: O(n)
*/


package edu.math.concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SieveOfEratosthenesWithLinearTimeComplexity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getAllPrimesTillN(sc.nextInt()));
        sc.close();
    }

    static List<Integer> getAllPrimesTillN(int n){
        ArrayList<Integer> primes = new ArrayList<>();
        int[] lp = new int[n+1];

        for (int i = 2 ; i < n; i++) {
            if(lp[i] == 0){
                lp[i] = i;
                primes.add(i);
            }

            for (int j = 0; j < primes.size() && primes.get(j) <= lp[i] && i*primes.get(j) <= n; j++) {
                lp[i*primes.get(j)] =  primes.get(j);
            }
        }

        return primes;
    }
}
