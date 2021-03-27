package edu.interviewBit.string;

import java.util.ArrayList;

public class JustifiedText {

    public static void main(String[] args) {
//        String[] text = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] text = { "What", "must", "be", "shall", "be."  };
        String[] text = {"lkgyyrqh", "qrdqusnh", "zyu", "w", "ukzxyykeh", "zmfqafqle", "e", "ajq", "kagjss", "mihiqla", "qekf", "ipxbpz", "opsndtyu", "x", "ec", "cbd", "zz", "yzgx", "qbzaffgf", "i", "atstkrdph", "jgx", "qiy", "jeythmm", "qgqvyz", "dfagnfpwat", "sigxajhjt", "zx", "hwmcgss"};
        int noOfLettersEachLine = 178;
        String[] justifiedText = getJustifiedText(text, noOfLettersEachLine);

        for (String line : justifiedText) {
            System.out.println(line);
        }
    }

    private static String[] getJustifiedText(String[] text, int noOfLettersEachLine) {
        if(text.length==0){
            return (new String[0]);
        }

        ArrayList<String> result = new ArrayList<>();

        int[] wordSizeArray = new int[text.length];
        for (int i = 0; i < text.length; i++) {
            wordSizeArray[i] = text[i].length();
        }

        int i=0;
        int j=1;
        int lineLength = wordSizeArray[i];
        while(j<text.length){

            if((lineLength+wordSizeArray[j]+(j-i)) <= noOfLettersEachLine){
                lineLength += wordSizeArray[j];
                j++;
            }else{
                int wordCount = j-i;
                StringBuilder newLine = new StringBuilder();
                if(wordCount>1){
                    int totalSpaces = noOfLettersEachLine-lineLength;
                    int minimumSpacesReq = totalSpaces/(wordCount-1);
                    int extraSpaces = totalSpaces % (wordCount-1);

                    while (i<(j-1)){
                        newLine.append(text[i]);
                        for (int k = 0; k < minimumSpacesReq; k++) {
                            newLine.append(" ");
                        }
                        if(extraSpaces>0){
                            newLine.append(" ");
                            extraSpaces--;
                        }
                        i++;
                    }
                    newLine.append(text[i]);
                    i++;
                    result.add(newLine.toString());
                    j++;

                }else{
                    newLine.append(text[i]);
                    int k = wordSizeArray[i];
                    while(k<noOfLettersEachLine){
                        newLine.append(" ");
                        k++;
                    }
                    result.add(newLine.toString());
                    i=j;
                    j++;
                }
                lineLength = wordSizeArray[i];
            }
        }
        StringBuilder newLine = new StringBuilder();
        while(i<(j-1)){
            newLine.append(text[i]+" ");
            i++;
        }
        newLine.append(text[i]);
        i++;
        int k=newLine.length();
        while(k<noOfLettersEachLine){
            newLine.append(" ");
            k++;
        }

        result.add(newLine.toString());
        String[] resultArr = new String[result.size()];
        result.toArray(resultArr);

        return resultArr;
    }

}
