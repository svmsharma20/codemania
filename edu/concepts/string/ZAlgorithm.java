package edu.concepts.string;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {

    public static void main(String[] args) {
        String text = "aaabcxyzaaaabczaaczabbaaaaaaabc";
        String pattern = "aaabc";

        // result will contain the indices where the match of pattern is found.
        List<Integer> result = patternMatching(text.toCharArray(), pattern.toCharArray());

        System.out.println(result);
    }

    private static List<Integer> patternMatching(char[] textArr, char[] patternArr) {
        List<Integer> matchingList = new ArrayList<>();

        char[] newCharArr = new char[patternArr.length + 1 + textArr.length + 1];

        int i=0;

        // add pattern first to the new char array
        for (char ch : patternArr) {
            newCharArr[i] = ch;
            i++;
        }

        // add a special char
        newCharArr[i] = '$';
        i++;

        // add text to the new char array
        for (char ch : textArr) {
            newCharArr[i] = ch;
            i++;
        }

        int[] Z = calculateZArray(newCharArr);

        for(int j=0; j<Z.length; j++){
            if(Z[j] == patternArr.length){
                matchingList.add(j-patternArr.length-1);
            }
        }

        return matchingList;
    }

    private static int[] calculateZArray(char[] input) {
        int[] Z = new int[input.length];
        Z[0] = 0;

        int left=0;
        int right=0;

        // iterating over each and every element in the array to calculate its z-value
        for (int k = 1; k < input.length; k++) {

            // There are two possible cases:
            // 1. k can be out of z-box i.e., greater than the right boundary
            if(k>right){

                // starting a new z-box
                left=right=k;

                // trying to match the char at right index with the prefix of the string.
                while(right<input.length && input[right] == input[right-left]){
                    // move the right boundary
                    right++;
                }

                // find the length of z-box
                Z[k] = right-left;
                right--;

            }else{

                // 2. k can be in the z-box

                // we are operating inside the z-box


                // tells how far are you from the left boundary
                // also the character from the start of the string
                // from where you will copy the z-value
                int k1 = k-left;

                // if the value does not stretch till the right boundary,
                // then simply copy the value
                if(right > (Z[k1]+k)){
                    Z[k] = Z[k1];
                }else{

                    // calculate the z-value for the character instead of copying
                    // and start a new z-box from here
                    left=right=k;
                    while(right<input.length && input[right] == input[right-left]){
                        // move the right boundary
                        right++;
                    }

                    // find the length of the z-box
                    Z[k] = right-left;
                    right--;
                }
            }
        }
        return Z;
    }

}
