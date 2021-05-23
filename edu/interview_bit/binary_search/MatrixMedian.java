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
            if(min>arr[i][0]) min=arr[i][0];
            if(max<arr[i][c-1]) max=arr[i][c-1];
       }

       /*
       * Since, median is the middle most element.
       * It divides all the numbers in two equals parts when they are in their sorted form.
       *
       * Also, in case where total numbers are odd, the position of the median tells us how many elements are there to its left and,
       * how many are at its right. It will be (position-1) elements to left and (position-1) elements to right.
       *
       * For e.g.: In case of (3 X 5) matrix; total number are: 15
       * and the position of the middle element is = (15+1)/2 = 8
       *
       * So, there will be 7 elements to the left of the median(1 to 7)
       * and there will be 7 elements to the right of the median(9 to 15)
       *
       * So we can say that number of elements to the left if median is (position of the median -1).
       *
       * desiredIndexOfTheMedian represents the index of the median when the matrix is converted into a sorted array form.
       * */
       int desiredIndexOfTheMedian = (r*c + 1)/2;

       while(min<max){
            int mid = min + (max-min)/2;
            int count=0;

            for(int i=0; i<arr.length; i++){
                count += getNumbersLessThanN(arr[i], mid);
            }

            /*
            * If the number of variables smaller than the mid is less than the desiredIndexOfTheMedian,
            * It tells us that mid does not divides the array equally
            * and, there are less numbers to the left of mid as compare to right of mid
            * and so median lies in the right section(that is, mid to max).
            *
            * And, the viceversa also,
            *
            * If the number of variables more than the mid is less than the desiredIndexOfTheMedian,
            * It tells us that mid does not divides the array equally
            * and, there are more numbers to the left of mid as compare to right of mid
            * and so median lies in the left section(that is, mid to max).
            * */
            if(count<desiredIndexOfTheMedian){
                min = mid+1;
            }else{
                max = mid;
            }

       }

       return min;

    }

    private int getNumbersLessThanN(int[] arr, int n){
        
        int totalNumbers = arr.length;
        int leftGreaterIndex = totalNumbers;
        int low=0;
        int high=totalNumbers-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid] > n){
                leftGreaterIndex = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return leftGreaterIndex;
    }
}