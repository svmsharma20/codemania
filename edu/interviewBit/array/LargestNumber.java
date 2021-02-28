package edu.interviewBit.array;

import java.util.List;

public class LargestNumber {
    
    public String largestNumber(final List<Integer> A) {
        int n = A.size();
        String[] sArr = new String[n];
        for(int i=0; i<n; i++){
            sArr[i] = String.valueOf(A.get(i));
        }
        
        sort(sArr, 0, n-1);
        
        String num = "";
        
        for(String s : sArr){
            //prevent preceeding zeros to be get added
            if(num.length()==0 && s.equals("0")){
                continue;    
            }
            num += s;
        }
        
        if(num.length()==0){
            num="0";
        }
        
        return num;
    }
    
    public void sort(String[] s, int start, int end){
        if(start==end){
            return;
        }
        
        int mid = start + (end-start)/2;
        
        sort(s, start, mid);
        sort(s, mid+1, end);
        
        String[] temp = new String[end-start+1];
        
        int i=start;
        int j=mid+1;
        int k=0;
        
        while(i<=mid && j<=end){
            if(compare(s[i], s[j])){
                temp[k] = s[i];
                i++;
            }else{
                temp[k] = s[j];
                j++;
            }
            k++;
        }
        
        while(i<=mid){
            temp[k] = s[i];
            i++;
            k++;
        }
        
        while(j<=end){
            temp[k] = s[j];
            j++;
            k++;
        }
        
        for(int p=0, q=start; p<temp.length && q<=end; p++, q++){
            s[q] = temp[p];
        }
        
    }
    
    public boolean compare(String s1, String s2){
        String num1 = s1+s2;
        String num2 = s2+s1;
        
        for(int i=0; i<num1.length(); i++){
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            int n2 = Integer.parseInt(num2.charAt(i)+"");
            if(n1>n2){
                return true;
            }else if (n2>n1){
                return false;
            }
        }
        
        return true;
    }

}
