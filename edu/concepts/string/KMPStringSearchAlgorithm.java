package edu.concepts.string;

import java.util.ArrayList;

public class KMPStringSearchAlgorithm {
    /*
    * https://www.youtube.com/watch?v=D6dCOa_gMoY
    * */

    public static void main(String[] args) {
        String text = "acbacxabcdabxabcdacbacdabcyacbacdabcyacb";
        String pattern = "acbacdabcyacb";

        System.out.println(new KMPStringSearchAlgorithm().getMatchesIndices(text, pattern));

    }

    private ArrayList<Integer> getMatchesIndices(String text, String pattern){
        ArrayList<Integer> matcherIndices = new ArrayList<>();

        int[] pi = getPiArray(pattern);

        int i=0;    // For text
        int j=0;    // For pattern

        int patternLen = pattern.length();

        while(i<text.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else if (j>0){
                j = pi[j-1];
            }else{
                i++;
            }

            if(j==patternLen){
                matcherIndices.add(i-patternLen);
                /*
                * We are not resetting it to zero because pattern's ending can also be a proper prefix.
                * In that case, a second pattern will start inside the pattern itself.
                *
                * or
                *
                * The ending and starting of the pattern matches and text contains two patterns consecutively.
                *
                * For example: pattern= "abcdab" & text= "abcdabcdab"
                * The "ab" at index 4 and 5 in the text is the starting of next pattern
                * and, previous pattern matching not yet completed.
                *
                * So here, we have two patterns found in text,
                * one which starts from index "0" and ending at index "5"
                * and, the second one starts from index "4" and ending at index "9"
                * If, we reset the value of j to zero we will miss the second pattern in the text.
                *
                * */
                if(j>0){ j = pi[j-1]; }
            }
        }

        return matcherIndices;
    }

    private int[] getPiArray(String str){
        int[] pi = new int[str.length()];

        int i=0;
        int j=1;

        while(j<str.length()){
            if(str.charAt(i)==str.charAt(j)){
                pi[j] = i+1;
                i++;
                j++;
            }else if(i>0){
                i = pi[i-1];
            }else{
                pi[j] = 0;
                j++;
            }
        }

        return pi;
    }
}
