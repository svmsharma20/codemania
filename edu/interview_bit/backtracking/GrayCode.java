package edu.interview_bit.backtracking;

import java.util.ArrayList;

public class GrayCode {

    /*
     * https://www.youtube.com/watch?v=KOD2BFauQbA
     * */
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> list = new ArrayList<>();
        if (a == 1) {
            list.add(0);
            list.add(1);
            return list;
        }
        int n = 1 << (a - 1);
        ArrayList<Integer> aMinusOneList = grayCode(a - 1);
        for (Integer i : aMinusOneList) {
            list.add(i);
        }

        for (int i = aMinusOneList.size() - 1; i >= 0; i--) {
            list.add(aMinusOneList.get(i) | n);
        }
        return list;
    }
}
