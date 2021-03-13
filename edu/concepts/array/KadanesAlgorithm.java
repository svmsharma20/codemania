package edu.concepts.array;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] array = {5, -3, 2, -1, -2, 6, -5, -3};
        System.out.println("Max: "+getMax(array));
        System.out.println("Min: "+getMin(array));

        int[] indices = getMaxIndices(array);
        int sum = 0;
        int i = indices[0];
        while(sum != indices[1]){
            System.out.print(array[i] + " ");
            sum += array[i];
            i--;
        }
    }

    static int getMax(int[] arr){
        int sum = 0;
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum>max){
                max = sum;
            }
            if(sum < 0 ){
                sum = 0;
            }

        }

        return max;
    }

    static int getMin(int[] arr){
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum<min){
                min = sum;
            }
            if(sum > 0){
                sum = 0;
            }
        }
        return min;
    }

    static int[] getMaxIndices(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int index = -1;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum>max){
                index = i;
                max = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        int[] indices = new int[2];
        indices[0] = index;
        indices[1] = max;

        return indices;
    }
}
