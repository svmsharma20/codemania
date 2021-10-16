package edu.interview_bit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum_II {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        generateCombinations(a, b, new ArrayList<Integer>(), 0, output, 0);
        return output;
    }

    public void generateCombinations(ArrayList<Integer> input,
        int target,
        ArrayList<Integer> temp,
        int tempSum,
        ArrayList<ArrayList<Integer>> output,
        int index) {
        if (tempSum == target) {
            output.add(new ArrayList<Integer>(temp));
            return;
        }

        if (tempSum > target) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < input.size(); i++) {
            if (!set.contains(input.get(i))) {
                temp.add(input.get(i));
                generateCombinations(input, target, temp, tempSum + input.get(i), output, i + 1);
                temp.remove(input.get(i));
                set.add(input.get(i));
            }

        }

    }
}
