package edu.interview_bit.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class FirstNonrepeatingCharacterInAStreamOfCharacters {

  public static void main(String[] args) {
    String str = "abcbcad";
    System.out.println(new FirstNonrepeatingCharacterInAStreamOfCharacters().solve(str));
  }

  public String solve(String A) {
    if (A == null || A.length() <= 1) {
      return A;
    }
    StringBuilder result = new StringBuilder();
    Queue<Character> queue = new ArrayDeque<>();
    HashSet<Character> charsEncounteredSet = new HashSet<>();

    for (int i = 0; i < A.length(); i++) {
      char ch = A.charAt(i);
      if(!charsEncounteredSet.contains(ch)){
        queue.add(ch);
        charsEncounteredSet.add(ch);
      }else {
        queue.remove(ch);
      }
      if(queue.isEmpty()){
        result.append("#");
      }else{
        result.append(queue.peek());
      }
    }

    return result.toString();
  }
}
