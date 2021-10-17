package edu.interview_bit.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {

    HashMap<Integer, String> map = new HashMap<>();

    public ArrayList<String> letterCombinations(String input) {
        initHashMap();
        ArrayList<String> output = new ArrayList<>();

        generate(input, output, "", 0);
        return output;
    }

    public void generate(String input, ArrayList<String> output, String temp, int index) {
        if (index == input.length()) {
            output.add(temp);
            return;
        }
        String s = map.get(Integer.parseInt(input.charAt(index) + ""));
        for (int i = 0; i < s.length(); i++) {
            generate(input, output, temp + s.charAt(i), index + 1);
        }
    }

    public void initHashMap() {
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
}
