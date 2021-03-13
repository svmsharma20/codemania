package edu.concepts.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentedSieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();

        for(int p : getAllPrimesInTheSegmented(low, high)){
            System.out.println(p);
        }

        sc.close();
    }

    public static List<Integer> getAllPrimesInTheSegmented(int low, int high){
        Integer[] primes = getAllPrimesTillN((int)Math.ceil(Math.sqrt(high)));

        boolean[] primeInSegment = new boolean[high-low];
        for (int i = 0; i < primeInSegment.length; i++) {
            primeInSegment[i] = true;
        }

        for (int i = 0; i < primes.length; i++) {
            for (int j = 0; j < primeInSegment.length; j++) {
                if(primeInSegment[j] && (j+low)%primes[i] ==0 && (j+low)!=primes[i]){
                    primeInSegment[j] = false;
                }
            }
        }

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < primeInSegment.length; i++) {
            if(primeInSegment[i] == true){
                primeNumbers.add(i+low);
            }
            
        }

        return primeNumbers;
    }

    public static Integer[] getAllPrimesTillN(int n){
        boolean[] primes_bool = new boolean[n+1];
        
        primes_bool[0] = false;
        primes_bool[1] = false;
        
        for (int i = 2; i < primes_bool.length; i++) {
            primes_bool[i] = true; 
        }

        for (int i = 2; i*i < primes_bool.length; i++) {
            if(primes_bool[i] == true){
                for (int j = i*2; j < primes_bool.length; j+=i) {
                    primes_bool[j]  = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 0; i < primes_bool.length; i++) {
            if(primes_bool[i] == true){
                primes.add(i);
            }
            
        }
        Integer[] prime_arr = new Integer[primes.size()];
        primes.toArray(prime_arr);

        return prime_arr;
    }
}
