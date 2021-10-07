package edu.leetcode.string;

import java.util.Stack;

public class RemoveKDigits {

  public String removeKdigits(String num, int k) {
    if (num == null || num.length() == 0 || num.length() <= k) {
      return "0";
    }
    Stack<Character> stack = new Stack<>();
    int i = 0;
    while (k > 0 && i < num.length()) {
      char n = num.charAt(i);
      i++;

      while (!stack.isEmpty() && stack.peek() > n && k > 0) {
        stack.pop();
        k--;
      }
      if (stack.isEmpty() && n == '0') {
        continue;
      }
      stack.push(n);
    }

    while (k > 0 && !stack.isEmpty()) {
      stack.pop();
      k--;
    }

    while (i < num.length()) {
      char n = num.charAt(i);
      i++;
      if (stack.isEmpty() && n == '0') {
        continue;
      }
      stack.push(n);
    }

    String str = "";
    while (!stack.isEmpty()) {
      str = stack.pop() + str;
    }

    return str.length() == 0 ? "0" : str;
  }
}
