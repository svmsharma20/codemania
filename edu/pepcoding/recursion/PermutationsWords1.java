package edu.pepcoding.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-words-1-official/ojquestion
public class PermutationsWords1 {

  public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
    if (cs > ts) {
      System.out.println(asf);
      return;
    }

    for (Entry<Character, Integer> entry : fmap.entrySet()) {
      if (entry.getValue() > 0) {
        fmap.put(entry.getKey(), entry.getValue() - 1);
        generateWords(cs + 1, ts, fmap, asf + entry.getKey());
        fmap.put(entry.getKey(), entry.getValue() + 1);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    HashMap<Character, Integer> fmap = new HashMap<>();
    for (char ch : str.toCharArray()) {
      if (fmap.containsKey(ch)) {
        fmap.put(ch, fmap.get(ch) + 1);
      } else {
        fmap.put(ch, 1);
      }
    }

    generateWords(1, str.length(), fmap, "");
  }
}
