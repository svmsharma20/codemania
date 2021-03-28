package edu.interview_bit.string;

public class LengthOfLastWord {

    public int lengthOfLastWord(final String A) {
        if(A==null){
            return 0;
        }
        int lenOfString = A.length()-1;
        int lenOfLastWord=0;

        while(lenOfString>=0 && A.charAt(lenOfString)==' '){
            lenOfString--;
        }

        while(lenOfString>=0 && A.charAt(lenOfString)!=' '){
            lenOfLastWord++;
            lenOfString--;
        }

        return lenOfLastWord;
    }

}
