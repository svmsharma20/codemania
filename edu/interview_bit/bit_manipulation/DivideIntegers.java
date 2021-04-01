package edu.interview_bit.bit_manipulation;

public class DivideIntegers {

    // https://www.youtube.com/watch?v=htX69j1jf5U

    public static void main(String[] args) {
        int dividend = -17;
        int divisor = 5;
        System.out.println(divide(dividend, divisor));
    }

    private static int divide(int dividend, int divisor) {
        if(dividend == Integer.MAX_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }

        boolean isDivisionWillBeNegative = ((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) ? true : false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count=0;

        while(dividend-divisor>=0){
            int x=0;
            while(dividend-(divisor<<1<<x)>=0){
                x++;
            }
            dividend -= (divisor<<x);
            count += 1<<x;
        }

        return (isDivisionWillBeNegative) ? (-1*count) : count;
    }
}
