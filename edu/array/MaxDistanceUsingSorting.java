/*
*  Time complexity => O(nlogn)
*/

package edu.array;

public class MaxDistanceUsingSorting {

    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 8, 2};
        int[] indices = new int[arr.length];
        int maxDiff = 0;
        int n=arr.length;

        for(int i=0; i<n; i++){
            indices[i] = i;    
        }

        new MaxDistanceUsingSorting().sort(arr, indices, 0, arr.length-1);

        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+" ");    
        // }
        
        // System.out.println();
        
        // for(int i=0; i<n; i++){
        //     System.out.print(indices[i]+" ");
        // }

        int[] prefix = new int[n];
        
        prefix[n-1] = -1;
        
        for(int i=n-2;i>=0; i--){
            prefix[i] = Math.max(indices[i+1], prefix[i+1]);
        }
        
        for(int i=0; i<n; i++){
            if(prefix[i]>=indices[i]){
                maxDiff = Math.max(maxDiff, prefix[i]-indices[i]);    
            }
        }

        System.out.println(maxDiff);
    }

    public void sort(int[] values, int[] indices, int start, int end){
        if(start==end){
            return;
        }
        
        int mid = start + (end-start)/2;
        sort(values, indices, start, mid);
        sort(values, indices, mid+1, end);
        
        int[] temp = new int[end-start+1];
        int[] tempForIndices = new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        
        while(i<=mid && j<=end){
            if(values[i] < values[j]){
                temp[k] = values[i];
                tempForIndices[k] = indices[i];
                i++;
            }else{
                temp[k] = values[j];
                tempForIndices[k] = indices[j];
                j++;
            }
            k++;
        }
        
        while(i<=mid){
           temp[k] = values[i];
           tempForIndices[k] = indices[i];
            i++;
            k++;
        }
        
        while(j<=end){
           temp[k] = values[j];
           tempForIndices[k] = indices[j];
            j++;
            k++;
        }
        
        for(int p=0, q=start; p<temp.length && q<=end; p++, q++){
            values[q] = temp[p];
            indices[q] = tempForIndices[p];
        }
    }
}
