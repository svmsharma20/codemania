package edu.interview_bit.math;

public class PalindromeInteger {
    public int isPalindrome(int A) {
        
        if(A<0){
            return 1;
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
}
