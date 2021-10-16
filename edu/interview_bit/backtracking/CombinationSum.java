package edu.interview_bit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>(A);
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        getAllSets(list, B, new ArrayList<Integer>(), 0, output, 0);
        return output;
    }

    public void getAllSets(ArrayList<Integer> input, int target, ArrayList<Integer> temp,
        int tempSum, ArrayList<ArrayList<Integer>> output, int index) {
        if (tempSum > target) {
            return;
        }
        if (tempSum == target) {
            output.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < input.size(); i++) {
            temp.add(input.get(i));
            getAllSets(input, target, temp, tempSum + input.get(i), output, i);
            temp.remove(input.get(i));
        }
    }
}
