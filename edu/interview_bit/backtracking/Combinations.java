package edu.interview_bit.backtracking;

import java.util.ArrayList;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        generateAllCombinations(n, k, new ArrayList<>(), output, 1);
        return output;
    }

    public void generateAllCombinations(int n, int k, ArrayList<Integer> temp,
        ArrayList<ArrayList<Integer>> output, int index) {
        if (k == 0) {
            output.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            generateAllCombinations(n, k - 1, temp, output, i + 1);
            temp.remove(new Integer(i));
        }
    }
}
