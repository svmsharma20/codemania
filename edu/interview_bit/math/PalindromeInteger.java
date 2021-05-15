package edu.interview_bit.math;

public class PalindromeInteger {

    public static void main(String[] args) {
        int num = 1223221;
        System.out.println( isPalindromeEfficient(num));
    }

    public static int isPalindrome(int A) {
        
        if(A<0){
            return 0;
        }
        
        int num=A;
        int len=0;
        while(num>9){
            num /= 10;
            len++;
        }
        
        len++;
        num=A;
        for(int i=0; i<=len; i+=2){
            int r = num%10;
            int q = num/(10^(len-1));
            if(q!=r){
                return 0;
            }
            num -= q*(10^(len-1))+r;
        }
        
        return 1;
    }

    public static int isPalindromeEfficient(int A){
        if(A<0){
            return 0;
        }

        int divisor = 1;

        while ((A/divisor)>9){
            divisor *= 10;
        }

        while(divisor>=1){
            if(((A/divisor) % 10) != (A%10)){
                return 0;
            }
            A /= 10;
            divisor /= 100;
        }

        return 1;
    }
}
