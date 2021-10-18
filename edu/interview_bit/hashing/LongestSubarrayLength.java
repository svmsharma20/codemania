package edu.interview_bit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * https://www.youtube.com/watch?v=sUsojorcNDA&t=515s
 * */
public class LongestSubarrayLength {

    public int solve(ArrayList<Integer> A) {
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> store = new HashMap<>();
        store.put(0, -1);
        for (int i = 0; i < A.size(); i++) {
            sum += (A.get(i) == 1 ? 1 : -1);
            if (store.containsKey(sum - 1)) {
                maxLen = Math.max(maxLen, i - store.get(sum - 1));
            }
            if (!store.containsKey(sum)) {
                store.put(sum, i);
            }
        }

        return maxLen;
    }

}
