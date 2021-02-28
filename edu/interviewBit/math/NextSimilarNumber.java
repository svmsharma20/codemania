package edu.interviewBit.math;

public class NextSimilarNumber {
    
    public String solve(String str) {
        int len = str.length();
        int[] num = new int[len];
        for(int i=0; i<len; i++){
            num[i] = Integer.parseInt(str.charAt(i)+"");
        }
        
        int i=len-2;
        while(i>=0){
            if(num[i]<num[i+1]){
                break;
            }
            i--;
        }
        
        if(i<0){
            return "-1";
        }
        
        int index = i+1;
        int j=i+2;
        
        while(j<len){
            if(num[j]<num[index] && num[j]>num[i]){
                index=j;
            }
            j++;
        }
        
        int temp = num[index];
        num[index] = num[i];
        num[i] = temp;
        
        sort(num, i+1, len-1);
        
        String nextPermutation = "";
        for(int p=0; p<len; p++){
            nextPermutation += num[p]+"";    
        }
        
        return nextPermutation;
    }
    
    void sort(int[] num, int start, int end){
        if(start==end){
            return;
        }
        
        int mid = start + (end-start)/2;
        
        sort(num, start, mid);
        sort(num, mid+1, end);
        
        int[] temp = new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        
        while(i<=mid && j<=end){
            if(num[i]<= num[j]){
                temp[k] = num[i];
                i++;
            }else{
                temp[k] = num[j];
                j++;
            }
            k++;
        }
        
        while(i<=mid){
            temp[k] = num[i];
            i++;
            k++;
        }
        
        while(j<=end){
            temp[k] = num[j];
            j++;
            k++;
        }
        
        for(int p=start, q=0; p<=end && q<temp.length; p++,q++){
            num[p] = temp[q];
        }
    }
    
}
