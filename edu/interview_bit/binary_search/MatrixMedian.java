package edu.interview_bit.binary_search;

public class MatrixMedian {
    
    public static void main(String[] args) {
        int[][] arr = { {1,2,3,4,4} , {4,4,5,6,9} , {9,9,9,10,15} };
        System.out.println(new MatrixMedian().getMedianOfSortedMatrix(arr));
    }

    private int getMedianOfSortedMatrix(int[][] arr) {
       
       int min = Integer.MAX_VALUE; 
       int max = Integer.MIN_VALUE;
       
        int r = arr.length;
        int c = arr[0].length;

       for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(min>arr[i][j]) min=arr[i][j];
                if(max<arr[i][j]) max=arr[i][j];
            }
       }
       
       int desired = (r*c + 1)/2;

       while(min<max){
            int mid = min + (max-min)/2;
            int place=0;

            for(int i=0; i<arr.length; i++){
                place += getNumbersLessThanN(arr[i], mid);
            }

            if(place<desired){
                min = mid+1;
            }else{
                max = mid;
            }

       }

       return min;

    }

    private int getNumbersLessThanN(int[] arr, int n){
        
        int totalNumbers = arr.length;
        int leftGreater = totalNumbers;
        int low=0;
        int high=totalNumbers-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid] > n){
                leftGreater = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return leftGreater;
    }
}