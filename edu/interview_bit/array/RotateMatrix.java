package edu.interview_bit.array;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                subList.add(arr[i][j]);
            }
            list.add(subList);
        }
        System.out.println(list);
        new RotateMatrix().rotateWithNoExtraSpace(list);
        System.out.println(list);
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        
        int[][] matrix = new int[a.size()][a.get(0).size()];
        
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                matrix[i][j] = a.get(i).get(j);
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        int p=0;
        int q=matrix.length-1;
        while(p<q){
            for(int j=0; j<matrix.length; j++){
                int temp = matrix[j][p];
                matrix[j][p] = matrix[j][q];
                matrix[j][q] = temp;
            }
            p++;
            q--;
        }
        
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                a.get(i).set(j, matrix[i][j]);
            }
        }
    }

    public void rotateWithNoExtraSpace(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int v1 = a.get(i).get(j);
                int v2 = a.get(j).get(n-i-1);
                int v3 = a.get(n-1-i).get(n-j-1);
                int v4 = a.get(n-j-1).get(i);

                a.get(i).set(j, v4);
                a.get(j).set(n-i-1, v1);
                a.get(n-1-i).set(n-j-1, v2);
                a.get(n-j-1).set(i, v3);
            }
        }
    }
}
