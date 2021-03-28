package edu.interview_bit.string;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String A) {
        char[] inputArr = constructOddArr(A.toCharArray());
        int[] d = new int[inputArr.length];

        d[0] = 0;

        int left = 0;
        int right = 0;

        for(int i=1; i<d.length; i++){
            int k = (i>right) ? 1 : (Math.min(d[left+right-i], right-i+1));
            while((i-k)>=0 && (i+k)<d.length && inputArr[i-k]==inputArr[i+k]){
                k++;
            }
            k--;
            d[i]=k;
            if((i+k)>right){
                left = i-k;
                right = i+k;
            }
        }

        int index = -1;
        int maxLength = -1;

        for(int i=0; i<d.length; i++){
            if(inputArr[i]!='#' && d[i]>maxLength){
                maxLength = d[i];
                index = i;
            }
        }

        left = index-maxLength;
        right = index+maxLength;

        StringBuilder palindromicString = new StringBuilder();

        while(left<=right){
            if(inputArr[left]!='#'){
                palindromicString.append(inputArr[left]);
            }
            left++;
        }

        return palindromicString.toString();
    }

    private char[] constructOddArr(char[] input){
        char[] oddLengthArray = new char[input.length*2+1];

        oddLengthArray[0]='#';
        int i=0;
        int j=1;

        while(i<input.length){
            oddLengthArray[j] = input[i];
            i++;
            j++;
            oddLengthArray[j] = '#';
            j++;
        }

        return oddLengthArray;
    }

}
