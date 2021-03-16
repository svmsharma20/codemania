package edu.concepts.string;

import java.util.Scanner;

public class StringHashing {

    public static void main(String[] args) {
        System.out.print("Enter the string.. ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        /*
        * prime should be a prime number and
        * greater than the character set.
        * */
        long prime = 53;
        long mod = 1000000007;
        System.out.println(new StringHashing().getHash(str, prime, mod));
    }

    private long getHash(String str, long prime, long mod){
        long hash = 0;
        long pow = 1;

        for (int i = 0; i < str.length(); i++) {
            hash += (((int)str.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (pow * prime) % mod;
        }

        return hash;
    }


}
