package edu.interviewBit.array;

import java.util.ArrayList;

public class MergeOverlappingIntervals {

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        sort(intervals, 0, intervals.size()-1);
        
        int i=0;
        int j=1;
        
        while(j<intervals.size()){
            if(intervals.get(i).end >= intervals.get(j).start){
                if(intervals.get(i).end < intervals.get(j).end){
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
    
    void sort(ArrayList<Interval> intervals, int start, int end){
        if(start==end){
            return;
        }
        
        int mid = start + (end-start)/2;
        
        sort(intervals, start, mid);
        sort(intervals, mid+1, end);
        
        int i=start;
        int j=mid+1;
        
        ArrayList<Interval> temp = new ArrayList<>();
        
        while(i<=mid && j<=end){
            if(intervals.get(i).start <= intervals.get(j).start){
                temp.add(intervals.get(i));
                i++;
            }else{
                temp.add(intervals.get(j));
                j++;
            }
        }
        
        while(i<=mid){
            temp.add(intervals.get(i));
            i++;
        }
        
        while(j<=end){
            temp.add(intervals.get(j));
            j++;
        }
        
        for(int p=start, q=0; p<=end && q<temp.size(); p++, q++){
            intervals.set(p, temp.get(q));
        }
    }
}
