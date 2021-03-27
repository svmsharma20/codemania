package edu.interviewBit.string;

public class ConvertToPalindrome {

    public static void main(String[] args) {
        String str = "abecbea";
        System.out.println(isPalindromPossile(str));
    }

    private static int isPalindromPossile(String input) {
        boolean isMismatchFound = false;
        int left=0;
        int right=input.length()-1;

        while(left<right){
            if(input.charAt(left)==input.charAt(right)){
                left++;
                right--;
            }else if(isMismatchFound){
                return 0;
            }else{
                isMismatchFound=true;
                if(left<input.length()-1 && right>0 && input.charAt(left+1)==input.charAt(right)){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return 1;
    }

}
