package edu.concepts.string;

public class ManachersAlgorithm {

    // https://cp-algorithms.com/string/manacher.html

    public static void main(String[] args) {
        String str = "cybabxzxbaza";
    //  String str = "abb";
        System.out.println(getLongestPalindromicSubstring(str.toCharArray()));
    }

    private static String getLongestPalindromicSubstring(char[] str) {

        char[] inputArr = constructOddArray(str);
        int[] d = new int[inputArr.length];

        d[0] = 0;

        int left=0;
        int right=0;

        for(int i=1; i<inputArr.length; i++){
            int k = (i>right) ? 1 : ( Math.min(d[left+right-i], right-i+1));
            while(0 <= i-k && i+k<d.length && inputArr[i-k] == inputArr[i+k]){
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
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < d.length; i++) {
            if(d[i]>maxLength){
                maxLength = d[i];
                index = i;
            }
        }

        left = index-maxLength;
        right = index + maxLength;
        StringBuilder palindromicString = new StringBuilder();

        while(left<=right){
            if(inputArr[left]!='#'){
                palindromicString.append(inputArr[left]);
            }
            left++;
        }

        return palindromicString.toString();
    }

    private static char[] constructOddArray(char[] input) {
        char[] strArr = new char[input.length*2+1];
        strArr[0] = '#';
        int p=0;    // For input array
        int q=1;    // For strArr array

        while(p<input.length && q<strArr.length){
            strArr[q]=input[p];
            strArr[++q]='#';
            p++;
            q++;
        }

        return strArr;
    }


}
