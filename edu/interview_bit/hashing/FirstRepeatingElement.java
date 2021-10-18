package edu.interview_bit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstRepeatingElement {

    public int solve(ArrayList<Integer> input) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < input.size(); i++) {
            if (store.containsKey(input.get(i))) {
                if (store.get(input.get(i)) < minIndex) {
                    minIndex = store.get(input.get(i));
                }
            } else {
                store.put(input.get(i), i);
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : input.get(minIndex);
    }
}
