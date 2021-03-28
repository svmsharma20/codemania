package edu.interview_bit.string;

//  https://www.interviewbit.com/problems/palindrome-string/

public class PalindromeString {
    
    public int isPalindrome(String A) {
        int left=0;
        int right=A.length()-1;
        
        while(left<right){
            int leftChar = A.charAt(left);
            int rightChar = A.charAt(right);
            
            int leftCharInt = (int)leftChar;
            int rightCharInt = (int)rightChar;
            
            if( !(leftCharInt>=95 && leftCharInt<=120) && !(leftCharInt>=65 && leftCharInt<=90) && !(leftCharInt>=48 && leftCharInt<=57) ){
                left++;
                continue;
            }
            
            if( !(rightCharInt>=95 && rightCharInt<=120) && !(rightCharInt>=65 && rightCharInt<=90) && !(rightCharInt>=48 && rightCharInt<=57)){
                right--;
                continue;
            }
            
            if(Character.toLowerCase(leftChar)==Character.toLowerCase(rightChar)){
                left++;
                right--;
            }else{
                return 0;
            }
        }
        
        return 1;
    }

}
