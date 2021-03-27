package edu.interviewBit.string;

public class MinimumAppendsForPalindrome {

    public static void main(String[] args) {
        String str = "abede";
        System.out.println(getCountForMakingStringPalindrom(str));
    }

    private static int getCountForMakingStringPalindrom(String input) {
        int left=0;
        int right=input.length()-1;
        int count=0;

        while (left<right){
            if(input.charAt(left)!=input.charAt(right)){
                count = left+1;
                right = input.length()-1;
                left++;
            }else{
                left++;
                right--;
            }
        }

        return count;
    }

}
