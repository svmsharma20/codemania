package edu.interviewBit.string;

import java.util.ArrayList;
import java.util.Stack;

public class PrettyJson {

    public static void main(String[] args) {
        String text =   "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        String[] prettyJson = getPrettyJSON(text);

        for (String line: prettyJson) {
            System.out.println(line);
        }
    }

    private static String[] getPrettyJSON(String text) {
        int indentation = 0;
        StringBuilder line = new StringBuilder();
        ArrayList<String> prettyJsonList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if(line.length()==0){
                for (int p = 0; p < indentation; p++) {
                    line.append("\t");
                }
            }

            line.append(ch);

            if(ch=='[' || ch=='{'){
                prettyJsonList.add(line.toString());
                line = new StringBuilder();
                indentation++;
            } else if(ch==',' || (i<(text.length()-1) && (text.charAt(i+1)=='{' || text.charAt(i+1)=='['))){
                prettyJsonList.add(line.toString());
                line = new StringBuilder();
            }else if ((i<(text.length()-1) && (text.charAt(i+1)=='}' || text.charAt(i+1)==']'))){
                prettyJsonList.add(line.toString());
                line = new StringBuilder();
                indentation--;
            }
        }

        prettyJsonList.add(line.toString());
        String[] prettyJson = new String[prettyJsonList.size()];
        prettyJsonList.toArray(prettyJson);
        return prettyJson;
    }
}
