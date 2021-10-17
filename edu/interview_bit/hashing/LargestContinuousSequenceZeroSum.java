package edu.interview_bit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int sum = 0;
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                int l = map.get(sum);
                if (i - l > (end - start)) {
                    start = l;
                    end = i;
                }
            } else {
                map.put(sum, i);
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start + 1; i <= end; i++) {
            list.add(A.get(i));
        }

        return list;
    }
}
