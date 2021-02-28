package edu.interviewBit.math;

import java.util.ArrayList;

public class NumbersOfLengthNAndValueLessThanK {
    // https://www.youtube.com/watch?v=MT8zeLak_bI&t=1048s
    public int solve(ArrayList<Integer> A, int len, int maxNum) {
        if(A==null || A.size()==0){
            return 0;
        }
        
        int[] digits = new int[A.size()];
        
        for(int i=0; i<A.size(); i++){
            digits[i] = A.get(i);
        }
        
        
        sort(digits, 0, digits.length-1);
        
        ArrayList<Integer> numList = getInetegerAsAnArray(maxNum);
        int ans =0;
        
        if(len>numList.size()){
            return 0;
        }else if(len<numList.size()){
            
            if(len==1){
                for(int i=0; i<digits.length; i++){
                    if(digits[i]<maxNum){ans++;}
                }
            }else{
                if(digits[0]==0){
                    ans = (digits.length-1)*(power(digits.length, len-1));
                }else{
                    ans = (digits.length)*(power(digits.length, len-1));
                }    
            }
        }else{
            if(len==1){
                for(int i=0; i<digits.length; i++){
                    if(digits[i]<maxNum){ans++;}
                }
            }else{
                int count=0;
                
                for(int n: digits){
                    if(n==0){continue;}
                    if(n>numList.get(0)){break;}
                    count++;
                }

                ans = count*(power(digits.length, len-1));

                boolean flag = false;
                int j=0;

                for(int i=0; i<digits.length; i++){
                    if(numList.get(0)==digits[i]){
                        flag = true;
                        break;
                    }
                }
                j++;
                while(flag && j<=len-1){
                    flag = false;
                    int countLarger = 0;
                    for(int i=0; i<digits.length; i++){
                        if(digits[i]>numList.get(j)) countLarger++;
                        if(digits[i]==numList.get(j)) flag=true;
                    }
                    ans -= countLarger * (power(digits.length, len-j-1));
                    j++;
                }

                if(j==len && flag){ans--;}
            }

        }

        return ans;
    }

    private void sort(int[] arr, int start, int end){
        if(start==end){
            return;
        }

        int mid = (start + end)/2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);

        int i=start;
        int j=mid+1;
        int k=0;

        int temp[] = new int[end-start+1];

        while(i<=mid && j<=end){
            if(arr[i]<= arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j<=end){
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int p =0, q=start; p < temp.length && q<=end; p++, q++) {
            arr[q] =  temp[p];
        }
    }

    private ArrayList<Integer> getInetegerAsAnArray(int n){
        ArrayList<Integer> l = new ArrayList<>();
        while(n>0){
            int rem = n%10;
            l.add(0, rem);
            n /= 10;
        }

        return l;
    }

    private int power(int a, int n){
        int res=1;
        int pow = a;
        while(n>0){
            if((n&1) > 0){
                res *= pow;
            }

            pow = pow * pow;
             n >>= 1;
        }

        return res;
    }
}
