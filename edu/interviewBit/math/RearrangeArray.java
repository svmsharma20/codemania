package edu.interviewBit.math;

import java.util.ArrayList;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> list) {
        int n = list.size();
        
        for(int i=0; i<list.size(); i++){
            int q = list.get(i);
            int r = (list.get(list.get(i)))/n;
            list.set(i, (n*q+r));
        }
        
        for(int i=0; i<list.size(); i++){
            int r = list.get(i)%n;
            list.set(i, r);
        }
    }
}
