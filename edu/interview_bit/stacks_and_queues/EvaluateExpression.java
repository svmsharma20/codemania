package edu.interview_bit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

  public int evalRPN(ArrayList<String> A) {
    Stack<Integer> stack = new Stack<>();
    int op1 = 1;
    int op2 = -1;
    for(String s : A){
      switch(s){
        case "+":
          op1 = stack.pop();
          op2 = stack.pop();
          stack.push(op2+op1);
          break;

        case "-":
          op1 = stack.pop();
          op2 = stack.pop();
          stack.push(op2-op1);
          break;

        case "*":
          op1 = stack.pop();
          op2 = stack.pop();
          stack.push(op2*op1);
          break;

        case "/":
          op1 = stack.pop();
          op2 = stack.pop();
          stack.push(op2/op1);
          break;

        default:
          stack.push(Integer.parseInt(s));

      }
    }

    return stack.pop();
  }

}
