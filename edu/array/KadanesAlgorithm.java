package edu.array;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] array = {5, -3, 2, -1, -2, 6, -5, -3};
        System.out.println(getMax(array));
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
}
