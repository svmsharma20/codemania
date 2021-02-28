package edu.interviewBit.array;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

public class HotelBookingsPossible {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        
        int size = arrive.size();
        
        Iterator<Integer> itr1 = arrive.iterator();
        Iterator<Integer> itr2 = depart.iterator();
        
        while(itr1.hasNext() && itr2.hasNext()){
            if(itr1.next() == itr2.next()){
                itr1.remove();
                itr2.remove();
            }
        }
        
        
        sort(arrive, depart, 0, size-1);
        
        PriorityQueue<Integer> endings = new PriorityQueue<>();
        
        for(int i=0; i<size; i++){
            if(endings.size()>0 && endings.peek()<=arrive.get(i)){
                endings.poll();
            }
            endings.add(depart.get(i));
            
            if(endings.size()>K){
                return false;
            }
        }
        
        // System.out.println(arrive);
        // System.out.println(depart);
        
        return true;
    }
    
    public void sort(ArrayList<Integer> arrive, ArrayList<Integer> depart, int start, int end){
        if(start == end){
            return;
        }
        
        int mid = (start+end)/2;
        
        sort(arrive, depart, start, mid);
        sort(arrive, depart, mid+1, end);
        
        ArrayList<Integer> tempArrive = new ArrayList<>();
        ArrayList<Integer> tempDepart = new ArrayList<>();
        
        int i=start;
        int j=mid+1;
        
        while(i<=mid && j<=end){
            if(arrive.get(i) <= arrive.get(j)){
                tempArrive.add(arrive.get(i));
                tempDepart.add(depart.get(i));
                i++;
            }else{
                tempArrive.add(arrive.get(j));
                tempDepart.add(depart.get(j));
                j++;
            }
        }
        
        while(i<=mid){
            tempArrive.add(arrive.get(i));
            tempDepart.add(depart.get(i));
            i++;
        }
        
        while(j<=end){
            tempArrive.add(arrive.get(j));
            tempDepart.add(depart.get(j));
            j++;
        }
        
        
        for(int p=start, q=0; p<=end && q<tempArrive.size(); p++, q++){
            arrive.set(p, tempArrive.get(q));
            depart.set(p, tempDepart.get(q));
        }
        
    }
}
