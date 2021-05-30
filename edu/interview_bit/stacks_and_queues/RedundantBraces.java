package edu.interview_bit.stacks_and_queues;

import java.util.Stack;

public class RedundantBraces {

  public int braces(String str) {
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<str.length(); i++){
      char ch = str.charAt(i);
      if(ch==')'){
        if(stack.peek()=='('){
          return 1;
        }else{
          boolean isAnyOperatorFound = false;
          char c = stack.peek();
          while(c !='('){
            if(c=='+' || c=='-' || c=='*' || c=='/'){
              isAnyOperatorFound = true;
            }
            stack.pop();
            c = stack.peek();
          }
          if(!isAnyOperatorFound){
            return 1;
          }
          stack.pop();
        }
      }else{
        stack.push(ch);
      }
    }

    return 0;
  }

}
