package edu.leetcode.string;

public class ReverseWordsInAString {

  public String reverseWords(String s) {

    StringBuilder sb = new StringBuilder();
    StringBuilder res = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (ch != ' ') {
        sb.insert(0, ch);
      } else if (sb.length() > 0) {
        sb.append(' ');
        res.append(sb);
        sb = new StringBuilder();
      }
    }

    if (sb.length() > 0) {
      res.append(sb);
    }
    if (res.charAt(res.length() - 1) == ' ') {
      res.deleteCharAt(res.length() - 1);
    }
    return res.toString();
  }
}
