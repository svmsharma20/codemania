package edu.interviewBit.string;

import java.util.Stack;

public class MinimumParantheses {

    public static void main(String[] args) {
        String str = ")(";
        System.out.println(getMinimumParanthesisCountToMakeStringValid(str));
    }

    private static int getMinimumParanthesisCountToMakeStringValid(String str) {
        int count=0;
        Stack<Character> parnthesisStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='('){
                parnthesisStack.push(ch);
            }else{
                if(parnthesisStack.isEmpty()){
                        count++;
                }else{
                    if(parnthesisStack.peek()=='('){
                        parnthesisStack.pop();
                    } else {
                        count++;
                    }
                }
            }
        }

        count += parnthesisStack.size();

        return count;
    }

}
