package edu.interviewBit.array;

import java.util.List;

public class N_By_3_RepeatNumber {
    
    //https://www.youtube.com/watch?v=3lh0j3YRH50
    
    public int repeatedNumber(final List<Integer> a) {
        if(a==null || a.size()==0){
            return -1;
        }
        
        int n = a.size();
        
        if(n==1){
            return a.get(0);
        }
        
        int element1 = Integer.MAX_VALUE;
        int element2 = Integer.MAX_VALUE;
        int count1=0;
        int count2=0;
        
        for(int i=0; i<n; i++){
            if(a.get(i)==element1){
                count1++;
            }else if(a.get(i)==element2){
                count2++;
            }else if(count1==0){
                element1 = a.get(i);
                count1=1;
            }else if(count2==0){
                element2 = a.get(i);
                count2=1;
            }else{
                count1--;
                count2--;
            }
            
        }
        
        count1=0;
        count2=0;
        
        for(int i=0; i<n; i++){
            if(element1==a.get(i)){
                count1++;
            }else if(element2==a.get(i)){
                count2++;
            }
        }
        
        if(count1>(n/3)) return element1;
        if(count2>(n/3)) return element2;
        
        return -1;
    }

}
