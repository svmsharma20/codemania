package edu.interview_bit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Subsets_II {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> inputs) {
        Collections.sort(inputs);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        generateSubsets(inputs, new ArrayList<>(), output, 0);
        return output;
    }

    public void generateSubsets(ArrayList<Integer> inputs, ArrayList<Integer> temp,
        ArrayList<ArrayList<Integer>> output, int index) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = index; i < inputs.size(); i++) {
            if (!set.contains(inputs.get(i))) {
                temp.add(inputs.get(i));
                output.add(new ArrayList<>(temp));
                generateSubsets(inputs, temp, output, i + 1);
                temp.remove(temp.size() - 1);
                set.add(inputs.get(i));
            }
        }
    }
}
