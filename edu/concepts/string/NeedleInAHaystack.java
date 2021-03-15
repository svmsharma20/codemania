package edu.concepts.string;

import java.util.ArrayList;
import java.util.Scanner;

public class NeedleInAHaystack {

    private static final long MOD = 1000000007;
    private static final int prime = 31;

    private ArrayList<Long> haystackHash = new ArrayList<>();
    private ArrayList<Long> multiplicativeInverseOfPrimeExp = new ArrayList<>();

    public static void main(String[] args) {

        String haystack = "coding is complete fun";
        String needle = "co";

        if(needle.length()==0 || needle.length()>haystack.length()){
            System.out.print(-1);
            return ;
        }

        NeedleInAHaystack needleInAHaystack = new NeedleInAHaystack();

        long needleHash = needleInAHaystack.getHash(needle);

        needleInAHaystack.initHash(haystack);

        for (int left = 0, right=needle.length()-1; right < haystack.length(); left++, right++) {
            if(needleHash== needleInAHaystack.substringHash(left, right)){
                System.out.print(left+" ");
            }
        }
    }

    private long substringHash(int left, int right){
        long hash = haystackHash.get(right);

        if(left>0){
            hash = (hash - haystackHash.get(left-1)) % MOD;
        }

        hash = (hash * multiplicativeInverseOfPrimeExp.get(left))%MOD;

        return hash;
    }

    private void initHash(String s){
        long hash = s.charAt(0) - 'a' + 1;
        long primeExp = 1;

        multiplicativeInverseOfPrimeExp.add(1L);
        haystackHash.add(hash);

        for (int i = 1; i < s.length(); i++) {
            primeExp = (primeExp * prime) % MOD;
            hash = (hash + (s.charAt(i)-'a'+1) * primeExp) % MOD;

            multiplicativeInverseOfPrimeExp.add(power(primeExp, MOD-2));
            haystackHash.add(hash);
        }

    }

    private long getHash(String s){
        long hash = 0;
        long primeExp = 1;
        for (int i = 0; i < s.length(); i++) {
            hash += (((int)s.charAt(i) - 'a' + 1) * primeExp) % MOD;
            primeExp = (primeExp * prime) % MOD;
        }

        return hash;
    }

    private long power(long a, long n){
        long result = 1;
        long pow = a;

        while(n>0){
            if((n&1)>0){
                result = (result * pow) % MOD;
            }
            pow = (pow * pow) % MOD;
            n >>= 1;
        }
        return result;
    }
}
