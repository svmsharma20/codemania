package edu.interview_bit.array;

import java.util.List;

public class MaxDistance {
    
    public int maximumGap(final List<Integer> A) {
        
        //  https://www.youtube.com/watch?v=Zyhxzg0WLWA&t=236s
        
        if(A==null || A.size()<2){
            return 0;
        }
        
        int maxDiff=0;
        int n=A.size();
        
        int prefixMin[] = new int[n];
        int suffixMax[] = new int[n];
        
        prefixMin[0]=A.get(0);
        suffixMax[n-1]=A.get(n-1);
        
        for(int i=1; i<n; i++) { prefixMin[i] = Math.min(A.get(i), prefixMin[i-1]); }
        
        for(int i=n-2; i>=0; i--) { suffixMax[i] = Math.max(A.get(i), suffixMax[i+1]); }
        
        int p=0;
        int q=0;
        
        while(p<n && q<n){
            if(prefixMin[p] <= suffixMax[q]){
                maxDiff = Math.max(maxDiff, q-p);
                q++;
            }else{
                p++;
            }
        }
        
        
        return maxDiff;
    }

}
