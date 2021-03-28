package edu.interview_bit.math;

import java.math.BigInteger;

public class NextSmallestPalindrome {
    
    public String solve(String num) {
        int len = num.length();
        String left = num.substring(0, len / 2);
        String middle = num.substring(len / 2, len - len / 2);
        String right = num.substring(len - len / 2);

        if (right.compareTo(reverse(left)) < 0)
            return left + middle + reverse(left);

        String next = new BigInteger(left + middle).add(BigInteger.ONE).toString();
        return next.substring(0, left.length() + middle.length())
             + reverse(next).substring(middle.length());
        
    }
    
    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}
