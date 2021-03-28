package edu.interview_bit.array;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

import java.util.ArrayList;

public class MergeIntervals {
    
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        
        sort(intervals, 0, intervals.size()-1);
        
        // for(Interval I : intervals){
        //     System.out.print("["+I.start+", "+I.end+"] ");
        // }
        
        int i=0;
        int j=1;
        
        while(j<intervals.size() && i<intervals.size()){
            if(intervals.get(i).end >= intervals.get(j).start){
                
                if(intervals.get(i).end < intervals.get(j).end ){
                    intervals.get(i).end = intervals.get(j).end;
                }
                
                j++;
                
            }else{
                i++;
                intervals.set(i, intervals.get(j));
                j++;
            }
        }
        
        i++;
        
        while(i<intervals.size()){
            intervals.remove(i);
        }
        return intervals;
    }

    void sort(ArrayList<Interval> ilist, int start, int end){
        if(start==end){
            return;
        }
        
        int mid = start + (end-start)/2;
        
        sort(ilist, start, mid);
        sort(ilist, mid+1, end);
        
        ArrayList<Interval> temp = new ArrayList<>();
        int i=start;
        int j=mid+1;
        
        while(i<=mid && j<=end){
            if(ilist.get(i).start <= ilist.get(j).start){
                temp.add(ilist.get(i));
                i++;
            }else{
                temp.add(ilist.get(j));
                j++;
            }
        }
        
        while(i<=mid){
            temp.add(ilist.get(i));
            i++;
        }
        
        while(j<=end){
            temp.add(ilist.get(j));
            j++;
        }
        
        for(int p=start, q=0; p<=end && q<temp.size(); p++, q++){
            ilist.set(p, temp.get(q));
        }
        
    }
}