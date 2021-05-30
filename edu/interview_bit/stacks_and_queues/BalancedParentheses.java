package edu.interview_bit.stacks_and_queues;

import java.util.Stack;

public class BalancedParentheses {

  public static void main(String[] args) {
    String str = "(()())";
    System.out.println(new BalancedParentheses().solve(str));
  }

  /*
  * return:
  * 1: If parentheses are balanced
  * 0: If parentheses are not balanced*/
  private int solve(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(ch=='('){
        stack.push(ch);
      }else if(stack.isEmpty() || '(' != stack.pop()){
        return 0;
      }
    }
    if(stack.isEmpty()){
      return 1;
    }

    return 0;
  }
}
