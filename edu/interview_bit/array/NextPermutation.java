package edu.interview_bit.array;

import java.util.ArrayList;

public class NextPermutation {
    
    //  https://leetcode.com/problems/next-permutation/solution/
    
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();
        int index = -1;
        for(int i=n-1; i>0; i--){
            if(A.get(i)>A.get(i-1)){
                index = i-1;
                break;
            }
        }
        
        if(index==-1){
            int left = 0;
            int right = n-1;
            
            while(left<right){
                int temp = A.get(left);
                A.set(left, A.get(right));
                A.set(right, temp);
                left++;
                right--;
            }
            return A;
        }
        int minLargerNumIndex = index+1;
        
        for(int i=index+2; i<n; i++){
            if(A.get(i)>A.get(index) && A.get(i)<A.get(minLargerNumIndex)){
                minLargerNumIndex = i;
            }    
        }
        
        int temp = A.get(index);
        A.set(index, A.get(minLargerNumIndex));
        A.set(minLargerNumIndex, temp);
        
        sort(A, index+1, n-1);
        
        return A;
        
    }
    
    void sort(ArrayList<Integer> list, int start, int end){
        if(start==end){
            return;
        }
        int mid = start + (end-start)/2;
        
        sort(list, start, mid);
        sort(list, mid+1, end);
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        int i=start;
        int j=mid+1;
        
        while(i<=mid && j<=end){
            if(list.get(i)<= list.get(j)){
                temp.add(list.get(i));
                i++;
            }else{
                temp.add(list.get(j));
                j++;
            }
        }
        
        while(i<=mid){
            temp.add(list.get(i));
            i++;
        }
        
        while(j<=end){
            temp.add(list.get(j));
            j++;
        }
        
        for(int p=start, q=0; p<=end && q<temp.size(); p++, q++){
            list.set(p, temp.get(q));
        }
        
    }

}
